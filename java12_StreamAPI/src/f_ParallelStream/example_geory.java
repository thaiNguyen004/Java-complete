package f_ParallelStream;

import com.sun.tools.javac.Main;

import java.util.ArrayList;

/*
* Sử dụng Stream Song song
* Trước khi khám phá thêm về API Stream, sẽ hữu ích nếu thảo luận về stream song song.
* Như đã được đề cập trước đây trong cuốn sách này, việc thực thi song song mã thông qua
* các bộ xử lý đa nhân có thể dẫn đến tăng hiệu suất đáng kể. Bởi vì điều này, lập trình
* song song đã trở thành một phần quan trọng trong công việc của các lập trình viên hiện đại.
* Tuy nhiên, lập trình song song có thể phức tạp và dễ gây lỗi. Một trong những lợi ích mà
* thư viện stream cung cấp là khả năng xử lý song song dễ dàng và đáng tin cậy cho một số
* hoạt động cụ thể.
*
* Xử lý song song của một stream khá đơn giản để yêu cầu: chỉ cần sử dụng một stream song song.
* Như đã đề cập trước đó, một cách để có được một stream song song là sử dụng phương thức parallelStream()
* được định nghĩa bởi Collection. Một cách khác để có được một stream song song là gọi phương thức parallel()
* trên một stream tuần tự. Phương thức parallel() được định nghĩa bởi BaseStream, như được hiển thị ở đây:
* S parallel()
*
* Nó trả về một stream song song dựa trên stream tuần tự mà gọi nó. (Nếu nó được gọi trên một stream đã song song,
* thì stream gọi sẽ được trả về.) Tất nhiên, hiểu rõ rằng ngay cả với một stream song song, song song sẽ được thực hiện
* chỉ khi môi trường hỗ trợ.
*
* Sau khi có được một stream song song, các hoạt động trên stream có thể diễn ra song song, miễn là song song được
* hỗ trợ bởi môi trường. Ví dụ, hoạt động reduce() đầu tiên trong chương trình trước đó có thể được song song hóa
* bằng cách thay thế parallelStream() cho cuộc gọi đến stream():
* Optional<Integer> productObj = myList.parallelStream().reduce((a,b) -> a*b);
*
* Kết quả sẽ giống nhau, nhưng việc nhân có thể xảy ra trong các luồng khác nhau.
*
* Như một quy tắc chung, bất kỳ hoạt động nào được áp dụng cho một stream song song phải là stateless
* (không lưu trạng thái). Nó cũng phải là non-interfering (không can thiệp) và associative (kết hợp được).
* Điều này đảm bảo rằng các kết quả được thu được bằng cách thực thi các hoạt động trên một stream song song
* là giống như các kết quả thu được từ việc thực thi các hoạt động tương tự trên một stream tuần tự.
* Khi sử dụng stream song song, bạn có thể thấy phiên bản sau của reduce() đặc biệt hữu ích. Nó cung cấp cho bạn
* một cách để chỉ định cách kết hợp các kết quả phần.
*
* <U> U reduce (U identity, BiFunction <U, ? super T, U> accumulator, BinaryOperator<U> combiner)
* Trong phiên bản này, combiner xác định chức năng kết hợp hai giá trị đã được tạo ra bởi chức năng accumulator.
* Giả sử chương trình trước đó, câu lệnh sau tính tích của các phần tử trong myList bằng cách sử dụng một stream song song.
*
* int parallelProduct = myList.parallelStream().reduce(1, (a,b) -> a*b, (a, b) -> a*b);
*
* Như bạn có thể thấy, trong ví dụ này, cả accumulator và combiner thực hiện cùng một chức năng.
* Tuy nhiên, có những trường hợp mà hành động của accumulator phải khác với combiner.
* Ví dụ, xem xét chương trình sau. Ở đây, myList chứa một danh sách các giá trị double.
* Sau đó, nó sử dụng phiên bản combiner của reduce() để tính tích của căn bậc hai của mỗi phần tử trong danh sách.
* */
public class example_geory {
    public static void main(String[] args) {
        var myList = new ArrayList<Double>();
        myList.add(25.0);
        myList.add(81.0);
        myList.add(16.0);
        myList.add(9.0);
        myList.add(64.0);

        double productOfSqrt = myList.parallelStream().reduce(
                1.0,
                (a,b) -> a * Math.sqrt(b),
                (a,b) -> a * b
        );
        System.out.println("Tích của căn bậc hai (Square roots) : " + productOfSqrt);

        double productOfSqrt2 = myList.parallelStream().reduce(
                1.0, (a,b) -> a * Math.sqrt(b)
        );
        System.out.println(productOfSqrt2);

        /*
        * Lưu ý rằng hàm accumulator nhân căn bậc hai của hai phần tử, nhưng hàm combiner nhân các kết quả phần tử một cách tương đối.
        * Do đó, hai hàm này khác nhau. Hơn nữa, để tính toán này hoạt động chính xác, chúng phải khác nhau.
        * Ví dụ, nếu bạn cố gắng tính tích của căn bậc hai của các phần tử bằng cách sử dụng câu lệnh sau, sẽ xảy ra lỗi:
        *
        * double productOfSqrt = myList.parallelStream().reduce(
                1.0, (a,b) -> a * Math.sqrt(b)
        );
        *
        * Trong phiên bản reduce() này, hàm accumulator và hàm combiner là một.
        * Điều này dẫn đến một lỗi vì khi hai kết quả phần tử được kết hợp, căn bậc hai của chúng được nhân với nhau thay
        * vì các kết quả phần tử riêng lẻ. Một điểm đáng chú ý, nếu stream trong lời gọi reduce() trước đó được thay đổi
        * thành một sequential stream, thì phép tính sẽ cho ra kết quả đúng vì không có sự cần thiết để kết hợp hai kết quả phần tử riêng lẻ.
        * Vấn đề xảy ra khi sử dụng một parallel stream. Bạn có thể chuyển đổi một parallel stream thành sequential bằng cách
        * gọi phương thức sequential(), được xác định bởi BaseStream. Phương thức này được hiển thị như sau:
        * S sequential()
        * Nói chung, một stream có thể được chuyển đổi giữa parallel và sequential khi cần thiết.
        * Có một khía cạnh khác của stream cần ghi nhớ khi sử dụng parallel execution: thứ tự các phần tử.
        * Stream có thể được sắp xếp hoặc không được sắp xếp. Nói chung, nếu nguồn dữ liệu được sắp xếp, thì stream cũng
        * sẽ được sắp xếp. Tuy nhiên, khi sử dụng một parallel stream, có thể có một tăng hiệu suất bằng cách
        * cho phép một stream không được sắp xếp. Khi một parallel stream không được sắp xếp, mỗi phân vùng của stream
        * có thể được xử lý độc lập mà không cần phải phối hợp với các phân vùng khác. Trong những trường hợp mà thứ tự
        * của các hoạt động không quan trọng, có thể chỉ định hành vi không được sắp xếp bằng cách gọi phương thức unordered(),
        * được hiển thị như sau:
        * S unordered()
        * Một điểm khác: phương thức forEach() có thể không bảo tồn thứ tự của một parallel stream. Nếu bạn muốn thực hiện
        * một hoạt động trên mỗi phần tử trong một parallel stream trong khi bảo tồn thứ tự, hãy xem xét việc sử dụng
        * forEachOrdered(). Nó được sử dụng giống như forEach().
        *
        * */
    }
}
