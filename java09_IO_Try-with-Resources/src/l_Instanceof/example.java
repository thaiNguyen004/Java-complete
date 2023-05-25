package l_Instanceof;
/*
* Sử dụng instanceof
* Đôi khi, việc biết loại đối tượng trong thời gian chạy là hữu ích. Ví dụ, bạn có thể có một luồng thực thi tạo ra các loại đối tượng khác nhau
* và một luồng khác xử lý những đối tượng này. Trong tình huống này, việc cho luồng xử lý biết loại của mỗi đối tượng khi nhận được nó có thể hữu ích.
*
* Một tình huống khác mà việc biết loại đối tượng vào thời gian chạy là quan trọng liên quan đến việc ép kiểu. Trong Java, việc ép kiểu
* không hợp lệ gây ra lỗi thời gian chạy. Nhiều ép kiểu không hợp lệ có thể được phát hiện tại thời gian biên dịch.
* Tuy nhiên, các ép kiểu liên quan đến các hệ thống lớp có thể tạo ra các ép kiểu không hợp lệ chỉ có thể được phát hiện tại thời gian chạy.
*
* Ví dụ, một lớp cha gọi là A có thể tạo ra hai lớp con, gọi là B và C. Do đó, việc ép kiểu một đối tượng B thành kiểu A
* hoặc ép kiểu một đối tượng C thành kiểu A là hợp lệ, nhưng việc ép kiểu một đối tượng B thành kiểu C (hoặc ngược lại) không hợp lệ.
* Bởi vì một đối tượng kiểu A có thể tham chiếu đến đối tượng kiểu B hoặc C, làm sao bạn biết, tại thời gian chạy,
* đối tượng thực sự được tham chiếu trước khi thử ép kiểu thành kiểu C? Nó có thể là một đối tượng kiểu A, B hoặc C.
* Nếu nó là một đối tượng kiểu B, một ngoại lệ thời gian chạy sẽ được ném ra. Java cung cấp toán tử instanceof để giải quyết câu hỏi này.
* Toán tử instanceof có dạng chung như sau:
*
* objref instanceof typ
*
* */

class A {
    int i, j;
}

class B {
    int i, j;
}

class C extends A {
    int k;
}

class D extends  A {
    int k;
}
public class example {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();


        if(a instanceof A)
            System.out.println("a is instance of A");
        if(b instanceof B)
            System.out.println("b is instance of B");
        if(c instanceof C)
            System.out.println("c is instance of C");
        if(c instanceof A)
            System.out.println("c can be cast to A");
        if(a instanceof C)
            System.out.println("a can be cast to C");
        System.out.println();


        A ob;
        ob = d; //A reference to d
        System.out.println("ob tham chiếu tới d");
        if(ob instanceof  D)
            System.out.println("ob is instance of D");
        System.out.println();



        ob = c; //A reference to C
        System.out.println("ob tham chiếu tới c");
        if(ob instanceof D)
            System.out.println("ob can be cast to D");
        else
            System.out.println("ob cannot be cast to D");
        if(ob instanceof A)
            System.out.println("ob can be cast to A");
        System.out.println();



        //Tất cả các đối tượng có thể ép kiểu thành Object
        if(a instanceof Object)
            System.out.println("a can be cast to Object");
        if(b instanceof Object)
            System.out.println("b can be cast to Object");
        if(c instanceof Object)
            System.out.println("c can be cast to Object");
        if(d instanceof Object)
            System.out.println("d can be cast to Object");


        /*
        * Toán tử instanceof không cần thiết trong hầu hết các chương trình, vì thông thường bạn biết kiểu đối tượng mà bạn đang làm việc.
        * Tuy nhiên, nó có thể rất hữu ích khi bạn viết các hàm tổng quát hoạt động trên đối tượng của một phân cấp lớp phức tạp.*/
    }
}
