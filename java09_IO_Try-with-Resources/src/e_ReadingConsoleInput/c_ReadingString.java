package e_ReadingConsoleInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* Để đọc một chuỗi từ bàn phím, sử dụng phiên bản của `readLine()` thuộc lớp `BufferedReader`. Hình thức chung của nó được thể hiện dưới đây:
*   `String readLine() throws IOException`
* Như bạn có thể thấy, nó trả về một đối tượng `String`.
* Chương trình sau minh họa việc sử dụng `BufferedReader` và phương thức `readLine()`;
* chương trình đọc và hiển thị các dòng văn bản cho đến khi bạn nhập từ "stop":
* */
public class c_ReadingString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        System.out.println("Nhập chuỗi kí tự.");
        System.out.println("Nhập \"stop\" để thoát.");

        do {
            str = br.readLine();
            System.out.println(str);
        } while(!str.equals("stop"));

        /*
        * Ví dụ tiếp theo tạo ra một trình soạn thảo văn bản nhỏ. Nó tạo ra một mảng các đối tượng String và sau đó đọc
        * các dòng văn bản, lưu trữ mỗi dòng vào mảng. Nó sẽ đọc tối đa 100 dòng hoặc cho đến khi bạn nhập "stop".
        * Nó sử dụng một BufferedReader để đọc từ bàn phím.*/

        //Tạo ra một mảng String
        String[] strs = new String[100];
        System.out.println("Nhập đoạn văn không quá 100 dòng");
        System.out.println("Nhập stop để dừng.");

        for(int i = 0; i < 100; i++) {
            strs[i] = br.readLine();
            if(strs[i].equals("stop")) break;
        }

        System.out.println("Hiển thị đoạn văn.");
        for (int i = 0; i < 100; i++) {
            if(strs[i].equals("stop")) break;
            System.out.println(strs[i]);
        }
    }
}
