package c_UsingExecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* Sử dụng Executor
* API đồng thời cung cấp một tính năng gọi là executor (thực thi viên) để khởi tạo và điều khiển việc thực thi các luồng.
* Do đó, executor cung cấp một phương án thay thế để quản lý luồng mà không cần sử dụng lớp Thread.
*
* Ở trung tâm của một executor là giao diện Executor. Nó định nghĩa phương thức sau:
* void execute(Runnable thread)
* Luồng được chỉ định bởi thread được thực thi. Do đó, phương thức execute() khởi động luồng đã chỉ định.
*
* Giao diện ExecutorService mở rộng Executor bằng cách thêm các phương thức giúp quản lý và điều khiển việc thực thi các luồng.
* Ví dụ, ExecutorService định nghĩa phương thức shutdown(), được hiển thị ở đây, để dừng ExecutorService đang gọi.
* void shutdown()
* ExecutorService cũng định nghĩa các phương thức thực thi các luồng trả về kết quả, thực thi một tập hợp các luồng và
* xác định trạng thái dừng. Chúng ta sẽ xem xét một số trong số các phương thức này sau.
*
* Cũng được định nghĩa là giao diện ScheduledExecutorService, mở rộng ExecutorService để hỗ trợ lập lịch cho các luồng.
*
* API đồng thời định nghĩa ba lớp executor đã được xác định trước:
* ThreadPoolExecutor và ScheduledThreadPoolExecutor, và
* ForkJoinPool. ThreadPoolExecutor thực thi các giao diện Executor và ExecutorService và cung cấp hỗ trợ cho một bể quản
* lý luồng. ScheduledThreadPoolExecutor cũng thực thi giao diện ScheduledExecutorService để cho phép lập lịch một bể luồng.
* ForkJoinPool thực thi các giao diện Executor và ExecutorService và được sử dụng bởi Frameword Fork/Join.
* Nó được mô tả sau trong chương này.
*
* Một bể luồng (thread pool) cung cấp một tập hợp các luồng được sử dụng để thực thi các nhiệm vụ khác nhau.
* Thay vì mỗi nhiệm vụ sử dụng một luồng riêng biệt, các luồng trong bể được sử dụng.
* Thay vì tạo một luồng mới cho mỗi nhiệm vụ cần thực hiện, một bể luồng cung cấp một tập hợp các luồng có sẵn để thực thi
* các nhiệm vụ. Khi có một nhiệm vụ mới, nó sẽ được gửi đến bể luồng và được thực thi bởi một trong các luồng trong bể.
* Ý nghĩa của việc này là ta có thể sử dụng lại các luồng đã tồn tại trong bể thay vì tạo mới một luồng mới cho mỗi nhiệm vụ.
* Điều này giúp giảm tải công việc liên quan đến việc tạo và huỷ bỏ các luồng, cũng như tăng hiệu suất và tối ưu hóa việc
* sử dụng tài nguyên hệ thống.
*
* Bằng cách sử dụng một bể luồng, chúng ta có thể quản lý và điều phối việc thực thi nhiều nhiệm vụ cùng một lúc mà không phải
* lo lắng về việc quản lý các luồng riêng biệt. Bể luồng sẽ tự động phân phối các nhiệm vụ cho các luồng khả dụng và xử lý
* chúng theo thứ tự hoặc ưu tiên đã định trước.
*
* Tóm lại, việc sử dụng một bể luồng giúp tận dụng tối đa tài nguyên luồng có sẵn, giảm tải hệ thống và tăng hiệu suất của
* ứng dụng có nhiều nhiệm vụ cần thực hiện cùng một lúc.
* Điều này giảm thiểu tải phụ liên quan đến việc tạo ra nhiều luồng riêng biệt.
* Mặc dù bạn có thể sử dụng ThreadPoolExecutor và ScheduledThreadPoolExecutor trực tiếp, nhưng thường thì bạn sẽ muốn
* lấy một executor bằng cách gọi một trong các phương thức tạo ở lớp tiện ích Executors. Dưới đây là một số ví dụ:
* static ExecutorService newCachedThreadPool()
* static ExecutorService newFixedThreadPool(int numThreads)
* static ScheduledExecutorService newScheduledThreadPool(int numThreads)
*
* newCachedThreadPool() tạo ra một bể luồng mà thêm luồng khi cần và sử dụng lại các luồng nếu có thể.
* newFixedThreadPool() tạo ra một bể luồng gồm một số luồng được chỉ định.
* newScheduledThreadPool() tạo ra một bể luồng hỗ trợ lập lịch cho luồng. Mỗi phương thức trên đều trả về một tham chiếu
* tới ExecutorService có thể được sử dụng để quản lý bể luồng.
*
* Một ví dụ đơn giản về Executor
* Trước khi tiếp tục, một ví dụ đơn giản sử dụng executor sẽ giúp ích được.
* Chương trình sau tạo ra một bể luồng cố định chứa hai luồng. Sau đó, nó sử dụng bể luồng đó để thực thi bốn nhiệm vụ.
* Sau khi các nhiệm vụ hoàn thành, bể luồng được dừng và chương trình kết thúc.
* */
public class a_GeoryAndExample {
    public static void main(String[] args) {
        CountDownLatch cdl1 = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("Starting");
        //Start the threads
        es.execute(new MyThread(cdl1, "A"));
        es.execute(new MyThread(cdl2, "B"));
        es.execute(new MyThread(cdl3, "C"));
        es.execute(new MyThread(cdl4, "D"));

        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        es.shutdown();
        System.out.println("Done");
    }

}

class MyThread implements  Runnable {
    String name;
    CountDownLatch latch;

    MyThread (CountDownLatch c, String n) {
        latch = c;
        name = n;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
/*
* Như đầu ra cho thấy, mặc dù bể luồng chỉ chứa hai luồng, tất cả bốn nhiệm vụ vẫn được thực thi.
* Tuy nhiên, chỉ có hai nhiệm vụ có thể chạy cùng một lúc. Các nhiệm vụ khác phải chờ đợi cho đến
* khi một trong các luồng trong bể luồng sẵn sàng sử dụng.
*
* Cuộc gọi đến shutdown( ) là quan trọng. Nếu không có nó trong chương trình, chương trình sẽ không kết thúc
* vì bể luồng vẫn hoạt động. Để kiểm tra điều này, bạn chỉ cần chú thích lại cuộc gọi đến shutdown( ) và quan sát kết quả.
* */