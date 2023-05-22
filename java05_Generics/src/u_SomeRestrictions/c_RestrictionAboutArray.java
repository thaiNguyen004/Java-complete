package u_SomeRestrictions;

/*
* Hạn chế về Mảng Generic
* Có hai hạn chế quan trọng đối với generics liên quan đến mảng.
*       Thứ nhất, bạn không thể khởi tạo một mảng có kiểu phần tử là một tham số kiểu.
*       Thứ hai, bạn không thể tạo một mảng của các tham chiếu generic cụ thể.
* Chương trình ngắn sau đây thể hiện cả hai tình huống:*/

class GenExample <T extends Number> {
    T ob; //OK
    T[] vals; //OK

    GenExample(T o, T[] nums){
        ob = o;
        //Thứ nhất, bạn không thể khởi tạo một mảng có kiểu phần tử là một tham số kiểu.
//        vals = new T[]; Illegal
        //Nhưng câu lệnh dưới đây thì OK
        vals = nums; // OK để gán tham chiếu
    }
}

public class c_RestrictionAboutArray {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        GenExample<Integer> iOb = new GenExample<>(50, nums);

        //Thứ hai, bạn không thể tạo một mảng của các tham chiếu generic cụ thể.
//        GenExample<Integer> n[] = new GenExample<>[100]; Illegal

        //Cách khắc phục này OK
        GenExample<?> n[] = new GenExample<?>[100];

    }
}

/*
* Như chương trình đã thể hiện, việc khai báo một tham chiếu đến một mảng có kiểu T là hợp lệ, như dòng code sau đây:
* T vals[]; // OK
* Tuy nhiên, bạn không thể khởi tạo một mảng của T, như được thử trong dòng code đã được chú thích:
* // vals = new T[10]; // không thể tạo một mảng của T
*
* Lý do bạn không thể tạo một mảng của T là vì trình biên dịch không biết tạo một mảng kiểu gì thực sự.
* Tuy nhiên, bạn có thể truyền một tham chiếu đến một mảng tương thích với kiểu cho Gen() khi tạo một đối tượng và
* gán tham chiếu đó cho vals, như chương trình đã làm trong dòng code này:
*       vals = nums; // OK để gán tham chiếu đến mảng hiện có
* Điều này hoạt động vì mảng được truyền vào Gen() có một kiểu đã biết, và kiểu đó sẽ là cùng một kiểu với T tại
* thời điểm tạo đối tượng.
*
* Trong phần main(), hãy chú ý rằng bạn không thể khai báo một mảng các tham chiếu đến một kiểu generic cụ thể.
* Điều này có nghĩa, dòng code sau đây sẽ không biên dịch được:
*       // GenExample<Integer> gens[] = new GenExample<Integer>[100]; // Sai!
* Tuy nhiên, bạn có thể tạo một mảng các tham chiếu đến một kiểu generic nếu sử dụng ký tự đại diện (wildcard),
* như được thể hiện ở đây:
* GenExample<?> gens[] = new GenExample<?>[100]; // Đúng
* Cách tiếp cận này tốt hơn so với sử dụng một mảng các kiểu nguyên thủy (raw types), vì ít nhất vẫn có một số
* kiểm tra kiểu sẽ được áp dụng.*/