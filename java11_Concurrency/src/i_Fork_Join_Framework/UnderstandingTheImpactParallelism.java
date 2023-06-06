package i_Fork_Join_Framework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/*
 * Để hiểu rõ hơn về tác động của mức độ song song đến hiệu suất của một nhiệm vụ fork/join và
 * cách tương tác giữa song song và ngưỡng, điều quan trọng là hiểu. Chương trình được hiển thị trong
 * phần này cho phép bạn thử nghiệm với các mức độ song song và giá trị ngưỡng khác nhau.
 * Giả sử bạn đang sử dụng một máy tính đa lõi, bạn có thể quan sát tác động của các giá trị này theo
 * cách tương tác.
 * Trong ví dụ trước đó, đã sử dụng mức độ song song mặc định.
 * Tuy nhiên, bạn có thể chỉ định mức độ song song mong muốn. Một cách là chỉ định nó khi bạn tạo một
 * ForkJoinPool bằng cách sử dụng constructor sau:
 * ForkJoinPool(int pLevel)
 * Ở đây, pLevel chỉ định mức độ song song, phải lớn hơn 0 và nhỏ hơn giới hạn được định nghĩa bởi hệ thống.
 * Chương trình sau tạo một nhiệm vụ fork/join để biến đổi một mảng các số thực. Quá trình biến đổi là tùy ý,
 * nhưng được thiết kế để tốn nhiều chu kỳ CPU. Điều này được thực hiện để đảm bảo rõ ràng hơn tác động của
 * việc thay đổi ngưỡng hoặc mức độ song song. Để sử dụng chương trình, chỉ định giá trị ngưỡng và mức độ
 * song song trên dòng lệnh. Sau đó, chương trình chạy các nhiệm vụ và hiển thị thời gian thực hiện của chúng.
 * Để làm điều này, chương trình sử dụng System.nanoTime(), trả về giá trị của bộ đếm thời gian có độ
 * phân giải cao của JVM.
* */

class Transform extends RecursiveAction {
    int seqThreshold; // Không chỉ định ngưỡng cố định mà chỉ định thông qua constructor
    double[] data;
    int start, end;
    Transform (double[] vals, int s, int e, int t) {
        data = vals;
        start = s;
        end = e;
        seqThreshold = t;
    }
    @Override
    protected void compute() {
        if((end - start) < seqThreshold) {
            // Mã này thực hiện tính căn bậc hai của số chẵn, căn bậc ba của số lẻ\
            // Mã này được thiết kế để đơn giản là tiêu tốn thời gian của CPU để các tác động
            // của việc thực thi đồng thời dễ quan sát hơn.
            for (int i = 0; i < data.length; i++) {
                if((data[i] % 2) == 0)
                    data[i] = Math.sqrt(data[i]);
                else
                    data[i] = Math.cbrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new Transform(data, start, middle, seqThreshold),
                    new Transform(data, middle, end, seqThreshold));
        }
    }
}
public class UnderstandingTheImpactParallelism {
    public static void main(String[] args) {
        int pLevel = 32;
        int threshold = 64000;

//        pLevel = Integer.parseInt(args[0]);
//        threshold = Integer.parseInt(args[1]);

        long beginT, endT;

        ForkJoinPool fjp = new ForkJoinPool(pLevel);

        double[] nums = new double[1000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }

        Transform task = new Transform(nums, 0, nums.length, threshold);

        //Starting
        beginT = System.nanoTime();
        fjp.invoke(task);
        endT = System.nanoTime();
        System.out.println("Mức độ song song: " + pLevel);
        System.out.println("Ngưỡng giới hạn: " + threshold);
        System.out.println("Khoảng thời gian: " + (endT - beginT) +" ns");
        System.out.println();
        System.out.println(fjp.getParallelism());
        /*
        * Mức độ song song: 1
        * Ngưỡng giới hạn: 1000
        * Khoảng thời gian: 13159821900 ns -> 13.1s
        *
        * Mức độ song song: 2
        * Ngưỡng giới hạn: 1000
        * Khoảng thời gian: 6848256900 ns -> 6.8s
        *
        * Mức độ song song: 3
        * Ngưỡng giới hạn: 1000
        * Khoảng thời gian: 4618159900 ns
        *
        * Mức độ song song: 4
        * Ngưỡng giới hạn: 1000
        * Khoảng thời gian: 3620954500 ns
        *
        * Mức độ song song: 8
        * Ngưỡng giới hạn: 1000
        * Khoảng thời gian: 2376559300 ns
        *
        * Mức độ song song: 16
        * Ngưỡng giới hạn: 1000
        * Khoảng thời gian: 1934541900 ns
        *
        * Mức độ song song: 16
        * Ngưỡng giới hạn: 2000
        * Khoảng thời gian: 1014280500 ns
        *
        * Mức độ song song: 32
        * Ngưỡng giới hạn: 4000
        * Khoảng thời gian: 539580200 ns
        *
        * Mức độ song song: 32
        * Ngưỡng giới hạn: 8000
        * Khoảng thời gian: 294352000 ns
        *
        * Mức độ song song: 32
        * Ngưỡng giới hạn: 16000
        * Khoảng thời gian: 194856400 ns
        *
        * Mức độ song song: 32
        * Ngưỡng giới hạn: 32000
        * Khoảng thời gian: 140286600 ns
        *
        * Mức độ song song: 32
        * Ngưỡng giới hạn: 64000
        * Khoảng thời gian: 95527200 ns
        *
        * Dưới đây là kết quả mẫu từ quá trình chạy này trên cùng một máy tính hai lõi:
        *
        * Như có thể thấy, việc thêm đồng thời hóa giảm đáng kể thời gian thực thi, từ đó tăng tốc độ của chương trình.
        * Bạn nên thử nghiệm với việc thay đổi ngưỡng và đồng thời hóa trên máy tính của riêng bạn.
        * Kết quả có thể khiến bạn ngạc nhiên.
        * Dưới đây là hai phương thức khác mà bạn có thể tìm hữu ích khi thử nghiệm với các đặc điểm thực thi
        * của một chương trình fork/join. Trước tiên, bạn có thể lấy mức độ đồng thời hóa bằng cách gọi
        * phương thức getParallelism(), được định nghĩa bởi ForkJoinPool. Nó được hiển thị như sau:
        * int getParallelism()
        * Nó trả về mức độ đồng thời hóa hiện đang có hiệu lực. Hãy nhớ rằng đối với các pool mà bạn tạo,
        * mặc định, giá trị này sẽ bằng số bộ xử lý có sẵn. (Để lấy mức độ đồng thời hóa cho pool chung,
        * bạn cũng có thể sử dụng getCommonPoolParallelism()). Thứ hai, bạn có thể lấy số bộ xử lý có sẵn
        * trong hệ thống bằng cách gọi phương thức availableProcessors(), được định nghĩa bởi lớp Runtime.
        * int availableProcessors()
        * Giá trị trả về có thể thay đổi từ lần gọi này sang lần gọi khác do yêu cầu hệ thống khác.
        * */
    }
}
