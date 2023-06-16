package g_HandlingRequestAndResponse.HandlingPOST;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
* Mã nguồn cho ColorPostServlet.java được hiển thị trong đoạn mã dưới đây.
* Phương thức doPost() được ghi đè để xử lý bất kỳ yêu cầu HTTP POST nào được gửi đến servlet này.
* Nó sử dụng phương thức getParameter() của HttpServletRequest để lấy thông tin lựa chọn mà người
* dùng đã chọn. Sau đó, một phản hồi được hình thành.
*
* */
public class ColorPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<b> The selected color is: " + color + "</b>");
        pw.close();
    }
}
/*
* Biên dịch servlet và thực hiện các bước tương tự như đã mô tả trong phần trước để kiểm tra nó.
* LƯU Ý: Các tham số cho yêu cầu HTTP POST không được bao gồm là một phần của URL được gửi đến máy chủ web.
* Trong ví dụ này, URL được gửi từ trình duyệt đến máy chủ là
* http://localhost:8080/examples/servlets/servlet/ColorPostServlet.
* Tên và giá trị của các tham số được gửi trong phần thân của yêu cầu HTTP.
*
* */