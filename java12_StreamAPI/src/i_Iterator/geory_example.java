package i_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

/*
* Iterator và Stream
* Mặc dù luồng dữ liệu không phải là một đối tượng lưu trữ dữ liệu, bạn vẫn có thể sử dụng một bộ lặp để duyệt qua
* các phần tử của nó một cách tương tự như bạn sử dụng một bộ lặp để duyệt qua các phần tử của một bộ sưu tập.
* API luồng hỗ trợ hai loại bộ lặp. Loại đầu tiên là bộ lặp truyền thống Iterator. Loại thứ hai là Spliterator,
* được thêm vào từ JDK 8. Nó cung cấp những lợi ích đáng kể trong một số tình huống khi sử dụng với luồng song song.
*
* Sử dụng một bộ lặp với một luồng
* Như vừa được đề cập, bạn có thể sử dụng một bộ lặp với một luồng một cách tương tự như bạn làm với một bộ sưu tập.
* Bộ lặp được thảo luận trong Chương 19, nhưng một đánh giá ngắn sẽ hữu ích ở đây. Bộ lặp là các đối tượng thực hiện
* giao diện Iterator được khai báo trong java.util. Hai phương thức quan trọng của nó là hasNext() và next().
* Nếu có một phần tử khác để lặp qua, hasNext() trả về true, và ngược lại là false.
* Phương thức next() trả về phần tử tiếp theo trong vòng lặp.
*
* LƯU Ý: Có các loại bộ lặp bổ sung khác xử lý luồng nguyên thủy: PrimitiveIterator,
* PrimitiveIterator.OfDouble, PrimitiveIterator.OfLong và PrimitiveIterator.OfInt.
* Những bộ lặp này đều mở rộng giao diện Iterator và hoạt động theo cách chung tương tự như những bộ lặp
* dựa trực tiếp trên Iterator.
*
* Để có một bộ lặp cho một luồng, gọi phương thức iterator() trên luồng. Phiên bản được sử dụng bởi Stream
* được hiển thị ở đây.
* Iterator<T> iterator()
* Ở đây, T chỉ định kiểu phần tử. (Các luồng nguyên thủy trả về bộ lặp của kiểu nguyên thủy tương ứng.)
*
* Chương trình sau cho thấy cách duyệt qua các phần tử của một luồng. Trong trường hợp này, các chuỗi trong một
* ArrayList được duyệt qua, nhưng quy trình tương tự cũng áp dụng cho bất kỳ loại luồng nào.
* */
public class geory_example {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Phi");
        myList.add("Omega");

        // Tạo ra một stream từ array list
        Stream<String> myStream = myList.stream();

        // Tạo ra một iterator từ stream
        Iterator<String> itr = myStream.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
