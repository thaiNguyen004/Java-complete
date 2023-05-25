package q_OverloadingThis;
/*
* Gọi các Constructor Qua this()
* Khi làm việc với các constructor được nạp chồng, đôi khi việc gọi một constructor khác từ constructor hiện tại là hữu ích.
* Trong Java, điều này được thực hiện bằng cách sử dụng một dạng khác của từ khóa this. Định dạng chung được hiển thị như sau:
*
* this(danh-sách-tham-số)
*
* Khi this() được thực thi, constructor nạp chồng phù hợp với danh sách tham số được chỉ định bởi danh-sách-tham-số sẽ được thực thi trước.
* Sau đó, nếu có bất kỳ câu lệnh nào trong constructor ban đầu, chúng sẽ được thực thi. Cuộc gọi this() phải là câu lệnh đầu tiên trong constructor.
*
* Để hiểu cách sử dụng this(), chúng ta hãy xem qua một ví dụ ngắn. Đầu tiên, hãy xem xét class sau không sử dụng this():*/

class MyClass {
    int a, b;

    //Khởi tạo a và b riêng lẻ
    MyClass (int i, int j) {
        a = i;
        b = j;
    }
    //Khởi tạo a và b cùng giá trị value
    MyClass (int i) {
        a = i;
        b = i;
    }
    //Khởi tạo a và b có cùng giá trị 0
    MyClass () {
        a = 0;
        b = 0;
    }
/*
* Lớp này chứa ba constructor, mỗi constructor khởi tạo giá trị của a và b. Constructor đầu tiên được truyền các giá trị riêng lẻ
* cho a và b. Constructor thứ hai chỉ truyền một giá trị, và giá trị này được gán cho cả a và b. Constructor thứ ba gán giá trị
* mặc định của a và b là 0.
*
* Bằng cách sử dụng this(), chúng ta có thể viết lại MyClass như sau:
* */
}

class MyClass1 {
    int a, b;

    MyClass1(int i, int j) {
        a = i;
        b = j;
    }
    //Khởi tạo a và b có cùng giá trị value
    MyClass1(int i) {
        this(i, i);
    }
    //Khởi tạo a và b có cùng giá trị 0
    MyClass1 () {
        this(0);
    }
}
/*
* Trong phiên bản MyClass này, constructor duy nhất thực sự gán giá trị cho các trường a và b là MyClass(int, int).
* Hai constructor còn lại chỉ đơn giản là gọi constructor đó (trực tiếp hoặc gián tiếp) thông qua this(). Ví dụ, hãy xem điều gì
* xảy ra khi câu lệnh này được thực thi:
*
*       MyClass mc = new MyClass(8);
*
* Cuộc gọi MyClass(8) dẫn đến việc thực thi this(8, 8), tương đương với việc gọi MyClass(8, 8), vì đây là phiên bản của constructor
* MyClass có danh sách tham số phù hợp với các đối số được truyền qua this(). Bây giờ, hãy xem câu lệnh sau, sử dụng constructor mặc định:
*
*       MyClass mc2 = new MyClass();
*
* Trong trường hợp này, this(0) được gọi. Điều này dẫn đến việc gọi MyClass(0) vì đó là constructor có danh sách tham số phù hợp.
* Tất nhiên, MyClass(0) sau đó gọi MyClass(0, 0) như đã mô tả.
*
* Một lý do khác tại sao việc gọi các constructor được nạp chồng thông qua this() có thể hữu ích là nó có thể ngăn chặn việc nhân bản
* mã code không cần thiết. Trong nhiều trường hợp. Giảm mã code trùng lặp giúp giảm thời gian tải lớp của bạn vì thông thường mã đối
* tượng sẽ nhỏ hơn. Điều này đặc biệt quan trọng đối với các chương trình được cung cấp qua Internet nơi thời gian tải lên là một vấn đề.
* Sử dụng this() cũng có thể giúp tổ chức mã của bạn khi các constructor chứa một lượng mã trùng lặp lớn.
*
* Tuy nhiên, bạn cần cẩn thận. Các constructor gọi this() sẽ chạy chậm hơn so với những constructor chứa toàn bộ mã khởi tạo trong nội tuyến.
* Điều này bởi vì cơ chế gọi và trả về được sử dụng khi constructor thứ hai được gọi thêm vào chi phí thêm. Nếu lớp của bạn chỉ được sử dụng
* để tạo ra một số ít đối tượng hoặc các constructor trong lớp gọi this() sẽ ít được sử dụng, thì sự giảm hiệu năng thời gian chạy này có thể
* không đáng kể.
*
* Tuy nhiên, nếu lớp của bạn được sử dụng để tạo ra một số lượng lớn đối tượng (khoảng hàng nghìn) trong quá trình chạy chương trình,
* thì ảnh hưởng tiêu cực của chi phí thêm có thể có ý nghĩa. Bởi vì việc tạo đối tượng ảnh hưởng đến tất cả người dùng của lớp của bạn,
* sẽ có những trường hợp bạn phải cân nhắc kỹ lưỡng lợi ích của thời gian tải nhanh hơn so với thời gian tạo đối tượng tăng lên.
*
* Đây là một yếu tố khác: đối với các constructor rất ngắn, như các constructor được sử dụng bởi MyClass, thường không có sự khác biệt đáng
* kể về kích thước của mã đối tượng, dù có sử dụng this() hay không.
* (Thực tế, có những trường hợp không giảm kích thước của mã đối tượng được đạt được.)
*
* Điều này bởi vì bytecode thiết lập và trả về từ cuộc gọi this() thêm các chỉ thị vào tệp đối tượng. Do đó, trong những tình huống như này,
* mặc dù mã code trùng lặp được loại bỏ, việc sử dụng this() sẽ không đem lại sự tiết kiệm đáng kể về thời gian tải. T
*
*
* Có hai hạn chế bạn cần ghi nhớ khi sử dụng this().
*   Thứ nhất, bạn không thể sử dụng bất kỳ biến thành viên của lớp constructor trong cuộc gọi this().
*   Thứ hai, bạn không thể sử dụng super() và this() trong cùng một constructor vì mỗi cái phải là câu lệnh đầu tiên trong constructor.*/
public class example {
}
