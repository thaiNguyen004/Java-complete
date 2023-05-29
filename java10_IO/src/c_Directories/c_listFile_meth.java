package c_Directories;

import java.io.File;
import java.io.FilenameFilter;

/*
* Sự thay thế bằng phương thức listFiles()
* Có một biến thể của phương thức list() gọi là listFiles()
* mà bạn có thể thấy hữu ích. Các phiên bản cho listFiles() được hiển thị như sau:
*
TODO       File[] listFiles()
TODO       File[] listFiles(FilenameFilter FFObj)
TODO       File[] listFiles(FileFilter FObj)
*
* Các phương thức này trả về danh sách tệp dưới dạng một mảng các đối tượng File thay vì chuỗi. Phương thức đầu tiên trả về
* tất cả các tệp, và phương thức thứ hai trả về những tệp thỏa mãn FilenameFilter được chỉ định. Ngoài việc trả về một mảng
* các đối tượng File, hai phiên bản listFiles() này hoạt động tương tự như các phiên bản tương ứng của phương thức list().
*
* Phiên bản thứ ba của listFiles() trả về những tệp với tên đường dẫn thỏa mãn FileFilter được chỉ định.
* FileFilter chỉ định duy nhất một phương thức là accept(), được gọi một lần cho mỗi tệp trong danh sách.
* Dạng tổng quát của accept() được mô tả như sau:
*
TODO       boolean accept(File path)
*
* Phương thức accept() trả về true cho các tệp nên được bao gồm trong danh sách (tức là các tệp phù hợp với đối số path),
* và trả về false cho những tệp nên bị loại trừ.*/
public class c_listFile_meth {
    public static void main(String[] args) {
        String dirname = "E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\java";
        File f1 = new File(dirname);

        if(f1.isDirectory()) {
            File[] files = f1.listFiles(new OnlyExt("html"));
            for (File file : files) {
                System.out.println(file);
            }
            /*
            * E:\Studyspace\Java\source\GeoryComplete\java10_IO\java\dir
              E:\Studyspace\Java\source\GeoryComplete\java10_IO\java\FileExcel.mpp
              E:\Studyspace\Java\source\GeoryComplete\java10_IO\java\FileWord.rtf
              E:\Studyspace\Java\source\GeoryComplete\java10_IO\java\index.html
              E:\Studyspace\Java\source\GeoryComplete\java10_IO\java\NEWNAME.txt*/
        }
    }
}

class OnlyExc implements FilenameFilter {
    String exc;

    OnlyExc (String exc) {
        this.exc = "." + exc;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(exc);
    }
}