package I_BufferedOutputStream;
/*
todo     BufferedOutputStream
* Một BufferedOutputStream tương tự như bất kỳ OutputStream nào với sự khác biệt là phương thức flush() được sử dụng để đảm bảo
* rằng dữ liệu trong bộ đệm được ghi vào luồng đang được đệm. Vì mục đích của BufferedOutputStream là cải thiện hiệu suất bằng cách
* giảm số lần hệ thống thực sự ghi dữ liệu, bạn có thể cần gọi phương thức flush() để đảm bảo rằng bất kỳ dữ liệu nào đang trong
* bộ đệm được ghi ngay lập tức.
*
* Khác với BufferedInputStream, BufferedOutputStream không cung cấp tính năng bổ sung. Việc BufferedOutputStream trong Java được
* thực hiện để tăng hiệu suất. Dưới đây là hai hàm tạo có sẵn:
*
* BufferedOutputStream(OutputStream outputStream)
* BufferedOutputStream(OutputStream outputStream, int bufSize)
*
* Biểu thức đầu tiên tạo một luồng đã được đệm sử dụng kích thước đệm mặc định.
* Trong biểu thức thứ hai, kích thước của bộ đệm được truyền vào thông qua tham số bufSize.*/
public class example {
}
