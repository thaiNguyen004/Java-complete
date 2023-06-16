package f_part2_ServletHTTP_API;
/*
* Giao diện HttpSession
* Giao diện HttpSession cho phép một servlet đọc và ghi thông tin trạng thái được liên kết với một phiên HTTP.
* Một số phương thức của nó được tóm tắt sau đây.
* Tất cả các phương thức này sẽ ném ra một IllegalStateException nếu phiên đã bị hủy trước đó.
*
*
* Object getAttribute(String attr)`:
* Trả về giá trị của thuộc tính được lưu trữ trong HTTP session dựa trên tên thuộc tính đã cho.
*
* Enumeration<String> getAttributeNames()`:
* Trả về một đối tượng `Enumeration` chứa tên của tất cả các thuộc tính được lưu trữ trong HTTP session.
*
* long getCreationTime()`:
* Trả về thời điểm tạo ra HTTP session, được đo bằng mili giây kể từ thời điểm Epoch (1/1/1970 GMT).
*
* String getId()`:
* Trả về ID duy nhất của HTTP session.
*
* long getLastAccessedTime()`:
* Trả về thời điểm cuối cùng HTTP session được truy cập, được đo bằng mili giây kể từ thời điểm Epoch (1/1/1970 GMT).
*
* void invalidate()`:
* Đánh dấu HTTP session hiện tại là không hợp lệ và sẽ bị xóa.
*
* boolean isNew()`:
* Kiểm tra xem HTTP session có phải là mới được tạo hay không.
*
* void removeAttribute(String attr)`:
* Xóa thuộc tính được lưu trữ trong HTTP session dựa trên tên thuộc tính đã cho.
*
* void setAttribute(String attr, Object val)`:
* Đặt giá trị của một thuộc tính trong HTTP session dựa trên tên thuộc tính và giá trị đã cho.
*
* */
public class d_HttpSession {
}
