package g_StreamClasses;
/*
* FileInputStream
* Lớp FileInputStream tạo ra một InputStream mà bạn có thể sử dụng để đọc các byte từ một tệp tin.
* Hai constructor thường được sử dụng như sau:
*
* FileInputStream(String filePath)
* FileInputStream(File fileObj)
*
* Cả hai constructor này có thể ném ra một FileNotFoundException. Trong đó,
* filePath là đường dẫn đầy đủ của tệp tin
* fileObj là một đối tượng File mô tả tệp tin.
*
* Ví dụ sau tạo ra hai FileInputStreams sử dụng cùng một tệp tin trên đĩa vào mỗi constructor:
*
* FileInputStream f0 = new FileInputStream("/autoexec.bat");
*
* File f = new File("/autoexec.bat");
* FileInputStream f1 = new FileInputStream(f);
*
* Mặc dù constructor đầu tiên thường được sử dụng phổ biến hơn, constructor thứ hai cho phép bạn kiểm tra kỹ hơn về tệp
* tin bằng cách sử dụng các phương thức của lớp File trước khi gắn nó vào một luồng đầu vào. Khi một FileInputStream được tạo ra,
* nó cũng được mở để đọc.
*
* FileInputStream ghi đè lên một số phương thức trong lớp abstract InputStream. Các phương thức mark() và reset() không được ghi đè,
* và bất kỳ cố gắng sử dụng reset() trên một FileInputStream sẽ sinh ra một IOException.
*
* Ví dụ tiếp theo sẽ hướng dẫn cách đọc một byte duy nhất, một mảng các byte và một phạm vi con của một mảng các byte.
* Nó cũng minh họa cách sử dụng phương thức available() để xác định số byte còn lại và cách sử dụng phương thức skip()
* để bỏ qua các byte không cần thiết. Chương trình sẽ đọc tệp tin nguồn của nó, phải nằm trong thư mục hiện tại.
* Lưu ý rằng nó sử dụng câu lệnh try-with-resources để tự động đóng tệp khi không còn cần thiết.
*
* */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class e_FileInputStream {
    public static void main(String[] args) throws IOException {
        int size;

        //Sử dụng try-with-resources để tự động đóng luồng
        try (FileInputStream fin =
                     new FileInputStream("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\src\\g_StreamClasses\\c_InputStream.java"))
        {

            //todo : Trường hợp đọc từng byte
            // todo available() : lấy tổng số byte có sẵn trong bộ đệm
            System.out.println("Tổng số byte có sẵn trong bộ đệm để đọc: " + (size = fin.available()));
            int n = size / 40; // todo: chia nhỏ số lần đọc
            System.out.println(n +" bytes đầu tiên của tệp mỗi lần đọc");
            for (int i = 0; i < n; i++) {
                System.out.print((char) fin.read());
            }

            //todo: Trường hợp đọc một mảng các bytes
            System.out.println("Vẫn có sẵn: " + fin.available());
            System.out.println("Đọc "+ n +" bytes tiếp theo với mỗi lần đọc (b[])");
            byte[] b = new byte[n];
            if(fin.read(b) != n) {
                System.err.println("Không thể đọc: " + n + " bytes");
            }
            System.out.println(new String(b, 0, n));
            /*
            * Trong trường hợp này, đối số b được truyền vào phương thức read() để chỉ định mảng byte mà dữ liệu được đọc vào.
            * Khi phương thức read() được gọi, nó sẽ đọc một lượng byte từ tệp và lưu vào mảng b. Kết quả trả về là số byte
            * đã được đọc và lưu vào mảng.*/


            //todo: Trường hợp đọc một phạm vi con của một mảng các byte
            System.out.println("Vẫn còn sẵn: " + (size = fin.available()));
            System.out.println("Bỏ qua nửa số byte còn lại bằng cách sử dụng skip");
            fin.skip(size/2);
            System.out.println("Vẫn còn sẵn: " + fin.available());

            System.out.println("Đọc "+ n/2 +" byte vào cuối của mảng");
            if(fin.read(b, n/2, n/2) != n/2) {
                System.err.println("Không thể đọc : "+ n/2 +" bytes");
            }
            System.out.println(new String(b, 0, b.length));
            System.out.println("Vẫn còn : "+ fin.available());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        /*
        * Ví dụ hơi vắt óc này giới thiệu cách đọc theo ba cách khác nhau, bỏ qua đầu vào và kiểm tra số lượng dữ liệu
        * có sẵn trên một luồng.
        *
        * Phương thức `available()` trong `FileInputStream` cho biết số byte có sẵn có thể đọc ngay lập tức từ điểm đọc hiện tại của file
        * mà không cần chờ thêm dữ liệu từ ổ đĩa. Nếu giá trị trả về là 0, có nghĩa là bạn đã đọc hết dữ liệu hiện có và cần đọc thêm từ file.
        * Lưu ý rằng số byte có sẵn chỉ đề cập đến số byte trong bộ đệm, không phải tổng số byte trong file.
        */

    }
}

