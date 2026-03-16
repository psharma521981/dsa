package interview.prep;

import java.util.*;
import java.util.stream.Collectors;

class EmployeeDemo {
    private String name;
    private String department;
    private double salary;
    private int age;

    public EmployeeDemo(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    // Getters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return String.format("%s (%s, $%.2f, %d)", name, department, salary, age);
    }
}
public class EmployeeExample {


    public static void main(String[] args) {
        List<EmployeeDemo> employees = Arrays.asList(
                new EmployeeDemo("Alice", "IT", 75000, 28),
                new EmployeeDemo("Bob", "HR", 55000, 35),
                new EmployeeDemo("Charlie", "IT", 90000, 42),
                new EmployeeDemo("David", "Finance", 65000, 31),
                new EmployeeDemo("Eve", "IT", 80000, 25),
                new EmployeeDemo("Frank", "HR", 48000, 45)
        );

        // 1. Get all IT department employees
        System.out.println("1. Get all IT department employees");
        List<EmployeeDemo> emp = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("IT"))
                .collect(Collectors.toList());
        System.out.println(emp);
        // 2. Get average salary by department
        System.out.println("2. Get average salary by department");
        Map<String, Double> stats = employees.stream().collect(Collectors.groupingBy(EmployeeDemo::getDepartment,
            Collectors.averagingDouble(EmployeeDemo::getSalary)));
        stats.forEach((key, value) -> System.out.println(key + " " + value));
        // 3. Get highest paid employee
        System.out.println("3. Get highest paid employee");
        String name = employees.stream().max(Comparator.comparing((EmployeeDemo::getSalary))).get().getName();
        System.out.println(name);
        // 4. Get names of employees earning > 60000
        System.out.println("4. Get names of employees earning > 60000");
        List<EmployeeDemo> empList = employees.stream().filter(e -> e.getSalary() > 60000).collect(Collectors.toList());
        empList.forEach(e -> System.out.println(e.getName()+" "+e.getSalary()));
        // 5. Department statistics
        System.out.println("5. Department statistics");
        Map<String,DoubleSummaryStatistics> summary = employees.stream().collect(Collectors.groupingBy(EmployeeDemo::getDepartment,Collectors.summarizingDouble(EmployeeDemo::getSalary)));
        summary.forEach((key, value) -> System.out.println(key + "  " + value.getCount()));
        // 6. Sort employees by salary descending
        System.out.println("6. Sort employees by salary descending");
        empList = employees.stream().sorted((a,b) -> Double.compare(b.getSalary() , a.getSalary())).collect(Collectors.toList());
        empList.forEach(e -> System.out.println(e.getName()+" "+e.getSalary()));
        // 7. Check if all employees are above 20
       boolean employee = employees.stream().allMatch(e -> e.getAge() > 40);
       System.out.println("7. Check if all employees are above 20");
        System.out.println(employee);
        // 8. Get total salary cost
        System.out.println("8. Get total salary cost");
        Double totalSal = employees.stream().collect(Collectors.summingDouble(EmployeeDemo::getSalary));
        System.out.println(totalSal);
    }

}
