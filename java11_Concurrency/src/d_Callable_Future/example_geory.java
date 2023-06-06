package d_Callable_Future;

import java.util.concurrent.*;

/*
* Sử dụng Callable và Future
* Một trong những tính năng thú vị nhất của API đồng thời là giao diện Callable. Giao diện này đại diện cho một luồng trả về một giá trị.
* Ứng dụng có thể sử dụng đối tượng Callable để tính toán kết quả rồi trả về cho luồng gọi. Đây là một cơ chế mạnh mẽ vì nó giúp việc
* lập trình nhiều loại tính toán số học trong đó các kết quả phần tử được tính toán đồng thời. Nó cũng có thể được sử dụng để chạy một
* luồng trả về mã trạng thái chỉ ra việc hoàn thành thành công của luồng.
*
* Callable là một giao diện generic được định nghĩa như sau:
* interface Callable<V>
* Ở đây, V chỉ ra kiểu dữ liệu được trả về bởi tác vụ. Callable chỉ định duy nhất một phương thức, call(), được hiển thị ở đây:
* V call() throws Exception
* Bên trong call(), bạn định nghĩa tác vụ mà bạn muốn thực hiện. Sau khi tác vụ hoàn thành, bạn trả về kết quả.
* Nếu không thể tính toán kết quả, call() phải ném ra một ngoại lệ.
*
* Một tác vụ Callable được thực thi bởi một ExecutorService bằng cách gọi phương thức submit() của nó. Có ba dạng của submit(),
* nhưng chỉ có một được sử dụng để thực thi một Callable. Đây là phương thức được hiển thị ở đây:
*
* <T> Future<T> submit(Callable<T> task)
* Ở đây, task là đối tượng Callable sẽ được thực thi trong một luồng riêng của nó.
* Kết quả được trả về qua một đối tượng kiểu Future.
*
* Future là một giao diện generic đại diện cho giá trị sẽ được trả về bởi một đối tượng Callable.
* Vì giá trị này được lấy ở một thời điểm trong tương lai, tên Future là phù hợp. Future được định nghĩa như sau:
* interface Future<V>
* Ở đây, V chỉ định kiểu kết quả.
*
* Để lấy giá trị trả về, bạn sẽ gọi phương thức get() của Future, có hai dạng như sau:
* V get() throws InterruptedException, ExecutionException
* V get(long wait, TimeUnit tu) throws InterruptedException, ExecutionException, TimeoutException
* Dạng đầu tiên đợi kết quả vô thời hạn. Dạng thứ hai cho phép bạn chỉ định một khoảng thời gian chờ đợi.
* Đơn vị thời gian chờ đợi được truyền vào thông qua tham số tu, là một đối tượng của định danh TimeUnit,
* được mô tả sau trong chương này.
*
* Chương trình dưới đây minh họa việc sử dụng Callable và Future bằng cách tạo ba tác vụ thực hiện ba tính toán khác nhau.
* Tác vụ đầu tiên trả về tổng của một giá trị, tác vụ thứ hai tính độ dài của cạnh huyền của một tam giác vuông với độ dài hai cạnh,
* và tác vụ thứ ba tính giai thừa của một giá trị. Cả ba tính toán này diễn ra đồng thời.
*/
public class example_geory {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> f;
        Future<Double> f2;
        Future<Integer> f3;

        System.out.println("Starting");

        f = es.submit(new Sum(10));
        f2 = es.submit(new Hypot(3, 4));
        f3 = es.submit(new Factorial(5));

        try {
            System.out.println(f.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (InterruptedException e) {
            System.out.println(e);
        }catch (ExecutionException e) {
            System.out.println(e);
        }
        es.shutdown();
        System.out.println("Done");
    }
}

class Sum implements Callable<Integer> {
    int stop;
    Sum(int v) {stop = v;}

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }
}

class Hypot implements Callable<Double> {
    double side1, side2;
    Hypot (double s1, double s2) {side1 = s1; side2 = s2;}

    @Override
    public Double call() throws Exception {
        return Math.sqrt((side1 * side1) + (side2 * side2));
    }
}

class Factorial implements Callable<Integer> {
    int stop;
    Factorial(int v) {stop = v;}

    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 2; i <= stop; i++) {
            fact *= i;
        }
        return fact;
    }
}