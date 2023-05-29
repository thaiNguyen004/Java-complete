package c_Directories;

import java.io.File;

/*
* Tạo Thư mục
* Hai phương thức tiện ích File khác hữu ích là mkdir() và mkdirs(). Phương thức mkdir() tạo một thư mục, trả về true nếu
* thành công và false nếu thất bại. Thất bại có thể xảy ra vì nhiều lý do, như đường dẫn đã được chỉ định trong đối tượng File
* đã tồn tại, hoặc thư mục không thể tạo vì toàn bộ đường dẫn chưa tồn tại. Để tạo một thư mục mà không có đường dẫn tồn tại,
* sử dụng phương thức mkdirs(). Nó tạo cả thư mục và tất cả các thư mục cha của thư mục đó.*/
public class d_CreatingDirectory {
    public static void main(String[] args) {
        //1
        File f1 = new File("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\src\\c_Directories\\newDirectory");
        System.out.println(f1.mkdir());

        //2
        File f2 = new File("E:\\Parent\\Children\\Next\\NguyenThaiNguyen");
        //Ở trường hợp trên các thư mục đều chưa tồn tại
        System.out.println(f2.mkdir()); //false
        System.out.println(f2.mkdirs()); //true

    }
}
