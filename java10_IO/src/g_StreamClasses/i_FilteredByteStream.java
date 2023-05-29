package g_StreamClasses;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

/*
* Luồng byte đã được lọc
* Các luồng đã được lọc đơn giản chỉ là các lớp bao bọc xung quanh các luồng đầu vào hoặc đầu ra cơ bản nhằm cung cấp một mức độ
* chức năng mở rộng. Những luồng này thường được truy cập bằng các phương thức mong đợi một luồng tổng quát, là một lớp cha của
* các luồng đã được lọc.
*
* Các chức năng mở rộng thông thường bao gồm đệm, chuyển đổi ký tự và chuyển đổi dữ liệu thô.
* Các luồng byte đã được lọc bao gồm FilterInputStream và FilterOutputStream. Dưới đây là các hàm tạo của chúng:
*
* FilterOutputStream(OutputStream os)
* FilterInputStream(InputStream is)
*
* Các phương thức được cung cấp trong các lớp này tương tự như các phương thức trong InputStream và OutputStream.
* Khi học về luồng đã được lọc, quan trọng là hiểu rằng chúng mang lại sự linh hoạt và dễ bảo trì hơn so với việc sử dụng
* FileOutputStream và FileInputStream trực tiếp.
*
* Khi sử dụng FilterInputStream và FilterOutputStream, bạn có thể thực hiện các tính năng mở rộng như đệm, chuyển đổi ký tự
* và chuyển đổi dữ liệu thô một cách dễ dàng và trong suốt. Bạn có thể thêm và xóa các bộ lọc một cách linh hoạt để mở rộng
* chức năng của luồng mà không ảnh hưởng đến cách bạn sử dụng luồng chính.
*
* Điều này giúp mã nguồn của bạn trở nên linh hoạt hơn vì bạn có thể dễ dàng điều chỉnh tính năng của luồng bằng cách thêm
* hoặc xóa các bộ lọc. Đồng thời, việc sử dụng luồng đã được lọc giúp bạn tập trung vào việc xử lý dữ liệu chính mà không phải
* lo lắng về các tính năng bổ sung.
*
* Ngoài ra, việc sử dụng FilterInputStream và FilterOutputStream cũng giúp mã của bạn dễ bảo trì hơn. Bạn có thể thay đổi
* hoặc cải thiện tính năng của luồng bằng cách chỉnh sửa hoặc thay đổi bộ lọc mà không phải thay đổi toàn bộ cách sử dụng luồng.
*
* Tóm lại, sử dụng luồng đã được lọc mang lại sự linh hoạt, dễ bảo trì và tập trung vào xử lý dữ liệu chính. Bằng cách thêm
* và xóa các bộ lọc, bạn có thể mở rộng chức năng của luồng một cách linh hoạt mà không ảnh hưởng đến cách sử dụng luồng chính.
*
* */
public class i_FilteredByteStream {
    public static void main(String[] args) throws IOException {

    }
}
