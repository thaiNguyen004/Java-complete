package g_StreamClasses;

import java.io.ByteArrayInputStream;

/*
* ByteArrayInputStream là một lớp triển khai của lớp input stream sử dụng một mảng byte làm nguồn dữ liệu.
* Lớp này có hai constructor, mỗi constructor đều yêu cầu một mảng byte làm nguồn dữ liệu:
*
todo    ByteArrayInputStream(byte array[]):
* Constructor này tạo ra một InputStream từ một mảng byte đã cho.
*
todo    ByteArrayInputStream(byte array[], int start, int numBytes):
* Constructor này tạo ra một InputStream từ một phần của mảng byte, bắt đầu từ vị trí chỉ định bởi start và có độ dài là numBytes.
*
* Phương thức close() không có tác dụng đối với ByteArrayInputStream. Do đó, không cần gọi close() trên ByteArrayInputStream,
* nhưng việc gọi close() cũng không gây lỗi.
*
* Ví dụ sau tạo ra một cặp ByteArrayInputStreams, khởi tạo chúng với biểu diễn byte của bảng chữ cái (alphabet).
* */
public class g_ByteArrayInputStream {
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        byte[] buf = alphabet.getBytes();

        ByteArrayInputStream input1 = new ByteArrayInputStream(buf);
        ByteArrayInputStream input2 = new ByteArrayInputStream(buf, 0, 3);

        /*
        * Đối tượng input1 chứa toàn bộ bảng chữ cái thường (lowercase alphabet), trong khi input2 chỉ chứa ba chữ cái đầu tiên.
        *
        * Một ByteArrayInputStream triển khai cả phương thức mark() và reset(). Tuy nhiên, nếu mark() chưa được gọi,
        * thì reset() sẽ đặt con trỏ của luồng về vị trí đầu tiên của luồng - trong trường hợp này là vị trí đầu tiên của
        * mảng byte được truyền vào constructor.
        *
        * Ví dụ sau cho thấy cách sử dụng phương thức reset() để đọc dữ liệu hai lần. Trong trường hợp này, chương trình
        * đọc và in ra chuỗi "abc" một lần ở dạng chữ thường và sau đó một lần ở dạng chữ hoa được thực hiện trên input2
        * */

        for(int i = 0; i < 2; i++) {
            int c;
            while((c = input2.read()) != -1) {
                if(i == 0) {
                    System.out.println((char) c);
                }else {
                    System.out.println(Character.toUpperCase((char) c));
                }
            }
            System.out.println();
            input2.reset();
        }
        /*
        * Ví dụ này trước tiên đọc từng ký tự từ luồng và in ra ký tự đó ở dạng chữ thường. Sau đó, nó thiết lập lại luồng
        * và bắt đầu đọc lại, lần này chuyển đổi mỗi ký tự thành chữ hoa trước khi in ra. Đây là kết quả đầu ra:
            abc
            ABC
        */
    }
}
