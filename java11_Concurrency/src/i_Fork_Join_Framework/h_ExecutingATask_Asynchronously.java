package i_Fork_Join_Framework;
/*
* Thực thi một tác vụ không đồng bộ (Executing a task asychronously)
* Các chương trình trước đã gọi invoke() trên một ForkJoinPool để khởi chạy một tác vụ.
* Phương pháp này thường được sử dụng khi luồng gọi phải đợi cho đến khi tác vụ hoàn thành
* (thường là trường hợp này) vì invoke() sẽ không trả về cho đến khi tác vụ kết thúc.
* Tuy nhiên, bạn cũng có thể khởi chạy một tác vụ không đồng bộ.
*
* Trong phương pháp này, luồng gọi tiếp tục thực thi. Do đó, cả luồng gọi và tác vụ được thực hiện đồng thời.
* Để khởi chạy một tác vụ không đồng bộ, sử dụng execute(), cũng được định nghĩa bởi ForkJoinPool.
* Nó có hai dạng như sau:
*
* void execute(ForkJoinTask<?> task)
* void execute(Runnable task)
*
* Trong cả hai dạng, task chỉ định tác vụ cần chạy.
* Lưu ý rằng dạng thứ hai cho phép bạn chỉ định một Runnable thay vì một tác vụ ForkJoinTask.
* Do đó, nó tạo thành một cầu nối giữa phương pháp truyền thống của Java về đa luồng và Framework Fork/Join.
* Quan trọng để nhớ rằng các luồng được sử dụng bởi ForkJoinPool là luồng daemon. Do đó, chúng sẽ kết thúc
* khi luồng chính kết thúc. Kết quả là, bạn có thể cần giữ cho luồng chính sống cho đến khi các tác vụ đã hoàn thành.
*
* */
public class h_ExecutingATask_Asynchronously {
}
