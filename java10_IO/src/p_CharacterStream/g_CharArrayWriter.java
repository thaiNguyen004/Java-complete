package p_CharacterStream;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
* CharArrayWriter là một phiên bản của lớp output stream sử dụng một mảng làm đích đến.
* CharArrayWriter có hai hàm tạo như sau:
*
*   CharArrayWriter()
*   CharArrayWriter(int numChars)
*
* Trong hình thức đầu tiên, một bộ đệm với kích thước mặc định được tạo ra.
* Trong hình thức thứ hai, một bộ đệm được tạo ra với kích thước bằng với giá trị được chỉ định bởi numChars.
* Bộ đệm được lưu trữ trong trường buf của CharArrayWriter. Kích thước của bộ đệm sẽ được tăng tự động nếu cần thiết.
* Số ký tự được lưu trữ trong bộ đệm được chứa trong trường count của CharArrayWriter. Cả buf và count đều là các trường được bảo vệ.
* Phương thức close() không có tác dụng đối với CharArrayWriter.
*
* Ví dụ sau minh họa CharArrayWriter bằng cách thay đổi chương trình mẫu được hiển thị trước đó cho ByteArrayOutputStream.
* Nó tạo ra cùng kết quả như phiên bản trước đó.
* */
public class g_CharArrayWriter {
    public static void main(String[] args) {
        CharArrayWriter f = new CharArrayWriter();
        String s = "Đoạn chữ này sẽ kết thúc trong mảng";
        char[] buf = new char[s.length()];

        s.getChars(0, s.length(), buf, 0);

        //Vì CharArrayWriter không cần close()
        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println("Error IO: " + e);
            return;
        }

        System.out.println("Nhập dữ liệu từ mảng vào CharArrayWriter");
        System.out.println(f.toString());
        System.out.println("Gán dữ liệu cho mảng");

        char[] c = f.toCharArray();
        for(int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }

        System.out.println("Gán dữ liệu cho một FileWriter");
        try (FileWriter f2 = new FileWriter("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\src\\p_CharacterStream\\test.txt")) {
            f.writeTo(f2);
        } catch (IOException e) {
            System.out.println("Error IO: "+ e);
        }

        System.out.println("Reset sẽ đưa con trỏ về vị trí đầu của CharArrayWriter");
        f.reset();
        f.write('X');
        System.out.println("Đồng nghĩa dữ liệu bị ghi đè");
        System.out.println(f.toString());
    }
}
