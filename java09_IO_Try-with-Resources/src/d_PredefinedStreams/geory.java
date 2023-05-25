package d_PredefinedStreams;
/*
* Các Luồng Định Sẵn
* Như bạn đã biết, tất cả các chương trình Java tự động import gói java.lang. Gói này định nghĩa một lớp gọi là System,
* bao gồm nhiều khía cạnh của môi trường thực thi. Ví dụ, sử dụng một số phương thức của nó, bạn có thể lấy thời gian hiện tại
* và các cài đặt của các thuộc tính liên quan đến hệ thống. System cũng chứa ba biến luồng được định nghĩa trước: in, out và err.
*
* Những trường này được khai báo là public, static và final trong System. Điều này có nghĩa là chúng có thể được sử dụng bởi bất
* kỳ phần nào khác của chương trình của bạn mà không cần tham chiếu đến một đối tượng System cụ thể.
*
* System.out đề cập đến luồng đầu ra tiêu chuẩn. Mặc định, đây là console. System.in đề cập đến luồng đầu vào tiêu chuẩn, mặc định
* là bàn phím. System.err đề cập đến luồng lỗi tiêu chuẩn, cũng là console mặc định. Tuy nhiên, những luồng này có thể được chuyển
* hướng đến bất kỳ thiết bị I/O tương thích nào.
*
* System.in là một đối tượng thuộc kiểu InputStream; System.out và System.err là đối tượng thuộc kiểu PrintStream. Chúng là các luồng byte,
* mặc dù thường được sử dụng để đọc và ghi các ký tự từ và đến console. Như bạn sẽ thấy, bạn có thể bao chúng bên trong các luồng
* dựa trên ký tự, nếu muốn.
*
* Các chương trình trước đã sử dụng System.out trong ví dụ của chúng. Bạn có thể sử dụng System.err cách tương tự. Như được giải thích
* trong phần tiếp theo, việc sử dụng System.in phức tạp hơn một chút.*/
public class geory {
    public static void main(String[] args) {
        System.err.println("Minh họa System.err");
    }
}
