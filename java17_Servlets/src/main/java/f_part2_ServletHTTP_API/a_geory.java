package f_part2_ServletHTTP_API;

import java.util.Random;

/*
* Package javax.servlet.http
*
* Các ví dụ trước đã sử dụng các lớp và giao diện được định nghĩa trong javax.servlet, như ServletRequest,
* ServletResponse và GenericServlet, để minh họa chức năng cơ bản của các servlet.
*
* Tuy nhiên, khi làm việc với HTTP, thông thường bạn sẽ sử dụng các giao diện và lớp trong javax.servlet.http.
* Chức năng của gói này giúp dễ dàng xây dựng các servlet hoạt động với yêu cầu và phản hồi HTTP.
*
* Bảng sau tóm tắt các giao diện được sử dụng trong chương này:
* 1. HttpServletRequest:
* Giao diện HttpServletRequest cho phép servlet đọc dữ liệu từ một yêu cầu HTTP. Nó cung cấp các phương thức để truy cập
* các thông tin như thông tin yêu cầu, tham số yêu cầu, tiêu đề yêu cầu, phương thức yêu cầu và nhiều hơn nữa.
* Giao diện này cho phép servlet xử lý và truy cập dữ liệu từ yêu cầu HTTP gửi từ client.
*
* HttpServletResponse:
* Giao diện HttpServletResponse cho phép servlet ghi dữ liệu vào một phản hồi HTTP. Nó cung cấp các phương thức để
* thiết lập các thông tin như tiêu đề phản hồi, kiểu nội dung, mã trạng thái và nhiều hơn nữa.
* Giao diện này cho phép servlet tạo và gửi phản hồi HTTP từ server đến client.
*
* HttpSession:
* Giao diện HttpSession cho phép đọc và ghi dữ liệu phiên. Phiên là một khái niệm trong ứng dụng web để theo dõi trạng thái
* của người dùng qua nhiều yêu cầu. Giao diện này cung cấp các phương thức để lưu trữ và truy xuất dữ liệu phiên,
* như lưu trữ giá trị theo khóa, xóa giá trị, xóa phiên và nhiều hơn nữa.
* Nó cho phép servlet lưu trữ thông tin phiên của người dùng và duy trì trạng thái giữa các yêu cầu của cùng một người dùng.
*
*
* Bảng sau tóm tắt các lớp được sử dụng trong chương này.
* Trong số đó, lớp quan trọng nhất là HttpServlet. Thông thường, các nhà phát triển servlet mở rộng lớp này để xử lý
* các yêu cầu HTTP.
*
* Lớp Cookie:
* Lớp Cookie trong gói javax.servlet.http được sử dụng để đại diện cho một cookie trong một yêu cầu HTTP hoặc phản hồi HTTP.
* Cookie được sử dụng để lưu trữ thông tin trạng thái trên máy khách và được gửi lại cho máy chủ với mỗi yêu cầu.
* Lớp Cookie cung cấp các phương thức để thiết lập và truy xuất thông tin của một cookie,
* bao gồm tên, giá trị, thời gian sống, miền và đường dẫn.
*
* Lớp HttpServlet:
* Lớp HttpServlet cung cấp một cơ chế tiện lợi cho việc xây dựng servlet xử lý các yêu cầu HTTP.
* Nó là một lớp trừu tượng mà các lớp con phải kế thừa và triển khai các phương thức để xử lý các phương thức HTTP
* như GET, POST, PUT, DELETE, vv. Lớp HttpServlet cung cấp các phương thức tiện ích để truy cập và xử lý thông tin
* yêu cầu và phản hồi, bao gồm các phương thức doGet(), doPost(), doPut(), doDelete(), vv.
*
* */
public class a_geory {
}
