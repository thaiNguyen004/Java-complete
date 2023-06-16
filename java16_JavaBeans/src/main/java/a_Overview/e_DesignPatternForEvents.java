package a_Overview;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/*
*
* Mẫu thiết kế cho Sự kiện
* Beans sử dụng mô hình sự kiện thông qua delegation đã được thảo luận trước đó trong cuốn sách này.
* Beans có thể tạo ra sự kiện và gửi chúng đến các đối tượng khác.
* Chúng có thể được xác định bằng các mẫu thiết kế sau, trong đó T là kiểu dữ liệu của sự kiện:
*
* public void addTListener(TListener eventListener)
* public void addTListener(TListener eventListener) throws java.util.TooManyListenersException
* public void removeTListener(TListener eventListener)
*
* Các phương thức này được sử dụng để thêm hoặc loại bỏ người nghe cho sự kiện được chỉ định.
* Phiên bản addTListener() không gây ra ngoại lệ có thể được sử dụng để phát đa luồng một sự kiện,
* có nghĩa là nhiều người nghe có thể đăng ký để nhận thông báo về sự kiện. Phiên bản gây ra ngoại
* lệ TooManyListenersException gửi sự kiện một cách đơn lẻ, có nghĩa là số lượng người nghe có thể
* bị hạn chế thành một. Trong cả hai trường hợp, removeTListener() được sử dụng để loại bỏ người nghe.
* Ví dụ, giả sử có một kiểu giao diện sự kiện được gọi là TemperatureListener, một Bean theo dõi
* nhiệt độ có thể cung cấp các phương thức sau
*
* public void addTemperatureListener(TemperatureListener tl)
*
* public void removeTemperatureListener(TemperatureListener tl)
*
* */
public class e_DesignPatternForEvents {
}
















