package i_Datagram;
/*
* DatagramPacket
* Lớp DatagramPacket định nghĩa một số hàm tạo. Bốn hàm tạo được trình bày dưới đây:
* 1. DatagramPacket(byte data[], int size):
* Hàm tạo này chỉ định một bộ đệm để nhận dữ liệu và kích thước của một gói tin (packet).
* Nó được sử dụng để nhận dữ liệu qua DatagramSocket.
*
* * 2. DatagramPacket(byte data[], int offset, int size):
* Hàm tạo này cho phép bạn chỉ định một vị trí bắt đầu trong bộ đệm để lưu trữ dữ liệu.
*
* 3. DatagramPacket(byte data[], int size, InetAddress ipAddress, int port):
* Hàm tạo này chỉ định địa chỉ và cổng mục tiêu, được sử dụng bởi DatagramSocket
* để xác định nơi mà dữ liệu trong gói tin sẽ được gửi đến.
*
* 4. DatagramPacket(byte data[], int offset, int size, InetAddress ipAddress, int port):
* Hàm tạo này truyền gói tin bắt đầu từ vị trí bắt đầu cụ thể trong dữ liệu.
*
* Hãy tưởng tượng hai hàm tạo đầu tiên như việc tạo "hộp thư đến", và hai hàm tạo thứ hai như việc đóng gói và ghi địa chỉ trên một phong bì.
*
* Lớp DatagramPacket định nghĩa một số phương thức khác nhau, bao gồm các phương thức dưới đây,
* cho phép truy cập vào địa chỉ và số cổng của một gói tin, cũng như dữ liệu gốc và độ dài của nó:
- InetAddress getAddress(): Trả về địa chỉ IP của gói tin.
- int getPort(): Trả về số cổng của gói tin.
- byte[] getData(): Trả về dữ liệu của gói tin.
- int getOffset(): Trả về vị trí bắt đầu trong bộ đệm của gói tin.
- int getLength(): Trả về độ dài của dữ liệu trong gói tin.
*
* Một ví dụ về Datagram
* Ví dụ dưới đây triển khai một máy khách và máy chủ giao tiếp qua mạng rất đơn giản.
* Tin nhắn được gõ vào cửa sổ tại máy chủ và được gửi qua mạng tới phía máy khách, nơi chúng được hiển thị.
* */

import java.net.*;

public class WriteServer {
    public static int serverPort = 998;
    public static int clientPort = 999;
    public static int buffer_size = 1024;
    public static DatagramSocket ds;
    public static byte[] buffer = new byte[buffer_size];

    public static void TheServer() throws Exception {
        int pos = 0;
        while (true) {
            int c = System.in.read();
            switch (c) {
                case -1:
                    System.out.println("Thoát máy chủ");
                    ds.close();
                    return;
                case '\r':
                    break;
                case '\n':
                    ds.send(new DatagramPacket(buffer, pos,
                            InetAddress.getLocalHost(), clientPort));
                    pos = 0;
                    break;
                default :
                    buffer[pos++] = (byte) c;
            }
        }
    }

    public static void TheClient() throws Exception {
        while(true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            System.out.println(new String (p.getData(), 0, p.getLength()));
        }
    }
    public static void main(String[] args) throws Exception{
        if(args.length == 1) {
            ds = new DatagramSocket(serverPort);
            TheServer();
        }else {
            ds = new DatagramSocket(clientPort);
            TheClient();
        }
    }
}




/*
* Chương trình mẫu này bị giới hạn bởi hàm tạo của DatagramSocket để chạy giữa hai cổng trên máy cục bộ.
* Để sử dụng chương trình, chạy
* java WriteServer
* trong một cửa sổ; đây sẽ là phía khách hàng.
* Sau đó chạy
* java WriteServer 1
* Đây sẽ là phía máy chủ. Bất cứ điều gì được nhập trong cửa sổ máy chủ sẽ được gửi đến cửa sổ khách hàng sau khi
* nhận được dấu xuống dòng.
*
* LƯU Ý Việc sử dụng datagram có thể không được phép trên máy tính của bạn. (Ví dụ, tường lửa có thể ngăn chặn việc sử dụng chúng.)
* Nếu điều này xảy ra, ví dụ trước không thể được sử dụng. Ngoài ra, các số cổng được sử dụng trong chương trình hoạt động trên
* hệ thống của tác giả, nhưng có thể cần điều chỉnh cho môi trường của bạn.
* */


