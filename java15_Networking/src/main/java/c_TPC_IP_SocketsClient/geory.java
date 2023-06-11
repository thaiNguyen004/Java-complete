package c_TPC_IP_SocketsClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
* Các Socket TCP/IP được sử dụng để triển khai các kết nối tin cậy, hai chiều, liên tục, điểm-điểm,
* dựa trên luồng giữa các máy chủ trên Internet. Một socket có thể được sử dụng để kết nối hệ thống I/O của Java
* với các chương trình khác có thể đặt trên máy cục bộ hoặc bất kỳ máy chủ nào khác trên Internet, tuân theo ràng buộc bảo mật.
*
* Có hai loại socket TCP trong Java. Một loại dành cho máy chủ và loại còn lại dành cho khách hàng.
* Lớp ServerSocket được thiết kế để là một "người nghe", đợi khách hàng kết nối trước khi thực hiện bất kỳ thao tác nào.
* Do đó, ServerSocket dành cho máy chủ. Lớp Socket dành cho khách hàng. Nó được thiết kế để kết nối với các socket máy chủ
* và khởi tạo trao đổi giao thức. Vì các socket khách hàng là phổ biến nhất được sử dụng bởi ứng dụng Java,
* chúng được xem xét ở đây.
*
* Việc tạo đối tượng Socket ngầm định thiết lập một kết nối giữa khách hàng và máy chủ.
* Không có phương thức hoặc constructor nào cho phép trực tiếp tiết lộ các chi tiết về việc thiết lập kết nối đó.
* Dưới đây là hai constructor được sử dụng để tạo socket khách hàng:
*
* Socket(String hostName, int port) throws UnknownHostException, IOException
* Tạo một socket được kết nối với host và cổng đã chỉ định.
*
* Socket(InetAddress ipAddress, int port) throws IOException
* Tạo một socket bằng cách sử dụng một đối tượng InetAddress đã tồn tại và một cổng.
*
* Socket định nghĩa một số phương thức (instance) thể hiện. Ví dụ, một Socket có thể được kiểm tra bất kỳ lúc nào để
* lấy thông tin địa chỉ và cổng liên quan đến nó, bằng cách sử dụng các phương thức sau:
*
* Dưới đây là mô tả các phương thức được yêu cầu:
*
* 1. `getInetAddress()`:
*  Phương thức này trả về đối tượng InetAddress, đại diện cho địa chỉ IP của máy chủ hoặc máy khách mà Socket đang kết nối tới.
*
* 2. `getPort()`: Phương thức này trả về số cổng của máy chủ hoặc máy khách mà Socket đang kết nối tới.
* Số cổng xác định một ứng dụng cụ thể mà Socket đang liên kết.
*
* 3. `getLocalPort()`:
* Phương thức này trả về số cổng của máy chủ hoặc máy khách mà Socket được sử dụng để
* giao tiếp với máy chủ hoặc máy khách khác.
*
* Bạn có thể truy cập vào các luồng đầu vào và đầu ra liên quan đến một Socket bằng cách sử dụng các
* phương thức getInputStream() và getOutputStream(), như được thể hiện dưới đây. Mỗi phương thức có thể ném ra một IOException
* nếu Socket đã không còn hợp lệ do mất kết nối. Các luồng này được sử dụng tương tự như các luồng I/O được mô tả
* trong Chương 21 để gửi và nhận dữ liệu.
*
* getInputStream():
* Trả về một đối tượng InputStream, được sử dụng để đọc dữ liệu từ kết nối socket.
* Phương thức này có thể ném ra một IOException nếu xảy ra lỗi khi truy cập vào luồng đầu vào.
*
* getOutputStream():
* Trả về một đối tượng OutputStream, được sử dụng để ghi dữ liệu vào kết nối socket.
* Phương thức này có thể ném ra một IOException nếu xảy ra lỗi khi truy cập vào luồng đầu ra.
*
* Có một số phương thức khác có sẵn, bao gồm:

- `connect()`: cho phép bạn chỉ định một kết nối mới.
- `isConnected()`: trả về true nếu socket đã kết nối với một máy chủ.
- `isBound()`: trả về true nếu socket đã được gắn với một địa chỉ.
- `isClosed()`: trả về true nếu socket đã đóng.
- `close()`: để đóng socket. Khi đóng socket, các luồng I/O liên quan cũng sẽ được đóng.
* Bắt đầu từ JDK 7, Socket cũng triển khai giao diện AutoCloseable, cho phép bạn sử dụng khối try-with-resources để quản lý socket.
*
* Dưới đây là một chương trình đơn giản sử dụng Socket. Nó mở một kết nối tới cổng "whois" (cổng 43) trên máy chủ InterNIC,
* gửi đối số dòng lệnh qua socket, và sau đó in ra dữ liệu được trả về. InterNIC sẽ cố gắng tìm kiếm đối số dưới dạng tên miền
* Internet đã đăng ký, và sau đó gửi lại địa chỉ IP và thông tin liên hệ cho trang web đó.
*
* */
public class geory {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // Tạo một socket kết nối tới máy chủ có tên là www.ap.poly.edu.vn, cổng 80
        Socket s = new Socket("www.ap.poly.edu.vn", 80);

        System.out.println(s.isConnected());
        // Có được các luồng đầu vào và các luồng đầu ra
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();

        // Xây dựng một chuỗi yêu cầu
        String str = "OraclePressBooks.com";

        // Chuyển sang bytes
        byte[] buf = str.getBytes();

        // Gửi yêu cầu (request)
        out.write(buf);

        int c;
        // Đọc và hiển thị phản hồi
        while ((c = in.read()) != -1) {
            System.out.println((char)c);
        }

        s.close();

        /*
        * Dưới đây là cách chương trình hoạt động. Trước tiên, một Socket được tạo ra để chỉ định tên máy chủ
        * là "whois.internic.net" và số cổng là 43. Internic.net là trang web InterNIC xử lý các yêu cầu whois.
        * Cổng 43 là cổng whois. Tiếp theo, cả luồng đầu vào và đầu ra được mở trên socket. Sau đó, một chuỗi
        * được tạo ra chứa tên trang web mà bạn muốn lấy thông tin. Chuỗi được chuyển đổi thành một mảng byte và
        * sau đó được gửi đi từ socket. Phản hồi được đọc bằng cách đọc từ socket và kết quả được hiển thị.
        *
        * Cuối cùng, socket được đóng, đồng thời cũng đóng luồng đầu vào/đầu ra.
        *
        * Trong ví dụ trước đó, socket được đóng thủ công bằng cách gọi close(). Bắt đầu từ JDK 7, bạn có thể sử dụng
        * khối try-with-resources để tự động đóng socket.
        * Ví dụ, dưới đây là cách khác để viết phương thức main() của chương trình trước đó:
        *
        * */

        try (Socket socket = new Socket("whois.internic.net", 43)) {
            InputStream in2 = socket.getInputStream();
            OutputStream out2 = socket.getOutputStream();
            String str2 = "OraclePressBooks.com";
            out2.write(str2.getBytes());
            int c2;
            while((c2 = in2.read()) != -1)
                System.out.println((char) c2);
        }

    }
}
/*
* Trong phiên bản này, socket sẽ được tự động đóng khi khối try kết thúc. Vì vậy, các ví dụ này sẽ hoạt động với
* các phiên bản Java trước đó và để rõ ràng khi nào một tài nguyên mạng có thể được đóng, các ví dụ tiếp theo
* sẽ tiếp tục gọi close() một cách rõ ràng.
* Tuy nhiên, trong mã của riêng bạn, bạn nên xem xét sử dụng quản lý tài nguyên tự động vì nó cung cấp một cách tiếp cận
* mượt mà hơn. Một điểm khác: Trong phiên bản này, các ngoại lệ vẫn được ném ra khỏi phương thức main(),
* nhưng chúng có thể được xử lý bằng cách thêm các khối catch vào cuối khối try-with-resources.
* LƯU Ý: Để đơn giản, các ví dụ trong chương này đơn giản là ném tất cả các ngoại lệ ra khỏi phương thức main().
* Điều này cho phép logic của mã mạng được minh họa một cách rõ ràng.
* Tuy nhiên, trong mã thực tế, bạn thường cần xử lý các ngoại lệ theo cách phù hợp.
* */
