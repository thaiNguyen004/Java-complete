package d_part1_ServletAPI;
/*
* Lớp ServletInputStream
*
* Lớp ServletInputStream mở rộng lớp InputStream. Nó được cài đặt bởi container servlet và cung cấp một luồng đầu vào
* mà nhà phát triển servlet có thể sử dụng để đọc dữ liệu từ yêu cầu của client. Ngoài các phương thức đầu vào được
* thừa kế từ InputStream, lớp này cung cấp một phương thức để đọc các byte từ luồng. Nó được hiển thị ở đây:
*
* int readLine(byte[ ] buffer, int offset, int size) throws IOException
*
* Ở đây, buffer là mảng mà size byte được đặt vào, bắt đầu từ offset. Phương thức trả về số byte thực sự đã được đọc,
* hoặc -1 nếu gặp điều kiện kết thúc luồng.*/
public class h_ServletInputStream {
}
