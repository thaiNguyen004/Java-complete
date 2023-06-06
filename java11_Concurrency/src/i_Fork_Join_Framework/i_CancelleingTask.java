package i_Fork_Join_Framework;
/*
* Hủy bỏ một tác vụ
* Một tác vụ có thể được hủy bỏ bằng cách gọi hàm cancel(), được định nghĩa bởi ForkJoinTask.
* Hàm này có dạng chung như sau:
*
* boolean cancel(boolean interruptOK)
*
* Nó trả về true nếu tác vụ mà nó được gọi đã bị hủy bỏ. Nó trả về false nếu tác vụ đã kết thúc
* hoặc không thể hủy bỏ. Hiện tại, tham số interruptOK không được sử dụng trong việc triển khai mặc định.
* Thông thường, cancel() được gọi từ mã bên ngoài tác vụ vì một tác vụ có thể dễ dàng tự hủy bỏ bằng cách trả về.
* Bạn có thể xác định xem một tác vụ đã bị hủy bỏ hay chưa bằng cách gọi hàm isCancelled(), như sau:
*
* final boolean isCancelled()
*
* Nó trả về true nếu tác vụ gọi hàm đã bị hủy bỏ trước khi hoàn thành và false trong trường hợp khác.
*
* */
public class i_CancelleingTask {
}
