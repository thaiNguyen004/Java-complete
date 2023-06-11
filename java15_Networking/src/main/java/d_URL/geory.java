package d_URL;


/*
* URL
* Ví dụ trước đó khá khó hiểu vì Internet hiện đại không liên quan đến các giao thức cũ như whois, finger và FTP.
* Nó liên quan đến WWW, World Wide Web. Web là một tập hợp không chặt chẽ các giao thức cấp cao và định dạng tập tin,
* được thống nhất trong trình duyệt web. Một trong những khía cạnh quan trọng nhất của Web là
* Tim Berners-Lee đã tạo ra một cách có khả năng mở rộng để xác định tất cả các tài nguyên trên Mạng.
* Khi bạn có thể đặt tên đáng tin cậy cho bất cứ điều gì, nó trở thành một mô hình rất mạnh mẽ.
* Uniform Resource Locator (URL) chính làm điều đó.
*
* URL cung cấp một hình thức khá thông minh để xác định hoặc địa chỉ duy nhất thông tin trên Internet.
* URL phổ biến; mọi trình duyệt sử dụng chúng để xác định thông tin trên Web. Trong thư viện lớp mạng của Java,
* lớp URL cung cấp một API đơn giản, ngắn gọn để truy cập thông tin trên Internet bằng URL.
*
* Tất cả các URL chia sẻ cùng định dạng cơ bản, mặc dù cho phép một số biến thể.
* Dưới đây là hai ví dụ: http://www.HerbSchildt.com/ và http://www.HerbSchildt.com:80/index.htm.
* Một đặc tả URL dựa trên bốn thành phần. Thành phần đầu tiên là giao thức sử dụng, được phân tách với phần còn lại của
* vị trí bằng dấu hai chấm (:). Các giao thức thông thường là HTTP (Hypertext transfer protocol), FTP (File transfer protocol),
* gopher và file, mặc dù ngày nay hầu hết mọi thứ đều được thực hiện qua HTTP (thực tế, hầu hết các trình duyệt sẽ hoạt động
* đúng nếu bạn bỏ đi "http://" từ định dạng URL của bạn). Thành phần thứ hai là tên máy chủ hoặc địa chỉ IP của máy chủ được sử dụng;
* phần này được giới hạn bên trái bằng dấu gạch chéo kép (//) và bên phải bằng một dấu gạch chéo (/) hoặc tùy chọn là dấu hai chấm (:).
* Thành phần thứ ba, số cổng, là một tham số tùy chọn, được giới hạn bên trái từ tên máy chủ bằng dấu hai chấm (:) và bên phải bằng dấu gạch chéo (/).
* (Nó mặc định là cổng 80, cổng HTTP được xác định trước; do đó, ":80" là dư thừa.)
* Phần thứ tư là đường dẫn tệp thực tế. Hầu hết các máy chủ HTTP sẽ thêm một tệp có tên index.html hoặc index.htm vào URL trỏ trực tiếp
* đến một tài nguyên thư mục. Do đó, http://www.HerbSchildt.com/ tương đương với http://www.HerbSchildt.com/index.htm.
*
* Lớp URL của Java có một số hàm tạo; mỗi hàm có thể ném ra một MalformedURLException. Một hình thức thường được sử dụng
* xác định URL bằng một chuỗi giống hệt như bạn thấy được hiển thị trong trình duyệt:
* URL(String urlSpecifier) throws MalformedURLException
*
* Hai hình thức tiếp theo của hàm tạo cho phép bạn phân tách URL thành các phần thành phần của nó:
* URL(String protocolName, String hostName, int port, String path) throws MalformedURLException
* URL(String protocolName, String hostName, String path) throws MalformedURLException
*
* Một hàm tạo thường được sử dụng khác cho phép bạn sử dụng một URL hiện có như một ngữ cảnh tham chiếu và
* sau đó tạo một URL mới từ ngữ cảnh đó. Mặc dù điều này nghe có vẻ hơi phức tạp, nhưng nó thực sự rất dễ dàng và hữu ích.
* URL(URL urlObj, String urlSpecifier) throws MalformedURLException
*
* Ví dụ sau đây tạo một URL đến một trang trên HerbSchildt.com và sau đó xem xét các thuộc tính của nó.*/
import java.net.*;
public class geory {
    public static void main(String[] args) throws MalformedURLException {
        URL hp = new URL("http://www.HerbSchildt.com/WhatsNew");
        System.out.println("Protocol: " + hp.getProtocol());
        System.out.println("Port: " + hp.getPort());

        System.out.println("Host: " + hp.getHost());
        System.out.println("File: " + hp.getFile());
        System.out.println("Ext: " + hp.toExternalForm());
        /*
        *   Protocol: http
            Port: -1
            Host: www.HerbSchildt.com
            File: /WhatsNew
            Ext: http://www.HerbSchildt.com/WhatsNew
        * */

        /*
        * Lưu ý rằng cổng là -1; điều này có nghĩa là một cổng không được thiết lập rõ ràng.
        * Khi có một đối tượng URL, bạn có thể lấy dữ liệu liên quan đến nó. Để truy cập vào các bit thực tế hoặc
        * thông tin nội dung của một URL, hãy tạo một đối tượng URLConnection từ nó bằng cách sử dụng phương thức
        * openConnection() của nó, như sau:
        *       urlc = url.openConnection()
        * Phương thức openConnection() có dạng tổng quát sau:
        *       URLConnection openConnection() throws IOException
        * Nó trả về một đối tượng URLConnection liên quan đến đối tượng URL gọi phương thức.
        * Lưu ý rằng nó có thể ném ra một IOException.
        *
        * */
    }
}
