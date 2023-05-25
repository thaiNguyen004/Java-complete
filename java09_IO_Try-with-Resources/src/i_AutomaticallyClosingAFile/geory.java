package i_AutomaticallyClosingAFile;

/*
* Tự động đóng một tệp
* Trong phần trước đó, các chương trình ví dụ đã gọi rõ ràng đến close() để đóng một tệp khi nó không còn cần thiết nữa.
* Như đã đề cập, đây là cách đóng tệp khi sử dụng các phiên bản Java trước JDK 7. Mặc dù cách tiếp cận này vẫn hợp lệ và hữu ích,
* JDK 7 đã thêm một tính năng cung cấp một cách khác để quản lý tài nguyên, chẳng hạn như luồng tệp, bằng cách tự động hóa
* quá trình đóng tệp.
*
* Tính năng này, đôi khi được gọi là quản lý tài nguyên tự động, hoặc viết tắt là ARM, dựa trên một phiên bản mở rộng của
* câu lệnh try. Lợi ích chính của việc quản lý tài nguyên tự động là nó ngăn chặn các tình huống mà một tệp
* (hoặc tài nguyên khác) không được giải phóng một cách vô tình sau khi không còn cần thiết nữa.
* Như đã giải thích, quên đóng một tệp có thể dẫn đến rò rỉ bộ nhớ và có thể dẫn đến các vấn đề khác.
*
* Quản lý tài nguyên tự động dựa trên một phiên bản mở rộng của câu lệnh try. Dưới đây là hình thức tổng quát của nó:
*       try (resource-specification) {
*           //use the resource
*       }
*
* Thường thì, phần resource-specification là một câu lệnh khai báo và khởi tạo một tài nguyên, chẳng hạn như một luồng tệp.
* Nó bao gồm một khai báo biến trong đó biến được khởi tạo với một tham chiếu tới đối tượng đang được quản lý.
* Khi khối try kết thúc, tài nguyên sẽ được giải phóng tự động. Trong trường hợp của một tệp, điều này có nghĩa là tệp
* sẽ tự động được đóng. (Do đó, không cần gọi close() một cách rõ ràng.) Tất nhiên, dạng try này cũng có thể bao gồm các mệnh
* đề catch và finally.
*
* Dạng try này được gọi là câu lệnh try-with-resources.
*
* LƯU Ý Từ JDK 9 trở đi, cũng có thể cho phần resource specification của câu lệnh try bao gồm một biến đã được khai báo và khởi tạo trước
* trong chương trình. Tuy nhiên, biến đó phải được coi là "effectively final", có nghĩa là sau khi được gán giá trị ban đầu,
* không được gán giá trị mới.
*
* Câu lệnh try-with-resources chỉ có thể được sử dụng với những tài nguyên thực hiện giao diện AutoCloseable được định nghĩa trong java.lang.
*
* Giao diện này định nghĩa phương thức close(). AutoCloseable được kế thừa bởi giao diện Closeable trong java.io. Cả hai giao diện này được
* cài đặt bởi các lớp luồng. Do đó, try-with-resources có thể được sử dụng khi làm việc với các luồng, bao gồm cả luồng tệp.
Như một ví dụ đầu tiên về việc tự động đóng một tệp, đây là một phiên bản đã chỉnh sửa: ShowFile.java*/

public class geory {

}
