package e_ReadingConsoleInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* Để đọc một ký tự từ `BufferedReader`, sử dụng phương thức `read()`. Phiên bản của `read()` mà chúng ta sẽ sử dụng là:
*       int read() throws IOException
*
* Mỗi lần gọi `read()`, nó sẽ đọc một ký tự từ luồng dữ liệu vào và trả về giá trị số nguyên tương ứng.
* Khi thử đọc từ cuối luồng dữ liệu, nó sẽ trả về -1. Như bạn thấy, nó có thể gây ra ngoại lệ IOException.
*
* Chương trình sau minh họa việc sử dụng `read()` bằng cách đọc các ký tự từ console cho đến khi người dùng gõ "q".
* Lưu ý rằng bất kỳ ngoại lệ I/O nào có thể xảy ra đều được ném ra khỏi phương thức `main()`.
* Tiếp cận này thường được sử dụng khi đọc từ console trong các chương trình ví dụ đơn giản như trong cuốn sách này,
* tuy nhiên trong các ứng dụng phức tạp hơn, bạn có thể xử lý các ngoại lệ một cách rõ ràng.*/
public class b_ReadingCharacter {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhấn 1 kí tự, 'q' để thoát.");

        //read characters
        do {
            c = (char)br.read();
            System.out.println(c);
        } while(c != 'q');
    }
    /*
    * Đầu ra có thể trông hơi khác so với những gì bạn mong đợi vì `System.in` mặc định là dạng line buffered (được đệm theo dòng).
    * Điều này có nghĩa là không có dữ liệu đầu vào được truyền đến chương trình cho đến khi bạn nhấn phím Enter.
    * Như bạn có thể đoán, điều này làm cho `read()` không quá hữu ích cho việc nhập từ bàn phím trong chế độ tương tác trực tiếp.*/
}
