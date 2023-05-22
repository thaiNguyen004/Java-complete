package g_LambdaExpressionAndException;

/*
* • Một biểu thức lambda có thể gây ra một ngoại lệ. Tuy nhiên, nếu nó gây ra một ngoại lệ checked,
* thì ngoại lệ đó phải tương thích với các ngoại lệ được liệt kê trong mệnh đề throws của phương thức trừu tượng
* trong giao diện chức năng. Dưới đây là một ví dụ minh họa cho điều này.
* • Nó tính trung bình của một mảng các giá trị double. Tuy nhiên, nếu một mảng có độ dài bằng không được truyền vào,
* nó sẽ ném ra ngoại lệ tùy chỉnh EmptyArrayException. Như ví dụ cho thấy, ngoại lệ này được liệt kê trong mệnh đề throws
* của func() được khai báo trong giao diện chức năng DoubleNumericArrayFunc.
* */

interface DoubleNumericArrayFunc {
    double func(double[] n) throws EmptyArrayException;
}

class EmptyArrayException extends Exception {
    public EmptyArrayException() {
        super("Array Empty");
    }
}
public class example {
    public static void main(String[] args) {
        double[] values = {1.54, 2.53, 7.65, 8.87, 9.65};

        DoubleNumericArrayFunc average = (n) -> {
            double sum = 0;
            if(n.length == 0) {
                throw new EmptyArrayException();
            }
            for (int i = 0; i < n.length; i++) {
                sum += n[i];
            }
            return sum / n.length;
        };
        try {
            System.out.println("Average : " + average.func(values));
            System.out.println("Average : " + average.func(new double[0]));
        } catch (EmptyArrayException e) {
            System.out.println(e);
        }
    }
/*
* Cuộc gọi đầu tiên đến average.func() trả về giá trị 6.048.
* Cuộc gọi thứ hai, trong đó truyền vào một mảng có độ dài bằng không, gây ra ném ngoại lệ EmptyArrayException.
* Hãy nhớ rằng việc bao gồm mệnh đề throws trong func() là cần thiết. Nếu không có nó, chương trình sẽ không
* biên dịch được vì biểu thức lambda sẽ không còn tương thích với func().
*
* Ví dụ này cho thấy một điểm quan trọng khác về biểu thức lambda. Lưu ý rằng tham số được chỉ định bởi func()
* trong giao diện chức năng DoubleNumericArrayFunc là một mảng. Tuy nhiên, tham số cho biểu thức lambda đơn giản là n,
*  chứ không phải là n[]. Hãy nhớ rằng kiểu của tham số biểu thức lambda sẽ được suy ra từ ngữ cảnh mục tiêu.
* Trong trường hợp này, ngữ cảnh mục tiêu là double[], do đó kiểu của n sẽ là double[]. Không cần thiết (hoặc hợp lệ)
* để chỉ định nó là n[]. Sẽ hợp lệ nếu rõ ràng khai báo là double[] n, nhưng làm như vậy không mang lại lợi ích gì trong
* trường hợp này.*/
}
