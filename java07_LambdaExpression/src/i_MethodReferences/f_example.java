package i_MethodReferences;

/* Tuy nhiên, để mang lại cho bạn một cái nhìn tổng quan về việc sử dụng thực tế hơn, chương trình sau đây sử dụng
một phương thức tĩnh có tên là myClassFactory() là một nhà máy cho các đối tượng của bất kỳ loại đối tượng MyFunc nào.
Nó có thể được sử dụng để tạo ra bất kỳ loại đối tượng nào có constructor tương thích với tham số đầu tiên của nó.
*/

import java.util.function.Function;

interface MyFuncs<R, T> {
    R func(T v);
}

class MyClass1<T> {
    T value;

    MyClass1(T v) {
        value = v;
    }

    MyClass1() {
        value = null;
    }

    T getValue() {
        return value;
    }
}

class MyClass2 {
    String str;

    MyClass2(String s) {
        str = s;
    }

    MyClass2() {
        str = "";
    }

    String getValue() {
        return str;
    }

}

public class f_example {
    static <R, T> R myClassFactory(MyFuncs<R, T> func, T v) {
        return func.func(v);
    }

    public static void main(String[] args) {
        MyFuncs<MyClass1<Integer>, Integer> myClass1Cons = MyClass1<Integer>::new;
        MyClass1<Integer> ob = myClass1Cons.func(100);

        System.out.println("Value of MyClass1 kiểu Integer: " + ob.getValue());

        MyFuncs<MyClass1<Double>, Double> myClass1Cons2 = MyClass1<Double>::new;
        MyClass1<Double> ob1 = myClass1Cons2.func(1000.1);

        System.out.println("Value of MyClass1 kiểu Double: " + ob1.getValue());

        MyFuncs<MyClass2, String> myClass2Cons = MyClass2::new;
        MyClass2 ob2 = myClass2Cons.func("Hello World");

        System.out.println("Value of MyClass2: " + ob2.getValue());

        //Bây giờ tạo một lớp khác bằng cách sử dụng myClassFactory()
        MyClass2 mc2 = myClassFactory(MyClass2::new, "Lambda");
        System.out.println("Value of MyClass2 is created by myClassFactory: "+mc2.getValue());



     /*
     * Như bạn có thể thấy, myClassFactory() được sử dụng để tạo đối tượng của kiểu MyClass<Double> và MyClass2.
     * Mặc dù cả hai lớp này khác nhau, ví dụ MyClass là generic và MyClass2 không phải, cả hai đều có thể được tạo bằng
     * myClassFactory() vì cả hai đều có các constructor tương thích với func() trong MyFunc. Điều này hoạt động vì
     * myClassFactory() nhận vào constructor để xây dựng đối tượng. Bạn có thể thử nghiệm chương trình này một chút
     * bằng cách tạo các lớp khác nhau mà bạn tạo. Hãy thử tạo các phiên bản khác nhau của đối tượng MyClass. Như bạn sẽ thấy,
     * myClassFactory() có thể tạo ra bất kỳ loại đối tượng nào mà lớp của nó có một constructor tương thích với func() trong MyFunc.
     * Mặc dù ví dụ này khá đơn giản, nó cho thấy sức mạnh mà constructor references mang lại cho Java.
     * */
    }
}


