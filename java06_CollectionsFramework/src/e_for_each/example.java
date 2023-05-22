package e_for_each;

import java.util.ArrayList;

/*
* Tùy chọn For-Each thay thế cho Iterators
* Nếu bạn không sẽ sửa đổi nội dung của một tập hợp hoặc lấy các phần tử theo thứ tự ngược, thì phiên bản for-each
* của vòng lặp for thường là một lựa chọn thuận tiện hơn để duyệt qua một tập hợp so với việc sử dụng một iterator.
* Hãy nhớ rằng vòng lặp for có thể duyệt qua bất kỳ tập hợp nào của các đối tượng thực hiện giao diện Iterable.
* Vì tất cả các lớp tập hợp đều thực hiện giao diện này, chúng có thể được thao tác bằng for.
* Ví dụ sau sử dụng một vòng lặp for để tính tổng các phần tử trong một tập hợp:*/
public class example {
    public static void main(String[] args) {
        var al = new ArrayList<Integer>();
        al.add(1);al.add(2);
        al.add(3);al.add(4);
        al.add(5);al.add(6);

        //Hiển thị các phần tử trong al
        System.out.print("Content of al: ");
        for(int x : al) {
            System.out.print(x+" ");
        }
        System.out.println();


        //Tính tổng các phần tử trong al
        int sum = 0;
        for(int v : al) {
            sum += v;
        }
        System.out.println("Sum = " +sum);

        /*
        * Như bạn có thể thấy, vòng lặp for có độ dài và cách sử dụng đáng kể ngắn gọn hơn so với phương pháp dựa trên iterator.
        * Tuy nhiên, nó chỉ có thể được sử dụng để duyệt qua một tập hợp theo hướng chuyển tiếp và bạn không thể sửa đổi
        * nội dung của tập hợp.*/

    }
}
