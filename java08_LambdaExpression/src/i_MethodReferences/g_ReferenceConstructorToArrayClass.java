package i_MethodReferences;

import java.util.function.Function;

interface MyClassCreator<T, R> {
    T func(R n);
}

class ClassDemo <T>{
    T val;

    ClassDemo(T a) {val = a;}

}

public class g_ReferenceConstructorToArrayClass {
    public static void main(String[] args) {


        Function<Integer, ClassDemo<Integer>> refcons = ClassDemo<Integer>::new;
        ClassDemo<Integer> ob = refcons.apply(100);
        System.out.println("value of classdemo = " + ob.val); //value of classdemo = 100
        //Trong trường hợp này tham số truyền trong hàm apply() bằng với tham số constructor của ClassDemo



        Function<Integer, ClassDemo<Integer>[]> refconsArray = ClassDemo[]::new;
        ClassDemo<Integer>[] arrayOfClassDemo = refconsArray.apply(2);
        System.out.println("Size of arrayOfClassDemo = "+arrayOfClassDemo.length);
        //Trong trường hợp này hàm apply không cùng ngữ cảnh mục tiêu với phương thức newInstance
        //nên giá trị của đối số là 2 không phải value mà là kích thước mảng, đúng với cả ví dụ bên dưới
        arrayOfClassDemo[0] = new ClassDemo<>(99);
        arrayOfClassDemo[1] = new ClassDemo<>(98);



        Function<Integer, Integer[]> creator = Integer[]::new;
        Integer[] arrs = creator.apply(5); //Triền khai độ lớn mảng = 5


        //Tham chiếu constructor bằng interface MyClassCreator
        MyClassCreator<ClassDemo<Integer>, Integer> refcons1 = ClassDemo::new;
        ClassDemo<Integer> ob1 = refcons1.func(10);
        System.out.println(ob1.val); //10


        MyClassCreator<ClassDemo<Integer>[], Integer> refconsArray1 = ClassDemo[]::new;
        ClassDemo<Integer>[] arrayOfClassDemo1 = refconsArray1.func(2);
        arrayOfClassDemo1[0] = new ClassDemo<>(999);
        arrayOfClassDemo1[1] = new ClassDemo<>(888);

    }
}
