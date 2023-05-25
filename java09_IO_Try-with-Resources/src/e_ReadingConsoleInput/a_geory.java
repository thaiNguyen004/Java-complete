package e_ReadingConsoleInput;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
* Đọc đầu vào từ Console
* Trong những ngày đầu của Java, cách duy nhất để thực hiện đầu vào từ console là sử dụng một luồng byte.
* Ngày nay, việc sử dụng luồng byte để đọc đầu vào từ console vẫn được chấp nhận.
*
* Tuy nhiên, đối với các ứng dụng thương mại, phương pháp ưu tiên để đọc đầu vào từ console là sử dụng một luồng dựa trên ký tự.
* Điều này làm cho chương trình của bạn dễ dàng quốc tế hóa và bảo trì hơn.
* Trong Java, đầu vào từ console được thực hiện bằng cách đọc từ System.in. Để có một luồng dựa trên ký tự được kết nối với console,
* bọc System.in trong một đối tượng BufferedReader. BufferedReader hỗ trợ một luồng đầu vào được đệm.
* Một constructor thường được sử dụng được hiển thị ở đây:
*   BufferedReader(Reader inputReader)
* Ở đây, inputReader là luồng được liên kết với phiên bản BufferedReader đang được tạo ra.
* Reader là một lớp trừu tượng. Một trong số các lớp con cụ thể của nó là InputStreamReader,
* chuyển đổi byte thành ký tự. Để có một đối tượng InputStreamReader được liên kết với System.in, sử dụng constructor sau:
*   InputStreamReader(InputStream inputStream)
* Bởi vì System.in tham chiếu đến một đối tượng kiểu InputStream, nó có thể được sử dụng cho inputStream.
* Kết hợp tất cả lại, dòng code sau tạo ra một đối tượng BufferedReader được kết nối với bàn phím:
*   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
*
* Sau khi câu lệnh này được thực hiện, biến `br` sẽ là một luồng dữ liệu dựa trên ký tự được kết nối
* với console thông qua `System.in`.
*/
public class a_geory {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}
