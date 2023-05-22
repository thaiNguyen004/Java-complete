package c_CollectionClasses;
/*
* Lớp EnumSet
* Lớp EnumSet mở rộng từ AbstractSet và triển khai giao diện Set. Nó được đặc biệt thiết kế để sử dụng với các phần tử
* của một kiểu enum. Đây là một lớp generic có khai báo như sau:
* class EnumSet<E extends Enum<E>>
* Ở đây, E chỉ định các phần tử. Lưu ý rằng E phải mở rộng từ Enum<E>, điều này đảm bảo yêu cầu các phần tử phải thuộc
* kiểu enum được chỉ định.
*
* EnumSet không định nghĩa bất kỳ constructor nào. Thay vào đó, nó sử dụng các phương thức factory được hiển thị
* trong Bảng 19-7 để tạo đối tượng. Tất cả các phương thức có thể ném ra ngoại lệ NullPointerException. Các phương
* thức copyOf( ) và range( ) cũng có thể ném ra ngoại lệ IllegalArgumentException. Lưu ý rằng phương thức of( ) được nạp
* chồng một số lần. Điều này được thực hiện vì hiệu suất. Truyền một số đã biết
*
* Dưới đây là các phương thức của EnumSet:
* 1. `allOf(Class<E> elementType)`: Tạo một EnumSet chứa tất cả các phần tử của enum được chỉ định.
* 2. `complementOf(EnumSet<E> set)`: Tạo một EnumSet chứa các phần tử không có trong EnumSet được chỉ định.
* 3. `copyOf(EnumSet<E> set)`: Tạo một EnumSet bằng cách sao chép các phần tử từ EnumSet được chỉ định.
* 4. `noneOf(Class<E> elementType)`: Tạo một EnumSet rỗng với kiểu enum được chỉ định.
* 5. `of(E e)`: Tạo một EnumSet chứa một phần tử duy nhất được chỉ định.
* 6. `of(E... elements)`: Tạo một EnumSet chứa các phần tử được chỉ định.
* 7. `range(E from, E to)`: Tạo một EnumSet chứa các phần tử từ phần tử bắt đầu đến phần tử kết thúc trong enum được chỉ định.

Lưu ý: Các phương thức trên trả về một EnumSet và có thể gây ra ngoại lệ NullPointerException hoặc
* IllegalArgumentException trong một số trường hợp.*/

import java.util.EnumSet;

//Minh họa một enum
enum season {
    SPRING(1), SUMMER(2), FALL(3), WINTER(4);
    private int value;

    season(int v) {this.value = v;}

    public int getValue(){
        return value;
    }
}
public class h_EnumSet {
    public static void main(String[] args) {
        System.out.println(season.SPRING+" "+season.SPRING.getValue());

        //1. `allOf(Class<E> elementType)`: Tạo một EnumSet chứa tất cả các phần tử của enum được chỉ định.
        EnumSet<season> enumSet = EnumSet.allOf(season.class);
        System.out.println(enumSet); //[SPRING, SUMMER, FALL, WINTER]


        //2. `complementOf(EnumSet<E> set)`: Tạo một EnumSet chứa các phần tử không có trong EnumSet được chỉ định.
        /*
            Ví dụ, giả sử chúng ta có một enum type là Color với các giá trị: RED, GREEN, BLUE.
            Chúng ta có một EnumSet được tạo với các giá trị GREEN và BLUE như sau:
                EnumSet<Color> set = EnumSet.of(Color.GREEN, Color.BLUE);

            Bây giờ, nếu chúng ta muốn tạo một EnumSet chứa các giá trị mà không có trong set ban đầu (trong trường hợp này là RED),
            chúng ta có thể sử dụng phương thức complementOf như sau:
                EnumSet<Color> complementSet = EnumSet.complementOf(set);
            Kết quả là complementSet sẽ chứa giá trị RED.
         */
        EnumSet<season> set = EnumSet.of(season.SPRING, season.SUMMER);
        //Tạo một enumset có tên là complementSet chứa các phần tử khác với set
        EnumSet<season> complementSet = EnumSet.complementOf(set);
        System.out.println(complementSet); //[FALL, WINTER]


        //3. `copyOf(EnumSet<E> set)`: Tạo một EnumSet bằng cách sao chép các phần tử từ EnumSet được chỉ định.
        //Thử thực hiện sao chép từ complementSet
        EnumSet<season> copied = EnumSet.copyOf(complementSet);
        System.out.println(copied);        //[FALL, WINTER]


        //4. `noneOf(Class<E> elementType)`: Tạo một EnumSet rỗng với kiểu enum được chỉ định.
        EnumSet<season> nonOfEnum = EnumSet.noneOf(season.class);
        System.out.println(nonOfEnum);     //[]



        //7. `range(E from, E to)`: Tạo một EnumSet chứa các phần tử từ phần tử bắt đầu đến phần tử kết thúc trong enum được chỉ định.
        EnumSet<season> rangeEnum = EnumSet.range(season.SPRING, season.WINTER);
        System.out.println(rangeEnum); //[SPRING, SUMMER, FALL, WINTER]

        EnumSet<season> rangeEnum1 = EnumSet.range(season.SPRING, season.FALL);
        System.out.println(rangeEnum1); //[SPRING, SUMMER, FALL]
    }
}
