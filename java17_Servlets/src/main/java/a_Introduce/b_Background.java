package a_Introduce;
/*
* Nền tảng (Background)
* Để hiểu được lợi ích của servlets, bạn cần có kiến thức cơ bản về cách trình duyệt web và máy chủ hợp tác
* để cung cấp nội dung cho người dùng. Hãy xem xét một yêu cầu cho một trang web tĩnh. Người dùng nhập một URL
* vào trình duyệt. Trình duyệt tạo ra một (request) yêu cầu HTTP tới máy chủ web tương ứng. Máy chủ web ánh xạ
* yêu cầu này vào một tệp cụ thể. Tệp đó được trả về trong một (response) phản hồi HTTP cho trình duyệt.
* Header HTTP trong phản hồi cho biết loại nội dung. Để làm điều này, sử dụng Multipurpose Internet Mail Extensions (MIME).
* Ví dụ, văn bản ASCII thông thường có loại MIME là text/plain. Mã nguồn HTML (Hypertext Markup Language) của một trang
* web có loại MIME là text/html.
*
* Bây giờ hãy xem xét nội dung động. Giả sử một cửa hàng trực tuyến sử dụng một cơ sở dữ liệu để lưu trữ thông tin
* về hoạt động kinh doanh của mình. Điều này bao gồm các mặt hàng để bán, giá cả, sẵn có, đơn hàng và những thứ tương tự.
* Cửa hàng muốn làm cho thông tin này có thể truy cập được cho khách hàng qua các trang web. Nội dung của những trang web
* đó phải được tạo ra động để phản ánh thông tin mới nhất trong cơ sở dữ liệu.
*
* Vào những ngày đầu của Web, một máy chủ có thể xây dựng động một trang bằng cách tạo ra một quy trình riêng để xử lý
* mỗi yêu cầu từ khách hàng. Quy trình sẽ mở kết nối tới một hoặc nhiều cơ sở dữ liệu để lấy thông tin cần thiết.
* Nó giao tiếp với máy chủ web thông qua một giao diện được gọi là Common Gateway Interface (CGI). CGI cho phép quy trình
* riêng đọc dữ liệu từ yêu cầu HTTP và ghi dữ liệu vào phản hồi HTTP. Nhiều ngôn ngữ khác nhau được sử dụng để xây dựng
* các chương trình CGI. Các ngôn ngữ này bao gồm C, C++ và Perl.
*
* Tuy nhiên, CGI gặp vấn đề nghiêm trọng về hiệu suất. Nó tốn kém về tài nguyên bộ xử lý và bộ nhớ để tạo ra một quy trình
* riêng cho mỗi yêu cầu từ khách hàng. Nó cũng tốn kém để mở và đóng kết nối cơ sở dữ liệu cho mỗi yêu cầu từ khách hàng.
* Ngoài ra, các chương trình CGI không độc lập với nền tảng. Do đó, đã được giới thiệu các kỹ thuật khác.
* Trong số đó có servlets.
*
* Servlets cung cấp một số lợi ích so với CGI. Đầu tiên, hiệu suất được cải thiện đáng kể. Servlets chạy trong không gian
* địa chỉ của máy chủ web. Không cần tạo ra một quy trình riêng để xử lý mỗi yêu cầu từ khách hàng.
* Thứ hai, servlets không phụ thuộc vào nền tảng vì chúng được viết bằng Java. Thứ ba, quản lý bảo mật Java trên máy chủ
* áp dụng một tập hợp các ràng buộc để bảo vệ tài nguyên trên máy chủ. Cuối cùng, các thư viện lớp Java đầy đủ chức năng
* có sẵn cho servlets. Nó có thể giao tiếp với phần mềm khác thông qua các cơ chế sockets và RMI mà bạn đã thấy trước đây.
*
* */
public class b_Background {
}
