package h_UsingCookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
* Dưới đây là mã nguồn cho tệp GetCookiesServlet.java.
* Nó sử dụng phương thức getCookies() để đọc bất kỳ cookie nào được bao gồm trong yêu cầu HTTP GET.
* Tên và giá trị của các cookie này sau đó được ghi vào phản hồi HTTP.
*
* Lưu ý rằng các phương thức getName() và getValue() được gọi để lấy thông tin này.
*
* */
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy một mảng các Cookie từ tiêu đề của yêu cầu HTTP
        Cookie[] cookies = req.getCookies();

        // Hiển thị các cookies
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<b>");
        for (int i = 0; i < cookies.length; i++) {
            String name = cookies[i].getName();
            String value = cookies[i].getValue();
            pw.println("name = " + name + "; value = " + value);
        }
        pw.close();
    }
}
/*
* Biên dịch các servlet. Sau đó, sao chép chúng vào thư mục thích hợp và cập nhật tệp web.xml như đã mô tả trước đây.
* Tiếp theo, thực hiện các bước sau để kiểm thử ví dụ này:
* 1. Khởi động Tomcat nếu chưa được chạy.
* 2. Hiển thị tệp AddCookie.html trong trình duyệt.
* 3. Nhập giá trị cho MyCookie.
* 4. Gửi trang web.
* Sau khi hoàn thành các bước này, bạn sẽ thấy một thông báo phản hồi được hiển thị bởi trình duyệt.
* Tiếp theo, yêu cầu URL sau qua trình duyệt:
* http://localhost:8080/examples/servlets/servlet/GetCookiesServlet
* Quan sát rằng tên và giá trị của cookie được hiển thị trong trình duyệt.
* Trong ví dụ này, không gán một ngày hết hạn cho cookie một cách rõ ràng thông qua phương thức setMaxAge() của Cookie.
* Do đó, cookie sẽ hết hạn khi phiên trình duyệt kết thúc.
* Bạn có thể thử nghiệm bằng cách sử dụng setMaxAge() và quan sát rằng cookie sau đó được lưu trên máy khách.
* */