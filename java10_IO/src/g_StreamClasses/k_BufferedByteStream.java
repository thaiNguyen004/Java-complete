package g_StreamClasses;
/*
* Luồng byte được đệm
* Đối với các luồng hướng byte, một luồng được đệm mở rộng một lớp luồng đã được lọc bằng cách kết nối một bộ đệm vào luồng I/O.
* Bộ đệm này cho phép Java thực hiện các hoạt động I/O trên nhiều byte cùng một lúc, từ đó cải thiện hiệu suất. Bởi vì bộ đệm có sẵn,
* việc bỏ qua (skip), đánh dấu (mark), và thiết lập lại (reset) của luồng trở nên có thể thực hiện. Các lớp luồng byte được đệm bao gồm
todo     BufferedInputStream
todo     BufferedOutputStream
todo     PushbackInputStream
* cũng triển khai một luồng được đệm.
*
* Có một số lợi ích khi sử dụng luồng byte được đệm (buffered byte streams):
*
todo  1. Tăng hiệu suất:
* Bằng cách kết nối bộ đệm vào luồng I/O, các hoạt động đọc và ghi dữ liệu được thực hiện trên nhiều byte cùng một lúc.
* Điều này giúp giảm số lần truy cập vào luồng gốc và tăng tốc độ truyền dữ liệu. Thay vì thực hiện ghi từng byte một,
* việc ghi vào bộ đệm sẽ tiến hành lưu trữ một số byte trước khi thực hiện hoạt động I/O. Khi bộ đệm đầy, nó sẽ được ghi
* vào luồng gốc một lần.
*
todo  2. Cung cấp các phương thức tiện ích:
* Với việc sử dụng luồng byte được đệm, ta có thể sử dụng các phương thức như bỏ qua (skip), đánh dấu (mark),
* và thiết lập lại (reset) trên luồng. Điều này cho phép ta điều khiển vị trí đọc/giữa trên luồng và quay lại vị trí đã được
* đánh dấu trước đó. Điều này hữu ích trong nhiều trường hợp, đặc biệt là khi cần đọc và xử lý dữ liệu theo từng phần nhỏ.
*
todo  3. Dễ sử dụng và bảo trì:
* Sử dụng luồng byte được đệm giúp mã nguồn trở nên dễ đọc và dễ bảo trì hơn. Chúng cung cấp một lớp trừu tượng (abstraction layer)
* giữa mã nguồn và luồng gốc, giúp ẩn đi chi tiết cụ thể về I/O. Điều này giúp tách biệt việc xử lý dữ liệu và việc xử lý I/O,
* giúp mã nguồn trở nên linh hoạt và dễ mở rộng.
*
todo  4. Hỗ trợ xử lý lỗi:
* Luồng byte được đệm cung cấp khả năng xử lý lỗi và khôi phục dễ dàng hơn. Nếu có lỗi xảy ra trong quá trình I/O, bộ đệm
* cho phép ta dễ dàng quay lại trạng thái trước đó và xử lý lỗi một cách tương thích.
*
* Tóm lại, sử dụng luồng byte được đệm giúp tăng hiệu suất, cung cấp các phương thức tiện ích, dễ sử dụng và bảo trì, và hỗ trợ xử
* lý lỗi trong quá trình I/O. Việc sử dụng luồng này giúp tối ưu hóa hiệu suất và giảm bớt công việc cần thực hiện khi xử lý dữ liệu byte trong Java.*/
public class k_BufferedByteStream {

}
