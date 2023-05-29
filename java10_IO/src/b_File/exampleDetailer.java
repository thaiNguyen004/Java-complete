package b_File;
/*
* Lớp File định nghĩa nhiều phương thức để lấy các thuộc tính tiêu chuẩn của một đối tượng File.
*
* Ví dụ:
* phương thức getName() trả về tên của tệp;
* phương thức getParent() trả về tên của thư mục cha
* phương thức exists() trả về true nếu tệp tồn tại, false nếu không tồn tại.
*
* Ví dụ sau minh họa một số phương thức của lớp File. Nó giả định rằng tồn tại một thư mục có tên "java" nằm trong thư mục gốc
* và chứa một tệp có tên "COPYRIGHT".
* */

//TODO: Hiểu được các phương thức của lớp File
import java.io.File;
import java.nio.file.Path;

public class exampleDetailer {
    static void p (String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        File f1 = new File("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\java\\COPYRIGHT.txt");
        p("File name: " + f1.getName()); // phương thức getName() trả về tên của tệp;
        p("Path: " + f1.getPath()); // phương thức getPath() trả về đường dẫn của tệp;
        p("Abs Path: " + f1.getAbsolutePath());
        p("Parent: " + f1.getParent());
        p("Exist: " + f1.exists());
        p("Can write: " + f1.canWrite());
        p("Can read: " + f1.canRead());
        p("Is Directory: " + f1.isDirectory());
        p(f1.isFile() ? "Là một File bình thường" : "Có thể là một đường ống được đặt tên");
        p(f1.isAbsolute() ? "is absolute" : "is not absolute");
        p("File last modified: " + f1.lastModified());
        p("File size: " + f1.length()+" bytes");

        Path path = f1.toPath();
        System.out.println(path); //E:\Studyspace\Java\source\GeoryComplete\java10_IO\java\COPYRIGHT.txt

        //Thực hiện phương thức boolean renameTo(File dest) để đổi tên và di chuyển file
        File dest = new File("dest/COPYRIGHT.txt");
        boolean canRename = f1.renameTo(dest);
        System.out.println(canRename); //true <=> tệp COPYRIGHT.txt đã bị di chuyển tới folder dest

        //Thực hiện vừa di chuyển vừa đổi tên file COPYRIGHT.txt thành NEWFILE.txt
        File f2 = new File("dest/COPYRIGHT.txt"); //File hiện tại
        File f3 = new File("java/NEWNAME.txt"); //File đích
        boolean canRename1 = f2.renameTo(f3);
        System.out.println(canRename1);


    }
}
/*
* Hầu hết các phương thức của lớp File đều rõ ràng trong ý nghĩa của chúng. Tuy nhiên, phương thức isFile() và isAbsolute()
* cần được giải thích thêm.
*
* Phương thức isFile() trả về true nếu được gọi trên một tệp và false nếu được gọi trên một thư mục.
* Ngoài ra, phương thức isFile() trả về false đối với một số tệp đặc biệt như trình điều khiển thiết bị và đường ống có tên,
* do đó phương thức này có thể được sử dụng để đảm bảo rằng tệp sẽ hoạt động như một tệp.
*
* Phương thức isAbsolute() trả về true nếu tệp có đường dẫn tuyệt đối và false nếu đường dẫn của nó là tương đối.
*
* Lớp File bao gồm hai phương thức tiện ích hữu ích đáng chú ý. Phương thức đầu tiên là renameTo(), được trình bày dưới đây:
*
//TODO       boolean renameTo(File dest)
*
* Phương thức này được sử dụng để đổi tên hoặc di chuyển một tệp tới một vị trí mới trong hệ thống tệp.
* Nó nhận đối số là một đối tượng File đích, đại diện cho vị trí mới mà tệp sẽ được đổi tên hoặc di chuyển đến.
* Phương thức trả về true nếu việc đổi tên hoặc di chuyển thành công, và false nếu không thành công.
*
* Phương thức thứ hai là delete(), được trình bày dưới đây:
*
//TODO       boolean delete()
*
* Phương thức này được sử dụng để xóa tệp. Nó xóa tệp được đại diện bởi đối tượng File và trả về true nếu việc xóa thành công,
* và false nếu không thành công.
*
* Lưu ý: Cả hai phương thức này thực sự xóa hoặc di chuyển tệp trên hệ thống tệp, vì vậy hãy sử dụng cẩn thận để tránh xóa
* hoặc mất dữ liệu quan trọng.
*
* Dưới đây là mô tả cho các phương thức sau:
*
TODO        1. `void deleteOnExit()`:
* Phương thức này được sử dụng để đánh dấu tệp sẽ bị xóa khi chương trình thoát.
* Khi chương trình kết thúc, tệp sẽ tự động bị xóa nếu phương thức delete() được gọi trên nó.
*
TODO        2. `long getFreeSpace()`:
* Phương thức này trả về số lượng không gian đĩa trống (tính bằng byte) trên đường dẫn
* tới tệp hoặc thư mục đại diện bởi đối tượng File.
*
TODO        3. `long getTotalSpace()`:
* Phương thức này trả về tổng số lượng không gian đĩa (tính bằng byte) trên đường dẫn
* tới tệp hoặc thư mục đại diện bởi đối tượng File.
*
TODO        4. `long getUsableSpace()`:
* Phương thức này trả về số lượng không gian đĩa khả dụng (tính bằng byte) trên đường
* dẫn tới tệp hoặc thư mục đại diện bởi đối tượng File. Đây là không gian có thể sử dụng cho ứng dụng hiện tại,
* không tính không gian đã được sử dụng bởi hệ thống hoặc quyền hạn hệ thống.
*
TODO        5. `boolean isHidden()`:
* Phương thức này kiểm tra xem tệp hoặc thư mục có được ẩn hay không. Nó trả về true nếu tệp
* hoặc thư mục được đánh dấu là ẩn và trả về false nếu không phải là ẩn.
*
TODO        6. `boolean setLastModified(long millisec)`:
* Phương thức này được sử dụng để đặt thời gian sửa đổi cuối cùng của tệp
* hoặc thư mục thành một giá trị đã cho. Giá trị millisec là số mili giây kể từ thời điểm Epoch (1 tháng 1, 1970, 00:00:00 GMT).
* Phương thức trả về true nếu thành công và false nếu không thành công.
*
TODO        7. `boolean setReadOnly()`:
* Phương thức này được sử dụng để đặt tệp hoặc thư mục chỉ để đọc. Nếu phương thức được gọi
* trên một tệp, nó sẽ được đánh dấu là chỉ đọc. Nếu phương thức được gọi trên một thư mục, tất cả các tệp và thư mục con bên
* trong nó cũng sẽ được đánh dấu chỉ đọc. Phương thức trả về true nếu thành công và false nếu không thành công.
*
* Cũng tồn tại các phương thức để đánh dấu tệp tin như có thể đọc, ghi và thực thi. Vì File thực hiện giao diện Comparable,
* nên phương thức compareTo() cũng được hỗ trợ.
*
* Một phương thức đặc biệt được gọi là toPath(), được mô tả như sau:

* TODO:      Path toPath()
*
* toPath() trả về một đối tượng Path đại diện cho tệp được đóng gói bởi đối tượng File gọi phương thức.
* (Nói cách khác, toPath() chuyển đổi một File thành một Path.)
* Path được đóng gói trong gói java.nio.file và là một phần của NIO. Do đó, toPath() tạo một cầu nối giữa lớp File cũ hơn và
* giao diện Path mới hơn. (Xem Chương 22 để biết thêm về Path.)*/