package e_ReadingServletParam;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/*
* Mã nguồn cho PostParametersServlet.java được hiển thị trong đoạn mã sau.
* Phương thức service() được ghi đè để xử lý yêu cầu từ phía khách hàng.
* Phương thức getParameterNames() trả về một danh sách liệt kê các tên tham số.
* Chúng được xử lý trong một vòng lặp. Bạn có thể thấy rằng tên tham số và giá trị
* được đưa ra cho khách hàng. Giá trị tham số được lấy thông qua phương thức getParameter().
*
* */
public class PostParametersServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        // Lấy đối tượng print writer
        PrintWriter pw =  servletResponse.getWriter();
        Enumeration<String> e = servletRequest.getParameterNames();

        while(e.hasMoreElements()) {
            String pname = e.nextElement();
            pw.print(pname + " = ");
            String pvalue = servletRequest.getParameter(pname);
            pw.println(pvalue);
        }
        pw.close();
    }
}
/*
* Biên dịch servlet. Tiếp theo, sao chép nó vào thư mục phù hợp và cập nhật tệp web.xml, như đã mô tả trước đó.
* Sau đó, thực hiện các bước sau để kiểm tra ví dụ này:
*
* 1. Khởi động Tomcat (nếu chưa chạy).
* 2. Hiển thị trang web trong trình duyệt.
* 3. Nhập tên nhân viên và số điện thoại vào các ô văn bản.
* 4. Gửi trang web.
*
* Sau khi hoàn thành các bước này, trình duyệt sẽ hiển thị một phản hồi được tạo ra động bởi servlet.
* */
