package i_MethodReferences;

/*
* Phương pháp Tham chiếu với Generics
* Bạn có thể sử dụng tham chiếu phương thức với các lớp generic và/hoặc phương thức generic.
* Ví dụ, hãy xem xét chương trình sau đây
* */

import java.util.ArrayList;
import java.util.Collections;

interface MyFuncGen <T> {
    int func(T[] vals, T v);
}

// Lớp này định nghĩa một phương thức có tên là countMatching()
// trả về số phần tử trong mảng mà bằng giá trị chỉ định.
// lưu ý rằng countMatching là một method generic nhưng MyArrayOps thì không
class MyArrayOps {
    static <T> int countMatching (T[] vals, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++)
            if(vals[i] == v) count++;
        return count;
    }
}

public class c_MethodReferenceWithGeneric {
    static <T> int myOp (MyFuncGen<T> func, T[] vals, T v) {
        return func.func(vals, v);
    }

    public static void main(String[] args) {
        String[] strs = {"one", "two", "three", "four", "five"};
        Integer[] vals = {1, 2, 3, 4, 5};
        int count;

        count = myOp(MyArrayOps::<String>countMatching, strs, "one");
        System.out.println("count = "+count);

    /*
    * Trong chương trình này, MyArrayOps là một lớp không generic chứa một phương thức generic được gọi
    * là countMatching(). Phương thức này trả về số lượng các phần tử trong một mảng khớp với một giá trị
    * đã chỉ định. Lưu ý cách chỉ định đối số kiểu generic. Ví dụ, lời gọi đầu tiên trong main(), như sau:
    *       count = myOp(MyArrayOps::<Integer>countMatching, vals, 4);
    * truyền đối số kiểu Integer. Lưu ý rằng nó xuất hiện sau dấu ::. Cú pháp này có thể tổng quát hóa:
    * Khi một phương thức generic được chỉ định làm tham chiếu phương thức, đối số kiểu của nó đi sau dấu ::
    * và trước tên phương thức. Tuy nhiên, cần nhấn mạnh rằng việc chỉ định rõ ràng đối số kiểu không
    * bắt buộc trong tình huống này (và nhiều tình huống khác) vì đối số kiểu đã được suy ra tự động.
    * Trong các trường hợp mà một lớp generic được chỉ định, đối số kiểu đi sau tên lớp và trước dấu ::.
    * Mặc dù các ví dụ trên chỉ cho thấy cách sử dụng tham chiếu phương thức, nhưng chúng không chỉ ra
    * những lợi ích thực sự của chúng. Một nơi mà tham chiếu phương thức có thể rất hữu ích là khi kết hợp
    * với Collections Framework, được mô tả sau trong Chương 19. Tuy nhiên, để đầy đủ, một ví dụ ngắn
    * nhưng hiệu quả sử dụng tham chiếu phương thức để xác định phần tử lớn nhất trong một collection
    * được đưa vào đây. (Nếu bạn không quen thuộc với Collections Framework, hãy quay lại ví dụ này sau
    * khi đã làm việc qua Chương 19.)
    *
    * Một cách để tìm phần tử lớn nhất trong một collection là sử dụng phương thức max() được định nghĩa
    * bởi lớp Collections. Đối với phiên bản max() được sử dụng ở đây, bạn phải truyền một tham chiếu
    * đến collection và một instance của một đối tượng thực hiện giao diện Comparator<T>.
    * Giao diện này chỉ định cách so sánh hai đối tượng. Nó chỉ định chỉ một phương thức trừu tượng,
    * gọi là compare(), nhận hai đối số, mỗi đối số là kiểu của các đối tượng được so sánh. Nó phải trả về
    * giá trị lớn hơn 0 nếu đối số thứ nhất lớn hơn đối số thứ hai, trả về 0 nếu hai đối số bằng nhau,
    * và trả về giá trị nhỏ hơn 0 nếu đối tượng thứ nhất nhỏ hơn đối tượng thứ hai.*/


        var al = new ArrayList<MyClass>();
        al.add(new MyClass(1));
        al.add(new MyClass(2));
        al.add(new MyClass(3));
        al.add(new MyClass(4));
        al.add(new MyClass(5));
        al.add(new MyClass(6));

        MyClass maxValue = Collections.max(al, c_MethodReferenceWithGeneric::myCompare);

        System.out.println(maxValue.getValue());
    }
    //Một phương thức compare tương ứng với phương thức trong Comparator<T>
    static int myCompare (MyClass v1, MyClass v2){
        return v1.getValue() - v2.getValue();
    }
}

class MyClass {
    private int value;
    public MyClass(int v){value = v;}

    int getValue() {return value;}
}
