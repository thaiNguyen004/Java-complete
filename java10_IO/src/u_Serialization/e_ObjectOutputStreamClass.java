package u_Serialization;
/*
* ObjectOutputStream
* Lớp ObjectOutputStream mở rộng lớp OutputStream và triển khai giao diện ObjectOutput. Nó chịu trách nhiệm ghi đối tượng
* vào một luồng. Một constructor của lớp này được hiển thị ở đây:
*   - ObjectOutputStream(OutputStream outStream) throws IOException
* Đối số outStream là luồng đầu ra mà các đối tượng đã được tuần tự hóa sẽ được ghi vào. Khi đóng ObjectOutputStream,
* luồng cơ bản được chỉ định bởi outStream cũng sẽ tự động đóng.
*
* Một số phương thức thông dụng trong lớp này được hiển thị trong Bảng 21-7. Chúng sẽ ném một IOException khi xảy ra
* điều kiện lỗi. Có một lớp nội trong ObjectOutputStream gọi là PutField. Nó giúp việc ghi các trường bền vững,
* và việc sử dụng nó nằm ngoài phạm vi của cuốn sách này.
*
* Các phương thức được mô tả dưới đây là các phương thức trong lớp ObjectOutputStream:

todo     1. void close( )
* Phương thức này đóng luồng đầu ra và giải phóng bất kỳ tài nguyên hệ thống nào được liên kết với luồng này.
*
todo     2. void flush( )
* Phương thức này đẩy dữ liệu từ bộ đệm xuống luồng đầu ra. Điều này đảm bảo rằng dữ liệu đã được ghi vào luồng.

todo     3. void write(byte b)
* Phương thức này ghi một byte vào luồng đầu ra. Tham số b là giá trị byte cần ghi.
*
todo    4. void write(byte[] buffer, int offset, int numBytes)
* Phương thức này ghi một phần của mảng byte buffer vào luồng đầu ra, bắt đầu từ vị trí offset và ghi numBytes byte.
*
todo    5. void write(int b)
* Phương thức này ghi một giá trị int (4 byte) vào luồng đầu ra.
*
todo    6. void writeBoolean(boolean b)
* Phương thức này ghi giá trị boolean vào luồng đầu ra. Nếu b là true, ghi byte 1; nếu b là false, ghi byte 0.
*
todo    7. void writeByte(int b)
* Phương thức này ghi một giá trị byte vào luồng đầu ra.
*
todo    8. void writeBytes(String str)
* Phương thức này ghi các byte của chuỗi str vào luồng đầu ra.
*
todo     9. void writeChar(int c)
* Phương thức này ghi một giá trị char (2 byte) vào luồng đầu ra.
*
todo    10. void writeChars(String str)
* Phương thức này ghi các char của chuỗi str vào luồng đầu ra.
*
todo    11. void writeDouble(double d)
* Phương thức này ghi một giá trị double (8 byte) vào luồng đầu ra.
*
todo    12. void writeFloat(float f)
* Phương thức này ghi một giá trị float (4 byte) vào luồng đầu ra.
*
todo    13. void writeInt(int i)
* Phương thức này ghi một giá trị int (4 byte) vào luồng đầu ra.
*
todo    14. void writeLong(long l)
* Phương thức này ghi một giá trị long (8 byte) vào luồng đầu ra.
*
todo    15. void writeObject(Object obj)
* Phương thức này được sử dụng để ghi một đối tượng đã tuần tự hóa vào luồng đầu ra.
*
todo    16. void writeShort(int s)
* Phương thức này ghi một giá trị short (2 byte) vào luồng đầu ra.
    * */
public class e_ObjectOutputStreamClass {
}
