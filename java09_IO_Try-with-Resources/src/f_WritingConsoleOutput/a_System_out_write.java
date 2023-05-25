package f_WritingConsoleOutput;

/*
* Ghi ra màn hình Console
* Việc ghi ra màn hình console dễ nhất được thực hiện bằng cách sử dụng print() và println(), đã được mô tả trước đó
* và được sử dụng trong hầu hết các ví dụ trong cuốn sách này.
*
* Các phương thức này được định nghĩa bởi lớp PrintStream (loại đối tượng được tham chiếu bởi System.out).
* Mặc dù System.out là một byte stream, việc sử dụng nó để xuất dữ liệu đơn giản trong chương trình vẫn là phương pháp chấp nhận được.
* Tuy nhiên, một phương pháp dựa trên ký tự sẽ được mô tả trong phần tiếp theo.
*
* Bởi vì PrintStream là một output stream được dẫn xuất từ OutputStream, nó cũng thực hiện phương thức cấp thấp write().
* Do đó, write() có thể được sử dụng để ghi vào màn hình console.
* Phiên bản đơn giản nhất của write() được định nghĩa bởi PrintStream được hiển thị dưới đây:
*
*   void write(int byteval)
*
* Phương thức này ghi byte được chỉ định bởi byteval. Mặc dù byteval được khai báo là một số nguyên, chỉ có tám bit thấp được ghi.
* Dưới đây là một ví dụ ngắn sử dụng write() để xuất ký tự "A" kèm theo dấu xuống dòng (newline) lên màn hình:
* */
public class a_System_out_write {
    public static void main(String[] args) {
        int b;
        b = 'A';
        System.out.write(b);
        System.out.write('\n');

        /*
        * Bạn sẽ không thường xuyên sử dụng write() để thực hiện đầu ra trên console
        * (mặc dù việc làm điều này có thể hữu ích trong một số tình huống) vì print() và println() dễ sử dụng hơn đáng kể.*/
    }
}
