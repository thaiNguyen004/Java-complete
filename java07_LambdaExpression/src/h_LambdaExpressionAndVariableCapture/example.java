package h_LambdaExpressionAndVariableCapture;
/*
* • Các biến được xác định bởi phạm vi bao quanh của biểu thức lambda có thể được truy cập trong biểu thức lambda đó.
* Ví dụ, một biểu thức lambda có thể sử dụng một biến thể hiện (instance) hoặc biến tĩnh (static) được xác định bởi
* lớp bao quanh của nó.
* • Một biểu thức lambda cũng có quyền truy cập vào từ khóa "this" (cả rõ ràng và ngầm định), đề cập đến thể hiện gọi
* của lớp bao quanh biểu thức lambda. Do đó, một biểu thức lambda có thể lấy hoặc đặt giá trị của một biến
* thể hiện hoặc biến tĩnh và gọi một phương thức được xác định bởi lớp bao quanh của nó.
*
* Tuy nhiên, khi một biểu thức lambda sử dụng một biến cục bộ từ phạm vi bao quanh của nó, một tình huống đặc biệt
* được tạo ra được gọi là capture variable. Trong trường hợp này, một biểu thức lambda chỉ có thể sử dụng các biến
* cục bộ mà thực tế là "effective final" (hiệu lực cuối cùng). Một biến "effective final" là biến mà giá trị của nó
* không thay đổi sau khi được gán lần đầu tiên. Không cần phải khai báo biến như final một cách rõ ràng,
* mặc dù việc làm điều đó cũng không phải là một lỗi. (Tham số "this" của một phạm vi bao quanh tự động trở thành
* "effective final", và biểu thức lambda không có "this" riêng của chúng nó.)
*
* Việc quan trọng là hiểu rằng một biến cục bộ của phạm vi bao quanh không thể được sửa đổi bởi biểu thức lambda.
* Làm như vậy sẽ xóa trạng thái "effective final" của nó, dẫn đến việc không thể capture.
*
* Chương trình sau minh họa sự khác biệt giữa biến "effective final" và biến cục bộ có thể thay đổi (mutable):
* */

/*
* Khi một biến cục bộ được "capture", nghĩa là nó có thể được sử dụng bên trong biểu thức lambda,
* kể cả sau khi phạm vi bao quanh của biến đó đã kết thúc.*/
interface MyFunc {
    int func (int n);
}
public class example {
    private int instanceVariable = 20;
    public void performLambda () {
        int localVariable = 5;

        MyFunc instanceVariableLambda = (n) -> {
            int v = instanceVariable + n; //Có thể sử dụng biến thể hiện
            instanceVariable ++; //Có thể sửa đổi biến thể hiện
            return v;
        };

        MyFunc localVariableLambda = (n) -> {
            int v = localVariable + n; //Có thể sử dụng biến cục bộ
//            localVariable++;  Không thể sửa đổi biến cục bộ
            return v;
        };
    }
    public static void main(String[] args) {
        // Một biến cục bộ có thể được capture
        int num = 10;

        MyFunc myLambda = (n) -> {
            //Việc sử dụng biến num OK, nó không làm thay đổi num
            int v = num + n;

            //Tuy nhiên đoạn code dưới đây là bất hợp pháp, nó đang cố gắng sửa đổi biến num
//            num++;
            return v;
        };

        //Dòng mã sau cũng sẽ gây ra lỗi vì nó sẽ xóa trạng thái "effective final" của biến "num".
//        num++;

    }
}
