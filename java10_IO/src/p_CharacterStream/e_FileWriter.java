package p_CharacterStream;

import java.io.FileWriter;
import java.io.IOException;

/*
* FileWriter
* FileWriter tạo ra một đối tượng Writer mà bạn có thể sử dụng để ghi vào một tệp. Dưới đây là bốn constructor
* thường được sử dụng:
*
* 1. `FileWriter(String filePath)`:
* Tạo một đối tượng FileWriter với đường dẫn tệp được chỉ định trong `filePath`.
* Phương thức này có thể ném ra ngoại lệ IOException.
*
* 2. `FileWriter(String filePath, boolean append)`:
* Tạo một đối tượng FileWriter với đường dẫn tệp được chỉ định trong `filePath`.
* Nếu `append` là `true`, dữ liệu được ghi thêm vào cuối tệp. Phương thức này có thể ném ra ngoại lệ IOException.
*
* 3. `FileWriter(File fileObj)`:
* Tạo một đối tượng FileWriter với đối tượng File `fileObj` mô tả tệp.
* Phương thức này có thể ném ra ngoại lệ IOException.
*
* 4. `FileWriter(File fileObj, boolean append)`:
* Tạo một đối tượng FileWriter với đối tượng File `fileObj` mô tả tệp. Nếu `append` là `true`,
* dữ liệu được ghi thêm vào cuối tệp. Phương thức này có thể ném ra ngoại lệ IOException.
*
* Việc tạo ra một FileWriter không phụ thuộc vào việc tệp đã tồn tại hay chưa. FileWriter sẽ tạo ra tệp trước khi
* mở nó để ghi khi bạn tạo đối tượng. Trong trường hợp bạn cố gắng mở một tệp chỉ có quyền đọc,
* một ngoại lệ IOException sẽ được ném ra.
*
* Ví dụ sau là một phiên bản dòng ký tự của một ví dụ đã được đề cập trước đó khi nói về FileOutputStream.
* Phiên bản này tạo một bộ đệm ký tự mẫu bằng cách tạo một chuỗi và sau đó sử dụng phương thức getChars()
* để trích xuất mảng ký tự tương đương. Sau đó, nó tạo ba tệp.
* Tệp đầu tiên, file1.txt, sẽ chứa từng ký tự khác nhau từ bộ mẫu.
* Tệp thứ hai, file2.txt, sẽ chứa toàn bộ tập ký tự.
* Cuối cùng, tệp thứ ba, file3.txt, sẽ chỉ chứa một phần tư cuối cùng.
*
* */
public class e_FileWriter {
    public static void main(String[] args) {
        String source = "Bây giờ là lúc để tất cả những người đàn ông tốt đến giúp đỡ " +
                "đất nước của họ và nộp thuế đúng hạn";

        char[] buffer = new char[source.length()];
        source.getChars(0, source.length(), buffer, 0);

        try (FileWriter f0 =
                     new FileWriter("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\src\\p_CharacterStream\\file1.txt");
             FileWriter f1 =
                     new FileWriter("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\src\\p_CharacterStream\\file2.txt");
             FileWriter f2 =
                     new FileWriter("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\src\\p_CharacterStream\\file3.txt");)
        {
            //Nhập dữ liệu vào file thứ nhất
            for(int i = 0; i < source.length(); i++) {
                f0.write(buffer[i]);
            }

            //Nhập dữ liệu cho file thứ hai
            f1.write(buffer);

            //Nhập dữ liệu cho file thứ ba
            f2.write(buffer, buffer.length - buffer.length / 4, buffer.length / 4);

        } catch (IOException e) {
            System.out.println("Error IO: "+ e.getMessage());
        }
    }
}
