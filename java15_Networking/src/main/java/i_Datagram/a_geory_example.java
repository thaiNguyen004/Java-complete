package i_Datagram;
/*
* Datagram
* Mạng TCP/IP phù hợp cho hầu hết các nhu cầu mạng. Nó cung cấp một luồng dữ liệu gói tin có tính tuần tự,
* đáng tin cậy và dự đoán được. Tuy nhiên, điều này không phải là không có chi phí.
* TCP bao gồm nhiều thuật toán phức tạp để xử lý điều khiển tắc nghẽn trên các mạng đông đúc,
* cũng như kỳ vọng tiêu cực về mất gói tin. Điều này dẫn đến một cách truyền dữ liệu hơi không hiệu quả.
*
* Datagram cung cấp một lựa chọn thay thế.
* Datagram là một gói thông tin được truyền giữa các máy. Chúng giống như việc ném mạnh từ một người chơi bắt bóng tay trái đ
* ến người chơi bắt bóng cuối cùng mà đã bị bịt mắt. Sau khi datagram được gửi đến đích mong muốn, không có đảm bảo rằng nó
* sẽ đến hoặc ngay cả là ai đó sẽ ở đó để bắt nó. Tương tự, khi datagram được nhận, không có đảm bảo rằng nó không bị hỏng
* trong quá trình truyền hoặc người gửi đã ở đó để nhận phản hồi.
* Java triển khai datagram trên giao thức UDP bằng cách sử dụng hai lớp:
* đối tượng DatagramPacket là thùng chứa dữ liệu, trong khi DatagramSocket là cơ chế được sử dụng để gửi
* hoặc nhận DatagramPackets. Mỗi lớp sẽ được trình bày dưới đây.
*
* DatagramSocket
* DatagramSocket xác định bốn hàm tạo công khai. Chúng được hiển thị như sau:
* DatagramSocket( ) throws SocketException
* DatagramSocket(int port) throws SocketException
* DatagramSocket(int port, InetAddress ipAddress) throws SocketException
* DatagramSocket(SocketAddress address) throws SocketException
* Hàm tạo đầu tiên tạo một DatagramSocket được gắn với bất kỳ cổng chưa sử dụng nào trên máy tính cục bộ.
* Hàm tạo thứ hai tạo một DatagramSocket được gắn với cổng được chỉ định bởi port.
* Hàm tạo thứ ba tạo một DatagramSocket được gắn với cổng và InetAddress đã chỉ định.
* Hàm tạo thứ tư tạo một DatagramSocket được gắn với SocketAddress đã chỉ định. SocketAddress là một lớp trừu tượng được
* thực thi bởi lớp cụ thể InetSocketAddress.
*
* InetSocketAddress bao gồm một địa chỉ IP với số cổng. Tất cả đều có thể gây ra ngoại lệ SocketException
* nếu xảy ra lỗi khi tạo socket.
* DatagramSocket xác định nhiều phương thức. Hai trong số những phương thức quan trọng nhất là send() và receive(),
* được hiển thị như sau:
* void send(DatagramPacket packet) throws IOException
* void receive(DatagramPacket packet) throws IOException
*
* Phương thức send() gửi một gói tin đến cổng được chỉ định bởi packet.
* Phương thức receive() chờ nhận một gói tin và trả về kết quả. DatagramSocket cũng xác định phương thức close(), đóng socket.
* DatagramSocket cũng thực hiện AutoCloseable, có nghĩa là một DatagramSocket có thể được quản lý bằng khối try-with-resources.
* Các phương thức khác cho phép truy cập vào các thuộc tính khác nhau liên quan đến một DatagramSocket. Đây là một mẫu:
*
* Các phương thức sau được mô tả như sau:
*
* 1. `InetAddress getInetAddress()`:
* Trả về địa chỉ IP của máy chủ hoặc máy khách được kết nối.
*
* 2. `int getLocalPort()`:
* Trả về số cổng cục bộ mà socket đang sử dụng.
*
* 3. `int getPort()`:
* Trả về số cổng từ xa mà socket đang kết nối tới.
*
* 4. `boolean isBound()`:
* Kiểm tra xem socket đã được liên kết (bound) hay chưa. Trả về `true` nếu socket đã được liên kết và `false` nếu chưa.
*
* 5. `boolean isConnected()`: Kiểm tra xem socket đã được kết nối hay chưa.
* Trả về `true` nếu socket đã được kết nối và `false` nếu chưa.
*
* 6. `void setSoTimeout(int millis) throws SocketException`:
* Đặt thời gian chờ (timeout) cho socket. Nếu không nhận được dữ liệu trong khoảng thời gian quy định,
* một ngoại lệ SocketTimeoutException sẽ được ném ra. Tham số `millis` là thời gian chờ tính bằng mili giây.
*
* Các phương thức này cung cấp thông tin về địa chỉ,
* cổng và trạng thái của socket, cũng như cho phép đặt thời gian chờ cho socket.
* */
public class a_geory_example {
}
