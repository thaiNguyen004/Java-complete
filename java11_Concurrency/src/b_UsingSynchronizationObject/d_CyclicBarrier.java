package b_UsingSynchronizationObject;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
* CyclicBarrier
* Một tình huống không hiếm trong lập trình đồng thời xảy ra khi một tập hợp hai hoặc nhiều luồng
* phải đợi tại một điểm thực thi đã xác định cho đến khi tất cả các luồng trong tập hợp đạt đến điểm đó.
* Để xử lý tình huống như vậy, concurrent API cung cấp lớp CyclicBarrier. Nó cho phép bạn xác định
* một đối tượng đồng bộ mà tạm dừng cho đến khi số lượng luồng đã đạt đến điểm ngăn cản đã chỉ định.
*
* CyclicBarrier có hai constructor như sau:
* CyclicBarrier(int numThreads)
* CyclicBarrier(int numThreads, Runnable action)
*
* Ở đây, numThreads chỉ định số lượng luồng phải đạt đến điểm ngăn cản trước khi thực thi tiếp tục.
* Trong dạng thứ hai, action chỉ định một luồng sẽ được thực thi khi điểm ngăn cản được đạt đến.
*
* Dưới đây là quy trình chung để sử dụng CyclicBarrier.
* Trước tiên, tạo một đối tượng CyclicBarrier, chỉ định số lượng luồng mà bạn sẽ đợi.
* Tiếp theo, khi mỗi luồng đạt đến điểm ngăn cản, hãy cho nó gọi await() trên đối tượng đó.
* Điều này sẽ tạm dừng thực thi của luồng cho đến khi tất cả các luồng khác cũng gọi await().
* Khi số lượng luồng đã đạt đến điểm ngăn cản được chỉ định, await() sẽ trả về và thực thi sẽ tiếp tục.
* Ngoài ra, nếu bạn đã chỉ định một action, thì luồng đó sẽ được thực thi.
*
* Phương thức await() có hai dạng như sau:
* int await() throws InterruptedException, BrokenBarrierException
* int await(long wait, TimeUnit tu) throws InterruptedException, BrokenBarrierException, TimeoutException
*
* Dạng thứ nhất chờ đến khi tất cả các luồng đạt đến điểm ngăn cản.
* Dạng thứ hai chờ chỉ trong khoảng thời gian được chỉ định bởi wait. Đơn vị thời gian được đại diện bởi
* wait được chỉ định bởi tu. Cả hai dạng trả về một giá trị chỉ thị thứ tự các luồng đến điểm ngăn cản.
* Luồng đầu tiên trả về một giá trị bằng số lượng luồng đã đợi trừ đi một. Luồng cuối cùng trả về giá trị 0.
*
* Dưới đây là một ví dụ minh họa về CyclicBarrier. Nó đợi cho đến khi một tập hợp ba luồng đã đạt
* đến điểm ngăn cản. Khi điều đó xảy ra, luồng được chỉ định bởi BarAction được thực thi.
*
* */


//Luồng thực thi sử dụng CyclicBarrier
class MyThread1 implements Runnable {
    CyclicBarrier cb;
    String name;

    MyThread1 (CyclicBarrier cb, String n) {
        this.cb = cb;
        this.name = n;
    }
    @Override
    public void run() {
        System.out.println(name);
        try {
            cb.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        catch (BrokenBarrierException e) {
            System.out.println(e);
        }
    }
}

//Đối tượng của lớp này sẽ được gọi khi CyclicBarrier kết thúc
class BarrierAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Đạt đến Barrier (rào cản)");
    }
}

public class d_CyclicBarrier {
    public static void main(String[] args) {
        //Chỉ định 3 luồng phải đạt đến điểm ngăn cản nhất định
        //thì luồng BarrierAction sẽ được thực thi
        CyclicBarrier cb = new CyclicBarrier(3, new BarrierAction());

//        new Thread(new MyThread1(cb, "A")).start();
//        new Thread(new MyThread1(cb, "B")).start();
//        new Thread(new MyThread1(cb, "C")).start();
        /*
        * Một CyclicBarrier có thể được sử dụng lại vì nó sẽ phát hành các luồng đang chờ mỗi khi
        * số lượng luồng được chỉ định gọi phương thức await(). Ví dụ, nếu bạn thay đổi phần main()
        * trong chương trình trước đó như sau:*/

        new Thread(new MyThread1(cb, "A")).start();
        new Thread(new MyThread1(cb, "B")).start();
        new Thread(new MyThread1(cb, "C")).start();
        new Thread(new MyThread1(cb, "D")).start();
        new Thread(new MyThread1(cb, "E")).start();

    }
}
