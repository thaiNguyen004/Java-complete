package c_SimpleServlet;
/**
 * Chi tiết hướng dẫn trước "SimpleServlet.java"
 */

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.*;
public class HelloServlet extends GenericServlet {
    // phương thức service() sử lý các yêu cầu từ phía khách hàng
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException
    {
        // Phương thức setContentType giúp thiết lập MIME của phản hồi HTTP
        servletResponse.setContentType("text/html");
        PrintWriter pw = servletResponse.getWriter();
        pw.println("<B>Hello!");
        pw.close();
    }
}

/*
 * Hãy xem kỹ chương trình này. Đầu tiên, lưu ý rằng nó import gói javax.servlet. Gói này chứa các lớp và giao diện
 * cần thiết để xây dựng servlet. Bạn sẽ tìm hiểu thêm về chúng sau trong chương này.
 *
 * Tiếp theo, chương trình định nghĩa HelloServlet như một lớp con của GenericServlet. Lớp GenericServlet cung cấp chức
 * năng giúp đơn giản hóa việc tạo ra một servlet. Ví dụ, nó cung cấp các phiên bản của init() và destroy(), có thể được
 * sử dụng như đã được định nghĩa sẵn. Bạn chỉ cần cung cấp phương thức service().
 *
 * Trong HelloServlet, phương thức service() (được kế thừa từ GenericServlet) được ghi đè. Phương thức này xử lý các
 * yêu cầu từ phía khách hàng. Lưu ý rằng đối số đầu tiên là một đối tượng ServletRequest. Điều này cho phép servlet
 * đọc dữ liệu được cung cấp thông qua yêu cầu của khách hàng. Đối số thứ hai là một đối tượng ServletResponse.
 * Điều này cho phép servlet tạo ra một phản hồi cho khách hàng.
 *
 * Cuộc gọi setContentType() thiết lập kiểu MIME của phản hồi HTTP. Trong chương trình này, kiểu MIME là text/html.
 * Điều này cho biết trình duyệt nên hiểu nội dung như mã nguồn HTML.
 *
 * Tiếp theo, phương thức getWriter() lấy được một PrintWriter. Bất kỳ điều gì được viết vào luồng này sẽ được gửi
 * đến khách hàng như một phần của phản hồi HTTP. Sau đó, println() được sử dụng để viết một số mã nguồn HTML đơn giản
 * làm phần phản hồi HTTP.
 *
 * Biên dịch mã nguồn này và đặt tệp HelloServlet.class vào thư mục Tomcat đúng như đã mô tả trong phần trước.
 * Hơn nữa, thêm HelloServlet vào tệp web.xml, như đã mô tả trước đó.
 *
 * Bắt đầu một trình duyệt web và yêu cầu Servlet
 * Mở trình duyệt web và nhập URL được hiển thị ở đây:
 * http://localhost:8080/examples/servlets/servlet/HelloServlet
 * Hoặc bạn có thể nhập URL được hiển thị ở đây:
 * http://127.0.0.1:8080/examples/servlets/servlet/HelloServlet
 * Điều này có thể được thực hiện vì 127.0.0.1 được xác định là địa chỉ IP của máy cục bộ.
 * Bạn sẽ nhìn thấy kết quả của servlet trên khu vực hiển thị của trình duyệt. Nó sẽ chứa chuỗi Hello! được in đậm.
 *
 * */