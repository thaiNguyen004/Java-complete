package e_ReductionsOperations;


/*
* Các phép toán Reduction (giảm giá trị)
* Xem xét các phương thức min() và max() trong ví dụ chương trình trước đó. Cả hai đều là các phép toán terminal (kết thúc)
* trả về một kết quả dựa trên các phần tử trong stream.
* Trong ngôn ngữ của Stream API, chúng đại diện cho các phép toán reduction vì mỗi phép toán này giảm stream về
* một giá trị duy nhất - trong trường hợp này là giá trị tối thiểu và tối đa. Stream API gọi chúng là reduction operations đặc biệt
* vì chúng thực hiện một chức năng cụ thể. Ngoài min() và max(), còn có các phép toán reduction đặc biệt khác như count(),
* đếm số phần tử trong một stream.
* Tuy nhiên, Stream API tổng quát hóa khái niệm này bằng cách cung cấp phương thức reduce(). Bằng cách sử dụng reduce(), bạn có thể
* trả về một giá trị từ một stream dựa trên bất kỳ tiêu chí tùy ý nào.
* Theo định nghĩa, tất cả các phép toán reduction đều là các phép toán terminal (kết thúc).
*
* Stream định nghĩa ba phiên bản của reduce(). Hai phiên bản đầu tiên mà chúng ta sẽ sử dụng được hiển thị như sau:
*
* Optional<T> reduce(BinaryOperator<T> accumulator)
* T reduce(T identityVal, BinaryOperator<T> accumulator)
*
* Phiên bản đầu tiên trả về một đối tượng Optional chứa kết quả. Phiên bản thứ hai trả về một đối tượng của kiểu T (là kiểu phần tử của stream).
* Trong cả hai phiên bản, accumulator là một hàm hoạt động trên hai giá trị và tạo ra một kết quả.
* Trong phiên bản thứ hai, identityVal là một giá trị sao cho một phép toán accumulator liên quan đến identityVal và bất kỳ phần tử
* nào của stream sẽ cho ra phần tử đó không thay đổi. Ví dụ, nếu phép toán là cộng, thì giá trị identity sẽ là 0 vì 0 + x chính là x.
* Đối với phép nhân, giá trị identity sẽ là 1, vì 1 * x chính là x.
*
* BinaryOperator là một giao diện chức năng (functional interface) được khai báo trong java.util.function,
* mở rộng từ giao diện chức năng BiFunction. BiFunction định nghĩa phương thức trừu tượng như sau:
* R apply(T val, U val2)
*
* Ở đây, R chỉ định kiểu kết quả, T là kiểu của toán hạng thứ nhất, và U là kiểu của toán hạng thứ hai. Vì vậy, apply()
* áp dụng một hàm cho hai toán hạng (val và val2) và trả về kết quả.
* Khi BinaryOperator mở rộng từ BiFunction, nó chỉ định cùng một kiểu cho tất cả các tham số kiểu.
* Vì vậy, đối với BinaryOperator, apply() có dạng như sau:
* T apply(T val, T val2)
*
* Hơn nữa, liên quan đến reduce(), val sẽ chứa kết quả trước đó và val2 sẽ chứa phần tử tiếp theo.
* Trong lần gọi đầu tiên, val sẽ chứa giá trị identity hoặc phần tử đầu tiên, tùy thuộc vào phiên bản của reduce() được sử dụng.
*
* Quan trọng là hiểu rằng phép toán accumulator phải đáp ứng ba ràng buộc. Nó phải:
*
* • Stateless (không lưu trạng thái): Tức là phép toán không phụ thuộc vào bất kỳ thông tin trạng thái nào.
* Do đó, mỗi phần tử được xử lý độc lập.
*
* • Non-interfering (không can thiệp): Nghĩa là nguồn dữ liệu không bị thay đổi bởi phép toán.
*
* • Associative (kết hợp): Đây là ý nghĩa thông thường của thuật ngữ "associative" trong toán học, có nghĩa là,
* với một toán tử kết hợp được sử dụng trong một chuỗi các phép toán, không quan trọng cặp toán hạng nào được xử lý trước.
* Ví dụ: (10 * 2) * 7 cho ra cùng kết quả như 10 * (2 * 7).
*
* Tính kết hợp đặc biệt quan trọng đối với việc sử dụng phép toán reduction trên parallel stream (stream song song),
* được thảo luận trong phần tiếp theo.
*
* */

import java.util.*;
public class example_geory {
    public static void main(String[] args) {
        // Tạo ra một ArrayList
        var myList = new ArrayList<Integer>();

        myList.add(7);
        myList.add(12);
        myList.add(21);
        myList.add(2);
        myList.add(3);
        myList.add(6);
        myList.add(7);

        // Hai cách để lấy tích số nguyên của các phần tử
        // trong myList bằng cách sử dụng hàm reduce() .
        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a* b);
        if(productObj.isPresent())
            System.out.println("Cách 1: " + productObj.get());

        // Cách 2
        int product = myList.stream().reduce(1, (a,b) -> a* b);
        System.out.println("Cách 2: " + product);

        /*
        * Trong chương trình, phiên bản đầu tiên của reduce() sử dụng biểu thức lambda để tính tích của hai giá trị.
        * Trong trường hợp này, vì luồng chứa các giá trị Integer, các đối tượng Integer được tự động unboxed để
        * thực hiện phép nhân và sau đó được reboxed để trả về kết quả. Hai giá trị này đại diện cho giá trị hiện tại
        * của kết quả và phần tử tiếp theo trong luồng. Kết quả cuối cùng được trả về trong một đối tượng Optional.
        * Giá trị được lấy bằng cách gọi get() trên đối tượng được trả về.
        *
        * Trong phiên bản thứ hai, giá trị identity được chỉ định rõ ràng, trong trường hợp này là 1 cho phép nhân.
        * Chú ý rằng kết quả được trả về dưới dạng đối tượng của kiểu phần tử, trong trường hợp này là Integer.
        *
        * Mặc dù các phép toán tổng quát đơn giản như phép nhân hữu ích cho các ví dụ, nhưng phép toán reduction không
        * giới hạn trong mục đích này. Ví dụ, giả sử có chương trình trước đó, sau đây là cách lấy tích của chỉ các giá trị chẵn:
        * */

        int evenProduct = myList.stream().reduce(1, (a, b) -> {
            if(b % 2 == 0) return a * b;
            else return a;
        });

        System.out.println("Tích chẵn: " + evenProduct);
        /*
        * Hãy chú ý đặc biệt đến biểu thức lambda. Nếu b là số chẵn, thì kết quả trả về là a * b. Ngược lại, trả về a.
        * Điều này hoạt động vì a chứa kết quả hiện tại và b chứa phần tử tiếp theo, như đã được giải thích trước đó.
        * */

    }
}
