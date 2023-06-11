package e_URLConnection;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*
* URLConnection là một lớp đa năng để truy cập các thuộc tính của một tài nguyên từ xa.
* Sau khi bạn thiết lập kết nối đến một máy chủ từ xa, bạn có thể sử dụng URLConnection
* để kiểm tra các thuộc tính của đối tượng từ xa trước khi thực sự chuyển nó vào bộ nhớ cục bộ.
* Các thuộc tính này được tiết lộ bởi thông số kỹ thuật giao thức HTTP, vì vậy,
* chỉ hợp lý đối với các đối tượng URL đang sử dụng giao thức HTTP.
*
* URLConnection xác định một số phương thức. Dưới đây là một số phương thức mẫu:
*
* 1. `int getContentLength()`:
* Phương thức này trả về độ dài của nội dung từ kết nối, dưới dạng một số nguyên.
* Nó chỉ định số byte trong nội dung mà bạn có thể đọc từ kết nối.
*
* 2. `long getContentLengthLong()`:
* Tương tự như phương thức `getContentLength()`, nhưng trả về độ dài của
* nội dung từ kết nối dưới dạng một số long. Phương thức này hữu ích khi độ dài của
* nội dung vượt quá giới hạn của kiểu dữ liệu int.
*
* 3. `String getContentType()`:
* Phương thức này trả về kiểu nội dung của tài nguyên từ kết nối.
* Ví dụ, nó có thể trả về "text/html" cho tệp HTML hoặc "image/jpeg" cho một hình ảnh JPEG.
*
* 4. `long getDate()`:
* Phương thức này trả về thời điểm tài nguyên được tạo hoặc sửa đổi lần cuối từ kết nối,
* dưới dạng một giá trị thời gian Unix.
*
* 5. `long getExpiration()`:
* Phương thức này trả về thời gian hết hạn của tài nguyên từ kết nối, dưới dạng một giá trị thời gian Unix.
* Nếu không có thông tin về thời gian hết hạn, phương thức trả về giá trị -1.
*
* 6. `String getHeaderField(int idx)`:
* Phương thức này trả về giá trị của trường tiêu đề với chỉ mục cụ thể từ kết nối.
* Chỉ mục 0 tương ứng với trường tiêu đề đầu tiên.
*
* 7. `String getHeaderField(String fieldName)`:
* Phương thức này trả về giá trị của trường tiêu đề với tên cụ thể từ kết nối.
* Ví dụ, bạn có thể sử dụng "Content-Type" để lấy giá trị kiểu nội dung.

8. `String getHeaderFieldKey(int idx)`:
* Phương thức này trả về tên của trường tiêu đề với chỉ mục cụ thể từ kết nối.
* Chỉ mục 0 tương ứng với tên trường tiêu đề đầu tiên.
*
* 9. `Map<String, List<String>> getHeaderFields()`:
* Phương thức này trả về một bản đồ (Map) chứa tất cả các trường tiêu đề và giá trị tương ứng từ kết nối.
* Mỗi tên trường tiêu đề được đại diện bởi một khóa (key) trong bản đồ và các giá trị liên quan được đại diện bởi danh sách (List).
*
* 10. `long getLastModified()`: Phương thức này trả về thời điểm tài nguyên được sửa đổi lần cuối từ kết nối,
* dưới dạng một giá trị thời gian Unix.
*
* 11. `getInputStream()`:
* Trả về một luồng đầu vào (InputStream). Luồng đầu vào này được sử dụng để đọc dữ liệu từ tài nguyên từ xa mà kết nối đang đại diện.
*
* Lưu ý rằng URLConnection xác định một số phương thức để xử lý thông tin tiêu đề.
* Một tiêu đề bao gồm các cặp khóa và giá trị được biểu diễn dưới dạng chuỗi. Bằng cách sử dụng phương thức getHeaderField(),
* bạn có thể lấy giá trị liên kết với một khóa tiêu đề. Bằng cách gọi phương thức getHeaderFields(), bạn có thể lấy một bản đồ (map)
* chứa tất cả các tiêu đề. Một số trường tiêu đề tiêu chuẩn có sẵn thông qua các phương thức như getDate() và getContentType().
*
* Ví dụ sau tạo một URLConnection bằng cách sử dụng phương thức openConnection() của đối tượng URL, sau đó sử dụng nó để
* xem xét các thuộc tính và nội dung của tài liệu:
*
* */
public class geory_example {
    public static void main(String[] args) throws Exception {
        int c;
        URL hp = new URL("http://www.internic.net");
        URLConnection hpCon = hp.openConnection();

        //getDate
        long d = hpCon.getDate();
        if (d == 0)
            System.out.println("Không có thông tin thời gian");
        else
            System.out.println("Date: " + new Date(d));

        // get content type
        System.out.println("Content-type: " + hpCon.getContentType());

        // get head field
        System.out.println("Trường tiêu đề đầu tiên: " + hpCon.getHeaderField(0));

        // get giá trường tiêu đề cụ thể bằng tên
        System.out.println("Giá trị của trường tiêu đề Date: " + hpCon.getHeaderField("Date"));

        // get map head field -> key tương ứng với tên của trường tiêu đề và value là giá trị
        System.out.println("Một Map chứa các trường tiêu đề: ");
        Map<String, List<String>> mapheadfields = hpCon.getHeaderFields();
        mapheadfields.forEach((k,v) -> System.out.println("Trường tiêu đề: " + k +"- Value: " + v));
        System.out.println();


        // get expiration date
        d = hpCon.getExpiration();
        if (d == 0)
            System.out.println("Không có thông tin thời gian hết hạn");
        else
            System.out.println("Expiration: " + new Date(d));

        // get last-modified date
        d = hpCon.getLastModified();
        if (d == 0)
            System.out.println("Không có thông tin về thay đổi gần nhất");
        else
            System.out.println("Last-modified: " + new Date(d));

        // get content length
        long len = hpCon.getContentLengthLong();
        if (len == 0)
            System.out.println("Content length unavailable (không có sẵn)");
        else
            System.out.println("Content length: " + len);

        if(len != 0) {
            System.out.println("=== Content ===");
            InputStream input = hpCon.getInputStream();
            while((c = input.read()) != -1) {
                System.out.print((char) c);
            }
            input.close();
        } else {
            System.out.println("Không có sẵn nội dung");
        }


    }
}
