package i_AutomaticallyClosingAFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ShowFile2 {
    public static void main(String[] args) throws IOException {
        int i;
        if(args.length != 2) {
            System.out.println("Usage: java ShowFile2.java file_from_name file_to_name");
            return;
        }

        try(var fin = new FileInputStream(args[0]);
            var fout = new FileOutputStream(args[1]))
        {
            do {
                i = fin.read();
                if(i != -1) fout.write(i);
            } while(i != -1);
        } catch (IOException e) {
            System.out.println("Error I/O: " + e);
        }
    }
}
/*
* Trong chương trình này, hãy chú ý cách mở tệp đầu vào và tệp đầu ra trong khối try:
* try (var fin = new FileInputStream(args[0]);
       var fout = new FileOutputStream(args[1])) {
    // Code to work with the files

* Sau khi khối try này kết thúc, cả fin và fout sẽ được đóng. Nếu so sánh phiên bản này của chương trình với phiên bản trước,
* bạn sẽ thấy nó ngắn gọn hơn rất nhiều. Khả năng tối ưu mã nguồn là một lợi ích phụ của việc quản lý tài nguyên tự động.
*
* Còn một khía cạnh khác của try-with-resources cần được đề cập. Nói chung, khi một khối try thực thi, có thể xảy ra ngoại lệ bên trong
* khối try dẫn đến ngoại lệ khác xảy ra khi tài nguyên được đóng trong một mệnh đề finally. Trong trường hợp của một try thông thường,
* ngoại lệ gốc bị mất, bị ưu tiên bởi ngoại lệ thứ hai.
* Tuy nhiên, khi sử dụng try-with-resources, ngoại lệ thứ hai được ức chế (suppressed). Tuy nhiên, nó không bị mất đi.
* Thay vào đó, nó được thêm vào danh sách các ngoại lệ bị ức chế liên quan đến ngoại lệ đầu tiên. Danh sách các ngoại lệ bị ức chế
* có thể được lấy bằng cách sử dụng phương thức getSuppressed() được định nghĩa bởi Throwable.
*/
