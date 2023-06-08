package d_SimpleExample;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/*
* Trước khi tiến xa hơn, hãy làm việc qua một ví dụ sử dụng streams.
* Chương trình sau tạo một ArrayList được gọi là myList chứa một tập hợp các số nguyên
* (tự động được đóng gói vào kiểu tham chiếu Integer). Tiếp theo, nó thu được một stream
* sử dụng myList làm nguồn dữ liệu.
* Sau đó, nó thực hiện các hoạt động trên stream khác nhau.
*
* */
public class StreamDemo {
    public static void main(String[] args) {
        // Tạo ra một danh sách chứa các giá trị Integer
        var list = new ArrayList<Integer>();
        list.add(7);
        list.add(14);
        list.add(19);
        list.add(22);
        list.add(26);

        System.out.println("Original list: " + list);
        // Lấy một stream vào arraylist
        Stream<Integer> myStream = list.stream();
        // Obtain minimum and minimax value by use of min(), max(), isPresent(), and get();
        Optional<Integer> minVal = myStream.min(Integer::compare);
        if(minVal.isPresent()) System.out.println("Minimun value: " + minVal.get());

        //hải lấy một luồng mới vì lệnh gọi trước đó là thao tác đầu cuối đã tiêu thụ luồng.
        myStream = list.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        if(maxVal.isPresent()) System.out.println("Minimax: " + maxVal.get());

        // Sắp xếp một stream bằng cách sử dụng sorted
        Stream<Integer> sortedStream = list.stream().sorted();

        // Hiển thị một tream đã sắp xếp bằng cách sử dụng forEach().
        sortedStream.forEach((n) -> System.out.print(n+" "));
        System.out.println();

        // Chỉ hiển thị các giá trị lẻ bằng cách sử dụng filter
        Stream<Integer> oddVals = list.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.print("Các giá trị lẻ: ");
        oddVals.forEach(n -> System.out.print(n+" "));
        System.out.println();

        // Chỉ hiển thị các giá trị lẻ và lớn hơn 5. Lưu ý rằng 2 thao tác
        // filter() được sắp xếp theo đường ống
        oddVals = list.stream().filter(n -> (n % 2) == 1)
                                .filter(n -> n > 5);
        System.out.print("Các giá trị lẻ lớn hơn 5: ");
        oddVals.forEach(n -> System.out.print(n +" "));
        System.out.println();


    }
}

/*
* Hãy xem kỹ từng hoạt động trên stream. Sau khi tạo một ArrayList, chương trình thu được
* một stream cho danh sách bằng cách gọi phương thức stream(), như được hiển thị dưới đây:
*       Stream<Integer> myStream = myList.stream();
* Như đã giải thích, giao diện Collection định nghĩa phương thức stream(), giúp thu được
* một stream từ collection gọi phương thức này. Vì Collection được thực hiện bởi mọi lớp
* collection, stream() có thể được sử dụng để thu được một stream cho bất kỳ loại collection nào,
* bao gồm ArrayList được sử dụng ở đây. Trong trường hợp này, một tham chiếu tới stream được
* gán cho myStream.
*
*        Stream<Integer> myStream = list.stream();
*
* Tiếp theo, chương trình thu được giá trị nhỏ nhất trong stream
* (cũng chính là giá trị nhỏ nhất trong nguồn dữ liệu) và hiển thị nó, như được hiển thị:
*
*       Optional<Integer> minVal = myStream.min(Integer::compare);
*       if(minVal.isPresent()) System.out.println("Minimun value: " + minVal.get());
*
* Hãy nhớ lại từ Bảng 29-2 rằng min() được khai báo như sau:
* Optional<T> min(Comparator<? super T> comp)
* Đầu tiên, hãy nhận thấy rằng kiểu tham số của min() là một Comparator.
* Comparator này được sử dụng để so sánh hai phần tử trong stream. Trong ví dụ này, min()
* được truyền một tham chiếu phương thức tới phương thức compare() của lớp Integer,
* được sử dụng để thực hiện một Comparator có khả năng so sánh hai số nguyên.
* Tiếp theo, hãy nhận thấy rằng kiểu trả về của min() là Optional. Lớp Optional được mô tả
* trong Chương 20, nhưng tóm tắt, đây là cách nó hoạt động.
* Optional là một lớp generic được đóng gói trong gói java.util và được khai báo như sau:
*
* class Optional<T>

* Ở đây, T xác định kiểu phần tử. Một thể hiện Optional có thể chứa một giá trị kiểu T
* hoặc trống rỗng. Bạn có thể sử dụng isPresent() để xác định xem giá trị có tồn tại hay không.
* Giả sử rằng một giá trị có sẵn, bạn có thể lấy nó bằng cách gọi get(), hoặc nếu bạn đang
* sử dụng JDK 10 trở lên, orElseThrow().
* Trong ví dụ này, phương thức get() được sử dụng. Trong ví dụ này, đối tượng trả về sẽ chứa
* giá trị nhỏ nhất của stream dưới dạng một đối tượng Integer.
*
* Một điểm khác về dòng trước đó: min() là một hoạt động kết thúc tiêu thụ stream.
* Do đó, myStream không thể được sử dụng lại sau khi min() được thực thi.
*
* Các dòng tiếp theo lấy và hiển thị giá trị lớn nhất trong luồng:
*
* Optional<Integer> maxVal = myStream.max(Integer::compare);
* if(maxVal.isPresent()) System.out.println("Minimax: " + maxVal.get());
*
* Trước tiên, myStream được gán lại bằng stream được trả về từ myList.stream(). Như đã được giải thích,
* điều này là cần thiết vì lời gọi trước đó của min() đã tiêu thụ stream trước đó. Do đó, cần một stream mới.
* Tiếp theo, phương thức max() được gọi để lấy giá trị lớn nhất. Giống như min(), max() cũng trả về một đối tượng Optional.
* Giá trị của nó được lấy bằng cách gọi phương thức get().
*
* Tiếp theo, chương trình lấy một sorted stream thông qua việc sử dụng dòng này:
* Stream<Integer> sortedStream = myList.stream().sorted();
* Ở đây, phương thức sorted() được gọi trên stream được trả về từ myList.stream(). Vì sorted() là một thao tác trung gian
* (intermediate operation), kết quả của nó là một stream mới, và đây là stream được gán cho sortedStream.
* Nội dung của sorted stream được hiển thị bằng cách sử dụng forEach():
*
* sortedStream.forEach((n) -> System.out.print(n + " "));
*
* Ở đây, phương thức forEach() thực thi một hoạt động trên mỗi phần tử trong stream. Trong trường hợp này,
* nó chỉ đơn giản gọi System.out.print() cho mỗi phần tử trong sortedStream. Điều này được thực hiện bằng cách
* sử dụng một biểu thức lambda. Phương thức forEach() có dạng chung như sau:
* void forEach(Consumer<? super T> action)
*
* Consumer là một giao diện chức năng (functional interface) được khai báo trong java.util.function.
* Phương thức trừu tượng của nó là accept(), được hiển thị ở đây:
* void accept(T objRef)
* Biểu thức lambda trong lời gọi forEach() cung cấp việc triển khai cho accept(). Phương thức forEach()
* là một thao tác terminal (terminal operation). Do đó, sau khi nó hoàn thành, stream đã được tiêu thụ.
*
*
* Tiếp theo, một luồng đã sắp xếp được lọc bởi filter() để nó chỉ chứa các giá trị lẻ:
* Stream<Integer> oddVals = list.stream().sorted().filter((n) -> (n % 2) == 1);
*
* Phương thức filter() lọc một stream dựa trên một predicate (tiên đề). Nó trả về một stream mới chứa chỉ những
* phần tử thỏa mãn predicate. Phương thức này có dạng như sau:
* Stream<T> filter(Predicate<? super T> pred)
* Predicate là một giao diện chức năng (functional interface) generic được định nghĩa trong java.util.function.
* Phương thức trừu tượng của nó là test(), được hiển thị như sau:
* boolean test(T objRef)
* Nó trả về true nếu đối tượng được tham chiếu bởi objRef thỏa mãn predicate và trả về false nếu không thỏa mãn.
* Biểu thức lambda được truyền cho filter() thực hiện phương thức này. Vì filter() là một thao tác trung gian
* (intermediate operation), nó trả về một stream mới chứa các giá trị đã được lọc, trong trường hợp này là các số lẻ.
* Các phần tử này sau đó được hiển thị thông qua forEach() như trước đó.
*
* Bởi vì filter(), hoặc bất kỳ thao tác trung gian nào khác, trả về một stream mới, nên có thể lọc một stream đã được lọc
* lần thứ hai. Điều này được thể hiện bằng dòng sau, tạo ra một stream chỉ chứa những giá trị lẻ lớn hơn 5:
*
* oddVals = list.stream().filter(n -> (n % 2) == 1)
*                               .filter(n -> n > 5);
*
*
* */