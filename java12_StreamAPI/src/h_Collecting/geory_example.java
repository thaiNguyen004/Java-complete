package h_Collecting;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Thu thập (Collecting)
* Như các ví dụ trước đã cho thấy, có thể (thậm chí thường) thu được một Stream từ một Collection.
* Đôi khi mong muốn ngược lại: thu được một Collection từ một Stream.
* Để thực hiện hành động như vậy, Stream API cung cấp phương thức collect(). Nó có hai dạng.
* Dạng mà chúng ta sẽ sử dụng trước được hiển thị ở đây:
*
*       <R, A> R collect(Collector<? super T, A, R> collectorFunc)
*
* Ở đây, R chỉ định kiểu kết quả, và T chỉ định kiểu phần tử của Stream gọi phương thức.
* Kiểu dữ liệu nội bộ tích lũy được chỉ định bởi A. collectorFunc chỉ định cách hoạt động của quá trình thu thập.
* Phương thức collect() là một hoạt động terminal.
* Giao diện Collector được khai báo trong java.util.stream, như được hiển thị ở đây:
*   interface Collector<T, A, R>
* T, A và R có cùng ý nghĩa như đã mô tả. Collector chỉ định một số phương thức, nhưng cho mục đích của chương này,
* chúng ta sẽ không cần triển khai chúng. Thay vào đó, chúng ta sẽ sử dụng hai collector được xác định trước có sẵn
* do lớp Collectors cung cấp, được đóng gói trong java.util.stream.
* Lớp Collectors định nghĩa một số phương thức collector tĩnh mà bạn có thể sử dụng ngay.
* Hai phương thức mà chúng ta sẽ sử dụng là toList() và toSet(), được hiển thị ở đây:
*   static <T> Collector<T, ?, List<T>> toList()
*   static <T> Collector<T, ?, Set<T>> toSet()
* Phương thức toList() trả về một collector có thể được sử dụng để thu thập các phần tử vào một List.
* Phương thức toSet() trả về một collector có thể được sử dụng để thu thập các phần tử vào một Set.
* Ví dụ, để thu thập các phần tử vào một List, bạn có thể gọi collect() như sau:
*   collect(Collectors.toList())
* Chương trình sau đây đặt vào hành động những thảo luận trước đó. Nó tạo lại ví dụ trong phần trước để
* thu thập tên và số điện thoại vào một List và một Set:
*/
public class geory_example {
    public static void main(String[] args) {
        var myList = new ArrayList<NamePhoneEmail>();
        myList.add(new NamePhoneEmail("Nguyên", "444-4444", "nguyen@gmail.com"));
        myList.add(new NamePhoneEmail("Dũng", "555-4444", "dung@gmail.com"));
        myList.add(new NamePhoneEmail("Linh", "777-7777", "linh@gmail.com"));

        Stream<NamePhone> namePhone = myList.stream().map((e) -> new NamePhone(e.name, e.phonenum));

        // Sử dụng collect để tạo một List gồm name và phone
        List<NamePhone> list = namePhone.collect(Collectors.toList());

        System.out.println("List");
        for (NamePhone o : list) {
            System.out.println(o.name +" "+ o.phonenum);
        }


        namePhone = myList.stream().map(e -> new NamePhone(e.name, e.phonenum));

        System.out.println("Set");
        Set<NamePhone> npSet = namePhone.collect(Collectors.toSet());
        for (NamePhone o : npSet) {
            System.out.println(o.name +" " + o.phonenum);
        }
    }
}
class NamePhoneEmail {
    String name;
    String phonenum;
    String email;
    NamePhoneEmail(String n, String p, String e){
        name = n;
        phonenum = p;
        email = e;
    }
}

class NamePhone {
    String name;
    String phonenum;
    NamePhone (String n, String p) {
        name = n;
        phonenum = p;
    }
}

/*
* Khả năng di chuyển dữ liệu từ một collection sang một stream, và sau đó quay trở lại một collection lại là một thuộc tính
* rất mạnh mẽ của Stream API. Nó cung cấp cho bạn khả năng thao tác trên một collection thông qua một stream, nhưng sau
* đó đóng gói lại thành một collection. Hơn nữa, các hoạt động trên stream có thể được thực hiện song song nếu thích hợp.
* Phiên bản của collect() được sử dụng trong ví dụ trước rất tiện lợi và thường là phiên bản bạn muốn, nhưng có một phiên bản
* thứ hai mang lại cho bạn sự kiểm soát hơn về quá trình thu thập. Nó được hiển thị ở đây:
* <R> R collect(Supplier<R> target,
*             BiConsumer<R, ? super T> accumulator,
*             BiConsumer<R, R> combiner)
*
* Ở đây, tham số target chỉ định cách tạo ra đối tượng chứa kết quả. Ví dụ, để sử dụng LinkedList làm collection kết quả,
* bạn sẽ chỉ định constructor của LinkedList. Hàm tích lũy (accumulator) thêm một phần tử vào kết quả và hàm kết hợp (combiner)
* kết hợp hai kết quả tích lũy. Do đó, các hàm này hoạt động tương tự như trong reduce(). Cả hai hàm đều phải không có
* trạng thái và không tương tác. Hơn nữa, chúng phải có tính kết hợp.
*
* Lưu ý rằng tham số target có kiểu là Supplier. Đây là một functional interface được khai báo trong java.util.function.
* Nó chỉ định phương thức get(), không có tham số và trong trường hợp này trả về một đối tượng kiểu R.
* Do đó, liên quan đến collect(), get() trả về một tham chiếu đến một đối tượng lưu trữ có thể thay đổi,
* chẳng hạn như một collection.
*
* Lưu ý rằng kiểu dữ liệu của accumulator và combiner là BiConsumer. Đây là một functional interface được định nghĩa
* trong java.util.function. Nó chỉ định phương thức abstract accept() được hiển thị ở đây:
*   void accept(T obj, U obj2)
* Phương thức này thực hiện một loại hoạt động trên obj và obj2. Liên quan đến accumulator, obj chỉ định collection mục tiêu
* và obj2 chỉ định phần tử được thêm vào collection đó. Liên quan đến combiner, obj và obj2 chỉ định hai collection sẽ được kết hợp.
*
* Sử dụng phiên bản của collect() vừa được mô tả, bạn có thể sử dụng LinkedList làm mục tiêu trong chương trình trước đó,
* như được hiển thị ở đây:
* LinkedList<PhoneName> lkl = nameStream.collect(
*                               () -> new LinkedList<>(),
*                               (list, element) -> list.add(element),
*                               (list1, list2) -> list1.addAll(list2));
*
* Lưu ý rằng đối số đầu tiên của collect() là một biểu thức lambda trả về một LinkedList mới. Đối số thứ hai sử dụng
* phương thức thường được sử dụng trong collection là add() để thêm một phần tử vào danh sách.
* Đối số thứ ba sử dụng addAll() để kết hợp hai danh sách liên kết. Một điểm đáng chú ý là bạn có thể sử dụng bất kỳ
* phương thức nào được định nghĩa bởi LinkedList để thêm một phần tử vào danh sách.
* Ví dụ, bạn có thể sử dụng addFirst() để thêm phần tử vào đầu danh sách, như được hiển thị ở đây:
*
* (list, element) -> list.addFirst(element)
* Như bạn có thể đã đoán được, không phải lúc nào cũng cần phải chỉ định một biểu thức lambda cho các đối số của collect().
* Thường, việc sử dụng tham chiếu phương thức và/hoặc tham chiếu constructor sẽ đủ. Ví dụ, tiếp tục giả sử chương trình
* trước đó, câu lệnh này tạo một HashSet chứa tất cả các phần tử trong stream nameAndPhone:
*
* HashSet<NamePhone> npSet = nameStream.collect(HashSet::new,
*                                               HashSet::add,
*                                               HashSet::addAll);
*
* Lưu ý rằng đối số đầu tiên chỉ định tham chiếu constructor của HashSet. Các đối số thứ hai và thứ ba chỉ định tham chiếu
* phương thức của HashSet là add() và addAll().
* Một điểm cuối cùng: trong ngôn ngữ của Stream API, phương thức collect() thực hiện điều được gọi là một quá trình giảm thiểu có
* tính thay đổi. Điều này là do kết quả của quá trình giảm thiểu là một đối tượng lưu trữ có tính thay đổi
* (tức là có thể thay đổi), chẳng hạn như một collection.
* */

class DemoCollect {
    public static void main(String[] args) {
        var myList = new ArrayList<NamePhoneEmail>();
        myList.add(new NamePhoneEmail("Nguyên", "444-4444", "nguyen@gmail.com"));
        myList.add(new NamePhoneEmail("Dũng", "555-4444", "dung@gmail.com"));
        myList.add(new NamePhoneEmail("Linh", "777-7777", "linh@gmail.com"));

        Stream<NamePhone> nameAndPhone = myList.stream().map(e -> new NamePhone(e.name, e.phonenum));
//        LinkedList<NamePhone> lkl = nameAndPhone.collect(() -> new LinkedList<NamePhone>(), LinkedList::add, LinkedList::addAll);
        LinkedList<NamePhone> lkl = nameAndPhone.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        nameAndPhone = myList.stream().map(e -> new NamePhone(e.name, e.phonenum));
        HashSet<NamePhone> hashSet = nameAndPhone.collect(() -> new HashSet<>()
                , (list, element) -> list.add(element)
                , (list1, list2) -> list1.addAll(list2));
    }
}