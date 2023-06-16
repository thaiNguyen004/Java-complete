package f_part2_ServletHTTP_API;
/*
* Lớp Cookie
*
* Lớp Cookie đóng gói một cookie. Một cookie được lưu trên máy khách (client) và chứa thông tin trạng thái.
* Cookie rất hữu ích để theo dõi hoạt động của người dùng. Ví dụ, giả sử một người dùng truy cập vào một cửa hàng trực tuyến.
* Một cookie có thể lưu trữ tên, địa chỉ và các thông tin khác của người dùng. Người dùng không cần phải nhập lại dữ liệu
* này mỗi khi truy cập cửa hàng.
*
* Một servlet có thể ghi một cookie vào máy người dùng thông qua phương thức `addCookie()` của giao diện HttpServletResponse.
* Dữ liệu của cookie sau đó được bao gồm trong tiêu đề của phản hồi HTTP được gửi đến trình duyệt.
*
* Các tên và giá trị của cookie được lưu trữ trên máy người dùng.
* Một số thông tin có thể được lưu trữ cho mỗi cookie bao gồm:

- Tên của cookie
- Giá trị của cookie
- Ngày hết hạn của cookie
- Domain và path của cookie

* Ngày hết hạn xác định khi nào cookie sẽ bị xóa khỏi máy người dùng.
* Nếu không gán một ngày hết hạn cụ thể cho cookie, nó sẽ bị xóa khi phiên duyệt hiện tại kết thúc.
*
* Domain và path của cookie xác định khi nào nó sẽ được bao gồm trong tiêu đề của một yêu cầu HTTP.
* Nếu người dùng nhập một URL mà domain và path phù hợp với các giá trị này, thì cookie sẽ được cung cấp cho máy chủ web.
* Ngược lại, nó sẽ không được cung cấp.
*
* Lớp Cookie có một constructor duy nhất với chữ ký như sau:
*   Cookie(String name, String value)
* Ở đây, tên và giá trị của cookie được cung cấp như đối số cho constructor.
* Các phương thức của lớp Cookie được tóm tắt trong bảng sau:
*
* Các phương thức của lớp Cookie là:

*
* Object clone():
* Trả về một bản sao của đối tượng Cookie.
*
* String getComment():
* Trả về giá trị của trường "Comment" trong cookie.
*
* String getDomain():
* Trả về giá trị của trường "Domain" trong cookie.
*
* int getMaxAge():
* Trả về thời gian sống tối đa của cookie, được đặt dưới dạng giây.
*
* String getName():
* Trả về tên của cookie.
*
* String getPath():
* Trả về giá trị của trường "Path" trong cookie.
*
* boolean getSecure():
* Kiểm tra xem cookie có được gắn kết với kết nối an toàn (HTTPS) hay không.
*
* String getValue():
* Trả về giá trị của cookie.
*
* int getVersion():
* Trả về phiên bản của cookie.
*
* boolean isHttpOnly():
* Kiểm tra xem cookie có được đánh dấu là "HttpOnly" hay không.
*
* void setComment(String c):
* Đặt giá trị của trường "Comment" cho cookie.
*
* void setDomain(String d):
* Đặt giá trị của trường "Domain" cho cookie.
*
* void setHttpOnly(boolean httpOnly):
* Đặt giá trị cho trường "HttpOnly" cho cookie.
*
* void setMaxAge(int secs):
* Đặt thời gian sống tối đa cho cookie, dưới dạng giây.
*
* void setPath(String p):
* Đặt giá trị của trường "Path" cho cookie.
*
* void setSecure(boolean secure):
* Đặt trạng thái bảo mật của cookie.
*
* void setValue(String v):
* Đặt giá trị cho cookie.
*
* void setVersion(int v):
* Đặt phiên bản của cookie.
*
* */
public class e_Cookie {
}
