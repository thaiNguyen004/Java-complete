package i_AutomaticallyClosingAFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) throws IOException {
        int i;
        //Đầu tiên, phải xác nhận chỉ định đúng tên tệp
        if (args.length != 1) {
            System.out.println("Usage: java ShowFile.java filename");
            return;
        }

        // Đoạn mã dưới đây sử dụng câu lệnh try-with-resources
        // để mở một tệp và tự động đóng nó khi khối try được rời đi.

        try (FileInputStream fin = new FileInputStream(args[0])) {
            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error I/O Occurred");
        }
    }
}
/*
* Trong chương trình, hãy chú ý cách mở tệp trong khối try:
*       try(FileInputStream fin = new FileInputStream(args[0])) {
* Lưu ý phần resource-specification của câu lệnh try khai báo một FileInputStream có tên là fin, sau đó gán một tham chiếu đến
* tệp được mở bởi hàm tạo của nó. Vì vậy, trong phiên bản này của chương trình, biến fin là cục bộ trong khối try, được tạo ra
* khi khối try được nhập. Khi khối try được rời đi, luồng được liên kết với fin được tự động đóng bằng cách gọi close() ngầm định.
* Bạn không cần gọi close() một cách rõ ràng, điều này có nghĩa là bạn không thể quên đóng tệp. Đây là một lợi thế quan trọng khi
* sử dụng try-with-resources.
* Quan trọng là hiểu rằng một tài nguyên được khai báo trong câu lệnh try được ngầm định là final. Điều này có nghĩa là bạn không
* thể gán giá trị cho tài nguyên sau khi nó được tạo ra. Ngoài ra, phạm vi của tài nguyên bị giới hạn trong câu lệnh try-with-resources.
*
* Trước khi tiếp tục, đáng lưu ý rằng từ JDK 10 trở đi, bạn có thể sử dụng kiểu biến cục bộ được suy luận để chỉ định kiểu của tài nguyên
* được khai báo trong câu lệnh try-with-resources. Để làm điều này, chỉ định kiểu là var. Khi làm như vậy, kiểu của tài nguyên được suy
* luận từ giá trị khởi tạo của nó. Ví dụ, câu lệnh try trong chương trình trước đây có thể được viết như sau:
*       try(var fin = new FileInputStream(args[0])) {
* Ở đây, fin được suy luận là kiểu FileInputStream vì đó là kiểu của giá trị khởi tạo. Vì nhiều độc giả sẽ làm việc trong môi trường
* Java trước JDK 10, các câu lệnh try-with-resources trong phần còn lại của cuốn sách này sẽ không sử dụng suy luận kiểu để mã hoạt
* động với nhiều độc giả nhất có thể. Tuy nhiên, trong tương lai, bạn nên xem xét việc sử dụng suy luận kiểu trong mã của riêng bạn.
*
* Bạn có thể quản lý nhiều tài nguyên trong một câu lệnh try duy nhất. Để làm điều này, chỉ cần phân tách mỗi phần khai báo tài nguyên
* bằng dấu chấm phẩy. Chương trình sau đây cho thấy một ví dụ. Nó đã chỉnh sửa chương trình CopyFile được hiển thị trước đó để sử dụng
* một câu lệnh try-with-resources duy nhất để quản lý cả fin và fout.
* */
