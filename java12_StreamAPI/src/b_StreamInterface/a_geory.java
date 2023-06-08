package b_StreamInterface;
/*
* Các Giao diện Stream
*
* Giao diện Stream API xác định một số giao diện stream, được đóng gói trong java.util.stream và
* nằm trong mô-đun java.base.
* Ở bên dưới là BaseStream, xác định các chức năng cơ bản có sẵn trong tất cả các stream.
* BaseStream là một giao diện generic được khai báo như sau:
*       interface BaseStream<T, S extends BaseStream<T, S>>
* Ở đây, T chỉ định kiểu của các phần tử trong stream và S chỉ định kiểu của stream mở rộng BaseStream.
* BaseStream mở rộng giao diện AutoCloseable; do đó, một stream có thể được quản lý trong một câu lệnh
* try-with-resources. Tuy nhiên, chỉ có những stream mà nguồn dữ liệu yêu cầu đóng
* (như những stream được kết nối với một tệp tin) mới cần được đóng. Trong hầu hết các trường hợp, chẳng hạn
* khi nguồn dữ liệu là một collection, không cần đóng stream.
*
* Các phương thức được khai báo bởi BaseStream được hiển thị dưới đây
*
* 1. `void close()`:
* Phương thức này được sử dụng để đóng stream và giải phóng tài nguyên liên quan.
* Chỉ các stream có nguồn dữ liệu yêu cầu đóng mới cần gọi phương thức này.
* Ví dụ, stream kết nối với một tệp tin sẽ cần được đóng để giải phóng tài nguyên hệ thống.
*
* 2. `boolean isParallel()`:
* Phương thức này trả về giá trị boolean xác định xem stream hiện tại có đang hoạt động song song
* (parallel) hay không. Nếu trả về true, có nghĩa là stream đang hoạt động song song,
* còn false có nghĩa là stream đang hoạt động tuần tự (sequential).
*
* 3. `Iterator<T> iterator()`:
* Phương thức này trả về một đối tượng Iterator cho phép lặp qua các phần tử trong stream.
*
* 4. `S onClose(Runnable handler)`:
* Phương thức này trả về một stream mới với một bộ xử lý được thực thi khi stream được đóng.
* Bộ xử lý này được đưa ra dưới dạng một đối tượng Runnable.
*
* 5. `S parallel()`:
* Phương thức này trả về một stream song song, cho phép các hoạt động trên stream được thực hiện một
* cách song song (parallel). Điều này có thể cải thiện hiệu suất xử lý đối với các tập dữ liệu lớn.
*
* 6. `S sequential()`: Phương thức này trả về một stream tuần tự, đảm bảo các hoạt động trên stream
* được thực hiện một cách tuần tự (sequential). Điều này hữu ích khi bạn muốn đảm bảo tính nhất quán
* và tuần tự trong việc xử lý dữ liệu.
*
* 7. `Spliterator<T> spliterator()`:
* Phương thức này trả về một đối tượng Spliterator, cho phép phân chia các phần tử trong stream để có
* thể lặp qua chúng một cách song song.
*
* 8. `S unordered()`:
* Phương thức này trả về một stream không tuân thủ thứ tự (unordered), cho phép các hoạt động trên stream
* được thực hiện một cách không quan tâm đến thứ tự xuất hiện của các phần tử. Điều này có thể giúp cải thiện
* hiệu suất xử lý trong một số trường hợp.
*
* Từ BaseStream được tạo ra một số loại giao diện stream.
* Giao diện phổ biến nhất trong số đó là Stream. Nó được khai báo như sau:
*       interface Stream<T>
*
* Ở đây, T chỉ định kiểu của các phần tử trong stream. Vì Stream là một giao diện generic, nó được sử dụng
* cho tất cả các kiểu tham chiếu. Ngoài các phương thức được kế thừa từ BaseStream, giao diện Stream còn thêm
* một số phương thức riêng, một số ví dụ được hiển thị trong Bảng 29-2.
*
* 1. <R,A> R collect(Collector<? super T, A, R> collectorFunc):
* Thu thập các phần tử vào một container, container này có thể thay đổi
* và trả về container đó. Đây được gọi là một hoạt động giảm thiểu
* có tính thay đổi (mutable reduction operation).
* Ở đây, R chỉ định kiểu của container kết quả và
* T chỉ định kiểu phần tử của stream gọi phương thức.
* A chỉ định kiểu tích lũy nội bộ. collectorFunc xác định cách hoạt động quá
* trình thu thập. (Hoạt động kết thúc - terminal operation.)
*
*
* 2. long count() :
* Đếm số phần tử trong stream và trả về kết quả (Hoạt động kết thúc - terminal operation.)
*
*
* 3. Stream<T> filter (Perdicate<? super T> pred) :
* Tạo ra một stream chứa các phần tử từ stream gốc mà thỏa mãn
* tiền đề được chỉ định bởi pred. (Hoạt động trung gian - intermediate operation.)
*
*
* 4. void forEach(Consumer<? super T > action) :
* Lặp qua mỗi phần tử trong stream gốc, mã được chỉ định bởi action sẽ được thực thi.
* (Hoạt động kết thúc - terminal operation.)
*
*
* 5. <R> Stream<R> map (Function<? super T, ? extends R> mapFunc) :
* Áp dụng mapFunc lên các phần tử từ stream gốc, tạo ra một stream mới chứa các phần tử đó.
* (Hoạt động trung gian - intermediate operation.)
*
*
* 6. DoubleStream mapToDouble (ToDoubleFunction<? super T> mapFunc) :
* Áp dụng mapFunc lên các phần tử từ stream gốc, tạo ra một DoubleStream mới chứa các phần tử đó.
* (Hoạt động trung gian - intermediate operation.)
*
*
* 7. IntStream mapToInt (ToIntFunction<? super T> mapFunc) :
* Áp dụng mapFunc lên các phần tử từ stream gốc, tạo ra một IntStream mới chứa các phần tử đó.
* (Hoạt động trung gian - intermediate operation.)
*
*
* 8. LongStream mapToLong (ToLongStream<? super T> mapFunc) :
* Áp dụng mapFunc lên các phần tử từ stream gốc, tạo ra một LongStream mới chứa các phần tử đó.
* (Hoạt động trung gian - intermediate operation.)
*
*
* 9. Optional<T> max (Comparator<? super T> comp) :
* Sử dụng thứ tự được chỉ định bởi comp, tìm và trả về phần tử lớn nhất trong stream gốc.
* (Hoạt động kết thúc - terminal operation.)
*
*
* 10. Optional<T> min (Comparator<? super T> comp) :
* Sử dụng thứ tự được chỉ định bởi comp, tìm và trả về phần tử nhỏ nhất trong stream gốc.
* (Hoạt động kết thúc - terminal operation.)
*
*
* 11. T reduce (T identityVal, BinaryOperator<T> accumulator) :
* Trả về một kết quả dựa trên các phần tử trong stream gốc. Đây được gọi là một hoạt động giảm thiểu (reduction operation).
* (Hoạt động kết thúc - terminal operation.)
*
*
* 12. Stream<T> sorted() :
* Tạo ra một stream mới chứa các phần tử của stream gốc được sắp xếp theo thứ tự tự nhiên.
* (Hoạt động trung gian - intermediate operation.)
*
*
* 13. Object[] toArray() :
* Tạo ra một mảng từ các phần tử trong stream gốc.
* (Hoạt động kết thúc - terminal operation.)
*
*
* Trong cả hai bảng, hãy chú ý rằng nhiều phương thức được chú thích là hoạt động kết thúc (terminal) hoặc trung gian (intermediate).
* Sự khác biệt giữa hai loại này rất quan trọng. Một hoạt động kết thúc tiêu thụ stream. Nó được sử dụng để tạo ra một kết quả,
* ví dụ như tìm giá trị nhỏ nhất trong stream, hoặc để thực hiện một hành động, như là trường hợp của phương thức forEach().
* Một khi một stream đã được tiêu thụ, nó không thể được sử dụng lại.
*
* Các hoạt động trung gian tạo ra một stream mới. Do đó, các hoạt động trung gian có thể được sử dụng để tạo ra một chuỗi các hành động.
* Một điểm khác: các hoạt động trung gian không xảy ra ngay lập tức. Thay vào đó, hành động được chỉ định được thực hiện
* khi một hoạt động kết thúc được thực thi trên stream mới được tạo ra bởi một hoạt động trung gian. Cơ chế này được gọi là hành vi lười biếng
* (lazy behavior), và các hoạt động trung gian được gọi là lười biếng (lazy). Việc sử dụng hành vi lười biếng cho phép stream API hoạt động hiệu quả hơn.
*
* Một khía cạnh quan trọng khác của stream là một số hoạt động trung gian là stateless (không có trạng thái) và một số là stateful (có trạng thái).
* Trong một hoạt động stateless, mỗi phần tử được xử lý độc lập với các phần tử khác.
* Trong một hoạt động stateful, việc xử lý của một phần tử có thể phụ thuộc vào các phần tử khác. Ví dụ, sắp xếp là một hoạt động stateful
* vì thứ tự của một phần tử phụ thuộc vào các giá trị của các phần tử khác. Do đó, phương thức sorted() là stateful. Tuy nhiên, việc lọc
* các phần tử dựa trên một tiền đề stateless là stateless vì mỗi phần tử được xử lý cá nhân. Do đó, filter() có thể (và nên) là stateless.
* Sự khác biệt giữa các hoạt động stateless và stateful là đặc biệt quan trọng khi muốn xử lý song song (parallel processing) của một stream
* , vì một hoạt động stateful có thể yêu cầu nhiều hơn một lần duyệt để hoàn thành.
*
* Vì Stream hoạt động trên các tham chiếu đối tượng, nó không thể hoạt động trực tiếp trên các kiểu nguyên thủy.
* Để xử lý stream của các kiểu nguyên thủy, stream API định nghĩa các giao diện sau:
* DoubleStream
* IntStream
* LongStream
*
* Các stream này đều mở rộng từ BaseStream và có khả năng tương tự như Stream ngoại trừ việc hoạt động trên các kiểu nguyên thủy
* thay vì kiểu tham chiếu. Chúng cũng cung cấp một số phương thức tiện ích, như boxed(), giúp tăng cường việc sử dụng của chúng.
* Vì stream của các đối tượng là phổ biến nhất, Stream là trọng tâm chính của chương này, nhưng các stream của kiểu nguyên thủy có thể
* được sử dụng theo cách tương tự.
* */
public class a_geory {
}
