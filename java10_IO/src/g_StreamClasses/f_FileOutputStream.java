package g_StreamClasses;

import java.io.FileOutputStream;
import java.io.IOException;

/*
* FileOutputStream
* FileOutputStream tạo ra một OutputStream mà bạn có thể sử dụng để ghi các byte vào một tập tin. Nó triển khai các giao diện
* AutoCloseable, Closeable và Flushable. Bốn trong số các constructor của nó được mô tả dưới đây:
*
* FileOutputStream(String filePath)
* FileOutputStream(File fileObj)
* FileOutputStream(String filePath, boolean append)
* FileOutputStream(File fileObj, boolean append)
*
* Chúng có thể gây ra FileNotFoundException. Ở đây, filePath là đường dẫn đầy đủ của một tập tin, và fileObj là một đối tượng File mô tả tập tin.
* Nếu append là true, tập tin sẽ được mở ở chế độ nối thêm (append mode).
* Việc tạo ra một FileOutputStream không phụ thuộc vào tập tin đã tồn tại hay chưa. FileOutputStream sẽ tạo ra tập tin trước khi mở nó
* để ghi khi bạn tạo đối tượng. Trong trường hợp bạn cố gắng mở một tập tin chỉ để đọc, một ngoại lệ sẽ được ném ra.
*
* Ví dụ sau tạo ra một buffer mẫu của các byte bằng cách tạo một chuỗi và sử dụng phương thức getBytes() để trích xuất mảng byte tương đương.
* Sau đó, nó tạo ra ba tập tin.
todo    1. Tập tin đầu tiên, file1.txt, sẽ chứa từng byte kế tiếp trong bộ đệm.
todo    2. Tập tin thứ hai, file2.txt, sẽ chứa toàn bộ tập hợp các byte.
todo    3. Tập tin thứ ba và cuối cùng, file3.txt, sẽ chỉ chứa một phần tức là một phần tư cuối cùng.
*
* */
public class f_FileOutputStream {
    public static void main(String[] args) throws IOException {
        String source = "Nguyễn Thái Nguyên \n" +
                "MSSV: PH33935 \n" +
                "Major: PTPM";

        byte[] buf = source.getBytes();

        // Tạo ra 3 tập tin
        FileOutputStream f1 = null;
        FileOutputStream f2 = null;
        FileOutputStream f3 = null;

        try {
            f1 = new FileOutputStream("file1.txt");
            f2 = new FileOutputStream("file2.txt");
            f3 = new FileOutputStream("file3.txt");

            //Viết cho file đầu tiên
            for(int i = 0 ; i < buf.length; i++) f1.write(buf[i]);

            //Viết cho file thứ 2
            f2.write(buf);

            //Viết cho file thứ 3 chỉ chứa 1/4 cuối
            f3.write(buf, 3/4, 1/4);
        }catch (IOException e) {
            System.out.println("Error");
        } finally {
            try {
                if(f1 != null) f1.close();
            } catch (IOException e) {
                System.out.println("Lỗi đóng file f1");
            }
            try {
                if(f2 != null) f2.close();
            } catch (IOException e) {
                System.out.println("Lỗi đóng file f2");
            }
            try {
                if(f3 != null) f3.close();
            } catch (IOException e) {
                System.out.println("Lỗi đóng file f3");
            }
        }

    }
}
