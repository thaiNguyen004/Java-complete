package b_UsingSynchronizationObject;

import java.util.concurrent.Semaphore;

/*
 * Semaphore
 * Đối tượng đồng bộ hóa mà nhiều người đọc sẽ nhận ra ngay lập tức là Semaphore,
 * một phiên bản cổ điển của semaphore. Semaphore điều khiển quyền truy cập vào một tài nguyên chung
 * thông qua việc sử dụng một bộ đếm. Nếu bộ đếm lớn hơn không, thì quyền truy cập được cho phép.
 * Nếu nó bằng không, thì quyền truy cập bị từ chối. Bộ đếm này đếm các phép ủy quyền cho phép truy cập
 * vào tài nguyên chung. Do đó, để truy cập vào tài nguyên, một luồng phải được cấp phép từ semaphore.
 *
 * Nói chung, để sử dụng semaphore, luồng muốn truy cập vào tài nguyên chung cố gắng lấy một phép ủy quyền.
 * Nếu số lượng của semaphore lớn hơn không, thì luồng sẽ lấy được một phép ủy quyền, điều này làm giảm
 * số lượng của semaphore. Nếu không, luồng sẽ bị chặn cho đến khi có thể lấy được một phép ủy quyền.
 * Khi luồng không còn cần truy cập vào tài nguyên chung, nó sẽ giải phóng phép ủy quyền, làm tăng
 * số lượng của semaphore. Nếu có một luồng khác đang đợi một phép ủy quyền,
 * thì luồng đó sẽ lấy được một phép ủy quyền tại thời điểm đó. Lớp Semaphore của Java thực hiện cơ chế này.
 *
 * Semaphore có hai hàm tạo như sau:
 * Semaphore(int num)
 * Semaphore(int num, boolean how)
 * Ở đây, num chỉ định số phép ủy quyền ban đầu. Do đó, num xác định số luồng có thể truy cập vào một tài nguyên
 * chung vào bất kỳ thời điểm nào. Nếu num là một, thì chỉ có một luồng có thể truy cập vào tài nguyên vào bất
 * kỳ thời điểm nào. Mặc định, các luồng đang chờ được cấp phép một phép ủy quyền theo một thứ tự không xác định.
 * Bằng cách đặt how thành true, bạn có thể đảm bảo rằng các luồng đang chờ được cấp phép theo thứ tự mà
 * chúng yêu cầu truy cập.\
 *
 * Để lấy một phép ủy quyền, gọi phương thức acquire(), có hai dạng như sau:
 * void acquire() throws InterruptedException
 * void acquire(int num) throws InterruptedException
 * Dạng đầu tiên lấy một phép ủy quyền. Dạng thứ hai lấy num phép ủy quyền. Thông thường, ta sử dụng dạng đầu tiên.
 * Nếu phép ủy quyền không thể được cấp phép tại thời điểm gọi, thì luồng gọi phương thức sẽ bị tạm dừng cho
 * đến khi phép ủy quyền có sẵn.
 *
 * Để giải phóng một phép ủy quyền, gọi phương thức release(), có hai dạng như sau:
 * void release()
 * void release(int num)
 * Dạng đầu tiên giải phóng một phép ủy quyền. Dạng thứ hai giải phóng số lượng phép ủy quyền được chỉ định bởi num.
 *
 * Để sử dụng semaphore để kiểm soát quyền truy cập vào một tài nguyên, mỗi luồng muốn sử dụng tài nguyên
 * đó phải gọi acquire() trước khi truy cập vào tài nguyên.
 * Khi luồng đã hoàn thành việc sử dụng tài nguyên, nó phải gọi release().
 *
 * Dưới đây là một ví dụ minh họa việc sử dụng semaphore:
 *
 * */

//Một tài nguyên được chia sẻ
class Shared {
    static int count = 0;
}

//Một luồng thực thi tăng số lượng
class IncThread implements Runnable{
    String name;
    Semaphore sem;
    IncThread (Semaphore s, String n) {
        sem = s;
        name = n;
    }

    @Override
    public void run() {
        System.out.println(name+ " starting");
        try {
            //Đầu tiên: xin phép ủy quyền
            System.out.println(name +" đang đợi một phép ủy quyền ...");
            sem.acquire();
            System.out.println(name +" được cấp phép");
            //Bây giờ hãy truy cập vào tài nguyên được chia sẻ
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                //Bây giờ cho phép chuyển ngữ cảnh nếu có thể
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        //Nhả giấy phép
        System.out.println(name + " nhả giấy phép");
//        sem.release();
    }
}

//Một luồng thực thi giảm số lượng
class DecThread implements Runnable {
    String name;
    Semaphore sem;
    DecThread (Semaphore s, String n) {
        sem = s;
        name = n;
    }
    @Override
    public void run() {
        System.out.println(name+ " starting");
        try {
            //Đầu tiên: xin phép ủy quyền
            System.out.println(name + " đang đợi một phép ủy quyền...");
            sem.acquire();
            System.out.println(name + " được cấp phép");
            //Bây giờ hãy truy cập vào tài nguyên được chia sẻ
            for (int i = 0; i < 5; i++) {
                Shared.count --;
                System.out.println(name +": " + Shared.count);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            System.out.println("Interrrupted");
        }
        //Nhả giấy phép
        System.out.println(name +" nhả giấy phép");
        sem.release();
    }
}

public class b_Semaphore {
    public static void main(String[] args) {
//        Semaphore sem = new Semaphore(1);
//        new Thread(new IncThread(sem, "A")).start();
//        new Thread(new DecThread(sem, "B")).start();

        Q q = new Q();
        new Thread(new Consumer(q)).start();
        new Thread(new Producer(q)).start();

    }
}
/*
 * Chương trình sử dụng một semaphore để kiểm soát quyền truy cập vào biến count, một biến tĩnh trong lớp Shared.
 * Biến Shared.count được tăng lên năm lần bởi phương thức run() của lớp IncThread và giảm đi năm lần
 * bởi phương thức run() của lớp DecThread. Để ngăn hai luồng này truy cập Shared.count cùng một lúc,
 * quyền truy cập chỉ được phép sau khi lấy được phép ủy quyền từ semaphore điều khiển. Sau khi truy cập hoàn tất,
 * phép ủy quyền được giải phóng. Như vậy, chỉ có một luồng được phép truy cập Shared.count vào một thời điểm,
 * như đầu ra đã cho thấy.
 *
 * Trong cả IncThread và DecThread, lưu ý cuộc gọi sleep() bên trong phương thức run(). Nó được sử dụng để "chứng minh"
 * rằng việc truy cập Shared.count được đồng bộ hóa bởi semaphore. Trong run(), cuộc gọi sleep() làm cho luồng gọi tạm dừng
 * giữa mỗi lần truy cập vào Shared.count. Thông thường, điều này sẽ cho phép luồng thứ hai chạy.
 * Tuy nhiên, do semaphore, luồng thứ hai phải đợi cho đến khi luồng đầu tiên đã giải phóng phép ủy quyền,
 * điều này chỉ xảy ra sau khi tất cả các lần truy cập của luồng đầu tiên hoàn tất và nhả phép ủy quyền.
 *
 * Do đó, Shared.count được tăng lên năm lần bởi IncThread và giảm đi năm lần bởi DecThread. Các lần tăng và giảm không được xen kẽ.
 *
 * Nếu không sử dụng semaphore, việc truy cập Shared.count bởi cả hai luồng sẽ xảy ra đồng thời và các lần tăng và giảm sẽ được xen kẽ.
 * Để xác nhận điều này, hãy thử comment các cuộc gọi acquire() và release(). Khi chạy chương trình, bạn sẽ thấy rằng việc truy cập
 * vào Shared.count không được đồng bộ hóa nữa và mỗi luồng truy cập nó ngay khi nó nhận được một timeslice bằng method sleep().
 *
 * Mặc dù nhiều cách sử dụng của semaphore đơn giản như trong chương trình trước đây, nhưng cũng có những cách sử dụng thú vị hơn.
 * Dưới đây là một ví dụ. Chương trình sau làm việc lại chương trình producer/consumer được hiển thị trong Chương 11
 * sao cho nó sử dụng hai semaphore để điều chỉnh các luồng producer và consumer, đảm bảo rằng mỗi lần gọi put() sẽ được theo sau
 * bởi một lần gọi get():
 * */

class Q {
    int n;
    //Bắt đầu với Semaphore của người tiêu dùng(Consumer) không có sẵn
    static Semaphore semCon = new Semaphore(0); //Không có bất kỳ phép ủy quyền nào
    static Semaphore semPro = new Semaphore(1);
    void get ()  {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Got : " + n);
        semPro.release();
    }

    void put(int n) {
        try {
            semPro.acquire();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        this.n = n;
        System.out.println("Put: " + n);
        semCon.release();
    }
}

class Producer implements Runnable {
    Q q;
    Producer (Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) q.put(i);
    }
}

class Consumer implements Runnable {
    Q q;
    Consumer (Q q) {
        this.q = q;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) q.get();
    }
}
/*
 * Như bạn có thể thấy, các cuộc gọi put() và get() được đồng bộ hóa. Tức là, mỗi lần gọi put() được theo sau bởi
 * một lần gọi get() và không có giá trị nào bị bỏ sót. Nếu không có các semaphore, nhiều cuộc gọi put() sẽ xảy ra
 * mà không có cuộc gọi tương ứng get(), dẫn đến việc bỏ sót các giá trị. (Để chứng minh điều này, hãy loại bỏ
 * mã semaphore và quan sát kết quả.)
 *
 * Thứ tự của các cuộc gọi put() và get() được xử lý bởi hai semaphore: semProd và semCon. Trước khi put() có thể
 * sản xuất một giá trị, nó phải lấy một phép ủy quyền từ semProd. Sau khi đặt giá trị, nó giải phóng semCon.
 * Trước khi get() có thể tiêu thụ một giá trị, nó phải lấy một phép ủy quyền từ semCon. Sau khi tiêu thụ giá trị,
 * nó giải phóng semProd. Cơ chế "cho và nhận" này đảm bảo rằng mỗi cuộc gọi put() phải được theo sau bởi một
 * cuộc gọi get().
 *
 * Lưu ý rằng semCon được khởi tạo với không có phép ủy quyền khả dụng. Điều này đảm bảo put() được thực thi trước.
 * Khả năng thiết lập trạng thái đồng bộ hóa ban đầu là một trong những khía cạnh mạnh mẽ của semaphore.
 *
 * */