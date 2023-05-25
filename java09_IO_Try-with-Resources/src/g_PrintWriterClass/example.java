package g_PrintWriterClass;

import java.io.PrintWriter;

/*
* Lớp PrintWriter
* Mặc dù việc sử dụng System.out để ghi vào console là chấp nhận được, nhưng nó thường được sử dụng tốt nhất cho mục đích
* gỡ lỗi hoặc các chương trình mẫu, như những chương trình được tìm thấy trong cuốn sách này. Đối với các chương trình thực tế,
* phương pháp được khuyến nghị để ghi vào console khi sử dụng Java là thông qua một luồng PrintWriter.
*
* PrintWriter là một trong những lớp dựa trên ký tự. Sử dụng lớp dựa trên ký tự để ghi ra console làm cho việc quốc tế
* hóa chương trình dễ dàng hơn.
* PrintWriter định nghĩa một số hàm tạo. Hàm tạo chúng ta sẽ sử dụng được hiển thị dưới đây:
*
*       PrintWriter(OutputStream outputStream, boolean flushingOn)
*
* Ở đây, outputStream là một đối tượng của kiểu OutputStream, và flushingOn điều khiển xem Java có xả luồng đầu ra mỗi khi một
* phương thức println() (và các phương thức khác) được gọi hay không. Nếu flushingOn là true, việc xả luồng tự động xảy ra.
* Nếu là false, việc xả luồng không được tự động thực hiện.
*
* PrintWriter hỗ trợ các phương thức print() và println(). Do đó, bạn có thể sử dụng những phương thức này theo cách tương tự
* như bạn đã sử dụng chúng với System.out. Nếu một đối số không phải là kiểu đơn giản, các phương thức của PrintWriter
* sẽ gọi phương thức toString() của đối tượng và sau đó hiển thị kết quả.
*
* Để ghi vào console bằng cách sử dụng PrintWriter, chỉ định System.out cho luồng đầu ra và xả tự động.
* Ví dụ, dòng mã sau tạo ra một PrintWriter được kết nối với đầu ra console:
*       PrintWriter pw = new PrintWriter(System.out, true);
* */
public class example {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true);

        pw.println("This is a string");
        int i = -7;
        pw.println(i);
        double d = 4.5e-7;
        pw.println(d);

        /*
            This is a string
            -7
            4.5E-7
        * */

        /*
        * Hãy nhớ rằng không có gì sai khi sử dụng System.out để viết đầu ra văn bản đơn giản ra console khi bạn đang học Java
        * hoặc gỡ lỗi chương trình của mình. Tuy nhiên, việc sử dụng PrintWriter sẽ làm cho ứng dụng thực tế của bạn dễ dàng
        * đa ngôn ngữ hóa. Vì không có lợi ích được đạt được bằng cách sử dụng PrintWriter trong các ví dụ chương trình mẫu
        * được hiển thị trong cuốn sách này, chúng ta sẽ tiếp tục sử dụng System.out để viết ra console.*/
    }
}
