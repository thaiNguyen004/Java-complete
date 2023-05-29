package t_ConsoleClass;
/*
todo     Lớp Console
* Lớp Console được sử dụng để đọc từ và ghi vào bảng điều khiển nếu có sẵn. Nó triển khai giao diện Flushable.
* Lớp Console chủ yếu là một lớp tiện ích vì hầu hết các chức năng của nó có sẵn thông qua System.in và System.out.
* Tuy nhiên, việc sử dụng nó có thể đơn giản hóa một số loại tương tác với bảng điều khiển,
* đặc biệt là khi đọc chuỗi từ bảng điều khiển.
*
* Console không cung cấp bất kỳ hàm tạo nào. Thay vào đó, một đối tượng Console được thu được bằng
* cách gọi System.console(), như sau:
*
todo       static Console console()
*
* Nếu một bảng điều khiển có sẵn, thì một tham chiếu tới nó sẽ được trả về. Ngược lại, null sẽ được trả về.
* Một bảng điều khiển có thể không có sẵn trong tất cả các trường hợp. Do đó, nếu null được trả về,
* không thể thực hiện I/O với bảng điều khiển.
*
* Console định nghĩa các phương thức được hiển thị trong Bảng 21-5. Lưu ý rằng các phương thức nhập, như readLine(),
* ném ra IOError nếu xảy ra lỗi nhập. IOError là một lớp con của Error. Nó chỉ ra một lỗi I/O nằm ngoài sự kiểm soát
* của chương trình của bạn. Do đó, bạn thường sẽ không bắt IOError.
*
* Thực ra, nếu một IOError được ném ra trong quá trình truy cập vào bảng điều khiển,
* thường có nghĩa là đã xảy ra một lỗi hệ thống thảm khốc.
*
* Dưới đây là mô tả các phương thức trong lớp Console:
*
todo 1.     `void flush()`:
* Phương thức này được sử dụng để xả bộ đệm đầu ra của bảng điều khiển, đảm bảo rằng dữ liệu đã được ghi vào bảng
* điều khiển được đẩy ra ngay lập tức.
*
todo 2.     `Console format(String fmtString, Object... args)`:
* Phương thức này cho phép định dạng chuỗi đầu ra theo một mẫu đã cho và các đối số tương ứng. Nó trả về một đối tượng
* Console để cho phép việc gọi tiếp theo.
*
todo 3.     `Console printf(String fmtString, Object... args)`:
* Phương thức này tương tự như phương thức `format()`, nó cho phép định dạng chuỗi đầu ra theo một mẫu đã cho và các
* đối số tương ứng. Nó trả về một đối tượng Console để cho phép việc gọi tiếp theo.
*
todo 4.     `Reader reader()`:
* Phương thức này trả về một đối tượng Reader để đọc dữ liệu từ bảng điều khiển. Bạn có thể sử dụng đối tượng Reader
* để đọc các loại dữ liệu như ký tự hoặc chuỗi từ bảng điều khiển.
*
todo 5.     `String readLine()`:
* Phương thức này được sử dụng để đọc một dòng văn bản từ bảng điều khiển và trả về dữ liệu dưới dạng một
* đối tượng String.
*
todo 6.     `String readLine(String fmtString, Object... args)`:
* Phương thức này tương tự như `readLine()`, ngoại trừ việc cho phép định dạng chuỗi đưa ra trước khi đọc dòng văn bản
* từ bảng điều khiển. Bạn có thể truyền vào các đối số để định dạng chuỗi định hình.
*
todo 7.     `char[] readPassword()`:
* Phương thức này được sử dụng để đọc mật khẩu từ bảng điều khiển mà không hiển thị dữ liệu nhập vào. Nó trả về một
* mảng ký tự chứa mật khẩu đã nhập.
*
todo 8.     `char[] readPassword(String fmtString, Object... args)`:
* Phương thức này tương tự như `readPassword()`, ngoại trừ việc cho phép định dạng chuỗi đưa ra trước khi đọc mật khẩu
* từ bảng điều khiển. Bạn có thể truyền vào các đối số để định dạng chuỗi định hình.
*
todo 9.     `PrintWriter writer()`: Phương thức này trả về một đối tượng PrintWriter để ghi dữ liệu vào bảng điều khiển.
* Bạn có thể sử dụng đối tượng PrintWriter để ghi các loại dữ liệu như ký tự, chuỗi hoặc các giá trị định dạng vào
* bảng điều khiển.
*
*
* Cũng lưu ý các phương thức readPassword(). Các phương thức này cho phép ứng dụng của bạn đọc một mật khẩu mà không
* hiển thị những gì được gõ. Sau khi đọc mật khẩu, bạn nên "xóa" cả mảng chứa chuỗi được nhập bởi người dùng và mảng
* chứa mật khẩu để giảm khả năng một chương trình độc hại có thể lấy được mật khẩu bằng cách quét bộ nhớ.
*
* Dưới đây là một ví dụ minh họa cho lớp Console:
* */

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class geory {
    public static void main(String[] args) throws IOException {
        String str;
        Console con; //Tạo một tham chiếu console

        //con có một tham chiếu tới bảng điều khiển console
        con = System.console();
        //Nếu không có bảng điều khiển đồng nghĩa dừng chương trình
        if(con == null) return;
        //Đọc một chuỗi và sau đó hiển thị
        str = con.readLine("Enter a string: ");
        con.printf("Here is your string: %s ", str);

        //Trong trường hợp trên dòng lệnh System.console() trả về null tức là môi trường chạy không hỗ trợ console
        //Để khắc phục điều này sử dụng đối tượng thay thế là Scanner (Input stream) để đọc dữ liệu console
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter a string: ");
        str = sc.nextLine();
        System.out.printf("Here is your string: %s", str);

    }
}
