package c_Directories;

import java.io.File;

/**
 * Thư mục
 * Một thư mục là một File chứa một danh sách các tệp và thư mục khác. Khi bạn tạo một đối tượng File là một thư mục,
 * phương thức isDirectory() sẽ trả về true. Trong trường hợp này, bạn có thể gọi list() trên đối tượng đó để
 * trích xuất danh sách các tệp và thư mục bên trong. Phương thức này có hai dạng.
 * Dạng đầu tiên được mô tả như sau:
 * <p>
 * TODO       String[] list()
 * <p>
 * Danh sách các tệp được trả về dưới dạng một mảng các đối tượng String.
 * Chương trình dưới đây minh họa cách sử dụng list() để xem nội dung của một thư mục:
 */

public class a_example {
    public static void main(String[] args) {
        File java = new File("E:\\Studyspace\\Java\\source\\GeoryComplete\\java10_IO\\java");
        if (java.isDirectory()) {
            String[] files = java.list();
            for (String file : files) {
                System.out.println(file);
            }
        }
    }
}
