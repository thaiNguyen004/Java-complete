package f_PassingLambdaExpressionAsArgument;
/*
* • Như đã giải thích trước đó, một biểu thức lambda có thể được sử dụng trong bất kỳ ngữ cảnh nào
* cung cấp một kiểu mục tiêu. Một trong số đó là khi một biểu thức lambda được truyền như một đối số.
* • Trên thực tế, việc truyền một biểu thức lambda như một đối số là một cách sử dụng phổ biến của lambdas.
* Hơn nữa, đây là một cách sử dụng rất mạnh mẽ vì nó cung cấp cho bạn một cách để truyền mã có thể thực thi
* như một đối số cho một phương thức. Điều này giúp tăng cường khả năng biểu đạt của Java.
* • Để truyền một biểu thức lambda như một đối số, kiểu của tham số nhận đối số biểu thức lambda phải là
* một kiểu giao diện chức năng tương thích với lambda. Mặc dù việc sử dụng một biểu thức lambda như một đối số
* là đơn giản, nhưng việc thấy nó hoạt động vẫn hữu ích. Chương trình sau đây minh họa quá trình này:
*
* */

interface Stringfunc {
    String func(String n);
}
public class example {
    /* • Phương thức này có một giao diện chức năng là kiểu của tham số đầu tiên. Do đó, nó có thể nhận một
     * tham chiếu tới bất kỳ phiên bản của giao diện đó, bao gồm cả phiên bản được tạo ra bằng một biểu thức lambda.
     * Tham số thứ hai xác định chuỗi để thực hiện các hoạt động trên.
     * */
    static String stringOp (Stringfunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String instring = "Lambda add power to Java";
        String outstring;

        System.out.println("Here is input string: " + instring);
        //Ở đây là một biểu thức lambda đơn giản chuyển đổi chuỗi sang viết hoa cho đối số thứ 2
        outstring = stringOp(str -> str.toUpperCase(), instring);
        System.out.println("Here is output string: " + outstring);

        //Ở đây là một biểu thức lambda đơn giản xóa khoảng trắng cho đối số thứ 2
        outstring = stringOp(str -> {
            String result = "";
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) != ' ') {
                    result += str.charAt(i);
                }
            }
            return result;
        }, instring);

        System.out.println("Here is string remove space : " + outstring);

/*
* Tất nhiên, cũng có thể truyền một phiên bản của StringFunc được tạo ra bởi một biểu thức lambda trước đó.
* Ví dụ, sau khi khai báo này được thực thi, reverse sẽ tham chiếu tới một phiên bản của StringFunc.
* */
        Stringfunc reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        //Truyền phiên bản reverse của interface kia làm đối số
        outstring = stringOp(reverse, instring);
        System.out.println("The String reversed : " + outstring);
    }
}

/*
* • Trong chương trình, trước tiên hãy chú ý đến phương thức stringOp(). Nó có hai tham số.
* Tham số đầu tiên có kiểu StringFunc, đó là một giao diện chức năng. Do đó, tham số này có thể nhận một
* tham chiếu tới bất kỳ phiên bản của StringFunc nào, bao gồm cả một phiên bản được tạo ra bởi một biểu thức lambda.
* Đối số thứ hai của stringOp() có kiểu String, và đây là chuỗi được thực hiện các hoạt động trên.
* Tiếp theo, chú ý đến lời gọi đầu tiên đến stringOp(), được trình bày lại ở đây:
*       outStr = stringOp((str) -> str.toUpperCase(), inStr);
* Ở đây, một biểu thức lambda đơn giản được truyền làm đối số. Khi điều này xảy ra, một phiên bản của giao diện chức năng
* StringFunc được tạo ra và một tham chiếu tới đối tượng đó được truyền vào tham số đầu tiên của stringOp().
* Do đó, mã lambda, được nhúng trong một phiên bản của lớp, được truyền vào phương thức.
* Ngữ cảnh kiểu mục tiêu được xác định bởi kiểu tham số. Vì biểu thức lambda tương thích với kiểu đó,
* cuộc gọi là hợp lệ.
* • Nhúng các biểu thức lambda đơn giản như vừa được hiển thị trong một cuộc gọi phương thức thường là một kỹ thuật tiện lợi -
* đặc biệt là khi biểu thức lambda được dùng cho một lần sử dụng duy nhất.
* • Tiếp theo, chương trình truyền một biểu thức lambda dạng khối vào stringOp().
* Lambda này loại bỏ các khoảng trắng khỏi một chuỗi. Nó được hiển thị lại ở đây:
*       outstring = stringOp(str -> {
*           String result = "";
*           for(int i = 0; i < str.length(); i++) {
*               if(str.charAt(i) != ' ') {
*                   result += str.charAt(i);
*               }
*           }
*           return result;
*       }, instring);
*
* • Mặc dù đoạn mã này sử dụng một block lambda, quá trình truyền biểu thức lambda là giống như đã được mô tả
* cho biểu thức lambda đơn giản. Trong trường hợp này, tuy nhiên, một số lập trình viên có thể thấy cú pháp hơi cồng kềnh.
* Khi một block lambda dường như quá dài để nhúng vào một cuộc gọi phương thức, việc gán lambda đó cho một biến
* giao diện chức năng là một việc đơn giản, như đã được thực hiện trong các ví dụ trước đó.
*
* • Sau đó, bạn có thể đơn giản là truyền tham chiếu đó vào phương thức. Kỹ thuật này được thể hiện ở cuối chương trình.
* Ở đó, một block lambda được định nghĩa để đảo ngược một chuỗi. Lambda này được gán cho reverse,
* một tham chiếu tới một phiên bản của StringFunc. Do đó, reverse có thể được sử dụng như một đối số cho tham số đầu tiên
* của stringOp(). Tiếp theo, chương trình gọi stringOp(), truyền vào reverse và chuỗi để thực hiện các hoạt động.
*
* • Vì các phiên bản được thu được từ việc đánh giá mỗi biểu thức lambda là một phiên bản của StringFunc,
* nên mỗi phiên bản đó có thể được sử dụng như tham số đầu tiên cho stringOp().
* */

/*
* Một điểm cuối cùng: Ngoài việc khởi tạo biến, gán giá trị và truyền đối số,
* các ngữ cảnh sau đây cũng được coi là ngữ cảnh kiểu mục tiêu: ép kiểu, toán tử ?, khởi tạo mảng, câu lệnh return
* và các biểu thức lambda.*/
