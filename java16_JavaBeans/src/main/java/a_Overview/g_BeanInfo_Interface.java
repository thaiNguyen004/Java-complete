package a_Overview;
/*
* Sử dụng giao diện BeanInfo
* Như những thảo luận trước đây đã chỉ ra, các mẫu thiết kế xác định ngầm thông tin nào có sẵn cho
* người sử dụng Bean. Giao diện BeanInfo cho phép bạn kiểm soát một cách rõ ràng thông tin nào được
* cung cấp. Giao diện BeanInfo định nghĩa một số phương thức, bao gồm:
* PropertyDescriptor[] getPropertyDescriptors():
* trả về một mảng các đối tượng cung cấp thông tin về các thuộc tính của Bean.
*
* EventSetDescriptor[] getEventSetDescriptors():
* trả về một mảng các đối tượng cung cấp thông tin về các sự kiện của Bean.
*
* MethodDescriptor[] getMethodDescriptors():
* trả về một mảng các đối tượng cung cấp thông tin về các phương thức của Bean.
*
* Các lớp PropertyDescriptor, EventSetDescriptor và MethodDescriptor được định nghĩa trong gói java.beans
* và mô tả các thành phần tương ứng. Bằng cách triển khai các phương thức này, một nhà phát triển có thể
* xác định chính xác những gì được hiển thị cho người dùng, vượt qua việc sử dụng introspection dựa trên
* các mẫu thiết kế.
*
* Khi tạo một lớp triển khai BeanInfo, bạn phải gọi lớp đó là bnameBeanInfo,
* trong đó bname là tên của Bean. Ví dụ, nếu Bean được gọi là MyBean, thì lớp thông tin phải được
* gọi là MyBeanBeanInfo.
*
* Để đơn giản hóa việc sử dụng BeanInfo, JavaBeans cung cấp lớp SimpleBeanInfo.
* Nó cung cấp các phiên bản mặc định của giao diện BeanInfo, bao gồm ba phương thức vừa được trình bày.
* Bạn có thể mở rộng lớp này và ghi đè một hoặc nhiều phương thức để kiểm soát một cách rõ ràng các khía cạnh
* của Bean được tiếp xúc. Nếu bạn không ghi đè một phương thức, introspection dựa trên mẫu thiết kế sẽ
* được sử dụng. Ví dụ, nếu bạn không ghi đè phương thức getPropertyDescriptors(), thì mẫu thiết kế sẽ được
* sử dụng để khám phá các thuộc tính của Bean. Bạn sẽ thấy SimpleBeanInfo hoạt động trong phần sau của chương này.
*
* */
public class g_BeanInfo_Interface {
}
