package k_Http;
/*
* Giới thiệu java.net.http
* Nội dung trước đã giới thiệu về hỗ trợ mạng truyền thống của Java do gói java.net cung cấp.
* API này có sẵn trong tất cả các phiên bản của Java và được sử dụng rộng rãi.
* Do đó, hiểu biết về cách tiếp cận truyền thống của Java đối với mạng là quan trọng đối với tất cả các nhà lập trình viên.
* Tuy nhiên, bắt đầu từ JDK 11, một gói mạng mới được gọi là java.net.http, trong module java.net.http,
* đã được thêm vào. Nó cung cấp hỗ trợ mạng cải tiến và cập nhật cho các khách hàng HTTP.
*
* API mới này thường được gọi là API HTTP Client.
* Đối với nhiều loại kết nối mạng HTTP, khả năng được xác định bởi API trong java.net.http có thể cung cấp
* các giải pháp ưu việt hơn. Ngoài việc cung cấp một API đơn giản và dễ sử dụng, những lợi ích khác bao gồm
* hỗ trợ cho giao tiếp không đồng bộ, HTTP/2 và điều khiển dòng. Nói chung, API HTTP Client được thiết kế
* như một lựa chọn tốt hơn cho các chức năng được cung cấp bởi HttpURLConnection. Nó cũng hỗ trợ giao thức
* WebSocket cho việc giao tiếp hai chiều.
*
* Phần thảo luận tiếp theo khám phá một số tính năng quan trọng của API HTTP Client. Hãy nhớ rằng nó chứa
* nhiều hơn những gì được mô tả ở đây. Nếu bạn sẽ viết mã dựa trên mạng phức tạp, thì đây là một gói mà bạn
* nên xem xét kỹ lưỡng. Mục đích của chúng tôi ở đây là giới thiệu một số kiến thức cơ bản liên quan
* đến module mới quan trọng này.
*
* Ba yếu tố chính
* Trong phần thảo luận tiếp theo, tập trung vào ba yếu tố cốt lõi của API HTTP Client:
* HttpClient: Đóng gói một HTTP client. Nó cung cấp phương tiện để gửi một yêu cầu và nhận được một phản hồi.
* HttpRequest: Đóng gói một yêu cầu.
* HttpResponse: Đóng gói một phản hồi.
*
* Các thành phần này hoạt động cùng nhau để hỗ trợ các tính năng yêu cầu/phản hồi của HTTP.
* Đây là quy trình chung. Đầu tiên, tạo một phiên bản của HttpClient. Tiếp theo, xây dựng một HttpRequest
* và gửi nó bằng cách gọi send() trên HttpClient. Phản hồi được trả về bởi send(). Từ phản hồi, bạn có thể lấy
* được các tiêu đề và nội dung phản hồi. Trước khi thực hiện một ví dụ, chúng ta sẽ bắt đầu với một cái nhìn
* tổng quan về những khía cạnh cơ bản của API này.
* */
public class a_geory {
}
