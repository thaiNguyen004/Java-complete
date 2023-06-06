package a_Introduce;
/*
* Các tiện ích đồng thời được chứa trong gói java.util.concurrent và hai gói con của nó:
* java.util.concurrent.atomic và java.util.concurrent.locks.
* Bắt đầu từ JDK 9, tất cả đều thuộc module java.base. Dưới đây là một cái nhìn tổng quan về nội dung của chúng.
*
* java.util.concurrent xác định các tính năng cốt lõi hỗ trợ các phương pháp thay thế cho các phương pháp tích hợp
* sẵn để đồng bộ hóa và giao tiếp giữa các luồng. Các tính năng này bao gồm:
• Các bộ đồng bộ hóa (Synchronizers)
• Executors
• Các bộ sưu tập đồng thời (Concurrent collections)
• Fork/Join Framework
*
* Các bộ đồng bộ hóa (Synchronizers) cung cấp cách đồng bộ hóa cao cấp để tương tác giữa nhiều luồng.
* Các lớp bộ đồng bộ hóa được định nghĩa bởi java.util.concurrent là
*
* Dưới đây là mô tả của các lớp Semaphore, CountDownLatch, CyclicBarrier, Exchanger và Phaser trong gói java.util.concurrent:
*
* 1. Semaphore:
* Lớp Semaphore cung cấp cơ chế đồng bộ hóa để giới hạn số lượng luồng được phép truy cập vào một phần tài nguyên
* hoặc một vùng truy cập cùng một lúc. Nó duy trì một bộ đếm và hỗ trợ hai phương thức chính là acquire()
* để yêu cầu tài nguyên và release() để giải phóng tài nguyên.
*
* 2. CountDownLatch: Lớp CountDownLatch cho phép một hoặc nhiều luồng chờ đợi cho đến khi một số sự kiện đã xảy ra.
* Nó duy trì một bộ đếm ngược từ một giá trị cụ thể và các luồng khác có thể chờ đợi cho đến khi bộ đếm đạt đến 0
* bằng cách gọi phương thức await().
*
* 3. CyclicBarrier: Lớp CyclicBarrier cho phép một nhóm luồng chờ đợi lẫn nhau để đạt tới một điểm hẹn nhất định
* trước khi tiếp tục thực hiện. Nó duy trì một bộ đếm và các luồng sẽ gọi phương thức await() để chờ đến khi tất cả
* các luồng đã đến điểm hẹn, sau đó cùng nhau tiếp tục thực hiện.
*
* 4. Exchanger: Lớp Exchanger cung cấp một điểm giao tiếp giữa hai luồng để trao đổi dữ liệu. Hai luồng có thể gửi
* dữ liệu cho nhau thông qua phương thức exchange(), và nó sẽ đợi cho đến khi cả hai luồng đã gửi xong trước
* khi trao đổi dữ liệu.
*
* 5. Phaser: Lớp Phaser cho phép đồng bộ hóa và điều phối giữa các luồng trong một giai đoạn (phase)
* hoặc một tập hợp các giai đoạn. Nó cung cấp các điểm đồng bộ hóa cho các luồng chờ đợi và các luồng sẽ tiếp tục
* thực hiện khi tất cả các luồng khác đạt đến điểm đồng bộ đó.
*
* Hãy để ý rằng mỗi bộ đồng bộ hóa cung cấp một giải pháp cho một loại vấn đề đồng bộ hóa cụ thể. Điều này cho phép
* mỗi bộ đồng bộ hóa được tối ưu hóa cho việc sử dụng dự định của nó. Trước đây, các đối tượng đồng bộ hóa này phải
* được tạo thủ công. Tuy nhiên, concurrent API đã tiêu chuẩn hóa chúng và đưa chúng vào sử dụng cho tất cả các
* lập trình viên Java.
*
* Executors quản lý việc thực thi luồng. Ở đỉnh của hierachy executor là giao diện Executor, được sử dụng để khởi tạo
* một luồng. ExecutorService mở rộng Executor và cung cấp các phương thức quản lý thực thi. Có ba lớp triển khai của
* ExecutorService: ThreadPoolExecutor, ScheduledThreadPoolExecutor và ForkJoinPool. java.util.concurrent cũng
* định nghĩa lớp tiện ích Executors, bao gồm một số phương thức tĩnh đơn giản hóa việc tạo ra các executors khác nhau.
*
* Có liên quan đến executors là giao diện Future và Callable. Một Future chứa một giá trị được trả về bởi một luồng
* sau khi nó thực thi. Do đó, giá trị của nó trở nên được xác định "trong tương lai", khi luồng kết thúc.
* Callable định nghĩa một luồng trả về một giá trị.
*
* java.util.concurrent định nghĩa một số lớp bộ sưu tập đồng thời, bao gồm ConcurrentHashMap, ConcurrentLinkedQueue
* và CopyOnWriteArrayList. Chúng cung cấp các phương thức đồng thời thay thế cho các lớp liên quan được định nghĩa
* bởi Collections Framework.
*
* Fork/Join Framework hỗ trợ lập trình song song. Các lớp chính của nó là ForkJoinTask, ForkJoinPool, RecursiveTask
* và RecursiveAction.
*
* Để xử lý thời gian của luồng một cách tốt hơn, java.util.concurrent định nghĩa liệt kê TimeUnit.
*
* Bắt đầu từ JDK 9, java.util.concurrent cũng bao gồm một hệ thống con cung cấp một phương tiện để kiểm soát luồng dữ liệu.
* Nó dựa trên lớp Flow và các giao diện lồng nhau sau đây: Flow.Subscriber, Flow.Publisher, Flow.Processor
* và Flow.Subscription. Mặc dù một cuộc thảo luận chi tiết về hệ thống con Flow nằm ngoài phạm vi của chương này,
* dưới đây là một mô tả ngắn.
*
* Lớp Flow và các giao diện lồng nhau của nó hỗ trợ quy định luồng phản ứng. Quy định này xác định phương tiện mà
* người tiêu dùng dữ liệu có thể ngăn chặn người sản xuất dữ liệu vượt qua khả năng xử lý dữ liệu của người tiêu dùng.
* Theo cách tiếp cận này, dữ liệu được sản xuất bởi một nhà cung cấp và được tiêu thụ bởi một người đăng ký.
* Kiểm soát được đạt được bằng cách thực hiện một hình thức áp suất trở lại (back pressure).
*
* Gói java.util.concurrent.atomic hỗ trợ việc sử dụng biến trong môi trường đồng thời. Nó cung cấp phương tiện để
* cập nhật giá trị của biến một cách hiệu quả mà không cần sử dụng khóa (locks). Điều này được thực hiện thông qua
* việc sử dụng các lớp như AtomicInteger và AtomicLong,
* cùng với các phương thức như compareAndSet(), decrementAndGet() và getAndSet().
* Những phương thức này được thực hiện như một thao tác duy nhất không thể bị gián đoạn.
*
* java.util.concurrent.locks: Gói java.util.concurrent.locks cung cấp một giải pháp thay thế việc sử dụng các
* phương thức synchronized. Điểm trọng yếu của giải pháp này là giao diện Lock, xác định cơ chế cơ bản được
* sử dụng để thu được và nhả quyền truy cập vào một đối tượng.
* Các phương thức quan trọng là lock(), tryLock() và unlock(). Ưu điểm của việc sử dụng những phương thức
* này là có sự kiểm soát tốt hơn về đồng bộ hóa.
*
* Phần còn lại của chương này sẽ xem xét chi tiết các thành phần của concurrent API.
*
* */
public class b_ConcurrentAPIPackage {
}
