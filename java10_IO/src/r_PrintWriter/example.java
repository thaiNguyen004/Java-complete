package r_PrintWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
todo    PrintWriter
* PrintWriter là một phiên bản hướng ký tự của lớp PrintStream. Nó triển khai các giao diện Appendable, AutoCloseable,
* Closeable và Flushable.
* PrintWriter có một số hàm tạo. Dưới đây là những hàm tạo đã được cung cấp bởi PrintWriter từ đầu:
*
todo   PrintWriter(OutputStream outputStream)
todo   PrintWriter(OutputStream outputStream, boolean autoFlushingOn)
todo   PrintWriter(Writer outputStream)
todo   PrintWriter(Writer outputStream, boolean autoFlushingOn)
*
* Ở đây, outputStream chỉ định một OutputStream đã mở sẽ nhận đầu ra.
* Tham số autoFlushingOn điều khiển việc tự động xả bộ đệm đầu ra mỗi khi gọi println(), printf() hoặc format().
* Nếu autoFlushingOn là true, thì sẽ tự động xả bộ đệm. Nếu là false, thì không xả bộ đệm tự động. Các hàm tạo không chỉ định
* tham số autoFlushingOn sẽ không tự động xả bộ đệm.
*
* Tự động xả bộ đệm (auto-flushing) đề cập đến việc đẩy dữ liệu từ bộ đệm vào đích đầu ra. Khi bạn gửi dữ liệu đến một
* đối tượng PrintWriter, nó sẽ không ngay lập tức ghi dữ liệu đó vào nguồn đầu ra thực tế (ví dụ: tệp tin hoặc luồng).
* Thay vào đó, nó sẽ lưu trữ dữ liệu trong một bộ đệm (buffer) tạm thời để tăng hiệu suất. Khi bộ đệm đạt đến một ngưỡng
* nhất định (hoặc khi cần thiết), dữ liệu trong bộ đệm sẽ được xả vào nguồn đầu ra.
*
* Tuy nhiên, với chế độ tự động xả bộ đệm, sau mỗi lần gọi các phương thức như println(), printf(), hoặc format(),
* bộ đệm sẽ tự động được xả, có nghĩa là dữ liệu sẽ được ghi ngay lập tức vào nguồn đầu ra. Điều này đảm bảo rằng dữ liệu
* được cập nhật liên tục và không bị lưu trữ trong bộ đệm quá lâu.
*
* Khi bạn tạo một đối tượng PrintWriter với cờ auto-flushing được đặt thành true, đồng nghĩa với việc bạn cho phép tự động
* xả bộ đệm. Trong trường hợp cờ này được đặt thành false, bạn sẽ cần gọi phương thức flush() của đối tượng PrintWriter
* để xả bộ đệm một cách rõ ràng.
*
* Việc sử dụng tự động xả bộ đệm có thể giúp cải thiện hiệu suất bởi giảm số lần ghi dữ liệu thực sự vào nguồn đầu ra,
* đặc biệt khi có nhiều hoạt động ghi dữ liệu liên tiếp.
*
* Bộ hàm tạo tiếp theo cho phép bạn dễ dàng tạo một PrintWriter để ghi đầu ra vào một tệp tin.
*
todo   PrintWriter(File outputFile) throws FileNotFoundException
todo   PrintWriter(File outputFile, String charSet) throws FileNotFoundException, UnsupportedEncodingException
todo   PrintWriter(String outputFileName) throws FileNotFoundException
todo   PrintWriter(String outputFileName, String charSet) throws FileNotFoundException, UnsupportedEncodingException
*
* Chúng cho phép tạo một PrintWriter từ một đối tượng File hoặc bằng cách chỉ định tên của một tệp tin.
* Trong cả hai trường hợp, tệp tin sẽ được tạo tự động. Bất kỳ tệp tin tồn tại trước đó cùng tên sẽ bị xóa.
* Sau khi được tạo, đối tượng PrintWriter sẽ chuyển hướng toàn bộ đầu ra vào tệp tin đã chỉ định. Bạn có thể chỉ định
* mã ký tự bằng cách truyền tên của nó vào charSet. JDK 11 cung cấp thêm các hàm tạo cho phép bạn chỉ định tham số Charset.
*
* PrintWriter hỗ trợ các phương thức print() và println() cho tất cả các loại dữ liệu, bao gồm cả Object.
* Nếu đối số không phải là kiểu nguyên thủy, các phương thức PrintWriter sẽ gọi phương thức toString()
* của đối tượng và sau đó xuất kết quả.
*
* PrintWriter cũng hỗ trợ phương thức printf(). Nó hoạt động giống như lớp PrintStream được mô tả trước đó: cho phép bạn
* xác định định dạng chính xác của dữ liệu. Đây là cách printf() được khai báo trong PrintWriter:
*
todo   PrintWriter printf(String fmtString, Object... args)
todo   PrintWriter printf(Locale loc, String fmtString, Object... args)
*
* Phiên bản đầu tiên ghi args ra đầu ra tiêu chuẩn theo định dạng được chỉ định bởi fmtString, sử dụng locale mặc định.
* Phiên bản thứ hai cho phép bạn chỉ định một locale. Cả hai đều trả về đối tượng PrintWriter gọi.
*
* Phương thức format() cũng được hỗ trợ. Nó có các hình thức tổng quát sau:
todo   PrintWriter format(String fmtString, Object... args)
todo   PrintWriter format(Locale loc, String fmtString, Object... args)
*
* Nó hoạt động hoàn toàn giống như printf(), cho phép bạn xác định định dạng chính xác của dữ liệu.
*
* */
public class example {
    public static void main(String[] args) {
        String s = "Nguyễn Thái Nguyên sẽ thành công!!!";
        char[] buf = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);

        try ( FileWriter f =
                      new FileWriter("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\src\\r_PrintWriter\\test.txt");
              PrintWriter pw = new PrintWriter(f, true))
        {
            pw.write(buf);
            pw.println();
            pw.write(buf);
        }catch (IOException e) {
            System.out.println("Error IO: "+ e);
        }

        PrintWriter pw = new PrintWriter(System.out);
        pw.printf("Hiển thị số sau: n = %d", 10);
        //Chương trình chưa hiển thị gì vì flushingOn đang ở chế độ false
        //Khi gọi flush thì nội dung trong buffer sẽ được xả vào đích đầu ra trong case này : System.out
    }
}
