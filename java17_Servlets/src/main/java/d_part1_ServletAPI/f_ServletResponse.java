package d_part1_ServletAPI;
/*
* Giao diện ServletResponse cho phép một servlet tạo ra phản hồi (response) cho một client.
*
* Dưới đây là mô tả của một số phương thức trong giao diện này:
*
* 1. String getCharacterEncoding(): Phương thức này trả về bộ mã ký tự (character encoding) được sử dụng cho phản hồi.
*
* 2. ServletOutputStream getOutputStream(): Phương thức này trả về một đối tượng ServletOutputStream, cho phép ghi
* dữ liệu đến client. Phương thức này có thể gây ra IOException.
*
* 3. PrintWriter getWriter(): Phương thức này trả về một đối tượng PrintWriter, cho phép ghi dữ liệu dưới dạng văn bản
* đến client. Phương thức này có thể gây ra IOException.
*
* 4. void setContentLength(int size): Phương thức này đặt kích thước (độ dài) của nội dung phản hồi.
*
* 5. void setContentType(String type): Phương thức này đặt kiểu nội dung (content type) của phản hồi,
* ví dụ như "text/html" hoặc "application/json".
*
* */
public class f_ServletResponse {
}
