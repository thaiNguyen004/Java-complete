package k_PredifinedFunctionalInterface;

import java.util.function.Function;

/*
* Chương trình sau cho thấy giao diện Function trong hoạt động bằng cách sử dụng nó để cải thiện ví dụ trước gọi là BlockLambdaDemo,
* đã minh họa block lambdas bằng cách thực hiện một ví dụ về giai thừa. Ví dụ đó đã tạo ra giao diện chức năng riêng của nó được gọi là NumericFunc,
* nhưng giao diện Function tích hợp sẵn cũng có thể được sử dụng, như phiên bản chương trình này minh họa:
* */
public class useFunctionInterfaceDemo {
    public static void main(String[] args) {
        //Block lambda này tính giai thừa của một giá trị int, lần này giao diện chức năng là Function.
        Function<Integer,Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1 ; i <= n ; i++) {
                result *= i;
            }
            return result;
        };

        System.out.println("Factorial of 5 = " + factorial.apply(5));
        //Factorial of 5 = 120
        System.out.println("Factorial of 9 = " + factorial.apply(7));
        //Factorial of 9 = 5040

        //Giống như các ví dụ trước
    }
}
