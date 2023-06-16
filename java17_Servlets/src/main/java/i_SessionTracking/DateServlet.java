package i_SessionTracking;
/*
* Theo dõi phiên
* HTTP là một giao thức không trạng thái. Mỗi yêu cầu đều độc lập với yêu cầu trước đó.
* Tuy nhiên, trong một số ứng dụng, cần lưu trữ thông tin trạng thái để có thể thu thập thông tin từ
* một số tương tác giữa trình duyệt và máy chủ.
* Phiên (Session) cung cấp cơ chế như vậy.
* Một phiên có thể được tạo ra thông qua phương thức getSession() của HttpServletRequest.
* Một đối tượng HttpSession được trả về. Đối tượng này có thể lưu trữ một tập hợp các liên kết kết nối tên với các đối tượng.
* Các phương thức setAttribute(), getAttribute(), getAttributeNames() và removeAttribute() của HttpSession quản lý
* các liên kết này. Trạng thái phiên được chia sẻ bởi tất cả các servlet liên quan đến một khách hàng.
*
* Đoạn mã servlet dưới đây minh họa cách sử dụng Session. Phương thức getSession() lấy phiên hiện tại.
* Một phiên mới được tạo nếu chưa tồn tại. Phương thức getAttribute() được gọi để lấy đối tượng được liên kết
* với tên "date". Đối tượng đó là một đối tượng Date chứa ngày và giờ truy cập trang cuối cùng.
* (Tất nhiên, không có liên kết như vậy khi trang được truy cập lần đầu.)
* Sau đó, một đối tượng Date chứa ngày và giờ hiện tại được tạo ra.
* Phương thức setAttribute() được gọi để liên kết tên "date" với đối tượng này.
*
* */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class DateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy phiên (Session)
        HttpSession hs = req.getSession();

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.print("<b>");

        // Hiển thị ngày giờ truy cập lần cuối
        Date date = (Date) hs.getAttribute("date");
        if (date != null) {
            pw.print("Last access: " + date + "<br>");
        }
        // Hiển thị thời gian hiện tại
        date = new Date();
        hs.setAttribute("date", date);
        pw.println("Current date: " + date);
    }
}

