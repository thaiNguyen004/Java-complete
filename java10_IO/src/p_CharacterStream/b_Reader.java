package p_CharacterStream;
/*
* Reader là một lớp trừu tượng định nghĩa mô hình nhập ký tự dòng của Java. Nó triển khai các giao diện AutoCloseable,
* Closeable và Readable. Tất cả các phương thức trong lớp này (trừ markSupported()) sẽ ném ra một IOException trong các điều kiện lỗi.
* Bảng 21-3 cung cấp một tóm tắt về các phương thức trong lớp Reader:
*
* Dưới đây là mô tả chi tiết các phương thức liên quan đến lớp Reader:
*
todo    1. `abstract void close()`:
* Đóng luồng đầu vào ký tự. Khi gọi phương thức này, luồng sẽ được giải phóng và không thể sử dụng lại.
*
todo    2. `void mark(int numChars)`:
* Đánh dấu vị trí hiện tại trong luồng. Có thể sử dụng phương thức reset() để trở về vị trí đã đánh dấu trước đó.
* Tham số `numChars` chỉ định số lượng ký tự có thể đọc sau khi đánh dấu trước khi đánh dấu bị hủy bỏ
*
todo    3. `boolean markSupported()`:
* Kiểm tra xem phương thức mark() có được hỗ trợ trên luồng hiện tại hay không.
* Trả về true nếu mark() được hỗ trợ, false nếu không.
*
todo    4. `static Reader nullReader()`:
* Trả về một đối tượng Reader rỗng, không đọc được bất kỳ ký tự nào.
* Đây là một lớp được sử dụng trong một số trường hợp đặc biệt.
*
todo    5. `int read()`:
* Đọc một ký tự từ luồng và trả về giá trị mã Unicode của ký tự đó.
* Nếu không còn ký tự nào để đọc, phương thức sẽ trả về -1.
*
todo    6. `int read(char[] buffer)`:
* Đọc một mảng ký tự từ luồng và lưu trữ vào mảng `buffer`. Trả về số lượng ký tự đã được đọc.
* Nếu không còn ký tự nào để đọc, phương thức sẽ trả về -1.
*
todo    7. `int read(CharBuffer buffer)`:
* Đọc dữ liệu ký tự vào một đối tượng CharBuffer. Trả về số lượng ký tự đã đọc.
* Nếu không còn ký tự nào để đọc, phương thức sẽ trả về -1.
*
todo    8. `abstract int read(char[] buffer, int offset, int numChars)`:
* Đọc `numChars` ký tự từ luồng và lưu trữ vào mảng `buffer`, bắt đầu từ vị trí `offset`. Trả về số lượng ký tự đã đọc.
* Nếu không còn ký tự nào để đọc, phương thức sẽ trả về -1.
*
todo    9. `boolean ready()`:
* Kiểm tra xem có thể đọc dữ liệu từ luồng mà không bị chặn hay không.
* Trả về true nếu luồng đã sẵn sàng để đọc, false nếu không.
*
todo    10. `void reset()`:
* Trở về vị trí đã đánh dấu trước đó trong luồng. Phương thức này chỉ có tác dụng
* nếu phương thức mark() đã được gọi trước đó.
*
todo    11. `long skip(long numChars)`:
* Bỏ qua `numChars` ký tự trong luồng. Trả về số lượng ký tự đã bị bỏ qua.
*
todo    12. `long transferTo(Writer writer)`:
* Đọc dữ liệu từ luồng và ghi trực tiếp vào một đối tượng Writer. Trả về số lượng ký tự đã được chuyển đổi.
*
* */
public class b_Reader {
}
