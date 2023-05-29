package m_PrintStream;
/*
* Lớp PrintStream cung cấp tất cả các khả năng xuất dữ liệu mà chúng ta đã sử dụng từ bộ xử lý tệp System.out từ đầu cuốn sách.
* Điều này khiến cho PrintStream trở thành một trong những lớp được sử dụng nhiều nhất trong Java. Nó triển khai các giao diện
* Appendable, AutoCloseable, Closeable và Flushable.
*
todo  PrintStream định nghĩa một số hàm tạo. Những hàm tạo được hiển thị dưới đây đã được xác định từ đầu:
todo  PrintStream(OutputStream outputStream)
todo  PrintStream (OutputStream outputStream, boolean autoFlushingOn)
todo  PrintStream(OutputStream outputStream, boolean autoFlushingOn, StringcharSet) throws UnsupportedEncodingException
*
* Ở đây, outputStream chỉ định một OutputStream đã mở sẽ nhận đầu ra. Tham số autoFlushingOn kiểm soát việc xả bộ đệm
* đầu ra tự động mỗi khi ghi một ký tự newline (\n) hoặc một mảng byte hoặc khi gọi println().
* Nếu autoFlushingOn là true, thì việc xả bộ đệm tự động sẽ xảy ra. Nếu là false, việc xả bộ đệm không được tự động thực hiện.
* Hàm tạo đầu tiên không tự động xả bộ đệm. Bạn có thể chỉ định mã ký tự bằng cách truyền tên của nó vào charSet.
*
* Bộ các hàm tạo tiếp theo cung cấp một cách dễ dàng để tạo một PrintStream ghi đầu ra của nó vào một tập tin:
*
todo  PrintStream(File outputFile) throws FileNotFoundException
todo  PrintStream(File outputFile, String charSet) throws FileNotFoundException, UnsupportedEncodingException
todo  PrintStream(String outputFileName) throws FileNotFoundException
todo  PrintStream(String outputFileName, String charSet) throws FileNotFoundException, UnsupportedEncodingException
*
* Các hàm tạo này cho phép tạo một PrintStream từ một đối tượng File hoặc bằng cách chỉ định tên của một tập tin.
* Trong cả hai trường hợp, tập tin sẽ được tạo tự động. Bất kỳ tệp tin trước đó cùng tên sẽ bị xóa. Sau khi tạo, đối tượng
* PrintStream chuyển hướng tất cả đầu ra vào tập tin đã chỉ định.
*
* Bạn có thể chỉ định mã ký tự bằng cách truyền tên của nó vào charSet. JDK 11 cung cấp thêm các hàm tạo cho phép bạn
* chỉ định một tham số Charset.
*
* LƯU Ý: Nếu có một quản lý bảo mật hiện diện, một số hàm tạo của PrintStream sẽ ném một SecurityException nếu
* xảy ra vi phạm bảo mật.
*
* PrintStream hỗ trợ các phương thức print() và println() cho tất cả các kiểu dữ liệu, bao gồm cả Object. Nếu đối số
* không phải là kiểu nguyên thủy, các phương thức của PrintStream sẽ gọi phương thức toString() của đối tượng và hiển thị kết quả.
*
* Một số năm trước, một phương thức rất hữu ích được thêm vào PrintStream được gọi là printf(). Nó cho phép bạn chỉ định
* định dạng chính xác của dữ liệu sẽ được ghi. Phương thức printf() định dạng như được mô tả trong lớp Formatter được thảo luận
* trong Chương 20. Sau đó, nó ghi dữ liệu này vào luồng gọi.
*
* Mặc dù có thể thực hiện định dạng bằng cách sử dụng Formatter trực tiếp, printf() giúp tinh chỉnh quy trình này.
* Nó cũng tương đồng với hàm printf() trong C/C++, giúp dễ dàng chuyển đổi mã C/C++ hiện có sang Java. Thực sự, printf()
* là một bổ sung rất được chào đón trong API Java vì nó đơn giản hóa đáng kể việc xuất dữ liệu được định dạng ra màn hình.
*
* Phương thức printf() có các dạng tổng quát sau đây:
*
todo   PrintStream printf(String fmtString, Object... args)
todo   PrintStream printf(Locale loc, String fmtString, Object... args)
*
* Phiên bản đầu tiên ghi args ra đầu ra chuẩn theo định dạng được chỉ định bởi fmtString, sử dụng ngữ cảnh mặc định.
* Phiên bản thứ hai cho phép bạn chỉ định ngữ cảnh. Cả hai đều trả về PrintStream gọi.
*
* Nói chung, printf() hoạt động tương tự như phương thức format() được chỉ định bởi lớp Formatter. Đối số fmtString bao gồm hai loại mục.
* Loại đầu tiên bao gồm các ký tự chỉ đơn giản được sao chép vào bộ đệm đầu ra.
* Loại thứ hai chứa các trình định dạng xác định cách các đối số tiếp theo, được chỉ định bởi args, được hiển thị.
*
* Để biết thông tin đầy đủ về định dạng đầu ra, bao gồm mô tả về các trình định dạng, hãy xem lớp Formatter trong Chương 20.
*
* Bởi vì System.out là một PrintStream, bạn có thể gọi printf() trên System.out. Do đó, printf() có thể được sử dụng thay
* cho println() khi ghi vào màn hình console mỗi khi muốn xuất dữ liệu được định dạng. Ví dụ, chương trình sau sử dụng printf()
* để xuất giá trị số theo các định dạng khác nhau. Trước đây, việc định dạng như vậy yêu cầu một chút công việc.
* Với sự thêm vào của printf(), điều này trở thành một nhiệm vụ dễ dàng.*/
public class example {
    public static void main(String[] args) {
        System.out.println("Đây là một số giá trị số ở các định dạng khác nhau");
        System.out.printf("Các định dạng số nguyên khác nhau: ");
        System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3); // 3 (3) +3 00003

        System.out.println();

        System.out.printf("Định dạng floating-point (dấu phẩy động) mặc định: %f\n",
                1234567.123);

        System.out.printf("Dấu phẩy động (floating-point) với dấu phẩy (commas): %,f\n",
                1234567.123);

        System.out.printf("Định dạng dấu phẩy động (floating-point) âm (Negative) mặc định: %,f\n",
                -1234567.123);

        System.out.printf("Định dạng số dấu phẩy động âm với tùy chọn: %,(f\n: ",
                -1234567.123);

        System.out.println();

        System.out.printf("Căn chỉnh các giá trị dương(positive) và âm(negative): \n");
        System.out.printf("%,.2f\n%,.2f\n", 1234567.123, -1234567.123);

        /*
        * Kết quả đầu ra được hiển thị ở đây:
        * Dưới đây là một số giá trị số theo các định dạng khác nhau.
        *
        * Các định dạng số nguyên khác nhau: 3 (3) +3 00003
        * Định dạng floating-point (dấu phẩy động) mặc định: 1234567.123000
        * Dấu phẩy động (floating-point) với dấu phẩy (commas): 1,234,567.123000
        * Định dạng dấu phẩy động (floating-point) âm (Negative) mặc định: -1,234,567.123000
        * Định dạng số dấu phẩy động âm với tùy chọn: (1,234,567.123000)
        * Căn chỉnh các giá trị dương và âm:
        1,234,567.12
        -1,234,567.12
        PrintStream cũng định nghĩa phương thức format(). Nó có các dạng tổng quát sau:
        PrintStream format(String fmtString, Object ... args)
        PrintStream format(Locale loc, String fmtString, Object ... args)
        Nó hoạt động hoàn toàn giống như printf().*/
    }

}
