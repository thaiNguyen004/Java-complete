package k_Http;
/*
*
* HttpRequest
* API HTTP Client đóng gói các yêu cầu trong lớp trừu tượng HttpRequest.
* Để tạo một đối tượng HttpRequest, bạn sẽ sử dụng một builder. Để có được một builder,
* gọi newBuilder(). Có hai hình thức như sau:
*
* static HttpRequest.Builder newBuilder()
* static HttpRequest.Builder newBuilder(URI uri)
*
* Hình thức đầu tiên tạo một builder mặc định. Hình thức thứ hai cho phép bạn chỉ định URI của tài nguyên.
* HttpRequest.Builder cho phép bạn chỉ định các khía cạnh khác nhau của yêu cầu,
* chẳng hạn như phương thức yêu cầu sử dụng (mặc định là GET). Bạn cũng có thể đặt thông tin tiêu đề,
* URI và phiên bản HTTP, và nhiều thông số khác. Ngoại trừ URI, thường thì các thiết lập mặc định là đủ.
* Bạn có thể lấy chuỗi biểu diễn của phương thức yêu cầu bằng cách gọi method() trên đối tượng HttpRequest.
*
* Để thực sự xây dựng một yêu cầu, gọi build() trên thể hiện của builder. Được thể hiện ở đây:
* HttpRequest build()
*
* Sau khi có một thể hiện HttpRequest, bạn có thể sử dụng nó trong một cuộc gọi đến phương thức send()
* của HttpClient, như được hiển thị trong phần trước.*/
public class c_HttpRequest {

}
