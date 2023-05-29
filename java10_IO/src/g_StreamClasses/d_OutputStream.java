package g_StreamClasses;
/* *
TODO     OutputStream là một lớp trừu tượng
* định nghĩa luồng byte đầu ra. Nó thực thi các giao diện AutoCloseable, Closeable và Flushable. Hầu hết các phương thức
* được định nghĩa bởi lớp này trả về void và ném một IOException trong trường hợp xảy ra lỗi I/O. Bảng 21-2 hiển thị
* các phương thức trong OutputStream.
*
TODO    1. `void close()`:
* Phương thức này đóng luồng đầu ra và giải phóng tài nguyên liên quan. Sau khi gọi phương thức này, không thể ghi dữ liệu
vào luồng nữa. Thông thường, phương thức này được gọi trong khối finally để đảm bảo luồng được đóng ngay cả khi xảy ra ngoại lệ.
*
TODO    2. `void flush()`:
* Phương thức này đẩy bất kỳ dữ liệu nào có thể còn đang lưu trong bộ đệm (buffer) vào luồng đầu ra. Điều này đảm bảo
* rằng tất cả dữ liệu đã được ghi vào luồng thực tế và sẵn sàng để được xử lý. Phương thức này thường được gọi trước khi
* đóng luồng để đảm bảo rằng không có dữ liệu bị mất.

TODO    3. `static OutputStream nullOutputStream()`:
* Phương thức này trả về một đối tượng OutputStream rỗng. Khi ghi dữ liệu vào OutputStream này, không có tác động gì xảy ra.
* Phương thức này hữu ích khi cần một đối tượng OutputStream không thực hiện bất kỳ hoạt động nào.

TODO    4. `void write(int b)`:
* Phương thức này ghi một byte vào luồng đầu ra. Giá trị byte được đưa vào dưới dạng một số nguyên từ 0 đến 255.

TODO    5. `void write(byte buffer[])`:
* Phương thức này ghi toàn bộ mảng byte buffer vào luồng đầu ra. Dữ liệu từ mảng sẽ được ghi từ vị trí đầu tiên
* cho đến vị trí cuối cùng của mảng.

TODO    6. `void write(byte buffer[], int offset, int numBytes)`:
* Phương thức này ghi numBytes byte từ mảng byte buffer vào luồng đầu ra, bắt đầu từ vị trí offset trong mảng.
* Nó cho phép ghi một phần của mảng byte vào luồng.
*
*/
public class d_OutputStream {
}
