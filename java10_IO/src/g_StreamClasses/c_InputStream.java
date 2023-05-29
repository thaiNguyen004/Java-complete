package g_StreamClasses;
/*
* * InputStream
TODO     InputStream là một lớp trừu tượng
* định nghĩa mô hình đầu vào byte dòng của Java. Nó triển khai các giao diện AutoCloseable và Closeable.
* Hầu hết các phương thức trong lớp này sẽ ném ra một IOException khi xảy ra lỗi I/O. (Các ngoại lệ là mark() và markSupported().)
* Bảng 21-1 hiển thị các phương thức trong InputStream.
*
* Tất cả các phương thức trong lớp InputStream dưới đây được giải thích chi tiết hơn:
*
TODO     1. `int available()`:
* Phương thức này trả về số byte có sẵn để đọc từ luồng đầu vào mà không chặn việc đọc. Nó cung cấp thông tin về số byte
* mà có thể đọc từ luồng mà không bị chặn.
*
TODO     2. `void close()`:
* Phương thức này đóng luồng đầu vào và giải phóng bất kỳ tài nguyên liên quan nào được sử dụng bởi luồng.
* Sau khi gọi phương thức này, không thể đọc thêm byte từ luồng.
*
TODO     3. `void mark(int numBytes)`:
* Phương thức này đánh dấu vị trí hiện tại trong luồng để có thể quay lại sau khi đọc một
* số lượng byte xác định. Khi gọi phương thức `reset()`, luồng sẽ quay lại vị trí đã được đánh dấu trước đó.
*
TODO     4. `boolean markSupported()`:
* Phương thức này kiểm tra xem việc đánh dấu (marking) được hỗ trợ bởi luồng hay không.
* Nếu phương thức này trả về `true`, thì phương thức `mark()` và `reset()` có thể được sử dụng. Nếu phương thức này
* trả về `false`, thì các phương thức `mark()` và `reset()` không được hỗ trợ và sẽ gây ra ngoại lệ.
*
TODO     5. `static InputStream nullInputStream()`:
* Phương thức này trả về một đối tượng InputStream trống, không có dữ liệu để đọc. Nó có thể được sử dụng trong các
* trường hợp đặc biệt khi cần một luồng trống không chứa dữ liệu.
*
TODO     6. `int read()`:
* Phương thức này đọc một byte từ luồng đầu vào và trả về giá trị của byte đó. Nếu đã đọc tới cuối luồng, phương thức trả về -1.
*
TODO     7. `int read(byte buffer[])`:
* Phương thức này đọc một dãy byte từ luồng và lưu vào mảng byte buffer. Nó trả về số byte đã đọc được hoặc -1 nếu
* đã đọc tới cuối luồng.
*
TODO     8. `int read(byte buffer[], int offset, int numBytes)`:
* Phương thức này đọc tối đa numBytes byte từ luồng và lưu vào mảng byte buffer, bắt đầu từ vị trí offset trong mảng.
* Nó trả về số byte đã đọc được hoặc -1 nếu đã đọc tới cuối luồng.
*
TODO     9. `byte[] readAllBytes()`:
* Phương thức này đọc toàn bộ nội dung của luồng đầu vào và trả về một mảng byte chứa dữ liệu đã đọc.
*
TODO     10. `byte[] readNBytes(int numBytes)`:
* Phương thức này đọc numBytes byte từ luồng và trả về một mảng byte chứa dữ liệu đã đọc. Nếu số byte đọc được ít hơn numBytes,
* mảng byte trả về có kích thước nhỏ hơn numBytes.
*
TODO     11. `int readNBytes(byte buffer[], int offset, int numBytes)`:
* Phương thức này đọc tối đa numBytes byte từ luồng và lưu vào mảng byte buffer, bắt đầu từ vị trí offset trong mảng.
* Nó trả về số byte đã đọc được. Nếu số byte đọc được ít hơn numBytes, số byte trả về sẽ nhỏ hơn numBytes.
*
TODO     12. `void reset()`:
* Phương thức này đặt lại vị trí đọc trong luồng đến vị trí đã được đánh dấu trước đó bằng phương thức `mark()`.
* Nếu luồng không hỗ trợ đánh dấu hoặc đánh dấu đã bị hủy, phương thức này sẽ gây ra IOException.
*
TODO     13. `long skip(long numBytes)`:
* Phương thức này bỏ qua numBytes byte trong luồng đầu vào và trả về số byte đã bị bỏ qua. Phương thức này thường được
* sử dụng để bỏ qua các byte không cần thiết trong luồng.
*
TODO     14. `long transferTo(OutputStream strm)`:
* Phương thức này chuyển toàn bộ dữ liệu từ luồng đầu vào sang một OutputStream đã được chỉ định. Nó sẽ tiếp tục chuyển
* dữ liệu cho đến khi đọc hết luồng hoặc xảy ra lỗi I/O. Phương thức này trả về tổng số byte đã chuyển.
*/
public class c_InputStream {
}
