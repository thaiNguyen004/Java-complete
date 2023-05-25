package h_ReadAndWriteFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Sao chép một tập tin. Để sử dụng chương trình này, hãy chỉ định tên của tệp nguồn và tệp đích.
 * Ví dụ: để sao chép một tệp có tên FIRST. TXT thành tệp có tên SECOND .TXT, sử dụng dòng lệnh sau.*/
public class b_CopyFile {
    public static void main(String[] args) throws IOException {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        //Xác nhận rằng cả hai tệp đã được chỉ định bằng câu lệnh sau:
        if(args.length != 2) {
            System.out.println("Usage: java b_CopyFile.java file_from_name file_to_name");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);
            do {
                //Đọc từng byte
                i = fin.read();
                if(i != -1) fout.write(i); //Ghi từng byte
            } while(i != -1);
        } catch (IOException e) {
            System.out.println("Error IOE: "+e.getMessage());
        } finally {
            try {
                if(fin != null) fin.close();
            } catch (IOException e) {
                System.out.println("Error closing Input file");
            }

            try {
                if(fout != null) fout.close();
            } catch (IOException e) {
                System.out.println("Error closing Output file");
            }
        }
/*
* Trong chương trình, hãy lưu ý rằng hai khối try riêng biệt được sử dụng khi đóng các tệp. Điều này đảm bảo cả hai tệp đều được đóng,
* ngay cả khi cuộc gọi fin.close() ném ra một ngoại lệ.
*
* Nói chung, hãy lưu ý rằng tất cả các lỗi I/O có thể có trong hai chương trình trước đây đều được xử lý bằng cách sử dụng các ngoại lệ.
* Điều này khác với một số ngôn ngữ máy tính sử dụng mã lỗi để báo cáo lỗi tệp. Không chỉ các ngoại lệ làm cho xử lý tệp sạch hơn,
* mà nó cũng cho phép Java dễ dàng phân biệt điều kiện cuối tệp từ lỗi tệp khi thực hiện việc nhập
* */

    }
}
