package b_File;

import java.io.File;

/*
* Ví dụ sau tạo ba tệp: f1, f2 và f3.
*
* Đối tượng File đầu tiên được xây dựng với một đường dẫn thư mục là đối số duy nhất.
* Đối tượng thứ hai bao gồm hai đối số - đường dẫn và tên tệp.
* Đối tượng thứ ba bao gồm đường dẫn tệp được gán cho f1 và một tên tệp; f3 tham chiếu đến cùng một tệp như f2.
*
* File f1 = new File("/");
*
* File f2 = new File("/", "autoexec.bat");
*
* File f3 = new File(f1, "autoexec.bat");

* LƯU Ý: Java tự động xử lý các ký tự phân cách đường dẫn giữa các quy ước UNIX và Windows. Nếu bạn sử dụng dấu gạch chéo xuống (/)
* trên phiên bản Java của Windows, đường dẫn vẫn sẽ được giải quyết đúng. Hãy nhớ rằng, nếu bạn đang sử dụng quy ước Windows với ký tự
* gạch chéo ngược (\), bạn sẽ cần sử dụng chuỗi thoát (\) bên trong một chuỗi.*/
public class example {
    File f1 = new File("/");
    File f2 = new File("/", "autoexec.bat");
    File f3 = new File(f1, "autoexec.bat");
}
