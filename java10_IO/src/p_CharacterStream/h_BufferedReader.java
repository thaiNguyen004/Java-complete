package p_CharacterStream;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;

/*
* BufferedReader là một phiên bản cải tiến về hiệu suất bằng cách đặt bộ đệm cho đầu vào.
* Nó có hai hàm tạo như sau:
*   BufferedReader(Reader inputStream)
*   BufferedReader(Reader inputStream, int bufSize)
*
* Hình thức đầu tiên tạo ra một luồng ký tự được đặt bộ đệm sử dụng kích thước bộ đệm mặc định.
* Trong hình thức thứ hai, kích thước của bộ đệm được truyền vào bằng tham số bufSize.
*
* Khi đóng một BufferedReader, luồng gốc được chỉ định bởi inputStream cũng sẽ được đóng.
* Tương tự như trường hợp với luồng byte, việc đặt bộ đệm cho một luồng ký tự đầu vào cũng cung cấp nền tảng để hỗ trợ
* di chuyển ngược trong luồng trong phạm vi bộ đệm hiện có. Để hỗ trợ điều này, BufferedReader triển khai các
* phương thức mark() và reset(), và BufferedReader.markSupported() trả về true.
*
* Một tính năng được thêm vào gần đây trong BufferedReader được gọi là lines(). Nó trả về một tham chiếu Stream tới chuỗi
* các dòng được đọc bởi đọc giả. (Stream là một phần của Stream API được thảo luận trong Chương 29.)
*
* Ví dụ sau đây cải tiến ví dụ BufferedInputStream được hiển thị trước đó để sử dụng luồng ký tự BufferedReader
* thay vì luồng byte được đặt bộ đệm. Như trước đây, nó sử dụng các phương thức mark() và reset() để phân tích một luồng
* cho tham chiếu thực thể HTML cho ký hiệu bản quyền. Một tham chiếu như vậy bắt đầu bằng dấu & và kết thúc
* bằng dấu chấm phẩy (;) mà không có khoảng trắng ở giữa. Đầu vào mẫu có hai dấu & để chỉ ra trường hợp reset() xảy ra
* và trường hợp nó không xảy ra. Kết quả đầu ra giống như trước đó.*/
public class h_BufferedReader {
    public static void main(String[] args) {
        String s = "This is a &copy; copyright symbol but this is &copy not.\n";
        char[] buf = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);

        CharArrayReader in = new CharArrayReader(buf);
        int c;
        boolean marked = false;

        try (BufferedReader f = new BufferedReader(in)) {
            while((c = f.read()) != -1) {
                switch (c) {
                    case '&' :
                        if(!marked) {
                            f.mark(32);
                            marked = true;
                        }else {
                            marked = false;
                        }
                        break;
                    case ';':
                        if(marked) {
                            marked = false;
                            System.out.print("(c)");
                        } else {
                            System.out.print((char) c);
                        }
                        break;
                    case ' ':
                        if(marked) {
                            f.reset();
                            System.out.print('&');
                            marked = false;
                        }else {
                            System.out.print((char) c);
                        }
                        break;
                    default:
                        if(!marked) {
                            System.out.print((char) c);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error IO: " + e);
        }

    }
}
