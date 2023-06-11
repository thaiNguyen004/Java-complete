package k_Http;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/*
*
* Một ví dụ đơn giản về HTTP Client
* Ví dụ sau đưa vào hoạt động các tính năng của HTTP Client API đã được mô tả. Nó minh họa việc gửi một yêu cầu,
* hiển thị thân bản (body) của phản hồi và lấy danh sách các tiêu đề của phản hồi.
* Bạn nên so sánh nó với các phần tương tự trong các chương trình HttpURLDemo đã được hiển thị trước đó.
* Lưu ý rằng nó sử dụng ofInputStream() để lấy một luồng vào liên kết với thân bản của phản hồi.
*
* */
public class e_HttpExample {
    public static void main(String[] args) throws Exception{
        // Thu được client bằng việc sử dụng cài đặt mặc định
        // Obtain a client that uses the default setting
        HttpClient myHC = HttpClient.newHttpClient();

        // Create a request
        // Tạo ra một yêu cầu
        HttpRequest myReq = HttpRequest.newBuilder(
                new URI("http://www.google.com/")).build();

        // Gửi yêu cầu và nhận phản hồi. Ở đây, một InputStream được sử dụng cho phần thân bản (body).
        HttpResponse<Stream<String>> myResp = myHC.send(myReq,
                HttpResponse.BodyHandlers.ofLines());

        // Hiển thị mã phản hồi và phương thức phản hồi
        System.out.println("Mã phản hồi: " + myResp.statusCode());
        System.out.println("Phương thức yêu cầu: " + myReq.method());

        // Nhận tiêu đề từ phản hồi
        HttpHeaders hdrs = myResp.headers();

        // Nhận một map chứa các tiêu đề và giá trị
        Map<String, List<String>> hdrMap = hdrs.map();
        Set<String> hdrField = hdrMap.keySet();
        System.out.println("Ở đây là các tiêu đề");
        for (String k : hdrField) {
            System.out.println("Key: " + k +" Value: " +hdrMap.get(k));
        }

        // Hiển thị phần thân bản của phản hồi
        System.out.println("Here is the body: ");
//        InputStream input = myResp.body();
//        int c;
//        while((c = input.read()) != -1)
//            System.out.print((char) c);
        myResp.body().forEach(e -> System.out.println(e));
    }
}

/*
* Chương trình trước tiên tạo một HttpClient và sau đó sử dụng client đó để gửi một yêu cầu đến www.google.com
* (tất nhiên, bạn có thể thay thế bằng bất kỳ trang web nào bạn muốn). Body handler sử dụng một input stream thông qua ofInputStream().
* Tiếp theo, mã trạng thái phản hồi và phương thức yêu cầu được hiển thị. Sau đó, tiêu đề được hiển thị, theo sau là phần thân.
* Vì ofInputStream() được chỉ định trong phương thức send(), phương thức body() sẽ trả về một InputStream.
* Stream này sau đó được sử dụng để đọc và hiển thị phần thân.
*
* Chương trình trước đó sử dụng một input stream để xử lý phần thân cho mục đích so sánh với chương trình UCDemo được hiển thị trước đó,
* sử dụng phương pháp song song. Tuy nhiên, còn các lựa chọn khác. Ví dụ, bạn có thể sử dụng ofString() để xử lý phần thân dưới dạng một chuỗi.
* Với phương pháp này, khi nhận được phản hồi, phần thân sẽ nằm trong một thể hiện String. Để thử điều này, thay thế dòng gọi send() bằng đoạn mã sau:
*
* HttpResponse<String> myResp = myHC.send(myReq,
*                       HttpResponse.BodyHandlers.ofString());
*
* Tiếp theo, thay thế đoạn mã sử dụng input stream để đọc và hiển thị phần thân bằng dòng sau:
*
* System.out.println(myResp.body());
*
* Vì phần thân của phản hồi đã được lưu trữ trong một chuỗi, nó có thể được in ra trực tiếp.
* Bạn có thể muốn thử nghiệm với các body handler khác. Đặc biệt đáng quan tâm là ofLines(), cho phép bạn truy cập vào
* phần thân dưới dạng một luồng các dòng. Một trong những lợi ích của HTTP Client API là có sẵn các body handler
* tích hợp cho nhiều tình huống khác nhau.
*
*
* Các khía cạnh khám phá trong java.net.http
* Phần giới thiệu trước đã mô tả một số tính năng chính trong HTTP Client API của java.net.http,
* nhưng còn nhiều tính năng khác mà bạn sẽ muốn khám phá.
*
* Một trong những tính năng quan trọng nhất là lớp WebSocket, hỗ trợ giao tiếp hai chiều.
* Một tính năng khác là khả năng không đồng bộ được hỗ trợ bởi API.
* Nói chung, nếu lập trình mạng là trong tương lai của bạn, bạn sẽ muốn khám phá kỹ về java.net.http.
* Đó là một bổ sung quan trọng cho các API mạng của Java.
* */