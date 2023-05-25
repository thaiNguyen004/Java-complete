package p_ImportStatic;
/*
* Import tĩnh (Static Import)
* Java bao gồm một tính năng gọi là import tĩnh (static import) mở rộng khả năng của từ khóa import. Bằng cách theo sau import
* với từ khóa static, một câu lệnh import có thể được sử dụng để nhập các thành viên tĩnh của một lớp hoặc giao diện.
*
* Khi sử dụng import tĩnh, bạn có thể truy cập trực tiếp đến các thành viên tĩnh bằng tên của chúng, mà không cần phải gắn liền chúng
* với tên của lớp. Điều này đơn giản hóa và rút ngắn cú pháp cần thiết để sử dụng một thành viên tĩnh.
* Để hiểu tính hữu ích của import tĩnh, hãy xem xét một ví dụ không sử dụng nó.
*
* Chương trình sau tính độ dài cạnh huyền của một tam giác vuông. Nó sử dụng hai phương thức tĩnh từ lớp toán học tích hợp sẵn Math của Java,
* nằm trong gói java.lang. Phương thức đầu tiên là Math.pow(), trả về giá trị lũy thừa của một số.
* Phương thức thứ hai là Math.sqrt(), trả về căn bậc hai của đối số của nó.*/

//Mã import tĩnh
import static java.lang.Math.*;
import static p_ImportStatic.MyClass.*; //import class của chính tôi
public class example {
    public static void main(String[] args) {
        double side1, side2;
        double hypot; //hypotenuse : cạnh huyền
        side1 = 3.0;
        side2 = 4.0;

//        hypot = Math.sqrt(Math.pow(side1, 2) +
//                Math.pow(side2, 2));

        hypot = sqrt(pow(side1, 2) + pow(side2, 2));

        System.out.println("Cho các cạnh: cạnh thứ nhất = " + side1 + "; cạnh thứ hai: " + side2 + "; " +
                "và cạnh huyền có độ dài được tính = " +hypot);

        //Bởi vì pow() và sqrt() là các phương thức tĩnh (static), nên chúng phải được gọi thông qua tên của lớp chứa chúng, Math.
        //Điều này dẫn đến việc tính cạnh huyền trở nên hơi phức tạp như sau:
        /*
        * hypot = Math.sqrt(Math.pow(side1, 2) +
                Math.pow(side2, 2));*/

        /*
        * Như ví dụ đơn giản này đã minh họa, việc phải chỉ định tên lớp mỗi khi sử dụng pow() hoặc sqrt() (hoặc bất kỳ phương thức
        * toán học khác của Java như sin(), cos() và tan()) có thể trở nên đơn điệu.
        * Bạn có thể loại bỏ sự đơn điệu này bằng cách sử dụng import tĩnh, như được sửa lại sau khi viết mã trước ở phần comment:*/



        //Import các phương thức của MyClass mà không cần ghi tên lớp
        display();
    }
}
