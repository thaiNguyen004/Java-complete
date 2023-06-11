package k_Http;
/*
* HttpResponse
* API HTTP Client đóng gói một phản hồi trong một thực thi của giao diện HttpResponse.
* Đây là một giao diện thông qua khai báo dưới dạng này:
* HttpResponse<T>
* Ở đây, T chỉ định loại của nội dung. Bởi vì loại nội dung là generic, nó cho phép xử lý nội dung theo nhiều cách khác nhau.
* Điều này mang lại một độ linh hoạt rộng lớn trong cách viết mã phản hồi của bạn.
*
* Khi một yêu cầu được gửi đi, một thể hiện của HttpResponse được trả về chứa phản hồi. HttpResponse định nghĩa một số
* phương thức cho phép bạn truy cập thông tin trong phản hồi. Có thể coi là phương thức quan trọng nhất là body(), được hiển thị ở đây:
*
* T body()
*
* Một tham chiếu đến nội dung được trả về. Loại tham chiếu cụ thể được xác định bởi kiểu T, mà được chỉ định bởi bộ xử lý
* nội dung được chỉ định bởi phương thức send().
*
* Bạn có thể lấy mã trạng thái liên quan đến phản hồi bằng cách gọi statusCode(), được hiển thị ở đây:
*
* int statusCode()
*
* Mã trạng thái HTTP được trả về. Giá trị 200 cho biết thành công.
* Một phương thức khác trong HttpResponse là headers(), cho phép bạn lấy thông tin đầu tiên của phản hồi.
* Nó được hiển thị ở đây:
*
* HttpHeaders headers()
*
* Các tiêu đề liên quan đến phản hồi được đóng gói trong một thể hiện của lớp HttpHeaders. Nó chứa các phương thức khác nhau
* cho phép bạn truy cập vào các tiêu đề. Một trong số đó được sử dụng trong ví dụ sau là map(), được hiển thị ở đây:
*
* Map<String, List<String>> map()
*
* Nó trả về một bản đồ chứa tất cả các trường tiêu đề và giá trị.
*
* Một trong những ưu điểm của API HTTP Client là các phản hồi có thể được xử lý tự động và theo nhiều cách khác nhau.
* Các phản hồi được xử lý bởi các thực thi của giao diện HttpResponse.BodyHandler. Một số phương thức tiền xử lý thân bản
* đã được cung cấp trong lớp HttpResponse.BodyHandlers. Dưới đây là ba ví dụ:
*
* static HttpResponse.BodyHandler<Path> ofFile(Path filename):
* Ghi thân bản của phản hồi vào tập tin được chỉ định bởi filename. Sau khi nhận được phản hồi,
* HttpResponse.body() sẽ trả về một đường dẫn (Path) tới tập tin.
*
* static HttpResponse.BodyHandler<InputStream> ofInputStream():
* Mở một InputStream để đọc thân bản của phản hồi. Sau khi nhận được phản hồi,
* HttpResponse.body() sẽ trả về một tham chiếu đến InputStream.
*
* static HttpResponse.BodyHandler<String> ofString():
* Thân bản của phản hồi được đặt vào một chuỗi (String). Sau khi nhận được phản hồi,
* HttpResponse.body() sẽ trả về chuỗi đó.
*
* Các trình xử lý trước định nghĩa khác lấy thân bản của phản hồi dưới dạng một mảng byte, một luồng các dòng, một tập tin
* tải xuống và một Flow.Publisher. Một người tiêu thụ không được điều khiển bởi luồng cũng được hỗ trợ. Trước khi tiếp tục,
* điều quan trọng cần nhắc là luồng được trả về bởi ofInputStream() nên được đọc toàn bộ. L
* àm như vậy cho phép giải phóng tài nguyên liên quan. Nếu không thể đọc toàn bộ thân bản vì một lý do nào đó,
* gọi close() để đóng luồng, điều này cũng có thể đóng kết nối HTTP. Nói chung, tốt nhất là đọc toàn bộ luồng.
*
* */
public class d_HttpResponse {
}
