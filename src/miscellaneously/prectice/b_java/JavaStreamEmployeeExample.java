package src.miscellaneously.prectice.b_java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean isSenior() {
        return senior;
    }

    public void setSenior(Boolean senior) {
        this.senior = senior;
    }

    Boolean senior;


}
public class JavaStreamEmployeeExample {

    public static void main(String s[]) {
        List<Employee> listOfEmployee = new ArrayList<>();
        Employee e1 = new Employee();
        e1.setAge(60);
        Employee e2 = new Employee();
        e2.setAge(50);
        Employee e3 = new Employee();
        e3.setAge(40);
        Employee e4 = new Employee();
        e4.setAge(62);

        listOfEmployee.add(e1);
        listOfEmployee.add(e2);
        listOfEmployee.add(e3);
        listOfEmployee.add(e4);

       List<Employee> output =  listOfEmployee.stream().filter((e) -> e.getAge() >=60)
                .map((e) -> {e.setSenior(true);
                return e;}).collect(Collectors.toList());

        output.forEach((e) -> System.out.println(e.getAge()));

    }

}
