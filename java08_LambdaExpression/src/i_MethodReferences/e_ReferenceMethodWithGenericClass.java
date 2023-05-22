package i_MethodReferences;

interface myFuncGen <T>{
    MyGenClass <T> func (T v);
}

class MyGenClass <T>{
    T value;

    MyGenClass(T v) {value = v;}
    MyGenClass() {value = null;}

    T getValue(){return value;}
}

public class e_ReferenceMethodWithGenericClass {
    public static void main(String[] args) {
        myFuncGen<String> myFuncCons = MyGenClass<String>::new;
        MyGenClass ob = myFuncCons.func("Nguyễn Thái Nguyên");

        System.out.println(ob.getValue());

        /*
        * Chương trình này tạo ra cùng kết quả với phiên bản trước. Sự khác biệt là cả MyFunc và MyClass đều là generic.
        Do đó, chuỗi tạo tham chiếu constructor có thể bao gồm một đối số kiểu (mặc dù không phải lúc nào cũng cần thiết),
        như được hiển thị ở đây:
        *       MyFunc<Integer> myClassCons = MyClass<Integer>::new;
        * Vì đối số kiểu Integer đã được chỉ định khi myClassCons được tạo, nó có thể được sử dụng để tạo
        * một đối tượng MyClass<Integer>, như dòng tiếp theo hiển thị:
        *       MyClass<Integer> mc = myClassCons.func(100);
        * Mặc dù các ví dụ trước đây thể hiện cơ chế sử dụng tham chiếu constructor, không ai sẽ sử dụng một tham chiếu
        * constructor như vừa hiển thị vì không có gì được đạt được. Hơn nữa, việc có hai tên cho cùng một constructor
        * tạo ra tình huống rắc rối (để nói ít nhất). Xem tiếp ở file f_example.java
        */
    }
}
