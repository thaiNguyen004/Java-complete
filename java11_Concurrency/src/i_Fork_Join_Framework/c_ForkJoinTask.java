package i_Fork_Join_Framework;
/*
* ForkJoinTask<V>
ForkJoinTask<V> là một lớp trừu tượng định nghĩa một nhiệm vụ có thể được quản lý bởi một ForkJoinPool.
* Tham số kiểu V xác định kiểu kết quả của nhiệm vụ. ForkJoinTask khác với Thread ở chỗ nó đại diện cho một
* nhiệm vụ nhẹ hơn là một luồng thực thi.
*
* Các ForkJoinTask được thực thi bởi các luồng được quản lý bởi một thread pool của loại ForkJoinPool.
* Cơ chế này cho phép quản lý một số lượng lớn các nhiệm vụ bằng một số lượng nhỏ các luồng thực sự.
* Do đó, ForkJoinTask rất hiệu quả so với luồng.
*
* ForkJoinTask định nghĩa nhiều phương thức. Ở trung tâm là phương thức fork() và join(), được hiển thị như sau:
* final ForkJoinTask<V> fork()
* final V join()
*
* Phương thức fork() gửi nhiệm vụ gọi đến để thực thi không đồng bộ. Điều này có nghĩa là luồng gọi fork()
* tiếp tục chạy. Phương thức fork() trả về this sau khi nhiệm vụ được lên lịch thực thi.
* Trước JDK 8, fork() chỉ có thể được thực thi từ bên trong phần tính toán của một ForkJoinTask khác,
* đang chạy trong một ForkJoinPool. (Bạn sẽ thấy cách tạo phần tính toán của một nhiệm vụ trong thời gian tới.)
*
* Tuy nhiên, với sự xuất hiện của JDK 8, nếu fork() không được gọi khi thực thi trong một ForkJoinPool,
* thì một common pool sẽ được sử dụng tự động.
* Phương thức join() đợi cho đến khi nhiệm vụ trên đó được gọi kết thúc. Kết quả của nhiệm vụ được trả về.
* Nhờ sử dụng fork() và join(), bạn có thể bắt đầu một hoặc nhiều nhiệm vụ mới và sau đó đợi chúng kết thúc.
* Một phương thức quan trọng khác của ForkJoinTask là invoke(). Nó kết hợp các thao tác fork và join thành một
* cuộc gọi duy nhất vì nó bắt đầu một nhiệm vụ và sau đó đợi cho đến khi nó kết thúc. Được hiển thị như sau:
*
* final V invoke()
*
* Kết quả của nhiệm vụ gọi đang được trả về.
* Bạn có thể gọi nhiều nhiệm vụ cùng một lúc bằng cách sử dụng invokeAll(). Hai dạng của nó được hiển thị như sau:
* static void invokeAll(ForkJoinTask<?> taskA, ForkJoinTask<?> taskB)
* static void invokeAll(ForkJoinTask<?> ... taskList)
*
* Trong trường hợp đầu tiên, taskA và taskB được thực thi. Trong trường hợp thứ hai, tất cả các nhiệm vụ được
* chỉ định được thực thi. Trong cả hai trường hợp, luồng gọi đợi cho đến khi tất cả các nhiệm vụ được chỉ định kết thúc.
* Trước JDK 8, phương thức invokeAll() chỉ có thể được thực thi từ bên trong phần tính toán của một ForkJoinTask khác,
* đang chạy trong một ForkJoinPool. Việc bao gồm common pool của JDK 8 đã nới lỏng yêu cầu này.
*
* */
public class c_ForkJoinTask {
}
