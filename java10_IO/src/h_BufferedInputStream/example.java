package h_BufferedInputStream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/*
 * Đệm một luồng đầu vào cũng cung cấp nền tảng cần thiết để hỗ trợ di chuyển ngược trong luồng của bộ đệm hiện có.
 * Ngoài các phương thức read() và skip() được thực hiện trong bất kỳ InputStream nào, BufferedInputStream cũng hỗ trợ các
 * phương thức mark() và reset().
 * Hỗ trợ này được phản ánh thông qua việc phương thức BufferedInputStream.markSupported() trả về giá trị true.
 *
 * Ví dụ sau đây tạo ra một tình huống mà chúng ta có thể sử dụng mark() để ghi nhớ vị trí hiện tại trong một luồng đầu vào
 * và sau đó sử dụng reset() để quay lại vị trí đó. Ví dụ này đang phân tích một luồng để tìm tham chiếu thực thể HTML
 * cho ký hiệu bản quyền. Một tham chiếu như vậy bắt đầu bằng dấu và (&) và kết thúc bằng dấu chấm phẩy (;) mà không có
 * khoảng trắng ở giữa. Vào lúc này, đầu vào mẫu có hai dấu và để thể hiện trường hợp reset() xảy ra và không xảy ra.
 * */
public class example {
    public static void main(String[] args) throws IOException {
        String s = "This is a &copy; copyright symbol " +
                "but this is &copy not .\n";
        byte[] buf = s.getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        int c;
        boolean marked = false;

        //Use try-with-resources để quản lý file
        try (BufferedInputStream f = new BufferedInputStream(in)) {
            while ((c = f.read()) != -1) {
                switch (c) {
                    case '&':
                        if (!marked) {
                            f.mark(32);
                            marked = true;
                        } else {
                            marked = false;
                        }
                        break;
                    case ';':
                        if (marked) {
                            marked = false;
                            System.out.print("(c)");
                        } else {
                            System.out.print((char) c);
                        }
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            f.reset();
                            System.out.print("&");
                        } else {
                            System.out.print((char) c);
                        }
                        break;
                    default:
                        if (!marked) {
                            System.out.print((char) c);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        /*
        * Trong ví dụ trên, `mark(32)` có nghĩa là chúng ta đánh dấu vị trí hiện tại trong luồng và lưu trữ thông tin đánh dấu
        * cho 32 byte tiếp theo. Điều này có nghĩa là chúng ta có thể di chuyển ngược trong luồng tối đa 32 byte từ vị trí
        * đánh dấu trước khi thông tin đánh dấu bị mất đi.
        *
        * Khi sử dụng phương thức `reset()`, chúng ta sẽ quay lại vị trí đã được đánh dấu trước đó.
        * Trong trường hợp này, 32 byte đủ để bao gồm tất cả các tham chiếu thực thể HTML có thể xuất hiện trong dữ liệu.
        * */
    }
}
