package k_Http;
/*
* HttpClient
* HttpClient đóng gói cơ chế yêu cầu/phản hồi của HTTP. Nó hỗ trợ cả giao tiếp đồng bộ
* và bất đồng bộ. Ở đây, chúng ta chỉ sử dụng giao tiếp đồng bộ, nhưng bạn có thể muốn
* thử nghiệm giao tiếp bất đồng bộ một cách riêng. Khi bạn có một đối tượng HttpClient,
* bạn có thể sử dụng nó để gửi yêu cầu và nhận phản hồi. Do đó, nó là nền tảng của API HTTP Client.
*
* HttpClient là một lớp trừu tượng và các phiên bản không được tạo ra thông qua một
* constructor công khai. Thay vào đó, bạn sẽ sử dụng một phương thức factory để xây dựng
* một đối tượng HttpClient. HttpClient hỗ trợ việc xây dựng với giao diện HttpClient.Builder,
* cung cấp một số phương thức cho phép bạn cấu hình HttpClient. Để lấy một builder HttpClient,
* sử dụng phương thức tĩnh newBuilder(). Nó trả về một builder cho phép bạn cấu hình HttpClient
* mà nó sẽ tạo ra. Tiếp theo, gọi phương thức build() trên builder. Nó tạo và trả về một phiên bản
* HttpClient. Ví dụ, đoạn mã sau tạo ra một HttpClient sử dụng các thiết lập mặc định:
*
* HttpClient myHC = HttpClient.newBuilder().build();
*
* HttpClient.Builder định nghĩa một số phương thức cho phép bạn cấu hình builder.
* Dưới đây là một ví dụ. Mặc định, không theo dõi chuyển hướng (redirect).
* Bạn có thể thay đổi điều này bằng cách gọi phương thức followRedirects(), truyền vào
* cài đặt chuyển hướng mới, phải là một giá trị trong đối tượng liệt kê HttpClient.Redirect.
* Nó định nghĩa các giá trị sau: ALWAYS, NEVER và NORMAL. Hai giá trị đầu tiên có ý nghĩa rõ ràng.
* Cài đặt NORMAL cho phép theo dõi chuyển hướng trừ khi chuyển hướng từ một trang HTTPS sang một
* trang HTTP. Ví dụ, đoạn mã sau tạo ra một builder trong đó chính sách chuyển hướng là NORMAL.
* Sau đó, nó sử dụng builder đó để xây dựng một đối tượng HttpClient.
*
* HttpClient.Builder myBuilder =
* HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL);
* HttpClient.myHC = myBuilder.build();
*
* Ngoài ra, các cài đặt cấu hình builder bao gồm xác thực, proxy, phiên bản HTTP và ưu tiên.
* Do đó, bạn có thể xây dựng một HTTP client phù hợp với hầu hết mọi nhu cầu.
*
* Trong các trường hợp mà cấu hình mặc định đủ đáp ứng, bạn có thể lấy một HttpClient mặc định
* trực tiếp bằng cách gọi phương thức newHttpClient(). Nó được thể hiện dưới đây:
*
* static HttpClient newHttpClient()
*
* Một đối tượng HttpClient với cấu hình mặc định được trả về. Ví dụ, đoạn mã sau tạo ra một HttpClient
* mặc định mới:
*
* HttpClient myHC = HttpClient.newHttpClient();
*
* Vì một client mặc định đủ cho mục đích của cuốn sách này, đây là phương pháp được sử dụng trong các
* ví dụ tiếp theo.
*
* Sau khi có một phiên bản HttpClient, bạn có thể gửi một yêu cầu đồng bộ bằng cách gọi phương thức send()
* của nó, như được hiển thị dưới đây:
*
* < T > HttpResponse <T> send(HttpRequest req, HttpResponse.BodyHandler<T> handler)
*                                           throws IOException, InterruptedException
*
* Ở đây, req bao gồm yêu cầu và handler chỉ định cách xử lý phần thân phản hồi.
* Như bạn sẽ thấy trong thời gian ngắn, thường thì bạn có thể sử dụng một trong các body handler
* được định nghĩa sẵn bởi lớp HttpResponse.BodyHandlers. Một đối tượng HttpResponse được trả về.
* Do đó, phương thức send() cung cấp cơ chế cơ bản cho giao tiếp HTTP.
* */
public class b_HttpClient {
}
