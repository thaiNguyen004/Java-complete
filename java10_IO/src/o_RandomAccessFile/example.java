package o_RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

/*
* RandomAccessFile
* RandomAccessFile đóng gói một tệp tin truy cập ngẫu nhiên. Nó không được kế thừa từ InputStream hoặc OutputStream.
* Thay vào đó, nó triển khai các giao diện DataInput và DataOutput, định nghĩa các phương thức cơ bản của I/O.
* Nó cũng triển khai các giao diện AutoCloseable và Closeable. RandomAccessFile đặc biệt vì nó hỗ trợ các yêu cầu
* vị trí - tức là, bạn có thể đặt con trỏ tệp tin trong tệp tin. Nó có hai constructor như sau:
*
* RandomAccessFile(File fileObj, String access) throws FileNotFoundException
* RandomAccessFile(String filename, String access) throws FileNotFoundException
*
* Trong dạng đầu tiên, fileObj chỉ định tệp tin cần mở dưới dạng một đối tượng File.
* Trong dạng thứ hai, tên tệp tin được chuyển vào dưới dạng filename. Trong cả hai trường hợp, access xác định loại
* truy cập tệp tin được phép.
*
* Nếu là "r", thì tệp tin có thể được đọc, nhưng không được ghi.
*
* Nếu là "rw", thì tệp tin được mở trong chế độ đọc-ghi.
*
* Nếu là "rws", tệp tin được mở cho các hoạt động đọc-ghi và mọi thay đổi về dữ liệu hoặc siêu dữ liệu của tệp tin sẽ
* được ghi ngay lập tức vào thiết bị vật lý.
*
* Nếu là "rwd", tệp tin được mở cho các hoạt động đọc-ghi và mọi thay đổi về dữ liệu của tệp tin sẽ được ghi ngay lập tức
* vào thiết bị vật lý.
*
* Phương thức seek(), được hiển thị dưới đây, được sử dụng để đặt vị trí hiện tại của con trỏ tệp tin trong tệp tin:
*
* void seek(long newPos) throws IOException
*
* Ở đây, newPos chỉ định vị trí mới, tính bằng byte, của con trỏ tệp tin từ đầu tệp tin. Sau khi gọi seek(), phép đọc
* hoặc ghi tiếp theo sẽ xảy ra tại vị trí tệp tin mới.
*
* RandomAccessFile triển khai các phương thức đầu vào và đầu ra tiêu chuẩn, mà bạn có thể sử dụng để đọc và ghi vào các tệp tin
* truy cập ngẫu nhiên. Nó cũng bao gồm một số phương thức bổ sung. Một trong số đó là setLength(). Nó có dạng như sau:
*
* void setLength(long len) throws IOException
*
* Phương thức này đặt chiều dài của tệp tin hiện tại thành giá trị được chỉ định bởi len. Phương thức này có thể được sử dụng
* để làm dài hoặc rút gọn một tệp tin. Nếu tệp tin được làm dài, phần được thêm vào là không xác định.*/
public class example {
    public static void main(String[] args) {
        try(RandomAccessFile raf =
                    new RandomAccessFile("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\file3.txt", "rw"))
        {
            /*
            * Khi sử dụng phương thức seek() để di chuyển vị trí con trỏ trong tệp tin, việc ghi dữ liệu tiếp theo sẽ
            * xảy ra từ vị trí mới đó. Nếu bạn ghi dữ liệu vào vị trí mới mà không đọc hoặc sao chép nội dung cũ,
            * nội dung trước đó của tệp tin sẽ bị ghi đè bởi dữ liệu mới.
            */

            /*
            * Lưu ý rằng việc sử dụng seek() và ghi dữ liệu mới chỉ thích hợp khi bạn muốn ghi dữ liệu vào vị trí cụ
            * thể trong tệp tin mà không cần quan tâm đến nội dung đã tồn tại. Nếu bạn muốn thêm dữ liệu vào cuối tệp
            * tin mà không làm mất dữ liệu cũ, bạn có thể sử dụng phương thức write() mà không cần sử dụng seek().
            * */
            String str = "Nguyen Thai Nguyen";
            //Ghi "Nguyen Thai Nguyen"
            byte[] buf = str.getBytes();
            raf.write(buf);

            //Muốn ghi đè lên nội dung cũ
            raf.seek(0);
            raf.writeBytes("Ho va ten: Nguyen Thai Nguyen");

        } catch (FileNotFoundException e) {
            System.out.println("Lỗi mở tệp");
        } catch (IOException e) {
            System.out.println("Lỗi IO");
        }
    }

}
