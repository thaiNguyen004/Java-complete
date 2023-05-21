package c_CollectionClasses;

import java.util.LinkedList;

/*
* Lớp LinkedList
* Lớp LinkedList mở rộng lớp AbstractSequentialList và triển khai các giao diện List, Deque và Queue. Nó cung cấp
* một cấu trúc dữ liệu danh sách liên kết. LinkedList là một lớp dùng chung (generic class) có khai báo như sau:
*       class LinkedList<E>
Ở đây, E chỉ định loại đối tượng mà danh sách sẽ lưu trữ. LinkedList có hai constructor như sau:
*       LinkedList()
*       LinkedList(Collection<? extends E> c)
*
* Constructor đầu tiên xây dựng một danh sách liên kết rỗng. Constructor thứ hai xây dựng một danh sách liên kết được
* khởi tạo với các phần tử của collection c.
* Vì LinkedList triển khai giao diện Deque, bạn có thể truy cập các phương thức được định nghĩa bởi Deque.
* Ví dụ, để thêm phần tử vào đầu danh sách, bạn có thể sử dụng addFirst() hoặc offerFirst(). Để thêm phần tử vào cuối danh sách,
* sử dụng addLast() hoặc offerLast(). Để lấy phần tử đầu tiên, bạn có thể sử dụng getFirst() hoặc peekFirst().
* Để lấy phần tử cuối cùng, sử dụng getLast() hoặc peekLast(). Để xóa phần tử đầu tiên, sử dụng removeFirst() hoặc pollFirst().
* Để xóa phần tử cuối cùng, sử dụng removeLast() hoặc pollLast().
Chương trình sau minh họa việc sử dụng LinkedList.*/
public class b_LinkedListClass {
    public static void main(String[] args) {
        var ll = new LinkedList<String>();

        //add elements to the linked list
        //add bằng add
        ll.add("F");
        ll.addFirst("B");
        //add bằng offer

        ll.offer("G");
        ll.offerFirst("A");

        ll.addLast("W");
        ll.offerLast("Z");

        //add bằng index
        ll.add(1, "A2");

        System.out.println("Original contents of ll: " +ll);

        //remove
        ll.remove(1);
        ll.remove("F");

        System.out.println("Contents of ll after deletion: "
                +ll);

        //remove first and last elements
        ll.removeFirst();
        ll.removeLast();

        System.out.println("ll after deleting first and last: "
                +ll);

        //Get and Set a value
        String val = ll.get(1);

        ll.set(1, val+" changed");
        System.out.println("ll after change: "+ll);

        //Bởi vì LinkedList triển khai giao diện List, việc gọi add(E) sẽ thêm các mục vào cuối danh sách, giống như việc gọi addLast().
    }
}
