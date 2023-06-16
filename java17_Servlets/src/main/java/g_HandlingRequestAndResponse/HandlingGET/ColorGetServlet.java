package g_HandlingRequestAndResponse.HandlingGET;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
* Mã nguồn cho ColorGetServlet.java được hiển thị trong danh sách dưới đây.
*
* Phương thức doGet() được ghi đè để xử lý các yêu cầu GET HTTP được gửi đến servlet này.
* Nó sử dụng phương thức getParameter() của HttpServletRequest để lấy thông tin được chọn bởi người dùng.
* Sau đó, một phản hồi được xây dựng.
*
* */
public class ColorGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<b> The selected color is: " + color +" </b>");
        pw.close();
    }
}
/*
* Sau khi hoàn thành các bước này, trình duyệt sẽ hiển thị phản hồi được tạo ra động bởi servlet.
* Một điểm khác: Các tham số cho một yêu cầu HTTP GET được bao gồm là một phần của URL được gửi đến
* máy chủ web.
*
* Giả sử người dùng chọn tùy chọn màu đỏ và gửi biểu mẫu. URL được gửi từ trình duyệt đến máy chủ là:
* http://localhost:8080/examples/servlets/servlet/ColorGetServlet?color=Red
* Các ký tự nằm bên phải dấu chấm hỏi được gọi là chuỗi truy vấn.
*
* */
