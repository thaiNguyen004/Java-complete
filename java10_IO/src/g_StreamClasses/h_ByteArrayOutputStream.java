package g_StreamClasses;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* ByteArrayOutputStream
* ByteArrayOutputStream là một lớp triển khai của đầu ra (output stream) sử dụng một mảng byte làm đích đầu ra.
* ByteArrayOutputStream có hai hàm tạo, được mô tả như sau:
*
todo     ByteArrayOutputStream():
* Hàm tạo đầu tiên tạo ra một bộ đệm có 32 byte.
*
todo     ByteArrayOutputStream(int numBytes):
* Hàm tạo thứ hai tạo ra một bộ đệm có kích thước bằng giá trị numBytes được chỉ định.
*
* Bộ đệm được lưu trữ trong trường buf được bảo vệ của ByteArrayOutputStream. Kích thước bộ đệm sẽ tự động tăng nếu cần.
* Số byte được giữ bởi bộ đệm được chứa trong trường count được bảo vệ của ByteArrayOutputStream.
* Phương thức close() không có tác dụng trên ByteArrayOutputStream. Do đó, không cần gọi close() trên ByteArrayOutputStream,
* nhưng việc làm điều này không gây lỗi.
*
* Ví dụ sau đây minh họa việc sử dụng ByteArrayOutputStream:
* */
public class h_ByteArrayOutputStream {
    public static void main(String[] args) {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "Nguyen Thai Nguyen";
        byte[] buf = s.getBytes();
        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println("Error writing to buffer");
            return;
        }

        System.out.println("Buffer dưới dạng chuỗi: ");
        System.out.println(f.toString());
        System.out.println("Into Array");
        byte[] b = f.toByteArray();
        System.out.println(new String(b));

        System.out.println("\nTới một luồng OutputStream");

        //Sử dụng try-with-resource để quản lý luồng file
        try (FileOutputStream f2 = new FileOutputStream("test.txt")) {
            f.writeTo(f2);
        } catch (IOException e) {
            System.out.println("I/O Error");
            return;
        }
        //Nội dung trong file test.txt : "Nguyen Thai Nguyen"



        System.out.println("ByteArrayOutputStream sau khi reset và write 3 byte 'X'");
        f.reset(); // quay lại vị trí xuất phát đồng nghĩa các byte trong ByteArrayOutputStream sẽ bị xóa hết
        for(int i = 0; i < 3; i++) f.write('X');
        System.out.println(f.toString());

    }
}
