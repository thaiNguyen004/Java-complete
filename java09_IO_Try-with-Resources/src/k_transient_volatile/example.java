package k_transient_volatile;

/*
* Các từ khóa transient và volatile
* Trong Java, có hai từ khóa đặc biệt là transient và volatile được sử dụng để xử lý những tình huống đặc biệt.
* Khi một biến của đối tượng được khai báo là transient, giá trị của biến này không cần được lưu trữ khi đối tượng được lưu trữ. Ví dụ:
*
* class T {
*    transient int a; // sẽ không tồn tại
*    int b; // sẽ tồn tại
* }
*
* Ở đây, nếu một đối tượng kiểu T được ghi vào một vùng lưu trữ bền vững, nội dung của biến a sẽ không được lưu trữ,
* trong khi nội dung của biến b sẽ được lưu trữ.
*
* Từ khóa volatile cho biết cho trình biên dịch rằng biến được sửa đổi bởi volatile có thể thay đổi một cách bất ngờ bởi các
* phần khác trong chương trình của bạn. Một trong những tình huống này liên quan đến các chương trình đa luồng. Trong một chương trình
* đa luồng, đôi khi hai hoặc nhiều luồng chia sẻ cùng một biến. Vì lợi ích về hiệu suất, mỗi luồng có thể giữ một bản sao riêng,
* riêng tư của biến chia sẻ đó. Bản sao thực sự (hoặc bản sao chính) của biến được cập nhật vào các thời điểm khác nhau,
* ví dụ khi một phương thức được đồng bộ được nhập vào. Mặc dù phương pháp này hoạt động tốt, nhưng đôi khi có thể không hiệu quả.
* Trong một số trường hợp, điều quan trọng thực sự chỉ là bản sao chính của biến luôn phản ánh trạng thái hiện tại của nó.
* Để đảm bảo điều này, chỉ định biến là volatile, cho biết trình biên dịch phải luôn sử dụng bản sao chính của một biến volatile
* (hoặc ít nhất là luôn giữ cho bất kỳ bản sao riêng nào được cập nhật với bản sao chính và ngược lại).
*
* Ngoài ra, truy cập vào biến chia sẻ phải được thực hiện theo thứ tự chính xác được chỉ định bởi chương trình.
*
* */
public class example {
    transient int a;

    volatile int b;

    int c;
}
