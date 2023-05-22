package c_CollectionClasses;

import java.util.ArrayDeque;

/*
* Lớp ArrayDeque
* Lớp ArrayDeque mở rộng từ AbstractCollection và thực thi giao diện Deque. Nó không thêm các phương thức riêng của nó.
* ArrayDeque tạo ra một mảng động và không có hạn chế về dung lượng. (Giao diện Deque hỗ trợ các triển khai có hạn chế
* về dung lượng, nhưng không yêu cầu hạn chế đó.)
* ArrayDeque là một lớp generic có khai báo như sau:
* class ArrayDeque<E>
* Ở đây, E chỉ định kiểu đối tượng được lưu trữ trong tập hợp.
* ArrayDeque định nghĩa các constructor sau:
*       ArrayDeque()
*       ArrayDeque(int size)
*       ArrayDeque(Collection<? extends E> c)
* Constructor đầu tiên tạo ra một deque rỗng. Dung lượng khởi tạo ban đầu là 16. Constructor thứ hai tạo ra một deque
* có dung lượng khởi tạo cụ thể. Constructor thứ ba tạo ra một deque được khởi tạo với các phần tử của tập hợp được
* truyền vào trong c. Trong tất cả các trường hợp, dung lượng mở rộng khi cần để xử lý các phần tử được thêm vào deque.
Chương trình sau đây minh họa việc sử dụng ArrayDeque để tạo ra một ngăn xếp (stack):*/
public class g_ArrayDeque {
    public static void main(String[] args) {
        var adq = new ArrayDeque<String>();
        //Sử dụng ArrayDeque như một stack
        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");
        //[F, E, D, B, A]
        //Lưu ý Deque.push sẽ thêm các phần tử vào đầu deque
        System.out.println("Giống như stack LIFO");
        while(adq.peek() != null) { //peek: lấy ra phần tử cuối được đưa vào ArrayDeque (không xóa)
            System.out.print(adq.pop()+" "); //pop: lấy ra phần tử cuối được đưa vào ArrayDeque (xóa)
        }
        System.out.println("Size of ArrayDeque after pop: "+adq.size());


        var adq1 = new ArrayDeque<String>();
        //Sử dụng ArrayDeque như một stack
        adq1.add("A");
        adq1.add("B");
        adq1.add("D");
        adq1.add("E");
        adq1.add("F");
        System.out.println("Giống như Queue FIFO");
        while(adq1.peekFirst() != null) {
            System.out.print(adq1.pollFirst() +" ");
        }
        System.out.println("Size of ArrayDeque after pop: "+adq1.size());

    }
}
