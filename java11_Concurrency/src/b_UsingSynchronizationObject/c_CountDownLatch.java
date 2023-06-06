package b_UsingSynchronizationObject;
/*
* CountDownLatch
* Đôi khi bạn muốn một luồng đợi cho đến khi một hoặc nhiều sự kiện xảy ra. Để xử lý tình huống như vậy,
* Concurrent API cung cấp CountDownLatch. Một CountDownLatch được tạo ban đầu với một count số lượng sự kiện
* phải xảy ra trước khi latch được mở. Mỗi khi một sự kiện xảy ra, count sẽ được giảm. Khi count đạt đến số không,
* latch sẽ mở ra.
*
* CountDownLatch có constructor như sau:
* CountDownLatch(int num)
* Ở đây, num chỉ định số lượng sự kiện phải xảy ra để latch mở.
*
* Để đợi trên latch, một luồng gọi await(), có các dạng như sau:
* void await() throws InterruptedException
* boolean await(long wait, TimeUnit tu) throws InterruptedException
* Dạng đầu tiên đợi cho đến khi count liên quan đến CountDownLatch gọi đến số không.
* Dạng thứ hai chỉ đợi trong khoảng thời gian được chỉ định bởi wait. Đơn vị thời gian được biểu diễn
* bởi wait được chỉ định bởi tu, là một đối tượng của định danh TimeUnit.
* (TimeUnit sẽ được mô tả sau trong chương này.)
* Phương thức trả về false nếu đạt đến giới hạn thời gian và true nếu đếm đến số không.
*
* Để tín hiệu cho một sự kiện, gọi phương thức countDown() như sau:
* void countDown()
* Mỗi lần gọi countDown() giảm giá trị count liên quan đến đối tượng gọi.
*
* Chương trình sau đây minh họa CountDownLatch. Nó tạo một latch yêu cầu có năm sự kiện xảy ra
* trước khi nó mở ra.
*
* */

import java.util.concurrent.CountDownLatch;

class MyThread implements Runnable {
    CountDownLatch latch;
    MyThread (CountDownLatch c) {
        latch = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown(); //decrement count
        }
    }
}
public class c_CountDownLatch {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        System.out.println("Starting");

        new Thread(new MyThread(cdl), "Ví dụ CountDownLatch").start();

        try {
            System.out.println("halo");
            cdl.await();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Done");
    }
}
