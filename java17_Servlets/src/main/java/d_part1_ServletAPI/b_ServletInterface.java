package d_part1_ServletAPI;
/*
* Giao diện Servlet
* Tất cả các servlet đều phải triển khai giao diện Servlet. Giao diện này khai báo các phương thức
*
* init()
* service()
* destroy()
*
* Được gọi bởi máy chủ trong quá trình vòng đời của một servlet. Giao diện cũng cung cấp một phương thức cho phép
* servlet lấy các tham số khởi tạo.
* Các phương thức được định nghĩa bởi giao diện Servlet được hiển thị :
*
* 1. void destroy():
* Được gọi khi servlet được hủy bỏ.
*
* 2. ServletConfig getServletConfig():
* Trả về một đối tượng ServletConfig chứa các tham số khởi tạo.
*
* 3. String getServletInfo():
* Trả về một chuỗi mô tả về servlet.
*
* 4. void init(ServletConfig sc) throws ServletException :
* Được gọi khi servlet được khởi tạo. Các tham số khởi tạo cho servlet có thể được lấy từ sc.
* Nếu servlet không thể khởi tạo, ngoại lệ ServletException sẽ được ném ra.
*
*
* 5. void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
* Phương thức `service` được gọi để xử lý một yêu cầu từ một client. Yêu cầu từ client có thể được đọc từ đối tượng `req`.
* Phản hồi đến client có thể được ghi vào đối tượng `res`. Một ngoại lệ được sinh ra nếu xảy ra vấn đề với servlet hoặc I/O.
*
*
* Các phương thức init(), service() và destroy() là các phương thức vòng đời của servlet.
* Chúng được gọi bởi máy chủ (server). Phương thức getServletConfig() được gọi bởi servlet để lấy các tham số khởi tạo.
* Một nhà phát triển servlet ghi đè phương thức getServletInfo() để cung cấp một chuỗi thông tin hữu ích (ví dụ: số phiên bản).
* Phương thức này cũng được gọi bởi máy chủ (server).
* */
public class b_ServletInterface {
}
