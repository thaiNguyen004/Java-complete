package d_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
* Sử dụng một Iterator
* Trước khi bạn có thể truy cập vào một collection thông qua một iterator, bạn phải có một iterator đó.
* Mỗi lớp collection cung cấp một phương thức iterator() trả về một iterator đến đầu của collection. Bằng cách sử dụng
* đối tượng iterator này, bạn có thể truy cập vào từng phần tử trong collection, một phần tử mỗi lần.
* Như một nguyên tắc chung, để sử dụng một iterator để duyệt qua nội dung của một collection, hãy làm theo các bước sau:
*       1. Lấy một iterator đến đầu của tập hợp bằng cách gọi phương thức iterator() của tập hợp.
*       2. Thiết lập một vòng lặp mà gọi hasNext(). Cho phép vòng lặp lặp lại miễn là hasNext() trả về true.
*       3. Trong vòng lặp, lấy từng phần tử bằng cách gọi next().
* Đối với các tập hợp thực hiện giao diện List, bạn cũng có thể lấy một iterator bằng cách gọi listIterator().
* Như đã giải thích, một list iterator cho phép bạn truy cập vào tập hợp theo hướng chuyển tiếp hoặc ngược lại và cho
* phép bạn thay đổi một phần tử. Nếu không, ListIterator được sử dụng tương tự như Iterator.
* Ví dụ sau thực hiện các bước này, cho thấy cả giao diện Iterator và ListIterator. Nó sử dụng một đối tượng ArrayList,
* nhưng các nguyên tắc chung cũng áp dụng cho bất kỳ loại tập hợp nào. Tất nhiên, ListIterator chỉ khả dụng cho những
* tập hợp thực hiện giao diện List.*/
public class example {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("C"); al.add("B");
        al.add("A"); al.add("F");
        al.add("A"); al.add("E");

        //Sử dụng Iterator để hiển thị nội dung của ArrayList
        System.out.print("Content of al: ");
        Iterator<String> itr = al.iterator();
        while(itr.hasNext()) {
            String element = itr.next();
            System.out.print(element+" ");
        }
        System.out.println();

        //Sửa các đối tượng đang được lặp đi lặp lại
        ListIterator<String> litr = al.listIterator();
        while(litr.hasNext()) {
            String element = litr.next();
            litr.set(element +"+");
        }

        System.out.print("Nội dung của al sau khi sửa đổi: ");
        itr = al.iterator();
        while(itr.hasNext()) {
            String element = itr.next();
            System.out.print(element+" ");
        }
        System.out.println();


        //Hiển thị danh sách ngược chỉ có ở ListIterator
        System.out.print("List backwards: ");
        while(litr.hasPrevious()) {
            String element = litr.previous();
            System.out.print(element+" ");
        }

    }
}
