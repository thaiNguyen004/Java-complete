package c_Directories;

/*
* Sử dụng FilenameFilter
* Bạn thường muốn giới hạn số lượng tệp được trả về bởi phương thức list() chỉ bao gồm các tệp phù hợp với một mẫu tên tệp
* nhất định hoặc bộ lọc.
* Để làm điều này, bạn phải sử dụng một dạng thứ hai của list(), được mô tả như sau:
*
* TODO        String[] list(FilenameFilter FFObj)
*
* Trong dạng này, FFObj là một đối tượng của một lớp thực hiện giao diện FilenameFilter.
* FilenameFilter chỉ định một phương thức duy nhất, accept(), được gọi một lần cho mỗi tệp trong danh sách.
* Dạng tổng quát của nó được mô tả như sau:
*
TODO        boolean accept(File directory, String filename)
*
* Phương thức accept() trả về true cho các tệp trong thư mục được chỉ định bởi directory mà nên được bao gồm trong danh sách
* (tức là các tệp phù hợp với đối số filename) và trả về false cho các tệp không nên được bao gồm.
*
* Lớp OnlyExt được hiển thị dưới đây triển khai FilenameFilter. Nó sẽ được sử dụng để chỉnh sửa chương trình trước để hạn chế sự hiển thị
* của các tên tệp được trả về bởi list() chỉ cho các tệp có tên kết thúc bằng phần mở rộng tệp được chỉ định khi đối tượng được xây dựng.*/

import java.io.File;
import java.io.FilenameFilter;

class OnlyExt implements FilenameFilter {
    String ext; //Viết tắt của extension là phần mở rộng của tên tệp ví dụ : .jpg .java .jar

    public OnlyExt (String ext) {
        this.ext = "." + ext;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}

public class b_FilenameFilter {
    public static void main(String[] args) {
        String dirname = "java";
        File f1 = new File(dirname);
        FilenameFilter only = new OnlyExt("html");
        String[] s = f1.list(only);

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

    }
}
