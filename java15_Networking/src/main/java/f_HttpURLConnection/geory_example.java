package f_HttpURLConnection;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * HttpURLConnection
 * Java cung cấp một lớp con của URLConnection để hỗ trợ kết nối HTTP. Lớp này được gọi là HttpURLConnection.
 * Bạn có thể nhận được một đối tượng HttpURLConnection theo cách tương tự vừa được trình bày, bằng cách gọi
 * phương thức openConnection() trên một đối tượng URL, nhưng bạn phải ép kiểu kết quả thành HttpURLConnection.
 * (Tất nhiên, bạn phải đảm bảo rằng bạn đang mở một kết nối HTTP thực sự.) Sau khi bạn đã nhận được một tham chiếu
 * đến đối tượng HttpURLConnection, bạn có thể sử dụng bất kỳ phương thức nào được kế thừa từ URLConnection.
 * Bạn cũng có thể sử dụng bất kỳ phương thức nào được định nghĩa bởi HttpURLConnection. Dưới đây là một số ví dụ:
 *
 * Dưới đây là mô tả các phương thức được liệt kê:
 *
 * 1. `static boolean getFollowRedirects()`:
 * Phương thức này trả về giá trị hiện tại của cờ followRedirects. Nếu giá trị của cờ là `true`,
 * thì HttpURLConnection sẽ tự động chuyển hướng theo các phản hồi redirect của máy chủ.
 * Nếu giá trị là `false`, chuyển hướng sẽ không được tự động xử lý.
 *
 * 2. `String getRequestMethod()`:
 * Phương thức này trả về phương thức HTTP hiện tại được sử dụng trong kết nối. Ví dụ: GET, POST, PUT, DELETE, v.v.
 *
 * 3. `int getResponseCode() throws IOException`:
 * Phương thức này trả về mã phản hồi HTTP từ máy chủ. Ví dụ: 200 (OK), 404 (Not Found), 500 (Internal Server Error), v.v.
 * Nếu không có phản hồi từ máy chủ, phương thức này sẽ ném ra IOException.
 *
 * 4. `String getResponseMessage() throws IOException`:
 * Phương thức này trả về thông điệp phản hồi HTTP tương ứng với mã phản hồi. Ví dụ: "OK", "Not Found", "Internal Server Error", v.v.
 * Nếu không có phản hồi từ máy chủ, phương thức này sẽ ném ra IOException.
 *
 * 5. `static void setFollowRedirects(boolean how)`:
 * Phương thức này được sử dụng để thiết lập cờ followRedirects. Nếu giá trị của cờ là `true`, thì HttpURLConnection
 * sẽ tự động chuyển hướng theo các phản hồi redirect của máy chủ.
 * Nếu giá trị là `false`, chuyển hướng sẽ không được tự động xử lý.
 *
 * 6. `void setRequestMethod(String how) throws ProtocolException`:
 * Phương thức này được sử dụng để thiết lập phương thức HTTP sử dụng trong kết nối. Tham số "how" là tên phương thức HTTP,
 * ví dụ: GET, POST, PUT, DELETE, v.v. Nếu tên phương thức không hợp lệ, phương thức này sẽ ném ra ProtocolException.
 *
 * Chương trình dưới đây minh họa việc sử dụng HttpURLConnection. Đầu tiên, nó thiết lập kết nối tới www.google.com.
 * Sau đó, chương trình hiển thị phương thức yêu cầu (request method), mã phản hồi (response code) và thông điệp phản hồi (response message).
 * Cuối cùng, nó hiển thị các khóa và giá trị trong tiêu đề phản hồi (response header).
 * */
public class geory_example {
    public static void main(String[] args) throws Exception{
        URL hp = new URL("http://www.google.com");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        // Hiển thị các phương thức yêu cầu (request method)
        System.out.println("Request method is " +
                hpCon.getRequestMethod());

        // Hiển thị mã phản hồi (response code)
        System.out.println("Response code is "+
                hpCon.getResponseCode());

        // Hiển thị thông điệp phản hồi (response message)
        System.out.println("Response message is " +
                hpCon.getResponseMessage());

        // Lấy một map chứa các tên của trường tiêu đề và giá trị
        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        Set<String> nameHeaderFieldSet = hdrMap.keySet();

        for (String nameHeaderField : nameHeaderFieldSet) {
            System.out.println("Tên trường tiêu đề: " + nameHeaderField+
                    "- Giá trị: " + hdrMap.get(nameHeaderField));
        }

        /*
        *   Request method is GET
            Response code is 200
            Response message is OK
            Tên trường tiêu đề: Transfer-Encoding- Giá trị: [chunked]
            Tên trường tiêu đề: null- Giá trị: [HTTP/1.1 200 OK]
            Tên trường tiêu đề: Server- Giá trị: [gws]
            Tên trường tiêu đề: P3P- Giá trị: [CP="This is not a P3P policy! See g.co/p3phelp for more info."]
            Tên trường tiêu đề: Date- Giá trị: [Sun, 11 Jun 2023 01:15:44 GMT]
            Tên trường tiêu đề: Accept-Ranges- Giá trị: [none]
            Tên trường tiêu đề: X-Frame-Options- Giá trị: [SAMEORIGIN]
            Tên trường tiêu đề: Cache-Control- Giá trị: [private, max-age=0]
            Tên trường tiêu đề: Vary- Giá trị: [Accept-Encoding]
            Tên trường tiêu đề: Set-Cookie- Giá trị: [NID=511=evP7V6iBxA3-yxoW_p99QeHsPT88lO5yRJ8r5Hlh1b7q6Iam2Kd3kQysbDqqSF0DITAJ_Hco0vkezXru_dmLlIm32sCgpjlMAWOae3W_h0Yrqor93neSiWUnP72LifaesVmO8NFq2Zr93qczoaf-6jKs52QrkbKfJvflNuDq5UA; expires=Mon, 11-Dec-2023 01:15:44 GMT; path=/; domain=.google.com; HttpOnly, AEC=AUEFqZdNBpLeI5rcPUb08bTOXXzVY-xlP0WyL9EviIxZPdm61TRX189mnJE; expires=Fri, 08-Dec-2023 01:15:44 GMT; path=/; domain=.google.com; Secure; HttpOnly; SameSite=lax, 1P_JAR=2023-06-11-01; expires=Tue, 11-Jul-2023 01:15:44 GMT; path=/; domain=.google.com; Secure]
            Tên trường tiêu đề: Expires- Giá trị: [-1]
            Tên trường tiêu đề: X-XSS-Protection- Giá trị: [0]
            Tên trường tiêu đề: Content-Security-Policy-Report-Only- Giá trị: [object-src 'none';base-uri 'self';script-src 'nonce-7wpCvsiNqF50CPXtSmifdw' 'strict-dynamic' 'report-sample' 'unsafe-eval' 'unsafe-inline' https: http:;report-uri https://csp.withgoogle.com/csp/gws/other-hp]
            Tên trường tiêu đề: Content-Type- Giá trị: [text/html; charset=ISO-8859-1]
        * */



    }
}
