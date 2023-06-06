package e_TimeUnit;

import java.util.concurrent.*;

/*
* Định danh TimeUnit
* API đồng thời định nghĩa một số phương thức nhận một đối số kiểu TimeUnit, cho biết một khoảng thời gian chờ đợi.
* TimeUnit là một định danh được sử dụng để chỉ định độ chi tiết (hoặc độ phân giải) của thời gian.
* TimeUnit được định nghĩa trong java.util.concurrent. Nó có thể là một trong các giá trị sau:
* DAYS (Ngày)
* HOURS (Giờ)
* MINUTES (Phút)
* SECONDS (Giây)
* MICROSECONDS (Micro giây)
* MILLISECONDS (Mili giây)
* NANOSECONDS (Nano giây)
*
* Mặc dù TimeUnit cho phép bạn chỉ định bất kỳ giá trị nào trong các cuộc gọi phương thức có đối số thời gian, nhưng không đảm
* bảo hệ thống có khả năng với độ phân giải cụ thể được chỉ định.
*
* Dưới đây là một ví dụ sử dụng TimeUnit. Lớp CallableDemo, được hiển thị trong phần trước, được sửa đổi như sau để sử dụng dạng
* thứ hai của phương thức get() nhận một đối số TimeUnit.
*
* */
public class geory_example {
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
            System.out.println(f.get(10, TimeUnit.MILLISECONDS));
            System.out.println(f2.get(10, TimeUnit.MILLISECONDS));
            System.out.println(f3.get(10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            System.out.println(e);
        }catch (ExecutionException e) {
            System.out.println(e);
        } catch (TimeoutException e) {
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
