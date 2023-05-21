package i_MethodReferences;
/*
* Để tạo một tham chiếu phương thức tĩnh (static method reference), sử dụng cú pháp chung sau:
*       TênLớp::tênPhươngThức
* Lưu ý rằng tên lớp được phân tách với tên phương thức bằng hai dấu hai chấm (::). Dấu :: là một dấu
* phân tách đã được thêm vào Java từ JDK 8 một cách cụ thể cho mục đích này. Tham chiếu phương thức này có
* thể được sử dụng bất cứ nơi nào nó tương thích với kiểu mục tiêu của nó.
* Chương trình sau đây minh họa một tham chiếu phương thức tĩnh:*/

//Một functional Interface làm việc với String
interface StringFunc {
    String func(String s);
}

class MyStringOps {
    static String strReverse(String s) {
        String result = "";
        for(int i = s.length()-1; i >=0; i--) {
            result += s.charAt(i);
        }
        return result;
    }
}

public class a_MethodReferecesToStaticMethods {
    static String stringOp (StringFunc func, String str) {
        return func.func(str);
    }

    public static void main(String[] args) {
        String inStr = "Nguyễn Thái Nguyên";
        String outStr;

        outStr = stringOp(MyStringOps::strReverse, inStr);

        System.out.println("inStr: "+inStr);
        System.out.println("outStr: "+outStr);
    }
/*
* Trong chương trình, hãy chú ý đến dòng này:
*       outStr = stringOp(MyStringOps::strReverse, inStr);
* Ở đây, một tham chiếu đến phương thức tĩnh strReverse(), được khai báo bên trong MyStringOps, được truyền làm đối số
* thứ nhất cho stringOp(). Điều này hoạt động vì strReverse tương thích với giao diện chức năng StringFunc.
*
* Do đó, biểu thức MyStringOps::strReverse được đánh giá thành một tham chiếu đến một đối tượng trong đó strReverse
*   cung cấp việc triển khai của func() trong StringFunc.*/
}
