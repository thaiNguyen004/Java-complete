package q_PushbackReader;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.io.PushbackReader;

/*
* PushbackReader
* Lớp PushbackReader cho phép một hoặc nhiều ký tự được trả lại vào luồng đầu vào. Điều này cho phép bạn nhìn trước
* trong luồng đầu vào. Dưới đây là hai hàm tạo của nó:
*
*   PushbackReader(Reader inputStream)
*   PushbackReader(Reader inputStream, int bufSize)
*
* Hình thức đầu tiên tạo ra một luồng được đặt bộ đệm cho phép một ký tự được đẩy trở lại. Trong hình thức thứ hai,
* kích thước của bộ đệm đẩy trở lại được truyền vào bằng tham số bufSize.
*
* Khi đóng một PushbackReader, luồng gốc được chỉ định bởi inputStream cũng sẽ được đóng.
*
* PushbackReader cung cấp phương thức unread(), cho phép trả lại một hoặc nhiều ký tự vào luồng đầu vào.
* Nó có ba hình thức như sau:
*
*   void unread(int ch) throws IOException
*   void unread(char buffer[]) throws IOException
*   void unread(char buffer[], int offset, int numChars) throws IOException
*
* Hình thức đầu tiên đẩy trở lại ký tự được truyền vào ch. Đây sẽ là ký tự tiếp theo được trả về bởi một cuộc gọi
* đến read() sau đó. Hình thức thứ hai trả về các ký tự trong buffer. Hình thức thứ ba đẩy trở lại numChars ký tự
* bắt đầu từ offset từ buffer. Một IOException sẽ được ném nếu có một sự cố khi trả lại ký tự khi bộ đệm
* đẩy trở lại đã đầy.
*
* Chương trình sau đây cải tiến ví dụ PushbackInputStream trước đó bằng cách thay thế PushbackInputStream
* bằng PushbackReader. Như trước đây, nó cho thấy cách một trình phân tích ngôn ngữ lập trình có thể sử dụng một
* luồng đẩy trở lại để xử lý sự khác biệt giữa toán tử == để so sánh và toán tử = để gán.
*
* */
public class example {
    public static void main(String[] args) {
        String code = "if(a == 4) a = 0;\n" ;
        char[] buf = new char[code.length()];
        code.getChars(0, code.length(), buf, 0);

        CharArrayReader in = new CharArrayReader(buf);
        int c;
        try (PushbackReader f = new PushbackReader(in)) {
            while((c = f.read()) != -1) {
                switch (c) {
                    case '=':
                        if((c = f.read()) == '=') {
                            System.out.print(".eq.");
                        }else {
                            System.out.print("<-");
                            f.unread(c);
                        }
                        break;
                    default:
                        System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error IO: " + e);
        }
    }
}
