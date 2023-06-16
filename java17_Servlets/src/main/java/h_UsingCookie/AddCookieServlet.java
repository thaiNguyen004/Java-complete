package h_UsingCookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
* Dưới đây là mã nguồn cho tệp AddCookieServlet.java.
* Nó lấy giá trị của tham số có tên "data". Sau đó, nó tạo một đối tượng Cookie có tên là "MyCookie"
* và chứa giá trị của tham số "data". Cookie sau đó được thêm vào tiêu đề của phản hồi HTTP thông qua
* phương thức addCookie(). Một tin nhắn phản hồi được ghi vào trình duyệt.
*
* */
public class AddCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = req.getParameter("data");

        // Tạo cookie
        Cookie cookie = new Cookie("MyCookie", data);
        cookie.setMaxAge(3600);
        // Thêm cookie vào phản hồi HTTP
        resp.addCookie(cookie);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<b> MyCookie has been set is : " + data + "</b>");
        pw.close();
    }
}
