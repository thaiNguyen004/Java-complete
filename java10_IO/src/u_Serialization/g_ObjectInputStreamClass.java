package u_Serialization;
/*
* ObjectInputStream
* Lớp ObjectInputStream mở rộng lớp InputStream và triển khai giao diện ObjectInput. ObjectInputStream chịu trách nhiệm
* đọc đối tượng từ một luồng. Một constructor của lớp này được hiển thị ở đây:
*   - ObjectInputStream(InputStream inStream) throws IOException
* Đối số inStream là luồng đầu vào mà các đối tượng đã tuần tự hóa sẽ được đọc. Khi đóng ObjectInputStream, luồng cơ bản được
* chỉ định bởi inStream cũng sẽ tự động đóng.
* Một số phương thức thông dụng trong lớp này được hiển thị trong Bảng 21-9. Chúng sẽ ném một IOException khi xảy ra điều kiện lỗi.
* Phương thức readObject() cũng có thể ném ClassNotFoundException. Có một lớp nội trong ObjectInputStream gọi là GetField.
* Nó giúp việc đọc các trường bền vững, và việc sử dụng nó nằm ngoài phạm vi của cuốn sách này.
*
* Dưới đây là mô tả các phương thức trong lớp ObjectInputStream:
*
todo  1. int available()
* Phương thức này trả về số byte có sẵn để đọc từ luồng đầu vào mà không bị chặn.
*
todo  2. void close()
* Phương thức này đóng luồng đầu vào và giải phóng bất kỳ tài nguyên hệ thống nào được liên kết với luồng này.
*
todo  3. int read()
* Phương thức này đọc một byte từ luồng đầu vào và trả về giá trị byte đọc được.
*
todo  4. int read(byte[] buffer)
* Phương thức này đọc một số byte từ luồng đầu vào và ghi vào mảng byte buffer. Nó trả về số byte đã được đọc.
*
todo  5. int read(byte[] buffer, int offset, int numBytes)
* Phương thức này đọc một số byte từ luồng đầu vào và ghi vào mảng byte buffer từ vị trí offset với độ dài numBytes. Nó trả về số byte đã được đọc.
*
todo  6. boolean readBoolean()
* Phương thức này đọc một giá trị boolean từ luồng đầu vào và trả về giá trị boolean tương ứng.
*
todo  7. byte readByte()
* Phương thức này đọc một giá trị byte từ luồng đầu vào và trả về giá trị byte tương ứng.
*
todo  8. char readChar()
* Phương thức này đọc một giá trị char từ luồng đầu vào và trả về giá trị char tương ứng.
*
todo  9. double readDouble()
* Phương thức này đọc một giá trị double từ luồng đầu vào và trả về giá trị double tương ứng.
*
todo  10. float readFloat()
* Phương thức này đọc một giá trị float từ luồng đầu vào và trả về giá trị float tương ứng.
*
todo  11. void readFully(byte[] buffer)
* Phương thức này đọc đầy đủ các byte từ luồng đầu vào và ghi vào mảng byte buffer.
*
todo  12. void readFully(byte[] buffer, int offset, int numBytes)
* Phương thức này đọc đầy đủ các byte từ luồng đầu vào và ghi vào mảng byte buffer từ vị trí offset với độ dài numBytes.
*
todo  13. int readInt()
* Phương thức này đọc một giá trị int từ luồng đầu vào và trả về giá trị int tương ứng.
*
todo  14. long readLong()
* Phương thức này đọc một giá trị long từ luồng đầu vào và trả về giá trị long tương ứng.
*
todo  15. Object readObject()
* Phương thức này đọc một đối tượng đã được tuần tự hóa từ luồng đầu vào và trả về đối tượng đã tuần tự hóa đó.
*
todo  16. short readShort()
* Phươngthức này đọc một giá trị short từ luồng đầu vào và trả về giá trị short tương ứng.
*
todo  17. int readUnsignedByte()
* Phương thức này đọc một giá trị byte không dấu từ luồng đầu vào và trả về giá trị byte không dấu tương ứng.
*
todo  18. int readUnsignedShort()
* Phương thức này đọc một giá trị short không dấu từ luồng đầu vào và trả về giá trị short không dấu tương ứng.
*
* Bắt đầu từ JDK 9, ObjectInputStream bao gồm các phương thức getObjectInputFilter() và setObjectInputFilter().
* Chúng hỗ trợ việc lọc các luồng đầu vào của đối tượng thông qua việc sử dụng
* ObjectInputFilter
* ObjectInputFilter.FilterInfo
* ObjectInputFilter.Config
* ObjectInputFilter.Status
* Các thành phần này đã được thêm vào bởi JDK 9. Việc lọc cho phép bạn kiểm soát quá trình giải tuần tự hóa.*/
public class g_ObjectInputStreamClass {
}
