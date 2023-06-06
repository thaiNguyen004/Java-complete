package i_Fork_Join_Framework;
/*
* Khởi động lại một tác vụ
* Thường thì bạn không thể chạy lại một tác vụ. Nghĩa là, một khi một tác vụ hoàn thành,
* nó không thể được chạy lại. Tuy nhiên, bạn có thể khởi tạo lại trạng thái của tác vụ (sau khi hoàn thành)
* để nó có thể chạy lại. Điều này được thực hiện bằng cách gọi hàm reinitialize(), như được hiển thị dưới đây:
*
* void reinitialize()
*
* Phương thức này đặt lại trạng thái của tác vụ gọi hàm. Tuy nhiên, bất kỳ sự thay đổi nào được thực hiện trên
* bất kỳ dữ liệu lưu trữ nào mà tác vụ hoạt động cũng sẽ không bị hoàn tác. Ví dụ, nếu tác vụ thay đổi một mảng,
* thì các thay đổi đó không được hoàn tác bằng cách gọi hàm reinitialize().
*
* */
public class l_RestartingTask {
}
