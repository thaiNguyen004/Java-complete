package i_Fork_Join_Framework;
/*
* RecursiveAction
* Lớp con của ForkJoinTask là RecursiveAction. Lớp này đóng gói một nhiệm vụ không trả về kết quả.
* Thông thường, mã của bạn sẽ mở rộng RecursiveAction để tạo một nhiệm vụ có kiểu trả về là void.
* RecursiveAction xác định bốn phương thức, nhưng chỉ có một phương thức thường được quan tâm:
* phương thức trừu tượng được gọi là compute(). Khi bạn mở rộng RecursiveAction để tạo một lớp cụ thể,
* bạn sẽ đặt mã xác định nhiệm vụ trong compute(). Phương thức compute() đại diện cho phần tính toán của nhiệm vụ.
* Phương thức compute() được định nghĩa bởi RecursiveAction như sau:
*
* protected abstract void compute()
*
* Lưu ý rằng compute() được bảo vệ và trừu tượng. Điều này có nghĩa là nó phải được thực hiện bởi một lớp con
* (trừ khi lớp con đó cũng là trừu tượng).
* Nhìn chung, RecursiveAction được sử dụng để thực hiện một chiến lược đệ quy, chia và trị cho các nhiệm vụ không trả về kết quả.
* (Xem "Chiến lược Chia và Trị" sau trong chương này.)
*
* */
public class d_RecursiveAction {
}
