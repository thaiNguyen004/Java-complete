package a_Overview;
/*
* Bound and Contrainted
* (Các Thuộc tính Ràng buộc và Ràng buộc)
* Một Bean có một thuộc tính ràng buộc sẽ tạo ra một sự kiện khi thuộc tính được thay đổi.
* Sự kiện này có kiểu PropertyChangeEvent và được gửi đến các đối tượng đã đăng ký quan tâm
* nhận thông báo như vậy. Một lớp xử lý sự kiện này phải triển khai giao diện PropertyChangeListener.
*
* Một Bean có một thuộc tính bị ràng buộc sẽ tạo ra một sự kiện khi có một nỗ lực thay đổi giá trị của nó.
* Nó cũng tạo ra một sự kiện có kiểu PropertyChangeEvent. Sự kiện này cũng được gửi đến các đối tượng
* đã đăng ký quan tâm nhận thông báo như vậy. Tuy nhiên, những đối tượng khác này có khả năng phản đối
* sự thay đổi đề xuất bằng cách ném một ngoại lệ PropertyVetoException. Khả năng này cho phép một Bean
* hoạt động khác nhau tùy theo môi trường chạy.
* Một lớp xử lý sự kiện này phải triển khai giao diện VetoableChangeListener.
*
* Persistence (Bền vững)
* Bền vững là khả năng lưu trạng thái hiện tại của một Bean, bao gồm các giá trị của các thuộc tính và
* biến thể của Bean, vào bộ nhớ (nonvolatile) không bay hơi và truy xuất chúng sau này. Khả năng tuần tự hóa
* đối tượng được cung cấp bởi thư viện lớp Java được sử dụng để cung cấp tính bền vững cho Beans.
* Cách dễ nhất để tuần tự hóa một Bean là khi nó triển khai giao diện java.io.Serializable,
* đó chỉ là một giao diện đánh dấu. Triển khai java.io.Serializable sẽ làm cho tuần tự hóa tự động.
* Bean của bạn không cần thực hiện bất kỳ hành động nào khác. Tuần tự hóa tự động cũng có thể được kế thừa.
* Do đó, nếu bất kỳ lớp cha nào của một Bean triển khai java.io.Serializable, thì tuần tự hóa tự động sẽ được đạt được.
* Khi sử dụng tuần tự hóa tự động, bạn có thể chọn lọc ngăn cản việc lưu trường thông qua từ khóa transient.
* Do đó, thành viên dữ liệu của một Bean được chỉ định là transient sẽ không được tuần tự hóa.
*
* Nếu một Bean không triển khai java.io.Serializable, bạn phải cung cấp tuần tự hóa một cách thủ công,
* ví dụ bằng cách triển khai java.io.Externalizable. Nếu không, các container không thể lưu cấu hình của thành phần của bạn.
*
* */
public class h_Bound_Constrainted {
}
