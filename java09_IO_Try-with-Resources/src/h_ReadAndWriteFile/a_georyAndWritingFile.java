package h_ReadAndWriteFile;

import java.io.FileInputStream;
import java.io.IOException;

/*
* Đọc và Ghi File
* Java cung cấp một số lớp và phương thức cho phép bạn đọc và ghi file. Trước khi bắt đầu, cần nhấn mạnh rằng chủ đề I/O file
* rất lớn và I/O file sẽ được xem xét chi tiết trong Phần II. Mục đích của phần này là giới thiệu các kỹ thuật cơ bản để đọc
* và ghi file. Mặc dù sử dụng byte streams, các kỹ thuật này có thể được áp dụng cho các character-based streams.
*
* Hai lớp stream được sử dụng phổ biến nhất là FileInputStream và FileOutputStream, tạo ra byte streams liên kết với file.
* Để mở một file, bạn chỉ cần tạo một đối tượng của một trong hai lớp này, chỉ định tên file như một đối số cho constructor.
* Mặc dù cả hai lớp hỗ trợ các constructor bổ sung, nhưng chúng ta sẽ sử dụng các dạng sau đây:
*       FileInputStream(String fileName) throws FileNotFoundException
*       FileOutputStream(String fileName) throws FileNotFoundException
*
* Ở đây, fileName chỉ định tên của file mà bạn muốn mở. Khi bạn tạo một input stream, nếu file không tồn tại,
* FileNotFoundException sẽ được ném ra. Đối với output streams, nếu file không thể mở hoặc tạo, FileNotFoundException sẽ được ném ra.
* FileNotFoundException là một lớp con của IOException.
* Khi một file output được mở, bất kỳ file đã tồn tại trước đó cùng tên sẽ bị xóa.
*
* LƯU Ý: Trong những tình huống có sự hiện diện của một quản lý bảo mật (security manager),
* một số lớp file như FileInputStream và FileOutputStream sẽ ném ra một SecurityException
* nếu xảy ra vi phạm bảo mật khi cố gắng mở một file. Mặc định, các ứng dụng chạy thông qua java
* không sử dụng quản lý bảo mật. Vì vậy, các ví dụ về I/O trong cuốn sách này không cần kiểm tra
* một SecurityException có thể xảy ra. Tuy nhiên, các loại ứng dụng khác có thể sử dụng quản lý bảo mật,
* và việc thực hiện I/O file bởi một ứng dụng như vậy có thể tạo ra một SecurityException. Trong trường hợp đó,
* bạn cần xử lý ngoại lệ này một cách phù hợp.
*
* Khi bạn hoàn thành việc sử dụng một file, bạn phải đóng nó. Điều này được thực hiện bằng cách gọi phương thức close(),
* mà được triển khai bởi cả FileInputStream và FileOutputStream. Đây là cú pháp của phương thức:
*       void close() throws IOException
* Việc đóng một file giải phóng các tài nguyên hệ thống đã được cấp phát cho file đó, cho phép chúng được sử dụng cho file khác.
* Việc không đóng một file có thể dẫn đến "rò rỉ bộ nhớ" do các tài nguyên không được sử dụng vẫn còn được cấp phát.
*
* GHI CHÚ: Phương thức close() được chỉ định bởi giao diện AutoCloseable trong java.lang. AutoCloseable được kế thừa bởi giao diện
* Closeable trong java.io. Cả hai giao diện này đều được triển khai bởi các lớp stream, bao gồm FileInputStream và FileOutputStream.
*
* Trước khi tiếp tục, quan trọng để nhấn mạnh rằng có hai phương pháp cơ bản mà bạn có thể sử dụng để đóng một file khi bạn hoàn thành
* việc sử dụng nó. Phương pháp đầu tiên là phương pháp truyền thống, trong đó phương thức close() được gọi một cách rõ ràng khi file
* không còn được sử dụng. Đây là phương pháp được sử dụng trong tất cả các phiên bản của Java trước JDK 7 và do đó,
* nó được tìm thấy trong tất cả mã code cổ điển trước JDK 7.
*
* Phương pháp thứ hai là sử dụng câu lệnh try-with-resources được thêm vào bởi JDK 7, nó tự động đóng một file khi không còn cần thiết.
* Trong phương pháp này, không có cuộc gọi rõ ràng đến phương thức close(). Vì bạn có thể gặp mã code cổ điển trước JDK 7,
* nên quan trọng rằng bạn biết và hiểu phương pháp truyền thống. Hơn nữa, phương pháp truyền thống vẫn có thể là phương pháp tốt nhất
* trong một số tình huống. Do đó, chúng ta sẽ bắt đầu với phương pháp này. Phương pháp tự động được mô tả trong phần tiếp theo.
*
* * Để đọc từ một file, bạn có thể sử dụng một phiên bản của phương thức read() được định nghĩa trong FileInputStream.
* Phiên bản mà chúng ta sẽ sử dụng được hiển thị dưới đây:
*
*       int read() throws IOException
*
* Mỗi lần gọi, nó đọc một byte từ file và trả về byte dưới dạng giá trị số nguyên. Phương thức read() trả về -1 khi cố gắng đọc tại cuối luồng.
* Nó có thể ném ra một IOException.
*
* Chương trình dưới đây sử dụng phương thức read() để nhập và hiển thị nội dung của một file chứa văn bản ASCII.
* Tên của file được chỉ định như một đối số dòng lệnh.
* */
public class a_georyAndWritingFile {
    public static void main(String[] args) {
        /*
        * Hiển thị một tập tin văn bản. Để sử dụng chương trình này, hãy chỉ định tên của tệp mà bạn muốn xem.
        * Ví dụ: để xem tệp có tên test.txt
        * Sử dụng command line*/


//        int i;
//        FileInputStream fin;
//        //Đầu tiên hãy xác nhận rằng tên tệp đã được xác nhận
//        if(args.length != 1) {
//            System.out.println("Usage: a_geory filename");
//            return;
//        }
//
//
//        //Cố gắng mở tệp tin
//        try {
//            fin = new FileInputStream(args[0]);
//        }catch (FileNotFoundException e) {
//            System.out.println("Cannot open the file");
//            return;
//        }

        //Tại thời điểm này, file đã sẵn sàng và có thể đọc
        //Phần sau đọc các kí tự cho đến khi EOF (end of file)

//        try {
//            do {
//                i = fin.read();
//                if(i != -1) System.out.print((char)i);
//            } while( i != -1);
//        } catch (IOException e) {
//            System.out.println("Error Reading File");
//            return;
//        }
//
//        try {
//            fin.close();
//        } catch(IOException e) {
//            System.out.println("Error Closing File");
//        }

/*
* Trong chương trình, hãy lưu ý các khối `try/catch` để xử lý các lỗi I/O có thể xảy ra. Mỗi hoạt động I/O được giám sát
* để xử lý ngoại lệ, và nếu có ngoại lệ xảy ra, nó sẽ được xử lý. Cần lưu ý rằng trong các chương trình đơn giản hoặc mã ví dụ,
* thường thấy các ngoại lệ I/O đơn giản chỉ được ném ra khỏi phương thức main(), như đã làm trong các ví dụ I/O từ bàn phím trước đây.
* Ngoài ra, trong một số mã thực tế, việc cho phép ngoại lệ lan truyền đến một phần gọi khác có thể hữu ích để cho phần gọi
* biết rằng một hoạt động I/O đã thất bại.
*
* Tuy nhiên, hầu hết các ví dụ I/O từ tập tin trong cuốn sách này xử lý tất cả các ngoại lệ I/O một cách rõ ràng,
* như được thể hiện, vì mục đích minh họa.
*
* Mặc dù ví dụ trước đã đóng luồng file sau khi đọc xong, có một biến thể thường hữu ích.
* Biến thể đó là gọi close() trong khối finally. Trong cách tiếp cận này, tất cả các phương thức truy cập tập tin được chứa trong khối try,
* và khối finally được sử dụng để đóng tập tin. Điều này đảm bảo rằng không có vấn đề gì xảy ra với khối try, tập tin sẽ được đóng.
* Giả sử ví dụ trước đó, đây là cách khối try đọc tập tin có thể được viết lại:
*/
        //Đọc file và đóng file được thực hiện trong khối try...catch and finally này:

//        int i;
//        FileInputStream fin = null;
//
//        if(args.length != 1) {
//            System.out.println("Usage: java a_geory.java filename");
//            return;
//        }
//
//
//        try {
//            fin = new FileInputStream(args[0]);
//
//            do{
//                i = fin.read();
//                if(i != -1) System.out.print((char)i);
//            }while(i != -1);
//        } catch (FileNotFoundException e) {
//            System.out.println("Không tìm thấy file");
//        } catch (IOException e) {
//            System.out.println("Error reading file");
//        } finally {
//            //Vẫn phải bọc trong một khối try catch
//            try {
//                //Nếu file chưa được đọc hoặc lỗi hoặc không tìm thấy file tức là fin = null như chỉ định thì không thực
//                //hiện đóng file
//                if(fin != null) fin.close();
//            } catch (IOException e) {
//                System.out.println("Error closing file");
//            }
//
//        }
/*
* Trong phương pháp này, hãy lưu ý rằng fin được khởi tạo thành null. Sau đó, trong khối finally, tập tin chỉ được đóng
* nếu fin không phải là null. Điều này hoạt động vì fin chỉ sẽ là không null nếu tập tin được mở thành công.
* Do đó, close() không được gọi nếu có ngoại lệ xảy ra khi mở tập tin.
*
* Có thể làm cho chuỗi try/catch trong ví dụ trước một chút gọn hơn. Vì FileNotFoundException là một lớp con của IOException,
* nên không cần phải bắt nó riêng biệt. Ví dụ, đây là chuỗi được viết lại để loại bỏ việc bắt FileNotFoundException.
* Trong trường hợp này, thông báo ngoại lệ tiêu chuẩn, mô tả lỗi, được hiển thị.
* */

        int i;
        FileInputStream fin = null;

        if(args.length != 1){
            System.out.println("Usage: java a_geory.java filename");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            do {
                i = fin.read();
                if(i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (IOException e){
            System.out.println("Error IOE: " + e);
        } finally {
            try {
                if(fin != null) fin.close();
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }

        /*
        * Trong phương pháp này, bất kỳ lỗi nào, bao gồm lỗi mở tệp, đều được xử lý đơn giản bằng câu lệnh catch duy nhất.
        * Vì tính gọn nhẹ, phương pháp này được sử dụng trong nhiều ví dụ I/O trong cuốn sách này. Tuy nhiên, hãy lưu ý
        * rằng phương pháp này không phù hợp trong các trường hợp mà bạn muốn xử lý riêng lẻ với lỗi mở tệp, chẳng hạn
        * như khi người dùng nhập sai tên tệp. Trong trường hợp như vậy, bạn có thể yêu cầu nhập lại tên chính xác trước
        * khi bắt đầu khối try để truy cập vào tệp.
        *
        * Để ghi vào tệp, bạn có thể sử dụng phương thức write() được định nghĩa bởi FileOutputStream. Dạng đơn giản nhất
        * của nó được thể hiện ở đây:
        *
        *       void write(int byteval) throws IOException
        *
        * Phương thức này ghi byte được chỉ định bởi byteval vào tệp. Mặc dù byteval được khai báo là một số nguyên,
        * chỉ có tám bit thấp nhất được ghi vào tệp. Nếu xảy ra lỗi trong quá trình ghi, một IOException được ném ra.
        * Ví dụ tiếp theo sử dụng write() để sao chép một tệp. CopyFile.java*/
    }

}
