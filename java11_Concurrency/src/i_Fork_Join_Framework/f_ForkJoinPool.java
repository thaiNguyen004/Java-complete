package i_Fork_Join_Framework;
/*
* ForkJoinPool
* Việc thực thi ForkJoinTasks diễn ra trong một ForkJoinPool, nơi cũng quản lý việc thực thi các nhiệm vụ.
* Do đó, để thực thi một ForkJoinTask, bạn phải có một ForkJoinPool trước. Bắt đầu từ JDK 8, có hai cách để có
* được một ForkJoinPool. Thứ nhất, bạn có thể tạo một ForkJoinPool một cách rõ ràng bằng cách sử dụng một constructor ForkJoinPool.
* Thứ hai, bạn có thể sử dụng cái gọi là common pool. Common pool (được thêm vào từ JDK 8) là một ForkJoinPool tĩnh tự động sẵn sàng
* để sử dụng. Mỗi phương thức sẽ được giới thiệu ở đây, bắt đầu với việc xây dựng một pool thủ công.
*
* ForkJoinPool định nghĩa một số constructor. Dưới đây là hai constructor được sử dụng phổ biến:
* ForkJoinPool()
* ForkJoinPool(int pLevel)
*
* Constructor đầu tiên tạo ra một pool mặc định hỗ trợ mức độ song song bằng số bộ xử lý có sẵn trong hệ thống.
* Constructor thứ hai cho phép bạn chỉ định mức độ song song. Giá trị của nó phải lớn hơn không và không vượt quá giới hạn của phiên bản hiện tại.
* Mức độ song song xác định số lượng luồng có thể thực thi đồng thời. Kết quả là, mức độ song song xác định hiệu quả số lượng nhiệm vụ
* có thể được thực thi đồng thời. (Tất nhiên, số lượng nhiệm vụ có thể thực thi đồng thời không thể vượt quá số bộ xử lý.)
*
* Quan trọng là hiểu rằng mức độ song song không giới hạn số lượng nhiệm vụ có thể được quản lý bởi pool.
* Một ForkJoinPool có thể quản lý nhiều nhiệm vụ hơn mức độ song song của nó. Hơn nữa, mức độ song song chỉ là một mục tiêu.
* Nó không phải là một cam kết.
*
* Sau khi bạn đã tạo một phiên bản của ForkJoinPool, bạn có thể bắt đầu một nhiệm vụ theo nhiều cách khác nhau.
* Nhiệm vụ đầu tiên được bắt đầu thường được coi là nhiệm vụ chính. Thường, nhiệm vụ chính bắt đầu các nhiệm vụ con
* cũng được quản lý bởi pool. Một cách phổ biến để bắt đầu một nhiệm vụ chính là gọi invoke() trên ForkJoinPool.
* Được trình bày như sau:
*
* <T> T invoke(ForkJoinTask<T> task)
*
* Phương thức này bắt đầu nhiệm vụ được chỉ định bởi task và trả về kết quả của nhiệm vụ. Điều này có nghĩa là mã gọi sẽ
* đợi cho đến khi invoke() trả về.
* Để bắt đầu một nhiệm vụ mà không đợi cho đến khi nó hoàn thành, bạn có thể sử dụng execute().
* Dưới đây là một trong các hình thức của nó:
* void execute(ForkJoinTask<?> task)
* Trong trường hợp này, task được bắt đầu, nhưng mã gọi không đợi cho đến khi nó hoàn thành. Thay vào đó, mã gọi tiếp tục thực
* thi một cách không đồng bộ.
*
* Bắt đầu từ JDK 8, không cần phải tạo một ForkJoinPool một cách rõ ràng vì common pool đã sẵn sàng để sử dụng.
* Nói chung, nếu bạn không sử dụng một pool mà bạn đã tạo, thì common pool sẽ được sử dụng tự động.
* Mặc dù điều này không luôn luôn cần thiết, bạn có thể lấy một tham chiếu đến common pool bằng cách gọi commonPool(), được định nghĩa bởi ForkJoinPool.
* Được trình bày như sau:
*
* static ForkJoinPool commonPool()
*
* Một tham chiếu đến common pool được trả về. Common pool cung cấp một mức độ song song mặc định. Nó có thể được thiết lập bằng cách sử dụng
* thuộc tính hệ thống. (Xem tài liệu API để biết chi tiết.) Thông thường, common pool mặc định là một lựa chọn tốt cho nhiều ứng dụng.
* Tất nhiên, bạn luôn có thể xây dựng pool riêng của mình.
* Có hai cách cơ bản để bắt đầu một nhiệm vụ sử dụng common pool. Thứ nhất, bạn có thể lấy một tham chiếu đến pool bằng cách gọi commonPool(),
* sau đó sử dụng tham chiếu đó để gọi invoke() hoặc execute(), như đã mô tả trước đó.
* Thứ hai, bạn có thể gọi các phương thức của ForkJoinTask như fork() hoặc invoke() trên nhiệm vụ từ bên ngoài phần tính toán của nó.
* Trong trường hợp này, common pool sẽ được sử dụng tự động. Nói cách khác, fork() và invoke() sẽ bắt đầu một nhiệm vụ sử dụng common pool
* nếu nhiệm vụ chưa chạy trong một ForkJoinPool nào khác.
* ForkJoinPool quản lý việc thực thi các luồng của mình bằng một phương pháp gọi là work-stealing. Mỗi luồng worker duy trì một hàng đợi các nhiệm vụ.
* Nếu hàng đợi của một luồng worker rỗng, nó sẽ lấy một nhiệm vụ từ một luồng worker khác.
* Điều này đóng góp vào hiệu suất tổng thể và giúp duy trì một tải cân đối. (Do yêu cầu về thời gian CPU của các quá trình khác trong hệ thống,
* ngay cả hai luồng worker có các nhiệm vụ giống nhau trong hàng đợi của họ có thể không hoàn thành cùng một lúc.)
*
* Một điểm khác: ForkJoinPool sử dụng luồng daemon. Luồng daemon tự động bị chấm dứt khi tất cả các luồng người dùng đã kết thúc.
* Do đó, không cần phải chấm dứt một ForkJoinPool một cách rõ ràng. Tuy nhiên, ngoại trừ common pool, bạn có thể làm điều này
* bằng cách gọi shutdown(). Phương thức shutdown() không có tác dụng đối với common pool.
*
*
* Một Ví dụ Đơn Giản Về Fork/Join Đầu Tiên
* Tại thời điểm này, một ví dụ đơn giản mà minh họa cho Khung công việc Fork/Join và chiến lược chia để trị sẽ hữu ích.
* Dưới đây là một chương trình biến đổi các phần tử trong một mảng số thực thành căn bậc hai của chúng.
* Chương trình thực hiện điều này thông qua một lớp con của RecursiveAction.
* Lưu ý rằng nó tạo ra một ForkJoinPool riêng của mình.
* */

// Một ví dụ đơn giản về chiến lược chia để trị cơ bản.
// Trong trường hợp này, RecursiveAction được sử dụng.

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/*
 * Một ForkJoinTask (thông qua RecursiveAction) biến đổi các phần tử trong một mảng
 * nhân đôi thành căn bậc hai của chúng.
 * Giá trị ngưỡng được đặt một cách tùy ý là 1.000 trong ví dụ này.
 * Trong mã thực tế, giá trị tối ưu có thể được xác định thông qua việc phân tích và thử nghiệm.
 *
 * */
//Transform : biến đổi
class SqrtTransform extends RecursiveAction {
    // Đặt giá trị ngưỡng (Sequential Threshold)
    final int seqThreshold = 1000;

    // Mảng được truy cập
    double[] data;

    //Xác định phần dữ liệu cần sử lý
    int start, end;

    SqrtTransform (double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }
    //Đây là phương thức trong đó tính toán song song sẽ xảy ra.

    @Override
    protected void compute() {
        // Nếu số phần tử dưới ngưỡng tuần tự, thì xử lý tuần tự.
        if ((end - start) < seqThreshold) {
            // Biến đổi từng phần tử thành căn bậc hai của nó.
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            // Nếu không, hãy tiếp tục chia dữ liệu thành các phần nhỏ hơn.
            // Bằng cách tìm middle
            int middle = (start + end) / 2;

            // Invoke new tasks, using the subdivided data.
            // Gọi các tác vụ mới, sử dụng dữ liệu được chia nhỏ
            invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
        }
    }
}

class ForkJoinDemo {
    public static void main(String[] args) {
        // Create a task pool.
        // Tạo ra một nhóm các tác vụ
//        ForkJoinPool fjp = new ForkJoinPool();
        ForkJoinPool fjp = ForkJoinPool.commonPool();
        double[] nums = new double[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }

        System.out.println("Một phần của chuỗi ban đầu: ");
        for (int i = 0 ; i < 10; i++ ) {
            System.out.print(nums[i] +" ");
        }

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);

        //Bắt đầu ForkJoinTask chính
//        fjp.invoke(task); //Cách 1
//        task.fork(); //Cách 2
        ForkJoinPool.commonPool().invoke(task); //Cách 3
        System.out.println("\nMột phần của chuỗi đã biến đổi (đến bốn chữ số thập phân)");
        for (int i = 0; i < 10; i++ ) {
            System.out.format("%.4f ", nums[i]);
        }
        System.out.println();
    }
}
/*
* Như bạn có thể thấy, các giá trị của các phần tử mảng đã được biến đổi thành căn bậc hai của chúng.
* Hãy xem cách chương trình này hoạt động chi tiết. Đầu tiên, hãy lưu ý rằng SqrtTransform là một lớp mở rộng của RecursiveAction.
* Như đã giải thích, RecursiveAction mở rộng ForkJoinTask cho các nhiệm vụ không trả về kết quả.
* Tiếp theo, hãy lưu ý biến hằng seqThreshold. Đây là giá trị xác định khi nào xử lý tuần tự sẽ diễn ra.
* Giá trị này được đặt (một cách tương đối tùy ý) là 1,000.
*
* Tiếp theo, lưu ý rằng một tham chiếu đến mảng cần xử lý được lưu trữ trong biến data và các trường start và end được sử dụng để
* chỉ định ranh giới của các phần tử được truy cập.
* Hành động chính của chương trình xảy ra trong phương thức compute(). Nó bắt đầu bằng việc kiểm tra xem số lượng phần tử cần xử lý
* có nhỏ hơn ngưỡng xử lý tuần tự hay không. Nếu có, các phần tử đó sẽ được xử lý (bằng cách tính căn bậc hai của chúng trong ví dụ này).
* Nếu ngưỡng xử lý tuần tự chưa được đạt, thì hai tác vụ mới được bắt đầu bằng cách gọi invokeAll(). Trong trường hợp này, mỗi tác vụ
* con xử lý một nửa số phần tử.
*
* Như đã giải thích trước đây, invokeAll() đợi cho đến khi cả hai tác vụ trả về. Sau khi tất cả các cuộc gọi đệ quy giải phóng,
* mỗi phần tử trong mảng sẽ được sửa đổi, với nhiều hoạt động diễn ra song song (nếu có nhiều bộ xử lý có sẵn).
* Như đã đề cập, bắt đầu từ JDK 8, không cần phải tạo một ForkJoinPool một cách rõ ràng vì có sẵn một common pool để sử dụng.
* Hơn nữa, việc sử dụng common pool rất đơn giản. Ví dụ, bạn có thể nhận một tham chiếu đến common pool bằng cách gọi phương thức
* static commonPool() được định nghĩa bởi ForkJoinPool. Do đó, chương trình trước đó có thể được viết lại để sử dụng common pool
* bằng cách thay thế cuộc gọi tới constructor của ForkJoinPool bằng cuộc gọi commonPool(), như sau:
*
* ForkJoinPool fjp = ForkJoinPool.commonPool();
*
* Hoặc, không cần phải nhận một tham chiếu đến common pool một cách rõ ràng vì việc gọi phương thức invoke() hoặc fork() của ForkJoinTask
* trên một nhiệm vụ chưa được tham gia vào một pool sẽ khiến nó thực thi trong common pool tự động. Ví dụ, trong chương trình trước đó,
* bạn có thể loại bỏ hoàn toàn biến fjp và bắt đầu nhiệm vụ bằng dòng này:
*
* task.invoke();
*
* Như cuộc thảo luận này đã chỉ ra, common pool có thể dễ sử dụng hơn việc tạo ra pool riêng của bạn.
* Hơn nữa, trong nhiều trường hợp, common pool là phương pháp được ưa thích.
*
* */

public class f_ForkJoinPool {

}
