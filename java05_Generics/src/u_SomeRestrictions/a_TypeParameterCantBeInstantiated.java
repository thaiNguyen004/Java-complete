package u_SomeRestrictions;
/*
* Tham số kiểu không thể được khởi tạo ?
* Không thể tạo một phiên bản của một tham số kiểu. Ví dụ, xem xét lớp sau đây:*/

class Gen<T> {
    T ob;
    Gen() {
//        ob = new T; Illegal Bất hợp pháp
    }
}
/*
* Ở đây, việc cố gắng tạo một phiên bản của T là không hợp lệ. Lý do này nên dễ hiểu:
* trình biên dịch không biết tạo ra đối tượng kiểu gì. T chỉ là một định vị giữ chỗ.*/
public class a_TypeParameterCantBeInstantiated {

}
