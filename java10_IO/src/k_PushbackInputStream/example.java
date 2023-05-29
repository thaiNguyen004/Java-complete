package k_PushbackInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/*
* PushbackInputStream
* Một trong những cách sáng tạo sử dụng đệm là triển khai pushback. Pushback được sử dụng trên một luồng đầu vào để cho phép
* một byte được đọc và sau đó được trả lại (được "pushed back") vào luồng. Lớp PushbackInputStream thực hiện ý tưởng này.
* Nó cung cấp cơ chế "nhìn trước" những gì đang đến từ một luồng đầu vào mà không làm gián đoạn nó.
*
* PushbackInputStream có các hàm tạo sau đây:
*   PushbackInputStream(InputStream inputStream)
*   PushbackInputStream(InputStream inputStream, int numBytes)
*
* Biểu thức đầu tiên tạo một đối tượng luồng cho phép một byte được trả lại vào luồng đầu vào.
* Biểu thức thứ hai tạo một luồng có một bộ đệm pushback có độ dài numBytes. Điều này cho phép nhiều byte
* được trả lại vào luồng đầu vào.
*
* Ngoài các phương thức quen thuộc của InputStream, PushbackInputStream cung cấp phương thức unread(),
* được trình bày dưới đây:
*
* void unread(int b)
* void unread(byte buffer [ ])
* void unread(byte buffer, int offset, int numBytes)
*
* Biểu thức đầu tiên đẩy lại byte có giá trị thấp nhất của b. Byte này sẽ là byte tiếp theo được trả về trong cuộc gọi read() sau đó.
* Biểu thức thứ hai đẩy lại các byte trong buffer. Biểu thức thứ ba đẩy lại numBytes byte bắt đầu từ offset trong buffer.
*
* Một IOException sẽ được ném ra nếu có sự cố trong việc đẩy lại một byte khi bộ đệm pushback đã đầy.
*
*
* Dưới đây là một ví dụ minh họa về cách một trình phân tích ngôn ngữ lập trình có thể sử dụng PushbackInputStream
* và phương thức unread() để xử lý sự khác biệt giữa toán tử = = để so sánh và toán tử = để gán:
* */
public class example {
    public static void main(String[] args) throws IOException {
        String code = "if (a == 4) a = 0;\n";
        byte[] buf = code.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        int c;

        try (PushbackInputStream f = new PushbackInputStream(in)) {
            //Làm mất khả năng mark và reset của InputStream được dùng để tạo ra PushbackInputStream
            System.out.println(f.markSupported());
            while ((c = f.read()) != -1) {
                switch (c) {
                    case '=' :
                        if((c = f.read()) == '=') {
                            System.out.print(".eq.");
                        }else {
                            System.out.print("<-");
                            f.unread(c); // Lần gọi read tiếp theo sẽ đọc c
                        }
                        break;
                    default :
                        System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("I.O Error: " + e);
        }
        /*
        * CẢNH BÁO: PushbackInputStream có tác dụng phụ là làm mất hiệu lực các phương thức mark() hoặc reset() của
        * InputStream được sử dụng để tạo ra nó. Hãy sử dụng markSupported() để kiểm tra bất kỳ luồng nào mà bạn định
        * sử dụng mark()/reset() trên đó.*/
    }
}
