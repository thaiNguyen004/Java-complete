package d_part1_ServletAPI;
/*
* Giao diện ServletContext
* Giao diện ServletContext cho phép servlet có thể lấy thông tin về môi trường thực thi của chúng.
*
* Một số phương thức quan trọng của giao diện này được tóm tắt:
*
* Dưới đây là mô tả các phương thức của giao diện ServletContext:
* 1. Object getAttribute(String attr):
* Phương thức này trả về giá trị của thuộc tính (attribute) được lưu trữ trong ServletContext dựa trên tên thuộc tính
* (attr) được cung cấp.
*
* 2. String getMimeType(StringJile):
* Phương thức này trả về kiểu MIME (Multipurpose Internet Mail Extensions) của tệp được xác định bởi đường dẫn
* tương đối (vpath).
*
* 3. String getRealPath(String vpath):
* Phương thức này trả về đường dẫn thực tế trên hệ thống tệp tin của tệp được xác định bởi đường dẫn tương đối (vpath).
*
* 4. String getServerInfo():
* Phương thức này trả về thông tin về máy chủ (server) mà servlet đang chạy trên, bao gồm tên và phiên bản.
*
* 5. void log(String s):
* Phương thức này ghi thông điệp log (log message) vào bộ ghi log (log file) của máy chủ với nội dung được cung cấp
* trong tham số (s).
*
* 6. void log(String s, Throwable e):
* Phương thức này ghi thông điệp log và ngoại lệ (exception) vào bộ ghi log của máy chủ. Tham số (s) chứa nội dung
* thông điệp log, và tham số (e) chứa thông tin về ngoại lệ.
*
* 7. void setAttribute(String attr, Object vat):
* Phương thức này đặt giá trị của thuộc tính (attribute) trong ServletContext. Tham số (attr) là tên thuộc tính và
* tham số (vat) là giá trị của thuộc tính đó.
* */
public class d_ServletContext {
}
