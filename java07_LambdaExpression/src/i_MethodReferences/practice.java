package i_MethodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Tìm sinh viên có điểm cao nhất bằng tham chiếu phương thức thể hiện (reference to instance method)
class Student {
    String id, name;
    double gpa;

    public Student (String id, String name, double gpa)
    {this.id = id; this.name = name; this.gpa = gpa;}

}

interface ObjectOperators <T> {
    double func (List<T> list);
}


public class practice {

    static double findMaxGpa (List<Student> list) {
        double maxGpa = list.get(0).gpa;
        for (int i = 0; i < list.size(); i++)
        if(list.get(i).gpa > maxGpa) maxGpa = list.get(i).gpa;

        return maxGpa;
    }

    static <T> double test (List<T> list, ObjectOperators<T> fi) {
        return fi.func(list);
    }

    public static void main(String[] args) {
        List<Student> listStudent = Arrays.asList(
                new Student("ID1", "Nguyên", 7.7),
                new Student("ID2", "Linh", 9.5),
                new Student("ID3", "Dũng", 9.1),
                new Student("ID4", "Thảo", 8.3),
                new Student("ID5", "Sơn", 9.4),
                new Student("ID6", "Khánh", 9.1)
        );

        double maxGPA = test(listStudent, practice::findMaxGpa);
        System.out.println(maxGPA);
    }
}

