package c_CollectionClasses;

import java.util.HashSet;

/*
 * HashSet mở rộng lớp AbstractSet và triển khai giao diện Set. Nó tạo ra một tập hợp sử dụng bảng băm để lưu trữ dữ liệu.
 * HashSet là một lớp dùng chung (generic class) có khai báo như sau:
 *      class HashSet<E>
 * Ở đây, E chỉ định loại đối tượng mà tập hợp sẽ lưu trữ.
 * Như hầu hết các độc giả có thể biết, bảng băm lưu trữ thông tin bằng cách sử dụng một cơ chế gọi là băm.
 * Trong băm, nội dung thông tin của một khóa được sử dụng để xác định một giá trị duy nhất, gọi là mã băm của nó.
 * Mã băm sau đó được sử dụng như một chỉ mục mà dữ liệu liên quan đến khóa được lưu trữ. Quá trình chuyển đổi khóa thành mã băm
 * được thực hiện tự động - bạn không bao giờ thấy mã băm chính nó. Hơn nữa, mã của bạn không thể trực tiếp chỉ mục vào bảng băm.
 * Lợi ích của băm là nó cho phép thời gian thực thi của các phương thức add(), contains(), remove() và size() duy trì không đổi
 * ngay cả đối với các tập hợp lớn.
 *
 * Dưới đây là các constructor được định nghĩa:
 * HashSet()
 * HashSet(Collection<? extends E> c)
 * HashSet(int capacity)
 * HashSet(int capacity, float fillRatio)
 *
 * • Form đầu tiên xây dựng một hash set mặc định.
 * • Form thứ hai khởi tạo hash set bằng cách sử dụng các phần tử của c.
 * • Form thứ ba khởi tạo khả năng của hash set thành capacity. (Khả năng mặc định là 16.)
 * • Form thứ tư khởi tạo cả khả năng và tỷ lệ điền (gọi là hệ số tải) của hash set từ các đối số của nó.
 * Tỷ lệ điền phải nằm trong khoảng từ 0.0 đến 1.0 và nó xác định mức độ đầy của hash set trước khi nó được thay đổi kích thước lên trên.
 * Cụ thể, khi số lượng phần tử lớn hơn khả năng của hash set nhân với tỷ lệ điền của nó, hash set sẽ được mở rộng.
 * Đối với các constructor không lấy tỷ lệ điền, 0.75 được sử dụng.
 * HashSet không định nghĩa bất kỳ phương thức bổ sung nào ngoài các phương thức được cung cấp bởi các lớp cha và các giao diện của nó*/
public class c_HashSetClass {
    public static void main(String[] args) {
        //Vì HashSet không định nghĩa bất kỳ phương thức bổ sung nào
        //Nên thử test hiệu năng để có cái nhìn thực tế hơn
        long startms = System.currentTimeMillis();
        //Sử dụng HashSet để add
        var hs = new HashSet<Integer>();
        for(int i = 0; i < 6000000; i++) {
            hs.add(i);
        }

        long endms = System.currentTimeMillis();
        long resultTime = endms - startms;
        System.out.println(resultTime +" ms"); //514 ms
    }
}
