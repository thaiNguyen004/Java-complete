package d_part1_ServletAPI;
/*
* Giao diện ServletConfig cho phép servlet lấy dữ liệu cấu hình khi nó được tải.
*
* Các phương thức được khai báo bởi giao diện này được tóm tắt như sau:
*
* 1. getServletContext():
* Phương thức này trả về một đối tượng ServletContext mà servlet đang chạy trong đó. ServletContext cung cấp các phương thức
* để tương tác với môi trường thực thi của servlet container.
*
* 2. getInitParameter(String param):
* Phương thức này nhận vào một chuỗi tham số (`param`) và trả về giá trị của tham số cấu hình tương ứng trong ServletConfig.
* Điều này cho phép servlet truy cập và sử dụng các giá trị cấu hình được chỉ định trong tệp cấu hình của servlet container.
*
* 3. getInitParameterNames():
* Phương thức này trả về một Enumeration chứa tên của tất cả các tham số cấu hình được khai báo trong ServletConfig.
* Điều này cho phép servlet lặp qua tất cả các tham số và truy cập giá trị của chúng.
*
* 4. getServletName():
* Phương thức này trả về tên của servlet được khai báo trong tệp cấu hình. Điều này cho phép servlet nhận biết tên của
* chính nó trong quá trình thực thi.
*
* */
public class c_ServletConfig {
}
