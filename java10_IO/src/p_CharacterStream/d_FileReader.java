package p_CharacterStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
* FileReader
* Lớp FileReader tạo ra một đối tượng Reader mà bạn có thể sử dụng để đọc nội dung của một tệp.
* Dưới đây là hai constructor thường được sử dụng:
*
* 1. `FileReader(String filePath)`:
* Tạo một đối tượng FileReader với đường dẫn tệp được chỉ định trong `filePath`. Phương thức này có thể ném ra
* ngoại lệ FileNotFoundException nếu không tìm thấy tệp.
*
* 2. `FileReader(File fileObj)`:
* Tạo một đối tượng FileReader với đối tượng File `fileObj` mô tả tệp. Phương thức này có thể ném ra
* ngoại lệ FileNotFoundException nếu không tìm thấy tệp.
*
* Ví dụ sau cho thấy cách đọc các dòng từ một tệp và hiển thị chúng trên thiết bị đầu ra tiêu chuẩn.
* Nó đọc tệp nguồn của chính nó, với điều kiện rằng tệp đó phải nằm trong thư mục hiện tại.
*
* */
public class d_FileReader {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\src\\p_CharacterStream\\d_FileReader.java")) {
            int c;
            //Đọc và hiển thị
            while((c = fr.read()) != -1) System.out.print((char) c);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Error IO");
        }
    }
}
