package k_Spliterator;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

/*
* Sử dụng Spliterator
* Spliterator cung cấp một sự lựa chọn thay thế cho Iterator, đặc biệt là khi liên quan đến xử lý song song. \
* Nói chung, Spliterator phức tạp hơn Iterator và cuộc thảo luận về Spliterator được tìm thấy trong Chương 19.
* Tuy nhiên, việc đánh giá lại các tính năng chính của nó ở đây sẽ hữu ích. Spliterator định nghĩa một số phương thức,
* nhưng chúng ta chỉ cần sử dụng ba phương thức. Phương thức đầu tiên là tryAdvance(). Nó thực hiện một hành động
* trên phần tử tiếp theo và sau đó di chuyển bộ lặp. Nó được hiển thị như sau:
*   boolean tryAdvance(Consumer<? super T> action)
* Ở đây, action chỉ định hành động được thực thi trên phần tử tiếp theo trong vòng lặp.
* tryAdvance() trả về true nếu có phần tử tiếp theo. Nó trả về false nếu không còn phần tử. Như đã thảo luận trước đây
* trong chương này, Consumer khai báo một phương thức gọi là accept() nhận một phần tử kiểu T làm đối số và trả về void.
* Vì tryAdvance() trả về false khi không còn phần tử để xử lý, nó làm cho cấu trúc vòng lặp lặp lại rất đơn giản, ví dụ:
*   while(splitItr.tryAdvance( // thực hiện hành động ở đây );
* Miễn là tryAdvance() trả về true, hành động sẽ được áp dụng cho phần tử tiếp theo. Khi tryAdvance() trả về false,
* quá trình lặp lại hoàn tất. Lưu ý cách tryAdvance() kết hợp mục đích của hasNext() và next() được cung cấp bởi Iterator
* thành một phương thức duy nhất. Điều này cải thiện hiệu suất của quá trình lặp lại.
* Phiên bản sau của chương trình trước đó thay thế một Spliterator cho Iterator.
*
* */
public class geory_example {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Phi");
        myList.add("Omega");

        // Tạo ra một stream từ arraylist
        Stream<String> myStream = myList.stream();

        // Tạo ra một spliterator
        Spliterator<String> splitItr = myStream.spliterator();
        // Bây giờ tách Iterator đầu tiên
        Spliterator<String> splitItr2 = splitItr.trySplit();

        if(splitItr2 != null) {
            System.out.println("Output from splitItr2: ");
            splitItr2.forEachRemaining((n -> System.out.println(n)));
        }

        // Bây giờ sử dụng splitItr
        System.out.println("Output: from splitItr: ");
        splitItr.forEachRemaining(n -> System.out.println(n));
    }
}
/*
* Mặc dù việc chia Spliterator trong ví dụ đơn giản này không mang lại giá trị thực tế,
* việc chia có thể mang lại giá trị lớn khi xử lý song song trên các tập dữ liệu lớn.
* Tuy nhiên, trong nhiều trường hợp, nên sử dụng một trong các phương thức khác của Stream
* kết hợp với một luồng song song, thay vì tự xử lý các chi tiết này với Spliterator.
* Spliterator chủ yếu được sử dụng trong các trường hợp mà không có phương thức được
* xác định trước nào phù hợp.
*
* Nhiều khả năng khám phá trong Stream API
* Chương này đã thảo luận về một số khía cạnh quan trọng của stream API và giới thiệu các kỹ thuật
* cần thiết để sử dụng chúng, nhưng stream API còn nhiều điều thú vị hơn để khám phá. Để bắt đầu,
* dưới đây là một số phương thức khác được cung cấp bởi Stream mà bạn sẽ thấy hữu ích:
- Để xác định xem một hoặc nhiều phần tử trong một luồng thoả mãn một giá trị predicate cụ thể, sử dụng allMatch(), anyMatch() hoặc noneMatch().
- Để lấy số lượng phần tử trong luồng, gọi phương thức count().
- Để lấy một luồng chỉ chứa các phần tử duy nhất, sử dụng distinct().
- Để tạo một luồng chứa một tập hợp cụ thể các phần tử, sử dụng of().
*
* Một điểm cuối cùng: stream API là một bổ sung mạnh mẽ cho Java.
* Bạn sẽ muốn khám phá tất cả các khả năng mà java.util.stream có để cung cấp.
*   */