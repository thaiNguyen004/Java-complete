package p_CharacterStream;
/*
* Writer
* Writer là một lớp trừu tượng định nghĩa đầu ra ký tự dòng. Nó triển khai các giao diện AutoCloseable, Closeable,
* Flushable và Appendable. Tất cả các phương thức trong lớp này sẽ ném ra một IOException trong trường hợp có lỗi xảy ra.

* * Dưới đây là mô tả chi tiết các phương thức liên quan đến lớp Writer:
*
todo    1. `Writer append(char ch)`:
* Ghi ký tự `ch` vào luồng đầu ra và trả về một tham chiếu đến đối tượng Writer hiện tại. Phương thức này được
* sử dụng để nối thêm ký tự vào cuối dữ liệu đã tồn tại.
*
todo    2.`Writer append(CharSequence chars)`:
* Ghi chuỗi ký tự `chars` vào luồng đầu ra và trả về một tham chiếu đến đối tượng Writer hiện tại.
* Phương thức này được sử dụng để nối thêm chuỗi ký tự vào cuối dữ liệu đã tồn tại.
*
todo    3. `Writer append(CharSequence chars, int begin, int end)`:
* Ghi một phần của chuỗi ký tự `chars`, bắt đầu từ vị trí `begin` và kết thúc tại vị trí `end`,
* vào luồng đầu ra và trả về một tham chiếu đến đối tượng Writer hiện tại.
*
todo    4. `abstract void close()`:
* Đóng luồng đầu ra ký tự. Khi gọi phương thức này, luồng sẽ được giải phóng và không thể sử dụng lại.
*
todo    5. `abstract void flush()`:
* Xả bộ đệm dữ liệu trong luồng đầu ra, đảm bảo rằng tất cả dữ liệu đã được ghi sẽ được đẩy ra đích đến.
*
todo    6. `static Writer nullWriter()`:
* Trả về một đối tượng Writer rỗng, không ghi được bất kỳ ký tự nào. Đây là một lớp được sử dụng
* trong một số trường hợp đặc biệt.
*
todo    7. `void write(int ch)`:
* Ghi ký tự Unicode `ch` vào luồng đầu ra.
*
todo    8. `void write(char[] buffer)`:
* Ghi một mảng ký tự `buffer` vào luồng đầu ra.
*
todo    9. `abstract void write(char[] buffer, int offset, int numChars)`:
* Ghi `numChars` ký tự từ mảng ký tự `buffer`, bắt đầu từ vị trí `offset`, vào luồng đầu ra.
*
todo    10. `void write(String str)`:
* Ghi chuỗi `str` vào luồng đầu ra.
*
todo    11. `void write(String str, int offset, int numChars)`:
* Ghi `numChars` ký tự từ chuỗi `str`, bắt đầu từ vị trí `offset`, vào luồng đầu ra.
*
* */
public class c_Writer {
}
