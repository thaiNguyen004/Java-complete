package h_TCP_IP_ServerSockets;
/*
* TCP/IP Server Sockets (Cổng dịch vụ TCP/IP)
* Như đã đề cập trước đó, Java có một lớp socket khác phải được sử dụng để tạo các ứng dụng máy chủ.
* Lớp ServerSocket được sử dụng để tạo máy chủ lắng nghe các chương trình khách địa phương hoặc từ xa kết nối đến
* trên các cổng đã được công bố.
* ServerSockets khác khá nhiều so với Sockets thông thường. Khi bạn tạo một ServerSocket, nó sẽ đăng ký với hệ thống rằng
* nó quan tâm đến các kết nối khách hàng. Các hàm tạo cho ServerSocket phản ánh số cổng mà bạn muốn chấp nhận kết nối và,
* tùy chọn, độ dài hàng đợi cho cổng đó. Độ dài hàng đợi cho hệ thống biết có bao nhiêu kết nối khách hàng nó có thể để đợi
* trước khi đơn giản là từ chối kết nối. Giá trị mặc định là 50. Các hàm tạo có thể ném ra ngoại lệ IOException trong
* các điều kiện bất lợi. Dưới đây là ba hàm tạo của nó:
*
*   ServerSocket(int port) throws IOException:
* Hàm tạo này tạo một đối tượng ServerSocket mới và liên kết nó với cổng được chỉ định.
* Tham số "port" là số cổng mà máy chủ sẽ lắng nghe các kết nối từ khách hàng.
* Nếu không thể tạo ServerSocket hoặc xảy ra lỗi trong quá trình tạo, ngoại lệ IOException sẽ được ném ra.
*
*   ServerSocket(int port, int maxQueue) throws IOException:
* Hàm tạo này tạo một đối tượng ServerSocket mới và liên kết nó với cổng và độ dài hàng đợi tối đa được chỉ định.
* Tham số "port" là số cổng mà máy chủ sẽ lắng nghe các kết nối từ khách hàng.
* Tham số "maxQueue" là độ dài tối đa của hàng đợi, xác định số lượng kết nối khách hàng mà máy chủ có thể để đợi trước khi từ chối kết nối.
* Nếu không thể tạo ServerSocket hoặc xảy ra lỗi trong quá trình tạo, ngoại lệ IOException sẽ được ném ra.
*
* ServerSocket có một phương thức gọi là accept(), đây là một cuộc gọi chặn (blocking call) sẽ đợi cho đến khi
* một khách hàng khởi tạo kết nối và sau đó trả về một Socket bình thường được sử dụng để giao tiếp với khách hàng.
*
*
* */
public class geory {
}
