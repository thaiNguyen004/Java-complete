package b_UsingSynchronizationObject;

import java.util.concurrent.Phaser;

/*
* Phaser
* Một lớp đồng bộ hóa khác được gọi là Phaser. Mục đích chính của nó là cho phép đồng bộ hóa các luồng đại diện cho một
* hoặc nhiều pha hoạt động. Ví dụ, bạn có thể có một tập hợp các luồng thực hiện ba pha của một ứng dụng xử lý đơn hàng.
* Trong pha đầu tiên, các luồng riêng biệt được sử dụng để xác thực thông tin khách hàng, kiểm tra hàng tồn kho và xác nhận giá cả.
* Khi pha đó hoàn tất, pha thứ hai có hai luồng tính toán chi phí vận chuyển và thuế áp dụng. Sau đó, một pha cuối cùng
* xác nhận thanh toán và xác định thời gian vận chuyển ước tính. Trong quá khứ, để đồng bộ hóa các luồng đa nhiệm trong
* kịch bản này, bạn phải làm một số công việc. Với sự bổ sung của Phaser, quá trình này trở nên dễ dàng hơn.
*
* Đầu tiên, cần biết rằng Phaser hoạt động tương tự như CyclicBarrier, đã được mô tả trước đó, ngoại trừ việc nó hỗ trợ
* nhiều pha. Do đó, Phaser cho phép bạn xác định một đối tượng đồng bộ hóa chờ đến khi một pha cụ thể hoàn tất. Sau đó,
* nó chuyển sang pha tiếp theo và tiếp tục chờ đến khi pha đó kết thúc. Quan trọng là hiểu rằng Phaser cũng có thể được
* sử dụng để đồng bộ hóa chỉ một pha duy nhất. Liên quan đến điều này, nó hoạt động tương tự như một CyclicBarrier.
* Tuy nhiên, việc sử dụng chính của nó là đồng bộ hóa nhiều pha.
*
* Phaser định nghĩa bốn hàm khởi tạo. Dưới đây là hai hàm được sử dụng trong phần này:
* Phaser()
* Phaser(int numParties)
*
* Hàm đầu tiên tạo một phaser với số lượng đăng ký là 0. Hàm thứ hai đặt số lượng đăng ký là numParties.
* Thuật ngữ "party" thường được áp dụng cho các đối tượng đăng ký với một phaser. Mặc dù thông thường có một tương ứng
* một-đến-một giữa số lượng người đăng ký và số lượng luồng đang được đồng bộ hóa, nhưng không yêu cầu điều này.
* Trong cả hai trường hợp, pha hiện tại là 0. Đó là, khi một Phaser được tạo, ban đầu nó ở pha 0.
*
* Nói chung, đây là cách bạn sử dụng Phaser. Trước tiên, tạo một phiên bản mới của Phaser. Tiếp theo, đăng ký một
* hoặc nhiều bên tham gia với phaser, bằng cách gọi register() hoặc chỉ định số lượng bên tham gia trong hàm khởi tạo.
* Đối với mỗi bên tham gia đã đăng ký, cho phaser chờ cho đến khi tất cả các bên tham gia đã hoàn thành một pha.
* Bên tham gia sẽ thông báo điều này bằng cách gọi một trong các phương thức được cung cấp bởi Phaser,
* chẳng hạn như arrive() hoặc arriveAndAwaitAdvance(). Sau khi tất cả các bên tham gia đã đến, pha được hoàn thành
* và phaser có thể chuyển sang pha tiếp theo (nếu có), hoặc kết thúc. Các phần sau giải thích quá trình này chi tiết.
*
* Để đăng ký các bên tham gia sau khi một Phaser đã được tạo, gọi hàm register(). Đây là cú pháp của nó:
* int register()
* Nó trả về số phiên của pha mà nó đã được đăng ký.
*
* Để thông báo rằng một bên tham gia đã hoàn thành một pha, bên đó phải gọi arrive() hoặc một phiên bản của arrive().
* Khi số lượng đến đạt đến số lượng bên tham gia đã đăng ký, pha được hoàn thành và Phaser chuyển sang pha tiếp theo (nếu có).
* Phương thức arrive() có cấu trúc chung như sau:
* int arrive()
* Phương thức này thông báo rằng một bên tham gia (thường là một luồng thực thi) đã hoàn thành một tác vụ (hoặc một phần của tác vụ).
* Nó trả về số phiên hiện tại. Nếu phaser đã bị kết thúc, thì nó trả về một giá trị âm. Phương thức arrive() không
* tạm dừng việc thực thi của luồng gọi. Điều này có nghĩa là nó không đợi cho pha hoàn thành. Phương thức này chỉ nên được
* gọi bởi một bên tham gia đã đăng ký.
*
* Nếu bạn muốn chỉ ra sự hoàn thành của một pha và sau đó đợi cho đến khi tất cả các bên tham gia khác cũng hoàn thành pha đó,
* hãy sử dụng arriveAndAwaitAdvance(). Dưới đây là cú pháp của nó:
* int arriveAndAwaitAdvance()
* Nó đợi cho đến khi tất cả các bên tham gia đã đến. Nó trả về số phiên tiếp theo hoặc một giá trị âm nếu phaser đã bị kết thúc.
* Phương thức này chỉ nên được gọi bởi một bên tham gia đã đăng ký.
*
* Một luồng có thể đến và sau đó hủy đăng ký bản thân bằng cách gọi arriveAndDeregister(). Dưới đây là cú pháp của nó:
* int arriveAndDeregister()
* Nó trả về số phiên hiện tại hoặc một giá trị âm nếu phaser đã bị kết thúc. Nó không đợi cho đến khi pha hoàn thành.
* Phương thức này chỉ nên được gọi bởi một bên tham gia đã đăng ký.
*
* Để nhận số phiên hiện tại, gọi getPhase(), như dưới đây:
* final int getPhase()
* Khi một Phaser được tạo, pha đầu tiên sẽ là 0, pha thứ hai là 1, pha thứ ba là 2, và cứ thế. Một giá trị âm được trả về
* nếu Phaser gọi đã bị kết thúc.
*
* Dưới đây là một ví dụ cho thấy Phaser hoạt động. Nó tạo ba luồng, mỗi luồng có ba pha. Nó sử dụng một Phaser để đồng bộ hóa mỗi pha.
*
* */
public class f_Phaser {
    public static void main(String[] args) {
        Phaser phsr = new Phaser(1); //Chỉ định số lượng bên tham gia ban đầu
        int curPhase;
        System.out.println("Starting");

        new Thread(new MyThreadd(phsr, "A") ).start();;
        new Thread(new MyThreadd(phsr, "B") ).start();;
        new Thread(new MyThreadd(phsr, "C") ).start();;

        // luồng chính (main thread) sẽ đợi cho đến khi tất cả các luồng khác đã gọi phương thức
        // này và đạt đến điểm đồng bộ.

        //Đợi cho tất cả các luồng hoàn thành giai đoạn một
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Giai đoạn thứ " + curPhase + " hoàn thành");

        //Đợi cho tất cả các luồng hoàn thành giai đoạn hai
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Giai đoạn thứ " + curPhase + " hoàn thành");

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Giai đoạn thứ " + curPhase + " hoàn thành");

        //Hủy đăng kí thread main
        phsr.arriveAndDeregister();
        //Khi tất cả các luồng hủy đăng kí thì isTerminated() trả về true
                if(phsr.isTerminated())
            System.out.println("Phaser bị chấm dứt (terminated)");
    }
}
//Một luồng thực thi khi sử dụng Phaser
class MyThreadd implements Runnable {
    Phaser phsr;
    String name;
    MyThreadd (Phaser p, String n) {
        phsr = p;
        name = n;
        //Đăng kí làm bên tham gia với đối tựợng Phaser
        phsr.register();
    }
    @Override
    public void run() {
        System.out.println("Thread " + name + " Bắt đầu giai đoạn (phase) một");
        // arriveAndAwaitAdvance()
        // thông báo rằng một bên tham gia đã hoàn thành pha hiện tại và
        // đợi cho tất cả các bên tham gia khác hoàn thành pha đó trước khi tiếp tục.
        phsr.arriveAndAwaitAdvance();
        // Tạm dừng một chút để ngăn đầu ra lộn xộn. Đây chỉ là minh họa
        // Nó không cần thiết cho hoạt động bình thường của phaser.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread " + name + " Bắt đầu giai đoạn (phase) hai");
        phsr.arriveAndAwaitAdvance(); //báo hiệu đến
        // Tạm dừng một chút để ngăn đầu ra lộn xộn. Đây chỉ là minh họa
        // Nó không cần thiết cho hoạt động bình thường của phaser.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread " + name + " Bắt đầu giai đoạn (phase) ba");
        phsr.arriveAndDeregister(); // Báo hiệu đến và hủy đăng kí
    }
}

/*
* Hãy xem kỹ các phần quan trọng trong chương trình. Đầu tiên, trong phần main(), một đối tượng Phaser có tên phsr được tạo
* với một số lượng ban đầu là 1 (tương ứng với luồng chính). Sau đó, ba luồng được bắt đầu bằng cách tạo ba đối tượng MyThreadd.
* Lưu ý rằng MyThreadd được truyền một tham chiếu đến phsr (phaser). Các đối tượng MyThreadd sử dụng phaser này để đồng bộ
* hoạt động của chúng. Tiếp theo, main() gọi getPhase() để lấy số pha hiện tại (ban đầu là 0) và sau đó gọi arriveAndAwaitAdvance().
* Điều này làm cho main() tạm dừng cho đến khi pha 0 hoàn thành. Điều này sẽ không xảy ra cho đến khi tất cả các MyThread
* cũng gọi arriveAndAwaitAdvance(). Khi điều này xảy ra, main() sẽ tiếp tục thực thi, lúc đó nó hiển thị rằng pha 0 đã hoàn thành
* và di chuyển đến pha tiếp theo. Quá trình này lặp lại cho đến khi cả ba pha đều hoàn thành. Sau đó, main() gọi arriveAndDeregister().
* Tại thời điểm đó, tất cả ba MyThread cũng đã hủy đăng ký. Vì không có bên tham gia đăng ký khi phaser tiến tới pha tiếp theo,
* phaser sẽ bị chấm dứt.
*
* Bây giờ hãy xem MyThread. Trước tiên, lưu ý rằng constructor được truyền một tham chiếu đến phaser mà nó sẽ sử dụng và sau đó
* đăng ký với luồng mới như một bên tham gia trên phaser đó. Do đó, mỗi MyThread mới trở thành một bên tham gia đã đăng ký với
* phaser được truyền vào. Lưu ý rằng mỗi luồng có ba pha. Trong ví dụ này, mỗi pha bao gồm một đại diện chỉ hiển thị tên của luồng
* và điều gì đang được thực hiện. Rõ ràng, trong mã thực tế, luồng sẽ thực hiện các hành động có ý nghĩa hơn.
* Giữa hai pha đầu tiên, luồng gọi arriveAndAwaitAdvance(). Do đó, mỗi luồng đợi cho đến khi tất cả các luồng đã hoàn thành pha
* (và luồng chính đã sẵn sàng). Sau khi tất cả các luồng đã đến (bao gồm cả luồng chính), phaser tiến tới pha tiếp theo.
* Sau pha thứ ba, mỗi luồng hủy đăng ký chính nó bằng cách gọi arriveAndDeregister(). Như các ghi chú trong MyThread giải thích,
* cuộc gọi đến sleep() được sử dụng để minh họa mục đích, để đảm bảo đầu ra không bị lộn xộn do đa luồng. Chúng không cần thiết
* để phaser hoạt động đúng. Nếu bạn xóa chúng, đầu ra có thể trông hơi lộn xộn, nhưng các pha vẫn được đồng bộ đúng.
*
* Một điểm khác: Mặc dù ví dụ trước sử dụng ba luồng cùng loại, nhưng điều này không phải là yêu cầu. Mỗi bên tham gia sử dụng phaser
* có thể là duy nhất, và mỗi bên thực hiện một số công việc riêng biệt.
* Có thể kiểm soát chính xác những gì xảy ra khi một pha tiến lên. Để làm điều này, bạn phải ghi đè phương thức onAdvance().
* Phương thức này được gọi bởi thời gian chạy khi một phaser tiến từ một pha sang pha tiếp theo. Nó được hiển thị như sau:

* * protected boolean onAdvance(int phase, int numParties)
*
* Ở đây, phase sẽ chứa số pha hiện tại trước khi tăng và numParties sẽ chứa số bên tham gia đã đăng ký.
* Để chấm dứt phaser, onAdvance() phải trả về true. Để giữ phaser hoạt động, onAdvance() phải trả về false.
* Phiên bản mặc định của onAdvance() trả về true (do đó chấm dứt phaser) khi không có bên tham gia đã đăng ký.
* Như một quy tắc chung, ghi đè của bạn cũng nên tuân theo thực tiễn này.
* Một lý do để ghi đè onAdvance() là cho phép phaser thực hiện một số lượng pha cụ thể và sau đó dừng lại.
* Ví dụ sau đây cho bạn cái nhìn tổng quan về việc sử dụng này. Nó tạo ra một lớp gọi là MyPhaser mở rộng từ Phaser
* để thực hiện một số lượng pha cụ thể. Điều này được thực hiện bằng cách ghi đè phương thức onAdvance().
* Constructor MyPhaser chấp nhận một đối số, chỉ định số lượng pha để thực hiện. Lưu ý rằng MyPhaser tự động đăng ký
* một bên tham gia. Hành vi này hữu ích trong ví dụ này, nhưng nhu cầu của ứng dụng riêng của bạn có thể khác nhau.
* */

class MyPhaser extends Phaser {
    int numPhases;
    MyPhaser (int parties, int phaseCount) {
        super(parties); //parites : số bên đăng ký không ghi đè lại
        numPhases = phaseCount - 1;
    }

    //Ghi đè lại phương thức onAdvance() để thực thi các hành động
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        // Câu lệnh println() này chỉ để minh họa
        // thông thường onAdvance() sẽ không hiển thị đầu ra
        System.out.println("Giai đoạn " + phase + " hoàn thành");

        // Nếu tất cả các giai đoạn đã hoàn thành thì trả về true
        if(phase == numPhases || registeredParties == 0) return true;

        // Nếu không thì trả về false
        return false;
    }
}

class PhaserDemo {
    public static void main(String[] args) {
        MyPhaser myPhsr = new MyPhaser(1, 4);
        System.out.println("Starting");

        new Thread(new MyThreaddd(myPhsr, "A")).start();
        new Thread(new MyThreaddd(myPhsr, "B")).start();
        new Thread(new MyThreaddd(myPhsr, "C")).start();
        new Thread(new MyThreaddd(myPhsr, "D")).start();
        new Thread(new MyThreaddd(myPhsr, "E")).start();

        while(!myPhsr.isTerminated()) {
            myPhsr.arriveAndAwaitAdvance();
        }

        System.out.println("My Phaser bị chấm dứt");

        /*
        * Trong phần main(), một phiên bản của Phaser được tạo ra. Nó được truyền vào giá trị 4 như một đối số,
        * có nghĩa là nó sẽ thực hiện bốn pha (giai đoạn) và sau đó dừng lại.
        * Tiếp theo, ba luồng được tạo và sau đó chương trình vào vòng lặp sau:
        * Vòng lặp này đơn giản chỉ gọi arriveAndAwaitAdvance() cho đến khi phaser bị chấm dứt. Phaser sẽ không kết thúc
        * cho đến khi số lượng pha đã được thực hiện theo yêu cầu. Trong trường hợp này, vòng lặp tiếp tục thực thi cho đến
        * khi đã chạy bốn pha.
        * Tiếp theo, lưu ý rằng các luồng cũng gọi arriveAndAwaitAdvance() trong một vòng lặp chạy cho đến khi phaser bị chấm dứt.
        * Điều này có nghĩa rằng chúng sẽ thực thi cho đến khi số lượng pha đã được hoàn thành theo yêu cầu.
        * Bây giờ, hãy xem xét cẩn thận mã code cho onAdvance(). Mỗi lần onAdvance() được gọi, nó nhận vào pha hiện tại và
        * số lượng bên tham gia đã đăng ký. Nếu pha hiện tại bằng với pha đã chỉ định, hoặc nếu số lượng bên tham gia đã đăng ký là không,
        * onAdvance() trả về true, từ đó dừng phaser. Điều này được thực hiện bằng dòng mã sau:
        * if(phase == numPhases || registeredParties == 0) return true;
        * return false;
        *
        * Như bạn có thể thấy, chỉ cần ít mã code là đủ để đạt được kết quả mong muốn. Trước khi tiếp tục, có ích để nhấn mạnh
        * rằng bạn không nhất thiết phải mở rộng Phaser một cách tường minh như ví dụ trước đó để đơn giản chỉ ghi đè onAdvance().
        * Trong một số trường hợp, mã code nhỏ gọn hơn có thể được tạo ra bằng cách sử dụng một lớp nội danh ẩn danh để ghi đè onAdvance().
        *
        * Phaser còn có các khả năng bổ sung có thể hữu ích trong ứng dụng của bạn. Bạn có thể chờ đợi một pha cụ thể bằng cách
        * gọi awaitAdvance(), được hiển thị như sau:
        * int awaitAdvance(int phase)
        *
        * Ở đây, phase chỉ định số pha mà awaitAdvance() sẽ chờ đợi cho đến khi chuyển sang pha tiếp theo.
        * Phương thức này sẽ trả về ngay lập tức nếu đối số được truyền cho phase không bằng pha hiện tại.
        * Nó cũng sẽ trả về ngay lập tức nếu phaser đã bị chấm dứt. Tuy nhiên, nếu phase được truyền vào là pha hiện tại,
        * thì nó sẽ chờ đến khi pha tăng lên. Phương thức này chỉ nên được gọi bởi một bên đã đăng ký.
        * Cũng có một phiên bản có thể bị ngắt của phương thức này gọi là awaitAdvanceInterruptibly().
        *
        * Để đăng ký nhiều bên, gọi bulkRegister().
        * Để lấy số lượng bên đã đăng ký, gọi getRegisteredParties(). Bạn cũng có thể lấy số lượng bên đã đến và
        * số lượng bên chưa đến bằng cách gọi lần lượt getArrivedParties() và getUnarrivedParties().
        * Để buộc phaser vào trạng thái kết thúc, gọi forceTermination().
        *
        * Phaser cũng cho phép bạn tạo ra một cây phaser. Điều này được hỗ trợ bởi hai constructor bổ sung,
        * cho phép bạn xác định phần tử cha và phương thức getParent().
        * */
    }
}

class MyThreaddd implements Runnable {
    Phaser phsr;
    String name;
    MyThreaddd (Phaser p, String n) {
        phsr = p;
        name = n;
        phsr.register();
    }
    @Override
    public void run() {
        while(!phsr.isTerminated()) {
            System.out.println("Thread " + name + " bắt đầu giai đoạn "
            + phsr.getPhase());

            phsr.arriveAndAwaitAdvance();

            // Tạm dừng một chút để tránh đầu ra lộn xộn.
            // đây chỉ là minh họa. Nó không cần thiết cho hoạt động
            // bình thường của một phaser
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}