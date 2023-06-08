package g_Map;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
* Ánh xạ
* Thường thì việc ánh xạ các phần tử từ một stream sang stream khác rất hữu ích. Ví dụ, một stream chứa thông tin tên,
* số điện thoại và địa chỉ email trong cơ sở dữ liệu có thể ánh xạ chỉ các phần tên và địa chỉ email sang một stream khác.
* Một ví dụ khác, bạn có thể muốn áp dụng một biến đổi nào đó cho các phần tử trong stream.
* Để làm điều này, bạn có thể ánh xạ các phần tử đã được biến đổi sang một stream mới. Vì các phép ánh xạ thường được
* sử dụng rất phổ biến, stream API cung cấp hỗ trợ tích hợp cho chúng.
* Phương thức ánh xạ tổng quát nhất là map(). Nó được hiển thị như sau:
*       <R> Stream<R> map(Function<? super T, ? extends R> mapFunc)
* Ở đây, R chỉ định loại các phần tử của stream mới;
* T là loại các phần tử của stream gọi phương thức; và mapFunc là một phiên bản của Function, thực hiện việc ánh xạ.
* Hàm ánh xạ phải không có trạng thái và không gây ảnh hưởng. Vì một stream mới được trả về, map() là một phương thức trung gian.
* Function là một functional interface được khai báo trong java.util.function. Nó được khai báo như sau:
*       Function<T, R>
* Liên quan đến map(), T là loại phần tử và R là kết quả của quá trình ánh xạ.
* Function có phương thức trừu tượng được hiển thị như sau:
*       R apply(T val)
* Ở đây, val là một tham chiếu đến đối tượng đang được ánh xạ. Kết quả ánh xạ được trả về.
* Dưới đây là một ví dụ đơn giản về map(). Nó cung cấp một biến thể trên chương trình ví dụ trước đó.
* Giống như trước, chương trình tính tích của căn bậc hai các giá trị trong ArrayList.
* Tuy nhiên, trong phiên bản này, căn bậc hai của các phần tử được ánh xạ trước sang một stream mới.
* Sau đó, reduce() được sử dụng để tính tích.
*
* */
public class example_geory {
    public static void main(String[] args) {
        var myList = new ArrayList<Double>();
        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(5.0);

        Stream<Double> sqrtRootStrm = myList.stream().map((n) -> Math.sqrt(n));

        // Tính tích các căn bậc 2 bằng reduce
        double productOfSqrRoots = sqrtRootStrm.reduce(1.0, (a, b) -> a* b);
        System.out.println("Tích các căn bậc 2: " + productOfSqrRoots);


        /*
        * Kết quả đầu ra giống như trước đó. Sự khác biệt giữa phiên bản này và phiên bản trước đó đơn giản
        * là quá trình biến đổi (tức là tính toán căn bậc hai) xảy ra trong quá trình ánh xạ, chứ không phải
        * trong quá trình giảm thiểu. Do đó, có thể sử dụng phiên bản hai tham số của reduce() để tính tích
        * vì không còn cần thiết phải cung cấp một hàm combiner riêng biệt.
        *
        * Dưới đây là một ví dụ sử dụng map() để tạo ra một stream mới chỉ chứa các trường được chọn từ stream gốc.
        * Trong trường hợp này, stream gốc chứa các đối tượng thuộc loại NamePhoneEmail, chứa tên, số điện thoại
        * và địa chỉ email. Chương trình sau đó ánh xạ chỉ tên và số điện thoại sang một stream mới chứa các
        * đối tượng NamePhone. Địa chỉ email được loại bỏ.
        *
        * */

        var myList2 = new ArrayList<NamePhoneEmail>();
        myList2.add(new NamePhoneEmail("Nguyên", "555-5555", "NguyenThai@gmail.com"));
        myList2.add(new NamePhoneEmail("Dũng", "255-5555", "DungBui@gmail.com"));
        myList2.add(new NamePhoneEmail("Linh", "2255-5555", "QuangLinh@gmail.com"));

        System.out.println("Original values in myList2: ");
        myList2.stream().forEach(e -> {
            System.out.println(e.name +" " + e.phonenum + " " + e.email);
        });
        System.out.println();

        // Chỉ ánh xạ tên và số điện thoại vào luồng mới
        Stream<NamePhone> namePhone = myList2.stream().map((a) -> new NamePhone(a.name, a.phonenum));
        System.out.println("Danh sách name và số điện thoại : ");
        namePhone.forEach(a -> {
            System.out.println(a.name +" " + a.phonenum);
        });
        System.out.println();

        // Bởi vì bạn có thể xếp hàng nhiều hoạt động trung gian lại với nhau, bạn có thể dễ dàng
        // tạo ra các hoạt động mạnh mẽ. Ví dụ, câu lệnh sau sử dụng `filter()`
        // và sau đó map() để tạo ra một luồng mới chỉ chứa tên và số điện thoại của các phần tử có tên là "Nguyên":

        Stream<NamePhone> nameAndPhone = myList2.stream().filter(o -> o.name.equals("Nguyên")).map(o -> new NamePhone(o.name, o.phonenum));
        nameAndPhone.forEach(e -> {
            System.out.println(e.name +" "+e.phonenum);
        });

        /*
        * Loại hoạt động lọc này rất phổ biến khi tạo các truy vấn theo kiểu cơ sở dữ liệu. Khi bạn có kinh nghiệm với stream API,
        * bạn sẽ nhận ra rằng chuỗi các hoạt động như vậy có thể được sử dụng để tạo ra các truy vấn, kết hợp và lựa chọn
        * rất tinh vi trên một luồng dữ liệu.
        * Ngoài phiên bản vừa được mô tả, cung cấp ba phiên bản khác của map(). Chúng trả về một primitive stream, được hiển thị như sau:
        *
        * IntStream mapToInt(ToIntFunction<? super T> mapFunc)
        * LongStream mapToLong(ToLongFunction<? super T> mapFunc)
        * DoubleStream mapToDouble(ToDoubleFunction<? super T> mapFunc)
        *
        * Mỗi mapFunc phải thực hiện phương thức trừu tượng được xác định bởi giao diện đã chỉ định, trả về một giá trị có kiểu được chỉ định.
        * Ví dụ, ToDoubleFunction xác định phương thức applyAsDouble(T val), phải trả về giá trị của tham số của nó dưới dạng double.
        *
        * Dưới đây là một ví dụ sử dụng primitive stream. Trước tiên, nó tạo một ArrayList chứa các giá trị Double.
        * Sau đó, sử dụng stream() tiếp theo là mapToInt() để tạo ra một IntStream chứa giá trị ceiling của mỗi phần tử.
        *
        * */
        // Class PrimitiveStreamDemo
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

class PrimitiveStreamDemo {
    public static void main(String[] args) {
        var listDouble = new ArrayList<Double>();
        listDouble.add(1.1);
        listDouble.add(3.6);
        listDouble.add(9.2);
        listDouble.add(12.1);
        listDouble.add(5.0);

        System.out.println("Original values in listDouble: ");
        listDouble.stream().forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

        IntStream ceilStream = listDouble.stream().mapToInt(a -> (int) Math.ceil(a));

        System.out.println("Các giá trị ép kiểu lên của listDouble: ");
        ceilStream.forEach(a -> {
            System.out.print(a + " ");
        });

        /*
        * Stream được tạo bởi mapToInt() chứa các giá trị ceiling của các phần tử gốc trong myList.
        *
        * Trước khi rời khỏi chủ đề về ánh xạ, cần phải chỉ ra rằng stream API cũng cung cấp các phương thức
        * hỗ trợ flat map. Đó là flatMap(), flatMapToInt(), flatMapToLong() và flatMapToDouble(). Các phương thức flat map
        * được thiết kế để xử lý những tình huống mà mỗi phần tử trong luồng gốc được ánh xạ thành nhiều hơn một phần tử
        * trong luồng kết quả.
        *
        * */


    }
}