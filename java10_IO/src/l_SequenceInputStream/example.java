package l_SequenceInputStream;
/*
* SequenceInputStream
*
* Lớp SequenceInputStream cho phép bạn ghép nối nhiều InputStream lại với nhau. Việc tạo đối tượng SequenceInputStream khác
* với bất kỳ InputStream nào khác. Một constructor của SequenceInputStream sử dụng cặp InputStream
* hoặc một Enumeration của InputStreams làm đối số:
*
*   SequenceInputStream(InputStream first, InputStream second)
*   SequenceInputStream(Enumeration <? extends InputStream> streamEnum)
*
* Về mặt hoạt động, lớp này đọc các yêu cầu từ InputStream đầu tiên cho đến khi nó hết dữ liệu, sau đó chuyển sang InputStream thứ hai.
* Trong trường hợp sử dụng Enumeration, nó sẽ tiếp tục qua tất cả các InputStream cho đến khi đến cuối cùng của InputStream cuối cùng.
* Khi đến cuối của mỗi tệp, luồng tương ứng của nó sẽ được đóng. Việc đóng luồng tạo bởi SequenceInputStream làm đóng tất cả các luồng chưa được đóng.
* Dưới đây là một ví dụ đơn giản sử dụng SequenceInputStream để xuất nội dung của hai tệp. Cho mục đích minh họa, chương trình này sử dụng kỹ thuật
* truyền thống để đóng một tệp. Như một bài tập, bạn có thể thử thay đổi nó để sử dụng câu lệnh try-with-resources.
*
* Trước khi làm ví dụ ta cùng đi qua khái niệm về Enumration
*
* Enumeration trong Java là một interface được sử dụng để lặp qua các phần tử của một tập hợp dữ liệu như một danh sách,
* mảng hoặc bất kỳ cấu trúc dữ liệu nào khác có thể được duyệt qua các phần tử tuần tự. Một đối tượng Enumeration chỉ
* có thể được sử dụng để duyệt qua các phần tử của tập hợp, không thể thay đổi nội dung của tập hợp.
*
*   Interface Enumeration chứa hai phương thức chính sau đây:
*
* boolean hasMoreElements(): Kiểm tra xem còn phần tử nào trong tập hợp để duyệt qua hay không. Trả về true nếu còn phần tử,
* false nếu không còn.
* Object nextElement(): Trả về phần tử tiếp theo trong tập hợp. Nếu không còn phần tử, sẽ ném ra một ngoại lệ NoSuchElementException.
*
* Trong ngữ cảnh của lớp SequenceInputStream, Enumeration<? extends InputStream> được sử dụng để liệt kê các InputStream
* để ghép nối. Điều này có nghĩa là chúng ta có thể chuyển một Enumeration của InputStreams vào constructor của SequenceInputStream
* để liên kết các InputStream với nhau theo thứ tự được chỉ định.
* */

import java.io.*;
import java.util.*;

class InputStreamEnumrator implements Enumeration<FileInputStream> {
    private Enumeration<String> files;

    public InputStreamEnumrator(Vector<String> files) {
        //Phương thức elements() trong lớp Vector được sử dụng để trả về một đối tượng Enumeration
        //cho các phần tử trong Vector.
        this.files = files.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement(){
        try {
            return new FileInputStream(files.nextElement().toString());
        } catch (IOException e) {
            return null;
        }
    }
}

public class example {
    public static void main(String[] args) throws IOException{
        int c;
        Vector<String> files = new Vector<>();

        files.add("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\file4");
        files.add("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\file5");
        files.add("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\file6");

        InputStreamEnumrator ise = new InputStreamEnumrator(files);
        //Khởi tạo một SequenceInputStream(Enumeration <? extends InputStream> streamEnum)
        InputStream input = new SequenceInputStream(ise);

        try {
            while((c = input.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (NullPointerException e) {
            System.out.println("Error Opening File");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println("Error Closing File");
            }
        }
        /*Lưu ý trong nextElement() rằng nếu một tệp không thể mở, null sẽ được trả về. Điều này dẫn đến NullPointerException,
        được bắt trong main().*/
    }
}
