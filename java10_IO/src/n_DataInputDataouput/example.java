package n_DataInputDataouput;

import java.io.*;

/*
* DataOutputStream và DataInputStream
* DataOutputStream và DataInputStream cho phép bạn ghi hoặc đọc dữ liệu nguyên thủy vào hoặc từ luồng. Chúng thực hiện
* các giao diện DataOutput và DataInput tương ứng. Các giao diện này xác định các phương thức chuyển đổi giá trị
* nguyên thủy thành một chuỗi byte và ngược lại. Các luồng này giúp lưu trữ dữ liệu nhị phân dễ dàng, chẳng hạn như
* số nguyên hoặc giá trị dấu chấm động, vào một tệp tin. Mỗi loại luồng sẽ được trình bày dưới đây.
*
*
todo:  DataOutputStream
* DataOutputStream mở rộng từ FilterOutputStream, mở rộng từ OutputStream. Ngoài việc thực hiện DataOutput,
* DataOutputStream cũng triển khai các giao diện AutoCloseable, Closeable và Flushable. DataOutputStream
* xác định constructor sau đây:
*
*   DataOutputStream(OutputStream outputStream)
*
* Ở đây, outputStream chỉ định luồng đầu ra mà dữ liệu sẽ được ghi vào. Khi một DataOutputStream được đóng
* (bằng cách gọi close()), luồng gốc được chỉ định bởi outputStream cũng sẽ tự động đóng.
*
* DataOutputStream hỗ trợ tất cả các phương thức được xác định bởi các lớp cha của nó. Tuy nhiên, các phương thức
* được xác định bởi giao diện DataOutput, mà nó triển khai, mới thực sự làm cho nó thú vị. DataOutput xác định các
* phương thức chuyển đổi các giá trị của kiểu nguyên thủy thành một chuỗi byte và sau đó ghi nó vào luồng gốc.
* Đây là một số phương thức mẫu của nó:
todo   final void writeDouble(double value) throws IOException
todo   final void writeBoolean(boolean value) throws IOException
todo   final void writeInt(int value) throws IOException
*
* Ở đây, value là giá trị được ghi vào luồng.
*
todo:  DataInputStream
* DataInputStream là phần bổ sung của DataOuputStream. Nó mở rộng từ FilterInputStream, mở rộng từ InputStream.
* Ngoài việc triển khai giao diện DataInput, DataInputStream cũng triển khai các giao diện AutoCloseable và Closeable.
* Đây là constructor duy nhất của nó:
*   DataInputStream(InputStream inputStream)
*
* Ở đây, inputStream chỉ định luồng đầu vào mà dữ liệu sẽ được đọc từ. Khi một DataInputStream được đóng (bằng cách gọi close()),
* luồng gốc được chỉ định bởi inputStream cũng sẽ tự động đóng.
*
* Giống như DataOutputStream, DataInputStream hỗ trợ tất cả các phương thức của lớp cha của nó, nhưng các phương thức được
* xác định bởi giao diện DataInput mới làm cho nó trở nên độc đáo. Các phương thức này đọc một chuỗi byte và chuyển đổi
* chúng thành giá trị của một kiểu nguyên thủy. Đây là một số phương thức mẫu của chúng:
*
todo   final double readDouble() throws IOException
todo   final boolean readBoolean() throws IOException
todo   final int readInt() throws IOException
*
* Chương trình sau đây minh họa việc sử dụng DataOutputStream và DataInputStream:*/
public class example {
    public static void main(String[] args) {
        //Đầu tiên là ghi dữ liệu
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("TestDataOutputStream.dat"))) {
            dout.writeBoolean(true);
            dout.writeDouble(98.7);
            dout.writeInt(10);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open the file");
        } catch (IOException e) {
            System.out.println("Error IO: "+ e.getMessage());
        }


        //Đọc chính file vừa ghi
        try (DataInputStream din = new DataInputStream(new FileInputStream("TestDataOutputStream.dat"))) {
            boolean bool = din.readBoolean();
            int i = din.readInt();
            double d = din.readDouble();

            System.out.printf("Các value: %s %d %f", bool, i, d);

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open the file");
        } catch (IOException e) {
            System.out.println("Error IO: "+ e.getMessage());
        }
    }
}
