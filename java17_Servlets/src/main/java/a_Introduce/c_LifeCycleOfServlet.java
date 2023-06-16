package a_Introduce;
/*
*
* Vòng đời của một Servlet
* Ba phương thức quan trọng trong vòng đời của một servlet là init(), service() và destroy().
* Tất cả các servlet đều triển khai những phương thức này và được gọi vào thời điểm cụ thể bởi máy chủ.
* Hãy xem xét một kịch bản người dùng điển hình để hiểu khi nào các phương thức này được gọi.
*
* Đầu tiên, giả sử một người dùng nhập một Uniform Resource Locator (URL) vào trình duyệt web. Trình duyệt
* sau đó tạo ra một yêu cầu HTTP cho URL này. Yêu cầu này được gửi tới máy chủ phù hợp.
*
* Thứ hai, yêu cầu HTTP này được nhận bởi máy chủ web. Máy chủ ánh xạ yêu cầu này vào một servlet cụ thể.
* Servlet được truy xuất và tải động vào không gian địa chỉ của máy chủ.
*
* Thứ ba, máy chủ gọi phương thức init() của servlet. Phương thức này chỉ được gọi khi servlet được tải lần đầu
* vào bộ nhớ. Có thể truyền các tham số khởi tạo cho servlet để cấu hình nó.
*
* Thứ tư, máy chủ gọi phương thức service() của servlet. Phương thức này được gọi để xử lý yêu cầu HTTP.
* Bạn sẽ thấy rằng servlet có thể đọc dữ liệu đã được cung cấp trong yêu cầu HTTP. Nó cũng có thể tạo ra một
* phản hồi HTTP cho máy khách.
*
* Servlet vẫn tồn tại trong không gian địa chỉ của máy chủ và có sẵn để xử lý bất kỳ yêu cầu HTTP nào được nhận
* từ máy khách. Phương thức service() được gọi cho mỗi yêu cầu HTTP.
*
* Cuối cùng, máy chủ có thể quyết định gỡ bỏ servlet khỏi bộ nhớ của nó. Các thuật toán để đưa ra quyết định này
* được cụ thể cho từng máy chủ. Máy chủ gọi phương thức destroy() để giải phóng bất kỳ tài nguyên nào,
* chẳng hạn như các handle tệp đã được cấp phát cho servlet. Dữ liệu quan trọng có thể được lưu vào một cơ sở dữ liệu
* lưu trữ. Bộ nhớ được cấp phát cho servlet và các đối tượng của nó sau đó có thể được thu gom rác.
*
* */
public class c_LifeCycleOfServlet {
}
