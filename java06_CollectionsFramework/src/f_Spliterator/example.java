package f_Spliterator;

/*
* Spliterators (Các bộ phân tách)
* JDK 8 đã thêm một loại iterator khác được gọi là spliterator được định nghĩa bởi giao diện Spliterator.
* Một spliterator duyệt qua một chuỗi các phần tử và về mặt này, nó tương tự như các iterator đã được mô tả.
* Tuy nhiên, các kỹ thuật sử dụng spliterator khác biệt. Hơn nữa, nó cung cấp nhiều chức năng hơn so với Iterator hoặc ListIterator.
* Có thể coi khả năng quan trọng nhất của Spliterator là khả năng hỗ trợ việc duyệt đồng thời (parallel) của các phần của chuỗi.
* Do đó, Spliterator hỗ trợ lập trình song song (parallel programming). (Xem Chương 28 để biết thông tin về đồng thời và
* lập trình song song.) Tuy nhiên, bạn có thể sử dụng Spliterator ngay cả khi bạn không sử dụng thực thi song song.
* Một lý do bạn có thể muốn làm điều đó là vì nó cung cấp một phương pháp tối ưu hóa kết hợp các thao tác hasNext và next
* thành một phương thức duy nhất.
* Spliterator là một giao diện generic được khai báo như sau:
*       interface Spliterator<T>
* Ở đây, T là kiểu của các phần tử được duyệt qua. Spliterator khai báo các phương thức như được hiển thị như sau:
*
* 1. `int characteristics()`: Trả về một tập hợp các thuộc tính (characteristics) của Spliterator.
* Các thuộc tính này mô tả các khả năng của Spliterator, chẳng hạn như có thể duyệt qua theo thứ tự, có thể phân chia (split),
* có thể sắp xếp, v.v.
*
* 2. `long estimateSize()`: Ước tính kích thước của Spliterator, tức là số lượng phần tử còn lại mà Spliterator sẽ duyệt qua.
* Đây là một ước tính và có thể không chính xác trong mọi trường hợp.
*
* 3. `void forEachRemaining(Consumer<? super T> action)`: Duyệt qua tất cả các phần tử còn lại của Spliterator và thực
* hiện một hành động (action) được chỉ định bởi Consumer trên mỗi phần tử.
*
* 4. `Comparator<? super T> getComparator()`: Trả về Comparator được sử dụng để so sánh các phần tử của Spliterator,
* nếu Spliterator có khả năng sắp xếp.
*
* 5. `long getExactSizeIfKnown()`: Trả về kích thước chính xác của Spliterator nếu nó có thể được xác định, ngược lại trả về -1.
*
* 6. `boolean hasCharacteristics(int characteristics)`: Kiểm tra xem Spliterator có chứa các thuộc tính được chỉ định hay không.
* Trả về true nếu có và false nếu không.
*
* 7. `boolean tryAdvance(Consumer<? super T> action)`: Thử tiến tới phần tử tiếp theo trong Spliterator.
* Nếu có phần tử, nó sẽ thực hiện một hành động (action) được chỉ định bởi Consumer trên phần tử đó và trả về true.
* Nếu không còn phần tử, nó sẽ trả về false
*
* 8. `Spliterator<T> trySplit()`: Chia Spliterator thành hai phần, mỗi phần sẽ duyệt qua một phần của chuỗi.
* Nếu việc chia thành công, nó sẽ trả về một Spliterator mới đại diện cho phần còn lại. Nếu không thể chia, nó sẽ trả về null.
* */

/*
* Việc sử dụng Spliterator cho các tác vụ lặp cơ bản khá dễ dàng: đơn giản là gọi phương thức tryAdvance()
* cho đến khi nó trả về false. Nếu bạn sẽ áp dụng cùng một hành động cho mỗi phần tử trong chuỗi,
* phương thức forEachRemaining() cung cấp một cách tiện lợi hơn. Trong cả hai trường hợp, hành động sẽ xảy ra với
* mỗi lần lặp được định nghĩa bởi những gì đối tượng Consumer thực hiện với mỗi phần tử. Consumer là một giao diện hàm
* (functional interface) áp dụng một hành động cho một đối tượng. Nó là một giao diện hàm thông thường được khai báo
* trong java.util.function. (Xem Chương 20 để biết thông tin về java.util.function.) Consumer chỉ định một phương thức
* trừu tượng duy nhất, accept(), được hiển thị như sau:
*       void accept(T objRef)
* Trong trường hợp của tryAdvance(), mỗi lần lặp sẽ chuyển phần tử tiếp theo trong chuỗi vào objRef. Thường,
* cách đơn giản nhất để triển khai Consumer là sử dụng biểu thức lambda.*/

import java.util.*;
public class example {
    public static void main(String[] args) {
        //Chương trình sau cung cấp một ví dụ đơn giản về Spliterator.
        //Lưu ý rằng chương trình thể hiện cả tryAdvance() và forEachRemaining().
        //Cũng lưu ý cách các phương thức này kết hợp hành động của next() và hasNext() trong Iterator thành một cuộc gọi duy nhất.

        var vals = new ArrayList<Double>();
        //Add values to the arraylist
        vals.add(1.0);
        vals.add(2.0);
        vals.add(3.0);
        vals.add(4.0);
        vals.add(5.0);

        //Use tryAdvance() to display contents of vals
        System.out.print("Contents of vals: ");
        Spliterator<Double> spltitr = vals.spliterator();
        while(spltitr.tryAdvance(n -> System.out.print(n+" ")));
        System.out.println();

        //Tạo một danh sách mới chứa căn bậc 2 của danh sách cũ
        var sqrts = new ArrayList<Double>();
        spltitr = vals.spliterator();
        while(spltitr.tryAdvance((n) -> sqrts.add(Math.sqrt(n))));

        //Use forEachRemaining to display contents of sqrts
        System.out.print("Contents of sqrts: ");
        spltitr = sqrts.spliterator();
        spltitr.forEachRemaining(n -> System.out.println(n));

        /*
        * Mặc dù chương trình này thể hiện cơ chế sử dụng Spliterator, nhưng nó không tiết lộ hết sức mạnh của nó. Như đã đề cập,
        * lợi ích tối đa của Spliterator được tìm thấy trong các tình huống liên quan đến xử lý song song.
        * Trong Bảng 19-10, lưu ý các phương thức characteristics() và hasCharacteristics(). Mỗi Spliterator có một tập hợp các thuộc tính,
        * gọi là characteristics, được liên kết với nó. Những thuộc tính này được xác định bởi các trường static int trong Spliterator,
        * như SORTED, DISTINCT, SIZED, và IMMUTABLE, để kể một số. Bạn có thể lấy các thuộc tính bằng cách gọi characteristics().
        * Bạn có thể xác định xem một thuộc tính có tồn tại hay không bằng cách gọi hasCharacteristics().
        * Thường thì bạn sẽ không cần truy cập vào các thuộc tính của một Spliterator, nhưng trong một số trường hợp, chúng có thể giúp tạo
        * ra mã hiệu quả và linh hoạt.
        *
        * CHÚ Ý: Để biết thêm về Spliterator, xem Chương 29, nơi nó được sử dụng trong ngữ cảnh của Stream API.
        * Để biết thêm về biểu thức lambda, xem Chương 15.
        * Xem Chương 28 để biết thêm về lập trình song song và đồng thời thực thi.
        *
        * Có một số giao diện con lồng nhau của Spliterator được thiết kế để sử dụng với các kiểu dữ liệu nguyên thủy như double, int và long.
        * Những giao diện này được gọi là Spliterator.OfDouble, Spliterator.OfInt và Spliterator.OfLong. Cũng có một phiên bản tổng quát được
        * gọi là Spliterator.OfPrimitive(), cung cấp tính linh hoạt bổ sung và đóng vai trò là siêu giao diện của những giao diện đã được đề cập trên
        * */
    }
}
