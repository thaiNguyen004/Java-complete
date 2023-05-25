package o_assert;
/*
* Sử dụng từ khóa assert
* Một từ khóa thú vị khác là assert. Nó được sử dụng trong quá trình phát triển chương trình để tạo ra một khẳng định,
* đó là một điều kiện mà nên đúng trong quá trình thực thi của chương trình. Ví dụ, bạn có thể có một phương thức luôn
* trả về một giá trị số nguyên dương. Bạn có thể kiểm tra điều này bằng cách khẳng định rằng giá trị trả về lớn hơn không
* bằng một câu lệnh assert. Trong thời gian chạy, nếu điều kiện đúng, không có hành động nào khác diễn ra. Tuy nhiên,
* nếu điều kiện sai, thì một AssertionError được ném ra. Các khẳng định thường được sử dụng trong quá trình kiểm tra
* để xác nhận rằng một số điều kiện dự kiến được thực sự đáp ứng.
* Chúng thường không được sử dụng cho mã nguồn đã được phát hành.
*
* Từ khóa assert có hai dạng. Dạng đầu tiên được hiển thị như sau:
*      assert condition;
* Ở đây, condition là một biểu thức phải đánh giá thành kết quả Boolean. Nếu kết quả là true, thì khẳng định là đúng và
* không có hành động nào khác diễn ra. Nếu điều kiện là false, thì khẳng định thất bại và một đối tượng AssertionError mặc định được ném ra.
*
* Dạng thứ hai của assert được hiển thị như sau:
*      assert condition: expr;
* Trong phiên bản này, expr là một giá trị được chuyển đến constructor của AssertionError. Giá trị này được chuyển đổi thành
* định dạng chuỗi và hiển thị nếu khẳng định thất bại. Thông thường, bạn sẽ chỉ định một chuỗi cho expr, nhưng bất kỳ biểu thức
* không trả về void nào cũng được chấp nhận miễn là nó xác định một quá trình chuyển đổi chuỗi hợp lý.
*
* Dưới đây là một ví dụ sử dụng assert. Nó xác nhận rằng giá trị trả về của getnum() là dương.*/
public class a_exampleAssert {
    static int val = 3;

    //Trả về 1 số nguyên
    static int getnum(){
        return val--;
    }

    public static void main(String[] args) {
        int n;
        for (int i = 0; i < 10; i++) {
//            n = getnum();
////            assert n > 0; //will false when n is 0
//            assert n > 0 : "n khong phai la mot so nguyen duong";
//            System.out.println("n: " + n);
        }
        /*
        *
            n: 3
            n: 2
            n: 1
            n: 0
            n: -1
            n: -2
            n: -3
            n: -4
            n: -5
            n: -6
        -- Không có vấn đề gì đúng không!
        * Để kích hoạt kiểm tra khẳng định trong thời gian chạy, bạn phải chỉ định tùy chọn -ea.
        * Ví dụ, để kích hoạt khẳng định cho AssertDemo, thực thi nó bằng dòng lệnh sau:
        *       java -ea example2.java
        *
        * n: 3
        * n: 2
        * n: 1
        * Exception in thread "main" java.lang.AssertionError
        * at o_assert.example.main(example.java:36)
        *
        * Câu lệnh này sẽ thất bại khi n bằng 0, điều này sẽ xảy ra sau lần gọi thứ tư. Khi điều này xảy ra, một ngoại lệ được ném ra.
        * Như đã giải thích, bạn có thể chỉ định thông báo được hiển thị khi một khẳng định thất bại. Ví dụ, nếu bạn thay thế
        *       assert n > 0 : "n is not positive!";
        * cho khẳng định trong chương trình trước đó, sau đó đầu ra sau sẽ được tạo ra:
        * n: 3
        * n: 2
        * n: 1
        * Exception in thread "main" java.lang.AssertionError: n khong phai la mot so nguyen duong
        * at o_assert.example.main(example.java:37)
        *
        * Một điểm quan trọng cần hiểu về các khẳng định là bạn không được phụ thuộc vào chúng để thực hiện bất kỳ hành động
        * nào thực sự cần thiết bởi chương trình. Lý do là thông thường, mã đã được phát hành sẽ chạy với các khẳng định bị vô hiệu hóa.
        * Ví dụ, xem xét biến thể sau của chương trình trước đó:
        * */

        int m = 0;
        for (int i = 0; i < 10; i++) {
            assert (m = getnum()) > 0 ; //this is good idea!
            System.out.println("m is : " + m);
        }

        /*
        * Trong phiên bản này của chương trình, cuộc gọi đến getnum() được di chuyển vào trong câu khẳng định assert.
        * Mặc dù điều này hoạt động tốt nếu các khẳng định được kích hoạt, nhưng nó sẽ gây mất chức năng khi các khẳng định bị vô hiệu hóa,
        * vì cuộc gọi đến getnum() sẽ không bao giờ được thực hiện! Trên thực tế, m phải được khởi tạo, vì trình biên dịch sẽ nhận ra rằng
        * nó có thể không được gán giá trị bởi câu lệnh assert.
        *
        * Các khẳng định có thể rất hữu ích vì chúng giúp tối ưu hóa loại kiểm tra lỗi thông thường trong quá trình phát triển.
        * Ví dụ, trước khi có assert, nếu bạn muốn xác minh rằng n là số dương trong chương trình trước đó, bạn phải sử dụng một chuỗi mã
        * tương tự như sau:
        *   if (n < O) {
        *       System.out.println("n is negative !")
        *       return; // or throw an exception
        *
        * Với assert, bạn chỉ cần một dòng mã. Hơn nữa, bạn không cần phải loại bỏ các câu lệnh assert khỏi mã đã phát hành.
        * */
    }
}
