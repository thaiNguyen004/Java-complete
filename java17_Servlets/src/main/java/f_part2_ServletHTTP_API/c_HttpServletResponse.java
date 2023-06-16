package f_part2_ServletHTTP_API;
/*
* Giao diện HttpServletResponse cho phép một servlet tạo ra một phản hồi HTTP cho một khách hàng.
* Có một số hằng số được định nghĩa trong giao diện này. Chúng tương ứng với các mã trạng thái khác nhau có thể được gán
* cho một phản hồi HTTP. Ví dụ:
*
* - SC_OK : cho biết yêu cầu HTTP thành công,
* - SC_NOT_FOUND: cho biết nguồn tài nguyên được yêu cầu không khả dụng.
*
* Một số phương thức trong giao diện này được tóm tắt:
* Dưới đây là mô tả các phương thức trong giao diện HttpServletResponse:
*
* void addCookie(Cookie cookie): Thêm một Cookie vào phản hồi HTTP.
*
* boolean containsHeader(String field): Kiểm tra xem phản hồi có chứa một trường (field) header cụ thể không.
*
* String encodeURL(String url): Mã hóa một URL để được sử dụng trong một phản hồi hoặc liên kết.
*
* String encodeRedirectURL(String url): Mã hóa một URL để được sử dụng trong phản hồi chuyển hướng (redirect).
*
* void sendError(int code): Gửi một mã lỗi HTTP tới khách hàng và kết thúc quá trình xử lý phản hồi.
*
* void sendError(int code, String s): Gửi một mã lỗi HTTP và thông báo lỗi tới khách hàng, kết thúc quá trình xử lý phản hồi.
*
* void sendRedirect(String url): Chuyển hướng khách hàng tới một URL mới.
*
* void setDateHeader(String field, long msec): Đặt giá trị cho trường header của ngày và giờ trong phản hồi.
*
* void setHeader(String field, String value): Đặt giá trị cho một trường header trong phản hồi.
*
* void setIntHeader(String field, int value): Đặt giá trị cho một trường header kiểu số nguyên trong phản hồi.
*
* void setStatus(int code): Đặt mã trạng thái HTTP cho phản hồi.
*
* */
public class c_HttpServletResponse {
}
