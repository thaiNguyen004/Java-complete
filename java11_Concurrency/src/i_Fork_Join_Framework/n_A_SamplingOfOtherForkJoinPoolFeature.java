package i_Fork_Join_Framework;
/*
* Một số tính năng khác của ForkJoinPool
* Một phương thức rất hữu ích khi tinh chỉnh ứng dụng fork/join là việc ghi đè toString() của ForkJoinPool.
* Nó hiển thị một tóm tắt "dễ đọc" về trạng thái của pool.
*
* */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class n_A_SamplingOfOtherForkJoinPoolFeature {

}
class FJExperiment {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool(32);
        double[] data = new double[10000];
        for (int i = 0; i < data.length; i++) {
            data[i] = ((i%2 == 0) ?  i : -i);
        }


        SumNumber task = new SumNumber(data, 0, data.length, 500);

        double sum = fjp.invoke(task);
//        fjp.execute(task);

        // Kết quả ban đầu là -5000
//        fjp.shutdown(); // dừng pool nhưng nếu đang chạy thì vẫn chạy nốt
        fjp.shutdownNow(); // dừng ngay lập tức
        /*
        * Phương thức `shutdownNow()` được sử dụng để dừng ngay lập tức các tác vụ đang hoạt động trong pool
        * và cố gắng hủy bỏ chúng. Mặc dù phương thức này cố gắng ngừng các tác vụ đang chạy, việc hủy bỏ một ,
        * tác vụ không đảm bảo thành công 100% vì nó phụ thuộc vào việc tác vụ có hỗ trợ hủy bỏ hay không.
        * Khi gọi `shutdownNow()`, pool sẽ gửi một yêu cầu hủy bỏ tới các tác vụ đang chạy bằng cách gọi
        * phương thức `cancel()` trên từng tác vụ. Tuy nhiên, tác vụ cần phải phản hồi yêu cầu hủy bỏ bằng cách
        * kiểm tra trạng thái hủy bỏ trong phương thức `compute()` và dừng lại nếu nhận được yêu cầu hủy bỏ.
        * Nếu một tác vụ không hỗ trợ hủy bỏ hoặc không phản hồi yêu cầu hủy bỏ, nó vẫn tiếp tục thực hiện cho
        * đến khi hoàn thành.
        * Do đó, mặc dù gọi `shutdownNow()` có thể ngừng một số tác vụ, nhưng không đảm bảo rằng tất cả các tác vụ
        * đều bị dừng ngay lập tức hoặc bị hủy bỏ. Kết quả cuối cùng mà bạn nhận được sau khi gọi `shutdownNow()`
        * phụ thuộc vào tính năng hủy bỏ của từng tác vụ và thời gian xử lý của chúng.
        * */
        // Kiểm tra xem pool đã tắt chưa ??
        if(fjp.isShutdown())
            System.out.println("Pool đã tắt");
        else
            System.out.println("Pool chưa tắt");

        // Kiểm tra xem Pool có luồng đang hoạt động hay không true nếu không và ngược lại
        System.out.println(fjp.isQuiescent());
        // Bạn cũng có thể xác định số lượng xấp xỉ của các luồng hoạt động trong pool
        System.out.println(fjp.getActiveThreadCount());

        if(!task.isDone())
            System.out.println(fjp);
        //[Running, parallelism = 32, size = 1, active = 1, running = 0, steals = 0, tasks = 0, submissions = 1]

        for (int i = data.length - 11; i < data.length; i++)
            System.out.print(data[i]+" ");
        System.out.println();

        // Lấy số luồng xử lý hiện tại đang tồn tại trong Pool
        System.out.println(fjp.getPoolSize());


        // Kết quả
        System.out.println("Sum: " + sum);

    }
}

class SumNumber extends RecursiveTask<Double> {
    int seqThreshold;
    double[] data;
    int start, end;
    SumNumber (double[] vals, int s, int e, int i) {
        data = vals;
        start = s;
        end = e;
        seqThreshold = i;
    }

    @Override
    protected Double compute() {
        double sum = 0;
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        }else {
            int middle = (end + start) / 2;
            SumNumber task1 = new SumNumber(data, start, middle, seqThreshold);
            SumNumber task2 = new SumNumber(data, middle, end, seqThreshold);
            task1.fork();
            task2.fork();

            sum = task1.join() + task2.join();
        }
        return sum;
    }
}
/*
*
* Để tắt một pool, bạn gọi phương thức shutdown(). Các tác vụ đang hoạt động vẫn sẽ được thực hiện,
* nhưng không thể bắt đầu tác vụ mới. Để dừng một pool ngay lập tức, bạn gọi phương thức shutdownNow().
* Trong trường hợp này, cố gắng huỷ các tác vụ đang hoạt động. (Tuy nhiên, cần lưu ý rằng cả hai
* phương thức này không ảnh hưởng đến common pool.) Bạn có thể xác định xem một pool đã được tắt chưa
* bằng cách gọi phương thức isShutdown(). Phương thức này trả về giá trị true nếu pool đã được tắt và
* false trong trường hợp ngược lại. Để xác định xem pool đã được tắt và tất cả các tác vụ đã hoàn thành
* hay chưa, gọi phương thức isTerminated().*/