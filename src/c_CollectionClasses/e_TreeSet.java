package c_CollectionClasses;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/*
* Lớp TreeSet
* Lớp TreeSet mở rộng lớp AbstractSet và triển khai giao diện NavigableSet. Nó tạo ra một tập hợp sử dụng ctdl Tree để lưu trữ.
* Đối tượng được lưu trữ theo thứ tự tăng dần. Thời gian truy cập và truy xuất khá nhanh, là lựa chọn tuyệt vời khi lưu trữ một
* lượng lớn thông tin đã được sắp xếp mà cần tìm kiếm nhanh chóng.
* TreeSet là một lớp dùng chung (generic class) có khai báo như sau:
*
*       class TreeSet<E>

* Ở đây, E chỉ định loại đối tượng mà tập hợp sẽ lưu trữ. TreeSet có các constructor sau:
* TreeSet()
* TreeSet(Collection<? extends E> c)
* TreeSet(Comparator<? super E> comp)
* TreeSet(SortedSet<E> ss)
*
* Form đầu tiên xây dựng một tập hợp TreeSet rỗng sẽ được sắp xếp theo thứ tự tăng dần dựa trên thứ tự tự nhiên của các phần tử.
* Form thứ hai xây dựng một tập hợp TreeSet chứa các phần tử của c. Form thứ ba xây dựng một tập hợp TreeSet rỗng sẽ được sắp xếp
* theo bộ so sánh được chỉ định bởi comp. (Các bộ so sánh sẽ được mô tả sau trong chương này.) Form thứ tư xây dựng một
* tập hợp TreeSet chứa các phần tử của ss.
* Dưới đây là một ví dụ minh họa về TreeSet:*/
public class e_TreeSet {
    public static void main(String[] args) {
        long startms = System.currentTimeMillis();
        var ts = new TreeSet<Integer>();
        for(int i = 0; i < 6000000; i++) {
            ts.add(i);
        }
        long endms = System.currentTimeMillis();

        long result = endms - startms;
        System.out.println(result +" ms"); //778 ms

        var ts2 = new TreeSet<Integer>();
        ts2.add(4);ts2.add(2);
        ts2.add(8);ts2.add(1);
        ts2.add(3);ts2.add(0);

        System.out.println("Nature order" + ts2); //Nature order[0, 1, 2, 3, 4, 8]



        Comparator<Integer> comp = Comparator.reverseOrder();
        var ts3 = new TreeSet<Integer>(comp);
        ts3.add(4);ts3.add(2);
        ts3.add(8);ts3.add(1);
        ts3.add(3);ts3.add(0);
        System.out.println("Reverse order" + ts3); //Reverse order[8, 4, 3, 2, 1, 0]

        /*
        * Như đã giải thích, vì TreeSet lưu trữ các phần tử trong một cây, chúng sẽ được tự động sắp xếp theo thứ tự đã
        * được sắp xếp, như đầu ra xác nhận.
        * Vì TreeSet triển khai giao diện NavigableSet, bạn có thể sử dụng các phương thức được định nghĩa bởi NavigableSet
        * để truy xuất các phần tử của TreeSet. Ví dụ, giả sử chương trình trước đó, câu lệnh sau sử dụng subSet() để lấy
        * một phần tử con của ts chứa các phần tử giữa C (bao gồm) và F (ngoại trừ).
        * Bạn có thể thử nghiệm các phương thức khác được định nghĩa bởi NavigableSet.*/

        System.out.println("Using subset: "+ts3.subSet(4, 2)); //[4, 3]
        //Tách từ phần tử có giá trị là 4 (bao gồm) đến phần tử có giá trị bằng 2 không bao gồm


    }
}
