package i_MethodReferences;

/*
* Tham chiếu đến Constructor
* Tương tự như cách bạn có thể tạo tham chiếu đến các phương thức, bạn cũng có thể tạo tham chiếu đến các
* constructor. Đây là dạng tổng quát của cú pháp mà bạn sẽ sử dụng:
* classname::new
* Tham chiếu này có thể được gán cho bất kỳ tham chiếu functional interface nào mà xác định một phương thức
* tương thích với constructor. Đây là một ví dụ đơn giản:
* */

interface myFunc {
    MyClass func(int v);
}

class MyClasss {
    int value;

    MyClasss (int v) {value = v;}

    MyClasss () {value = 0;}

    int getValue(){return value;}
}
public class d_ConstructorReferences {
    public static void main(String[] args) {
        //tạo một tham chiếu đến constructor của MyClass vì func() trong myfunc nhận một đối số,
        // new đề cập đến constructor có tham số trong MyClass chứ không phải constructor mặc định.
        myFunc MyClassCons = MyClass::new;
        //tạo ra một thể hiện của MyClass thông qua tham chiếu constructor
        MyClass ob = MyClassCons.func(5);

        System.out.println("val in ob: "+ ob.getValue());

        /*
        * Trong chương trình này, hãy để ý rằng phương thức func() của MyFunc trả về một tham chiếu kiểu MyClass
        * và có một tham số kiểu int. Tiếp theo, hãy nhìn vào đoạn mã sau:
        *       MyFunc myClassCons = MyClass::new;
        * Ở đây, biểu thức MyClass::new tạo ra một tham chiếu constructor đến một constructor của lớp MyClass.
        * Trong trường hợp này, vì phương thức func() của MyFunc nhận một tham số int, constructor đang được
        * tham chiếu là MyClass(int v)
        * vì nó khớp với yêu cầu. Hãy cũng để ý rằng tham chiếu đến constructor này được gán cho một tham
        * chiếu MyFunc được gọi là myClassCons. Sau khi câu lệnh này được thực thi, myClassCons có thể được
        * sử dụng để tạo một phiên bản của MyClass, như ví dụ dưới đây:
        *       MyClass mc = myClassCons.func(100);
        * Điều quan trọng là myClassCons đã trở thành một cách khác để gọi MyClass(int v).
        * Tham chiếu constructor đến các lớp generic được tạo ra theo cùng cách. Sự khác biệt duy nhất là đối số
        * kiểu có thể được chỉ định. Việc này hoạt động tương tự như việc sử dụng một lớp generic để tạo
        * một tham chiếu phương thức: chỉ định đối số kiểu sau tên lớp. Ví dụ sau đây minh họa điều này
        * bằng cách sửa đổi ví dụ trước để MyFunc và MyClass trở thành generic.
        * file e_ReferenceMethodWithGenericClass.java*/
    }
}
