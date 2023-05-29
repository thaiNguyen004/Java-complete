package u_Serialization;
/*
 * Một ví dụ về Serialization
 *
 * Chương trình dưới đây minh họa cách sử dụng tuần tự hóa và giải tuần tự hóa đối tượng. Nó bắt đầu bằng cách khởi tạo
 * một đối tượng của lớp MyClass. Đối tượng này có ba biến thành viên là kiểu String, int và double.
 * Đây là thông tin chúng ta muốn lưu trữ và khôi phục.
 *
 * Một FileOutputStream được tạo ra để trỏ đến một tệp có tên là "serial", và một ObjectOutputStream được tạo ra cho luồng tệp đó.
 * Phương thức writeObject() của ObjectOutputStream được sử dụng để tuần tự hóa đối tượng của chúng ta.
 * Luồng đầu ra của đối tượng được xả và đóng.
 *
 * Sau đó, một FileInputStream được tạo ra để trỏ đến tệp có tên là "serial", và một ObjectInputStream được tạo ra cho luồng tệp đó.
 * Phương thức readObject() của ObjectInputStream được sử dụng để giải tuần tự hóa đối tượng của chúng ta.
 * Luồng đầu vào của đối tượng sau đó được đóng.
 *
 * Lưu ý rằng lớp MyClass được định nghĩa để triển khai giao diện Serializable. Nếu không làm điều này, một NotSerializableException
 * sẽ được ném ra. Hãy thử thay đổi chương trình này bằng cách khai báo một số biến thành viên của MyClass là transient.
 * Dữ liệu đó sau đó sẽ không được lưu trữ trong quá trình tuần tự hóa.
 * */

import java.io.*;

class MyClass implements Serializable {
    private String s;
    private int i;
    private double d;

    //Chú ý biến thành viên có modifier là transient
    transient String transientString;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
        transientString = "Hello this is transient";
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", d=" + d +
                '}' + transientString;
    }
}

public class h_example {
    public static void main(String[] args) throws ClassNotFoundException {

        //Object Serialization
        try (ObjectOutputStream objOS = new ObjectOutputStream(new FileOutputStream("serial.txt"))) {
            //Khai báo một đối tượng MyClass
            MyClass object1 = new MyClass("Nguyên", 2004, 10.2);
            System.out.println("Object1: " + object1);

            objOS.writeObject(object1);

        } catch (IOException e) {
            System.out.println("Error IO");
        }

        //Object Deserialization
        try (ObjectInputStream objIS = new ObjectInputStream(new FileInputStream("serial.txt"))) {
            MyClass object2 = (MyClass) objIS.readObject();
            System.out.println("Object2: " + object2);
        } catch (IOException e) {
            System.out.println("Error IO");
        }
    }
}
