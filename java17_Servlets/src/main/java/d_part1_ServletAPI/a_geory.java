package d_part1_ServletAPI;
/*
* API Servlet
* Hai gói (package) chứa các lớp và giao diện cần thiết để xây dựng các servlet được mô tả trong chương này.
* Đó là javax.servlet và javax.servlet.http.
* Chúng tạo nên nhân tố cốt lõi của API Servlet. Hãy nhớ rằng các gói này không phải là phần của các gói cốt lõi của Java.
* Do đó, chúng không được bao gồm trong Java SE. Thay vào đó, chúng được cung cấp bởi Tomcat. Chúng cũng được cung cấp bởi Java EE.
*
* API Servlet đã được phát triển và cải tiến liên tục. Phiên bản đặc tả servlet được hỗ trợ bởi Tomcat 8.5.31 là phiên bản 3.1.
* (Lưu ý rằng Tomcat 9 hỗ trợ đặc tả servlet 4.) Chương này thảo luận về nhân tố cốt lõi của API Servlet, sẽ có sẵn cho
* hầu hết các độc giả và hoạt động với tất cả các phiên bản hiện đại của đặc tả servlet.
*
* Gói javax.servlet
* Gói javax.servlet chứa một số giao diện và lớp thiết lập khung làm việc mà servlet hoạt động trong đó.
* Bảng sau tóm tắt một số giao diện quan trọng được cung cấp trong gói này.
* Giao diện quan trọng nhất trong số này là Servlet. Tất cả các servlet phải triển khai giao diện này hoặc mở rộng một lớp
* triển khai giao diện này. Giao diện ServletRequest và ServletResponse cũng rất quan trọng.
*
* Dưới đây là mô tả của các giao diện liên quan đến Servlet API:
* 1. Servlet:
* Giao diện Servlet là giao diện cốt lõi của một servlet. Tất cả các servlet phải triển khai giao diện này hoặc
* mở rộng một lớp triển khai giao diện này. Nó định nghĩa các phương thức chính để xử lý các yêu cầu (request)
* và phản hồi (response) từ client.
*
* 2. ServletConfig:
* Giao diện ServletConfig chứa các phương thức để cấu hình một servlet trong quá trình khởi tạo. Nó cung cấp thông tin
* cấu hình cho servlet, bao gồm các tham số khởi tạo và tham chiếu đến ServletContext.
*
* 3. ServletContext:
* Giao diện ServletContext đại diện cho ngữ cảnh của một ứng dụng web. Nó cung cấp thông tin về môi trường thực thi của
* ứng dụng và cho phép servlet tương tác với các thành phần khác của ứng dụng như các servlet khác, tài nguyên và
* thông tin cấu hình.
*
* 4. ServletRequest:
* Giao diện ServletRequest đại diện cho một yêu cầu (request) từ client gửi đến một servlet. Nó cung cấp các phương thức
* để truy cập thông tin về yêu cầu như thông tin về HTTP, tham số yêu cầu và dữ liệu gửi kèm.
*
* 5. ServletResponse:
* Giao diện ServletResponse đại diện cho một phản hồi (response) từ servlet gửi về client. Nó cung cấp các phương thức
* để thiết lập thông tin và nội dung của phản hồi như kiểu MIME, độ dài nội dung và ghi dữ liệu phản hồi đến client.
*
* Bảng sau đây tóm tắt các lớp cốt lõi được cung cấp trong gói javax.servlet:
* Dưới đây là mô tả các lớp sau trong gói javax.servlet:
*
* 1. GenericServlet:
* Lớp abstract là một lớp cơ sở được sử dụng để xây dựng servlet. Nó triển khai các giao diện Servlet, ServletConfig
* và Serializable. GenericServlet cung cấp các phương thức mặc định để xử lý yêu cầu và phản hồi cơ bản, và có thể được
* mở rộng để tạo ra servlet tùy chỉnh.
*
* 2. ServletInputStream:
* Lớp đại diện cho luồng đầu vào của yêu cầu được gửi tới một servlet. Nó cung cấp các phương thức để đọc dữ liệu từ
* luồng đầu vào.
*
* 3. ServletOutputStream:
* Lớp đại diện cho luồng đầu ra của phản hồi được trả về từ một servlet. Nó cung cấp các phương thức để ghi dữ liệu vào
* luồng đầu ra.
*
* 4. ServletException:
* Ngoại lệ thông báo lỗi xảy ra trong quá trình xử lý một yêu cầu servlet. Nó thường được ném ra khi có lỗi xảy ra
* trong servlet, ví dụ như lỗi cấu hình, lỗi xử lý yêu cầu, hoặc lỗi tương tác với các thành phần khác.
*
* 5. UnavailableException:
* Ngoại lệ thông báo rằng một servlet không khả dụng hoặc không thể thực thi tạm thời. Nó được sử dụng để thông báo cho
* máy chủ ứng dụng web rằng một servlet không thể được sử dụng trong một thời gian nhất định, ví dụ như khi servlet
* đang được nâng cấp hoặc bảo trì.
*
*
* */
public class a_geory {
}
