package i_Fork_Join_Framework;
/*
* Một ví dụ sử dụng RecursiveTask<V>
* Hai ví dụ trước dựa trên RecursiveAction, điều đó có nghĩa là chúng thực hiện các nhiệm vụ đồng thời mà
* không trả về kết quả. Để tạo một nhiệm vụ trả về kết quả, bạn sử dụng RecursiveTask. Nhìn chung, các
* giải pháp được thiết kế theo cùng một cách như đã được hiển thị.
* Sự khác biệt chính là phương thức compute() trả về một kết quả. Do đó, bạn phải tổng hợp các kết quả, để khi
* lần gọi đầu tiên hoàn thành, nó trả về kết quả tổng quan. Một sự khác biệt khác là bạn thường sẽ bắt đầu một
* nhiệm vụ con bằng cách gọi fork() và join() một cách rõ ràng (thay vì ngầm định bằng cách gọi invokeAll(), ví dụ như vậy).
*
* Chương trình sau đây minh họa RecursiveTask. Nó tạo ra một nhiệm vụ được gọi là Sum trả về tổng các giá trị
* trong một mảng double. Trong ví dụ này, mảng bao gồm 5.000 phần tử. Tuy nhiên, mỗi giá trị khác nhau là âm.
* Do đó, các giá trị đầu tiên trong mảng là 0, -1, 2, -3, 4, và cứ tiếp tục như vậy.
* (Lưu ý rằng ví dụ này tạo ra một pool riêng. Bạn có thể thử thay đổi nó để sử dụng common pool như một bài tập.)
*
* */
// Một RecursiveTask tính toán tổng của một mảng nhân đôi.

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Sum extends RecursiveTask<Double> {
    //Ngưỡng tuần tự
    final int seqthreshold = 500;
    double[] data;
    int start, end;
    Sum (double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    @Override
    protected Double compute() {
        double sum = 0;
        // Nếu số phần tử dưới ngưỡng tuần tự thì sử lý tuần tự
        if((end - start) < seqthreshold) {
            for (int i = start ; i < end; i++) {
                sum += data[i];
            }
        }else {
            int middle = (start + end) / 2;

            // Gọi các tác vụ mới sử dụng kiểu chia nhỏ
            Sum subTaskA = new Sum(data, start, middle);
            Sum subTaskB = new Sum(data, middle, end);

            // Bắt đầu các tác vụ
            subTaskA.fork();
            subTaskB.fork();

            // Đợi các nhiệm vụ con quay trở lại và tổng hợp
            sum = subTaskA.join() + subTaskB.join();
        }
        return sum;
    }
}
public class g_ExRecursiveTask {
    public static void main(String[] args) {
        // Tạo ra một TaskPool
        ForkJoinPool fjp = new ForkJoinPool();
        double[] nums = new double[5000];

        // Tạo một mảng có các giá trị âm dương xen kẽ
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) ((i % 2 == 0) ? i : -i);
        }

        Sum task = new Sum(nums, 0, nums.length);
        // Bắt đầu gọi ForkJoinTask chú ý trong trường hợp này
        // invoke trả về kết quả
        double sumation = fjp.invoke(task);
        System.out.println("Sumation: " + sumation);
    }
}

/*
* Dưới đây là kết quả đầu ra từ chương trình:
* Sumation: -2500.0
*
* Có một số điểm thú vị trong chương trình này.
* Đầu tiên, lưu ý rằng hai nhiệm vụ con được thực hiện bằng cách gọi fork(), như được hiển thị ở đây:
* subTaskA.fork();
* subTaskB.fork();
* Trong trường hợp này, fork() được sử dụng vì nó khởi động một nhiệm vụ nhưng không đợi nó hoàn thành.
* (Do đó, nó thực thi nhiệm vụ bất đồng bộ.) Kết quả của mỗi nhiệm vụ được lấy bằng cách gọi join(),
* như được hiển thị ở đây:
* sum = subTaskA.join() + subTaskB.join();
* Lệnh này đợi cho đến khi mỗi nhiệm vụ kết thúc. Sau đó, nó cộng tổng kết quả của mỗi nhiệm vụ và gán tổng đó cho sum.
* Do đó, tổng của mỗi nhiệm vụ con được thêm vào tổng chạy. Cuối cùng, compute() kết thúc bằng cách trả về sum,
* đó sẽ là tổng cuối cùng khi lần gọi đầu tiên trả về.
* Có các cách khác để xử lý việc thực thi không đồng bộ của các nhiệm vụ con.
* Ví dụ, chuỗi sau sử dụng fork() để bắt đầu subTaskA và sử dụng invoke() để bắt đầu và chờ subTaskB:
* subTaskA.fork();
* sum = subTaskB.invoke() + subTaskA.join();
*
* Một lựa chọn khác là cho subTaskB gọi compute() trực tiếp, như được hiển thị ở đây:
* subTaskA.fork();
* sum = subTaskB.compute() + subTaskA.join();
*
* Lưu ý khi gọi phương thức compute luồng sẽ chờ đợi kết quả !!
* */
