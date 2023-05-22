package l_LocalVariableTypeInference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class example {

    class myClass {
        private int i;

        myClass(int k) {i = k;}

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        //Ví dụ đơn giản
        var str = "My String";

        //Ví dụ với đối tượng
        var fin = new FileInputStream("text.txt");

        //Ví dụ 
        example e = new example();
        var mc = e.new myClass(10);
        System.out.println(mc.getI());
    }

}