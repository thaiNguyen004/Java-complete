package h_AtomicOperations;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.DoubleAccumulator;

/*
* Các Phép Toán Nguyên Tử (Atomic)
* Gói java.util.concurrent.atomic cung cấp một giải pháp thay thế cho các tính năng đồng bộ hóa khác khi đọc hoặc ghi
* giá trị của một số loại biến. Gói này cung cấp các phương thức để lấy, đặt, hoặc so sánh giá trị của một biến trong
* một thao tác không bị gián đoạn (tức là nguyên tử). Điều này có nghĩa là không cần sử dụng khóa hoặc cơ chế đồng bộ hóa khác.
*
* Các phép toán nguyên tử được thực hiện thông qua việc sử dụng các lớp như AtomicInteger và AtomicLong, cùng với các
* phương thức như get(), set(), compareAndSet(), decrementAndGet() và getAndSet(),
* thực hiện các hành động được chỉ định bởi tên của chúng.
*
* Dưới đây là một ví dụ minh họa về cách truy cập vào một số nguyên chia sẻ có thể được đồng bộ hóa bằng cách sử dụng
* AtomicInteger:
*
* */
public class example_geory {
    public static void main(String[] args) {
        new Thread(new AtomThread("A")).start();
        new Thread(new AtomThread("B")).start();
        new Thread(new AtomThread("C")).start();
        new Thread(new AtomThread("D")).start();

        //Không thằng nào bị deadlock cả
    }
}

class Shared {
    static AtomicInteger ai = new AtomicInteger(0);
}

class AtomThread implements Runnable {
    String name;
    AtomThread (String n) {name = n;}

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " got: " + Shared.ai.getAndSet(i));
        }
    }
}


/*
* Trong chương trình, một AtomicInteger tĩnh có tên là ai được tạo bởi lớp Shared. Sau đó, ba luồng kiểu AtomThread
* được tạo. Bên trong phương thức run(), Shared.ai được thay đổi bằng cách gọi phương thức getAndSet().
* Phương thức này trả về giá trị trước đó và sau đó đặt giá trị thành giá trị được truyền như một đối số.
*
* Việc sử dụng AtomicInteger ngăn không cho hai luồng ghi vào ai cùng một lúc.
* Nó cung cấp một cách tiện lợi (và có thể hiệu quả hơn) so với các cơ chế đồng bộ hóa
* khác khi chỉ có một biến duy nhất được liên quan.
*
* Ngoài ra, java.util.concurrent.atomic cũng cung cấp bốn lớp hỗ trợ các phép toán tổng hợp không cần khóa.
* Đó là DoubleAccumulator, DoubleAdder, LongAccumulator và LongAdder.
* Các lớp accumulator hỗ trợ một loạt các phép toán được chỉ định bởi người dùng. Các lớp adder duy trì tổng tích lũy.
*
* */