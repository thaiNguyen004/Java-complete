package f_part2_ServletHTTP_API;
/*
* Lớp HttpServlet mở rộng từ GenericServlet. Nó được sử dụng phổ biến khi phát triển các
* servlet nhận và xử lý yêu cầu HTTP.
*
* Các phương thức được định nghĩa bởi lớp HttpServlet được tóm tắt trong Bảng sau:
*
* Dưới đây là mô tả các phương thức:
*
* 1. void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException:
* Phương thức này được gọi khi có yêu cầu HTTP DELETE từ client. Nó xử lý yêu cầu này và tạo phản hồi tương ứng.
*
* 2. void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException:
* Phương thức này được gọi khi có yêu cầu HTTP GET từ client. Nó xử lý yêu cầu này và tạo phản hồi tương ứng.
*
* 3. void doHead(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException:
* Phương thức này được gọi khi có yêu cầu HTTP HEAD từ client. Nó xử lý yêu cầu này và tạo phản hồi tương ứng.
*
* 4. void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException:
* Phương thức này được gọi khi có yêu cầu HTTP OPTIONS từ client. Nó xử lý yêu cầu này và tạo phản hồi tương ứng.
*
* 5. void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException:
* Phương thức này được gọi khi có yêu cầu HTTP POST từ client. Nó xử lý yêu cầu này và tạo phản hồi tương ứng.
*
* 6. void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException:
* Phương thức này được gọi khi có yêu cầu HTTP PUT từ client. Nó xử lý yêu cầu này và tạo phản hồi tương ứng.
*
* 7. void doTrace(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException:
* Phương thức này được gọi khi có yêu cầu HTTP TRACE từ client. Nó xử lý yêu cầu này và tạo phản hồi tương ứng.
*
* 8. long getLastModified(HttpServletRequest req):
* Phương thức này trả về thời gian sửa đổi lần cuối cùng của tài nguyên mà servlet đại diện cho. Nó được sử dụng trong việc xác định xem liệu phản hồi từ servlet có cần được gửi lại cho client hay không.
*
* 9. void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException:
* Phương thức này được gọi bởi container servlet để xử lý yêu cầu từ client. Nó tự động xác định phương thức HTTP của yêu cầu và gọi phương thức tương ứng (doGet, doPost, doPut, v.v.) để xử lý yêu cầu.
*
* */
public class f_HttpServletClass {
}
