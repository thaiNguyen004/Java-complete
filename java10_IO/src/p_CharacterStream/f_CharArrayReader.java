package p_CharacterStream;

import java.io.CharArrayReader;
import java.io.IOException;

/*
*
* CharArrayReader
* CharArrayReader là một phiên bản của lớp input stream sử dụng một mảng ký tự làm nguồn dữ liệu. Lớp này có hai hàm tạo,
* mỗi hàm yêu cầu một mảng ký tự để cung cấp nguồn dữ liệu:
*
* CharArrayReader(char array[])
* CharArrayReader(char array[], int start, int numChars)
*
* Ở đây, array là nguồn dữ liệu đầu vào. Hàm tạo thứ hai tạo ra một Reader từ một phần con của mảng ký tự của bạn bắt đầu
* từ ký tự tại chỉ số được chỉ định bởi start và có độ dài là numChars.
* Phương thức close() được triển khai bởi CharArrayReader không gây ra bất kỳ ngoại lệ nào.
* Điều này là vì nó không thể thất bại.
*
* Ví dụ sau sử dụng hai CharArrayReader:
* */
public class f_CharArrayReader {
    public static void main(String[] args) {
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        char[] c = new char[tmp.length()];
        tmp.getChars(0, tmp.length(), c, 0);
        int i;

        //Đọc full mảng char
        try (CharArrayReader input1 = new CharArrayReader(c)) {
            System.out.print("input1: ");
            while((i = input1.read()) != -1) System.out.print((char) i);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error IO: " + e);
        }

        //Đọc một phần mảng char
        try (CharArrayReader input2 = new CharArrayReader(c, 0 , 5)) {
            System.out.print("input2: ");
            while((i = input2.read()) != -1) System.out.print((char) i);
        } catch (IOException e) {
            System.out.println("Error IO:"+ e);
        }
    }
}
