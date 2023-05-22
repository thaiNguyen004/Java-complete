package c_CollectionClasses;

import java.util.HashSet;
import java.util.LinkedHashSet;

/*
* Lớp LinkedHashSet
* Lớp LinkedHashSet mở rộng lớp HashSet và không thêm bất kỳ thành viên riêng nào. Nó là một lớp dùng chung (generic class)
* có khai báo như sau:
*       class LinkedHashSet<E>
* Ở đây, E chỉ định loại đối tượng mà tập hợp sẽ lưu trữ. Các constructor của nó tương tự như trong HashSet.
* LinkedHashSet duy trì một danh sách liên kết các mục trong tập hợp, theo thứ tự chúng được chèn.
* Điều này cho phép lặp theo thứ tự chèn qua tập hợp. Nghĩa là, khi duyệt qua một LinkedHashSet bằng một trình lặp,
* các phần tử sẽ được trả về theo thứ tự chúng được chèn. Đây cũng là thứ tự trong đó chúng được chứa trong chuỗi được
* trả về bởi phương thức toString() khi gọi trên một đối tượng LinkedHashSet
* */
public class d_LinkedHashSet {
    public static void main(String[] args) {
        //Vì LinkedHashSet không định nghĩa bất kỳ phương thức bổ sung nào
        //Nên thử test hiệu năng để có cái nhìn thực tế hơn
        long startms = System.currentTimeMillis();
        //Sử dụng LinkedHashSet để add
        var lhs = new LinkedHashSet<Integer>();
        for(int i = 0; i < 6000000; i++) {
            lhs.add(i);
        }

        long endms = System.currentTimeMillis();
        long resultTime = endms - startms;
        System.out.println(resultTime +" ms"); //670 ms
    }
}
