package i_Fork_Join_Framework;
/*
* RecursiveTask<V>
* Lớp con khác của ForkJoinTask là RecursiveTask<V>. Lớp này đóng gói một nhiệm vụ trả về kết quả.
* Kiểu kết quả được chỉ định bởi V. Thông thường, mã của bạn sẽ mở rộng RecursiveTask<V> để tạo một nhiệm vụ trả về giá trị.
* Tương tự như RecursiveAction, phương thức trừu tượng compute() thường là quan trọng nhất vì nó đại diện cho phần tính toán
* của nhiệm vụ. Khi bạn mở rộng RecursiveTask<V> để tạo một lớp cụ thể, đặt mã đại diện cho nhiệm vụ vào trong compute().
* Mã này cũng phải trả về kết quả của nhiệm vụ.
*
* Phương thức compute() được định nghĩa bởi RecursiveTask<V> như sau:
* protected abstract V compute()
*
* Lưu ý rằng compute() được bảo vệ và trừu tượng. Điều này có nghĩa là nó phải được thực hiện bởi một lớp con.
* Khi được thực hiện, nó phải trả về kết quả của nhiệm vụ.
* Nhìn chung, RecursiveTask được sử dụng để thực hiện một chiến lược đệ quy, chia và trị cho các nhiệm vụ trả về kết quả.
* (Xem "Chiến lược Chia và Trị" sau trong chương này.)
*
* */
public class e_RecursiveTask {
}
