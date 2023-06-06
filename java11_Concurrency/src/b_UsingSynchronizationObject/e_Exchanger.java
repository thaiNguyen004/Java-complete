package b_UsingSynchronizationObject;

import java.util.concurrent.Exchanger;

/*
* Exchanger
* Có thể nói rằng Exchanger là một trong những lớp đồng bộ hóa thú vị nhất. Nó được thiết kế để đơn giản hóa
* việc trao đổi dữ liệu giữa hai luồng. Cách hoạt động của Exchanger rất đơn giản: nó đợi cho đến khi hai
* luồng riêng biệt gọi phương thức exchange() của nó.
* Khi điều này xảy ra, nó trao đổi dữ liệu được cung cấp bởi các luồng. Cơ chế này vừa thanh lịch vừa dễ sử dụng.
* Có thể dễ dàng tưởng tượng ra các trường hợp sử dụng Exchanger. Ví dụ, một luồng có thể chuẩn bị một bộ đệm
* để nhận thông tin qua kết nối mạng. Luồng khác có thể điền bộ đệm đó bằng thông tin từ kết nối.
* Hai luồng này làm việc cùng nhau sao cho mỗi khi cần một bộ đệm mới, sẽ có một sự trao đổi xảy ra.
*
* Exchanger là một lớp generic được khai báo như sau:
* Exchanger<V>
Ở đây, V chỉ định kiểu dữ liệu đang được trao đổi.
*
* Phương thức duy nhất được định nghĩa bởi Exchanger là exchange(), có hai dạng như sau:
* V exchange(V objRef) throws InterruptedException
* V exchange(V objRef, long wait, TimeUnit tu) throws InterruptedException, TimeoutException
*
* Ở đây, objRef là một tham chiếu đến dữ liệu cần trao đổi. Dữ liệu nhận từ luồng khác sẽ được trả về.
* Dạng thứ hai của exchange() cho phép chỉ định một khoảng thời gian chờ tối đa.
* Điểm chính về exchange() là nó chỉ thành công khi được gọi trên cùng một đối tượng Exchanger
* bởi hai luồng riêng biệt. Do đó, exchange() đồng bộ hóa việc trao đổi dữ liệu.
*
* Dưới đây là một ví dụ minh họa về Exchanger. Nó tạo ra hai luồng. Một luồng tạo ra một bộ đệm rỗng
* mà sẽ nhận dữ liệu được đặt vào nó bởi luồng thứ hai. Trong trường hợp này, dữ liệu là một chuỗi.
* Do đó, luồng đầu tiên trao đổi một chuỗi rỗng cho một chuỗi đầy đủ.
*
* */
public class e_Exchanger {
    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<>();
        new Thread(new UseString(exgr)).start();
        new Thread(new MakeString(exgr)).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

    }
}

//Một luồng tạo chuỗi
class MakeString implements Runnable {
    Exchanger<String> ex;
    String str;

    MakeString(Exchanger<String> c) {
        ex = c;
        str = new String();
    }

    @Override
    public void run() {
        char ch = 'A';
        for (int i = 0 ; i < 3; i++){
            for (int j = 0 ; j < 5; j++)
                str += ch++;

            try {
                str = ex.exchange(str);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        try {
            ex.exchange("Mặt hàng");
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}

//Một luồng sử dụng chuỗi
class UseString implements Runnable {
    Exchanger<String> ex;
    String str;

    UseString(Exchanger<String> ob) {
        ex = ob;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = ex.exchange(new String());
                System.out.println("Got: " + str);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}