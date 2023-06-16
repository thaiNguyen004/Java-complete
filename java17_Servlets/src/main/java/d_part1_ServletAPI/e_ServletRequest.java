package d_part1_ServletAPI;
/*
* Giao diện ServletRequest cho phép servlet nhận thông tin về một yêu cầu từ client.
* Dưới đây là mô tả của một số phương thức trong giao diện này:
*
*
* 1. Object getAttribute(String attr): Phương thức này trả về giá trị của thuộc tính (attribute) được
* lưu trữ trong ServletRequest dựa trên tên thuộc tính (attr) được cung cấp.
*
* 2. String getCharacterEncoding(): Phương thức này trả về bộ mã ký tự (character encoding) của yêu cầu.
*
* 3. int getContentLength(): Phương thức này trả về kích thước (độ dài) của nội dung yêu cầu.
*
* 4. String getContentType(): Phương thức này trả về kiểu nội dung (content type) của yêu cầu.
*
* 5. ServletInputStream getInputStream(): Phương thức này trả về một đối tượng ServletInputStream,
* cho phép đọc dữ liệu đến từ client. Phương thức này có thể gây ra IOException.
*
* 6. String getParameter(String pname): Phương thức này trả về giá trị của tham số (parameter)
* trong yêu cầu dựa trên tên tham số (pname) được cung cấp.
*
* 7. Enumeration<String> getParameterNames(): Phương thức này trả về một Enumeration chứa tất cả
* tên của các tham số trong yêu cầu.
*
* 8. String[] getParameterValues(String name): Phương thức này trả về một mảng các giá trị của
* tham số trong yêu cầu dựa trên tên tham số được cung cấp.
*
* 9. String getProtocol(): Phương thức này trả về phiên bản giao thức mà client sử dụng trong yêu cầu.
*
* 10. BufferedReader getReader(): Phương thức này trả về một đối tượng BufferedReader để đọc
* nội dung yêu cầu. Phương thức này có thể gây ra IOException.
*
* 11. String getRemoteAddr(): Phương thức này trả về địa chỉ IP của client.
*
* 12. String getRemoteHost(): Phương thức này trả về tên host của client.
*
* 13. String getScheme(): Phương thức này trả về giao thức (scheme) của URL của yêu cầu (ví dụ: "http", "https").
*
* 14. String getServerName(): Phương thức này trả về tên máy chủ (server) mà servlet đang chạy trên.
*
* 15. int getServerPort(): Phương thức này trả về cổng (port) của máy chủ (server) mà servlet đang chạy trên.
* */
public class e_ServletRequest {
}
