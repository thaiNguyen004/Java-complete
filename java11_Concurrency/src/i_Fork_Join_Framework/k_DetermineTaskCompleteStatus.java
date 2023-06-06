package i_Fork_Join_Framework;
/*
* Xác định (Determine) trạng thái hoàn thành của một tác vụ
* Ngoài hàm isCancelled() đã được mô tả trước đó, ForkJoinTask còn bao gồm hai phương thức khác mà
* bạn có thể sử dụng để xác định trạng thái hoàn thành của một tác vụ. Phương thức đầu tiên là
* isCompletedNormally(), được định nghĩa như sau:
* final boolean isCompletedNormally()
* Nó trả về true nếu tác vụ gọi hàm hoàn thành một cách bình thường, tức là nó không ném ra một ngoại lệ
* và không bị hủy bỏ bằng cách gọi hàm cancel(). Nó trả về false trong trường hợp khác.

* Xác định trạng thái kết thúc
* Phương thức thứ hai là isCompletedAbnormally(), được định nghĩa như sau:
* final boolean isCompletedAbnormally()
* Nó trả về true nếu tác vụ gọi hàm hoàn thành do bị hủy bỏ hoặc ném ra một ngoại lệ.
* Nó trả về false trong trường hợp khác.
*
* */
public class k_DetermineTaskCompleteStatus {
}
