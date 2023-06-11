package b_NetworkingInterface;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
* InetAddress
Lớp InetAddress được sử dụng để bao gồm cả địa chỉ IP số và tên miền cho địa chỉ đó.
* Bạn tương tác với lớp này bằng cách sử dụng tên của một máy chủ IP, điều này thuận tiện và dễ hiểu hơn so với địa chỉ IP
* của nó. Lớp InetAddress giấu đi con số bên trong và có thể xử lý cả địa chỉ IPv4 và IPv6.
*
* Phương thức tạo
* Lớp InetAddress không có các hàm tạo rõ ràng. Để tạo một đối tượng InetAddress, bạn phải sử dụng một trong những
* phương thức tạo sẵn có. Như đã được giải thích trước đây trong cuốn sách này, các phương thức tạo chỉ là một quy ước
* mà các phương thức tĩnh trong một lớp trả về một phiên bản của lớp đó. Điều này được thực hiện thay vì quá tải một
* hàm tạo với các danh sách tham số khác nhau khi việc có các tên phương thức duy nhất làm cho kết quả rõ ràng hơn.
*
* Dưới đây là ba phương thức tạo InetAddress thường được sử dụng:
*
* static InetAddress getLocalHost() throws UnknownHostException
* static InetAddress getByName(String hostName) throws UnknownHostException
* static InetAddress[] getAllByName(String hostName) throws UnknownHostException
*
* Phương thức getLocalHost() đơn giản trả về đối tượng InetAddress đại diện cho máy chủ cục bộ.
* Phương thức getByName() trả về một InetAddress cho một tên máy chủ được truyền vào. Nếu các phương thức này không thể
* giải quyết tên máy chủ, chúng sẽ ném ra một UnknownHostException.
*
* Trên Internet, thường có một tên duy nhất được sử dụng để đại diện cho nhiều máy chủ. Trong thế giới của các máy chủ web,
* đây là một cách để cung cấp một số mức độ mở rộng.
*
* Phương thức tạo getAllByName() trả về một mảng các InetAddresses đại diện cho tất cả các địa chỉ mà một tên cụ thể giải quyết thành.
* Nó cũng sẽ ném ra một UnknownHostException nếu không thể giải quyết tên thành ít nhất một địa chỉ.
*
* InetAddress cũng bao gồm phương thức tạo getByAddress(), nhận địa chỉ IP và trả về một đối tượng InetAddress.
* Cả địa chỉ IPv4 và IPv6 đều có thể được sử dụng.
*
* Ví dụ sau in ra địa chỉ và tên của máy cục bộ và hai trang web trên Internet:
*/
public class InetAddessesDemo {
    public static void main(String[] args) throws UnknownHostException, IOException {
        InetAddress Address = InetAddress.getLocalHost();
        System.out.println(Address);

        Address = InetAddress.getByName("www.HerbSchildt.com");
        System.out.println(Address);

        InetAddress[] SW = InetAddress.getAllByName("nba.com");
        for(int i = 0; i < SW.length; i++) {
            System.out.println(SW[i]);
        }

        /*
        * Các phương thức của đối tượng
        *
        * Lớp InetAddress còn một số phương thức khác, có thể được sử dụng trên các đối tượng được trả về bởi những
        * phương thức đã được thảo luận. Dưới đây là một số phương thức mẫu:
        *
        * - String getHostName(): Trả về tên miền của địa chỉ IP.
        *
        * - String getCanonicalHostName(): Trả về tên miền đầy đủ (canonical) của địa chỉ IP.
        *
        * - byte[] getAddress(): Trả về địa chỉ IP dưới dạng một mảng byte.
        *
        * - String getHostAddress(): Trả về địa chỉ IP dưới dạng một chuỗi ký tự.
        *
        * - boolean isReachable(int timeout): Kiểm tra xem địa chỉ IP có thể được truy cập hay không trong
        *   khoảng thời gian timeout (đơn vị là mili giây).
        *
        * - boolean equals(Object obj): So sánh hai đối tượng InetAddress để xem chúng có địa chỉ IP giống nhau hay không.
        *
        * - int hashCode(): Trả về mã băm của đối tượng InetAddress.
        * Những phương thức này cho phép bạn làm việc với các thông tin liên quan đến địa chỉ IP và tên miền của máy chủ.
        *
        * */

        InetAddress Address2 = InetAddress.getLocalHost();
        // Lấy ra tên miền của địa chỉ IP
        String HostName = Address2.getHostName();
        // Lấy ra tên miền đầy đủ của địa chỉ IP
        String canonicalHostName = Address2.getCanonicalHostName();
        // Lấy thông tin của địa chỉ IP dưới dạng 1 mảng byte[]
        byte[] address = Address2.getAddress();
        // Lấy thông tin của địa chỉ IP (một chuỗi ký tự)
        String strHostAddress = Address2.getHostAddress();
        // Kiểm tra xem địa chỉ IP có thể được truy cập hay không trong khoảng thời gian timeout
        boolean isReachable = Address2.isReachable(100);

        System.out.println("Lấy ra tên miền của địa chỉ IP: " + HostName);
        System.out.println("Lấy ra tên miền đầy đủ của địa chỉ IP: " + canonicalHostName);
        System.out.println("Lấy thông tin của địa chỉ IP dưới dạng 1 mảng byte[]: ");
        for (int i = 0; i < address.length; i++)
            System.out.print(address[i]);
        System.out.println();
        System.out.println("Lấy thông tin của địa chỉ IP (một chuỗi ký tự): " + strHostAddress);
        System.out.println("Kiểm tra xem địa chỉ IP có thể được truy cập hay không trong khoảng thời gian timeout: " + isReachable);

    }
}
/*
*
* Các địa chỉ Internet được tra cứu thông qua một chuỗi các máy chủ được lưu trữ theo cấu trúc phân cấp.
* Điều này có nghĩa là máy tính cục bộ của bạn có thể tự động biết một bản đồ ánh xạ tên miền sang địa chỉ IP cụ thể
* , chẳng hạn cho chính nó và các máy chủ gần đó.
* Đối với các tên miền khác, nó có thể yêu cầu máy chủ DNS cục bộ để lấy thông tin địa chỉ IP. Nếu máy chủ đó không
* có địa chỉ cụ thể, nó có thể gửi yêu cầu đến một trang web từ xa để lấy thông tin. Quá trình này có thể tiếp tục cho
* đến máy chủ gốc. Quá trình này có thể mất thời gian rất lâu, vì vậy nên tổ chức mã của bạn để lưu trữ thông tin địa chỉ
* IP cục bộ thay vì tra cứu lặp đi lặp lại.
*
* Java hỗ trợ cả địa chỉ IPv4 và IPv6. Do đó, hai lớp con của InetAddress được tạo ra: Inet4Address và Inet6Address.
* Inet4Address đại diện cho địa chỉ IPv4 theo kiểu truyền thống.
* Inet6Address đóng gói một địa chỉ IPv6 mới hơn. Vì chúng là lớp con của InetAddress, một tham chiếu InetAddress
* có thể tham chiếu đến cả hai loại địa chỉ này. Đây là một cách mà Java có thể thêm chức năng IPv6 mà không làm hỏng
* mã hiện có hoặc thêm nhiều lớp mới. Đối với phần lớn, bạn có thể đơn giản sử dụng InetAddress khi làm việc với
* địa chỉ IP vì nó có thể chứa cả hai kiểu địa chỉ này.
*
* */
