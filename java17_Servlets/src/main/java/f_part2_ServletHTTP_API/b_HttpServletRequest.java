package f_part2_ServletHTTP_API;
/*
* Giao diện HttpServletRequest cho phép một servlet lấy thông tin về yêu cầu từ phía khách hàng.
*
* Dưới đây là mô tả của các phương thức được liệt kê:
*
* String getAuthType()`:
* Trả về kiểu xác thực được sử dụng trong yêu cầu, ví dụ như "BASIC", "DIGEST", "FORM", vv.
*
* Cookie[] getCookies()`:
* Trả về một mảng chứa tất cả các cookie được gửi kèm trong yêu cầu từ khách hàng.
*
* long getDateHeader(String field)`:
* Trả về giá trị ngày/giờ của trường dữ liệu trong tiêu đề của yêu cầu,
* ví dụ như "If-Modified-Since" hoặc "Expires".
*
* String getHeader(String field)`:
* Trả về giá trị của trường dữ liệu trong tiêu đề của yêu cầu, dựa trên tên trường dữ liệu.
*
* Enumeration<String> getHeaderNames()`:
* Trả về một Enumeration chứa tất cả các tên trường dữ liệu trong tiêu đề của yêu cầu.
*
* int getIntHeader(String field)`:
* Trả về giá trị số nguyên của trường dữ liệu trong tiêu đề của yêu cầu, dựa trên tên trường dữ liệu.
*
* String getMethod()`:
* Trả về phương thức HTTP được sử dụng trong yêu cầu, ví dụ như "GET", "POST", "PUT", vv.
*
* String getPathInfo()`:
* Trả về thông tin về đường dẫn bổ sung trong URL sau tên servlet, nếu có.
*
* String getPathTranslated()`:
* Trả về đường dẫn vật lý của tệp được chỉ định bởi `getPathInfo()`.
*
* String getQueryString()`:
* Trả về chuỗi các tham số truy vấn được gửi kèm trong URL.
*
* String getRemoteUser()`:
* Trả về tên người dùng từ xa được xác thực trong yêu cầu, nếu có.
*
* String getRequestedSessionId()`:
* Trả về ID phiên yêu cầu từ khách hàng, nếu có.
*
* String getRequestURI()`:
* Trả về URI (Uniform Resource Identifier) của yêu cầu.
*
* StringBuffer getRequestURL()`:
* Trả về URL (Uniform Resource Locator) của yêu cầu dưới dạng StringBuffer.
*
* String getServletPath()`:
* Trả về phần đường dẫn của URL được khớp với servlet trong yêu cầu.
*
* HttpSession getSession()`:
* Trả về phiên hiện tại được liên kết với yêu cầu hoặc tạo một phiên mới nếu chưa tồn tại.
*
* HttpSession getSession(boolean new)`:
* Trả về phiên hiện tại được liên kết với yêu cầu hoặc tạo một phiên mới nếu chưa tồn tại,
* tuỳ thuộc vào giá trị của `new`.
*
* boolean isRequestedSessionIdFromCookie()`:
* Xác định xem ID phiên yêu cầu có được gửi từ cookie không.
*
* boolean isRequestedSessionIdFromURL()`:
* Xác định xem ID phiên yêu cầu có được gửi qua URL không.
*
* boolean isRequestedSessionIdValid()`:
* Xác định xem ID phiên yêu cầu có hợp lệ hay không.
*
* */
public class b_HttpServletRequest {
}
