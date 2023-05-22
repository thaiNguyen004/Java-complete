package i_MethodReferences;

/*
* Để truyền một tham chiếu đến một phương thức thể hiện trên một đối tượng cụ thể, sử dụng cú pháp cơ bản này:
*       objRef::methodName
* Như bạn có thể thấy, cú pháp này tương tự như cú pháp sử dụng cho một phương thức tĩnh,
* chỉ khác là sử dụng tham chiếu đối tượng thay vì tên lớp. Dưới đây là chương trình trước đó được viết lại
* để sử dụng một tham chiếu đến phương thức thể hiện.*/

interface StringFunc2 {
    String func(String str);
}

class StringOps {
    String strReverse (String str) {
        String result = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

public class b_MethodReferencesToInstanceMethod {
    //Tạo ra một phương thức mà tham số đầu tiên là một biến tham chiếu kiểu interface StringFunc2
    static String stringOp (StringFunc2 func, String str) {
        return func.func(str);
    }

    public static void main(String[] args) {
        String inStr = "Nguyễn Thái Nguyên";
        String outStr;
        //stringOp(StringOps::strReverse, inStr); Lỗi!!! Lý do chưa khởi tạo đối tượng StringOps

        StringOps strOps = new StringOps();
        outStr = stringOp(strOps::strReverse, inStr);

        System.out.println("inStr: "+inStr);
        System.out.println("outStr: "+outStr);
        /*
        * Chương trình này tạo ra cùng kết quả với phiên bản trước đó.
        * Trong chương trình, hãy chú ý rằng strReverse() hiện đã là một phương thức thể hiện của MyStringOps.
        * Trong phương thức main(), một đối tượng của MyStringOps được tạo ra với tên là strOps. Đối tượng này được
        * sử dụng để tạo tham chiếu phương thức tới strReverse trong cuộc gọi stringOp, như được hiển thị lại ở đây:
        *       outStr = stringOp(strOps::strReverse, inStr);
        * Trong ví dụ này, strReverse() được gọi trên đối tượng strOps.*/

    /*
    * Cũng có thể xử lý một tình huống khi bạn muốn chỉ định một phương thức thể hiện có thể được sử dụng với bất kỳ
    * đối tượng nào của một lớp cụ thể - không chỉ một đối tượng cụ thể. Trong trường hợp này, bạn sẽ tạo một tham
    * chiếu phương thức như được hiển thị ở đây:
    *       ClassName::instanceMethodName
    *
    * Ở đây, tên của lớp được sử dụng thay vì một đối tượng cụ thể, mặc dù một phương thức thể hiện được chỉ định.
    * Với hình thức này, tham số đầu tiên của giao diện chức năng phù hợp với đối tượng gọi và tham số thứ hai phù hợp
    * với tham số được chỉ định bởi phương thức. Dưới đây là một ví dụ. Nó xác định một phương thức có tên là counter()
    * đếm số lượng đối tượng trong một mảng thỏa mãn điều kiện được xác định bởi phương thức func() của giao diện chức năng MyFunc.
    * Trong trường hợp này, nó đếm các đối tượng của lớp HighTemp.*/


        //Create an array of HighTemp objects
        HighTemp[] weekDayHighs = {
                new HighTemp(89),new HighTemp(90),
                new HighTemp(90),new HighTemp(33),
                new HighTemp(90),new HighTemp(89),
                new HighTemp(89),new HighTemp(89),
                new HighTemp(65),new HighTemp(65)
        };

        //Use counter() with arrays of the class HighTemp
        //Sử dụng hàm counter với mảng các lớp HighTemp
        //Notice that a reference to instance method sameTemp() is passed as the second argument
        //Lưu ý 1 tham chiếu phương thức tới sameTemp() được truyền vào đối số thứ 2

        int count;
        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
        System.out.println("Có " + count +" ngày có nhiệt độ 89");

        //Bây giờ sử dung hàm lessThanTemp để tìm những ngày có nhiệt độ
        //nhỏ hơn nhiệt độ chỉ định
        count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(50));
        System.out.println("Có " + count +" ngày có nhiệt độ nhỏ hơn 50");
    }
    static <T> int counter (T[] vals, MyFunc<T> f , T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++)
            if(f.func(vals[i], v)) {count++;}
        return count;
    }
}

interface MyFunc<T> {
    boolean func(T v1, T v2);
}

class HighTemp {
    private int hTemp;

    HighTemp(int ht) {hTemp = ht;}

    // Trả về true nếu 2 đối tượng không bằng nhau về chỉ số hTemp;
    boolean sameTemp (HighTemp ht2) {
        return hTemp == ht2.hTemp;
    }

    // Trả về true nếu đối tượng gọi phương thức có giá trị hTemp lớn hơn đôi số
    boolean lessThanTemp (HighTemp ht2) {
        return hTemp < ht2.hTemp;
    }
}

/*
* Trong chương trình, lưu ý rằng lớp HighTemp có hai phương thức của đối tượng: sameTemp() và lessThanTemp().
* Phương thức đầu tiên trả về true nếu hai đối tượng HighTemp chứa cùng nhiệt độ.
* Phương thức thứ hai trả về true nếu nhiệt độ của đối tượng gọi phương thức nhỏ hơn nhiệt độ của đối tượng được truyền vào.
* Mỗi phương thức có một tham số kiểu HighTemp và mỗi phương thức trả về kết quả boolean.
* Do đó, mỗi phương thức tương thích với giao diện MyFunc vì kiểu đối tượng gọi phương thức có thể được ánh xạ vào tham số đầu tiên của func()
* và đối số được ánh xạ vào tham số thứ hai của func(). Do đó, khi biểu thức HighTemp::sameTemp được truyền vào phương thức counter(),
* một phiên bản của giao diện chức năng MyFunc được tạo ra, trong đó kiểu tham số của tham số đầu tiên là kiểu đối tượng gọi phương thức,
* tức là HighTemp. Kiểu của tham số thứ hai cũng là HighTemp vì đó là kiểu của tham số của sameTemp().
* Điều tương tự cũng đúng đối với phương thức lessThanTemp().
*
* Một điểm khác: bạn có thể tham chiếu đến phiên bản của phương thức trong lớp cha bằng cách sử dụng "super", như được thể hiện ở đây:
*       super::name
* Tên của phương thức được xác định bởi "name". Một dạng khác là
*       typeName.super::name
* trong đó typeName đề cập đến một lớp bao hoặc siêu giao diện.*/

