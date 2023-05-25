package n_nativeMethod;
/*
* Phương thức Native
* Mặc dù hiếm khi xảy ra, đôi khi bạn có thể muốn gọi một tiểu chương trình được viết bằng một ngôn ngữ khác ngoài Java.
* Thông thường, một tiểu chương trình như vậy tồn tại dưới dạng mã thực thi cho CPU và môi trường mà bạn đang làm việc - có nghĩa
* là mã nguồn tự nhiên. Ví dụ, bạn có thể muốn gọi một tiểu chương trình mã nguồn tự nhiên để đạt được thời gian thực thi nhanh hơn.
* Hoặc bạn có thể muốn sử dụng một thư viện chuyên biệt của bên thứ ba, chẳng hạn như một gói thống kê.
*
* Tuy nhiên, vì chương trình Java được biên dịch thành bytecode, sau đó được giải thích (hoặc biên dịch trực tiếp) bởi hệ thống chạy Java,
* có vẻ như không thể gọi một tiểu chương trình mã nguồn tự nhiên từ bên trong chương trình Java của bạn.
* May mắn thay, kết luận này là sai. Java cung cấp từ khóa native, được sử dụng để khai báo các phương thức mã nguồn tự nhiên.
* Sau khi khai báo, các phương thức này có thể được gọi từ bên trong chương trình Java của bạn như cách bạn gọi bất kỳ phương thức Java nào khác.
*
* Cơ chế được sử dụng để tích hợp mã nguồn tự nhiên với chương trình Java được gọi là Giao diện Native Java (JNI). Để khai báo một phương thức native,
* đặt từ khóa native trước phương thức, nhưng không định nghĩa bất kỳ thân phương thức nào.
* Ví dụ: public native int meth();
* Sau khi bạn khai báo một phương thức native, bạn phải viết phương thức native và tuân theo một loạt các bước khá phức tạp để liên kết nó với
* mã Java của bạn. Xem tài liệu Java để biết chi tiết hiện tại.*/
public class example {
}
