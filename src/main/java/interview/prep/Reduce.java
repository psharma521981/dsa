package interview.prep;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Reduce {

    public static void main(String s[]) {
        List<Integer> reduceEx = Arrays.asList(1,2,3,4,5,6);

        Optional<Integer> ans = reduceEx.stream().reduce(Integer::sum);

        ans.ifPresent(System.out::println);

        int totalLength = Arrays.asList("Java", "Stream", "Reduce").stream()
                .reduce(0,
                        (sum, str) -> sum + str.length(), // Accumulator
                        Integer::sum);
        System.out.println(totalLength);

        //Youngest boy of by dept
        System.out.println("Youngest boy of by dept");

        List<EmployeeDemo> employees = Arrays.asList(
                new EmployeeDemo("Alice", "IT", 75000, 28),
                new EmployeeDemo("Bob", "HR", 55000, 35),
                new EmployeeDemo("Charlie", "IT", 90000, 42),
                new EmployeeDemo("David", "Finance", 65000, 31),
                new EmployeeDemo("Eve", "IT", 80000, 25),
                new EmployeeDemo("Frank", "HR", 48000, 45)
        );

        Map<String, Optional<EmployeeDemo>> deptWithMinAgeEmployee = employees.stream()
                .collect(Collectors.groupingBy(EmployeeDemo::getDepartment ,Collectors.minBy(Comparator.comparingDouble(EmployeeDemo::getSalary))));

        deptWithMinAgeEmployee.entrySet().stream().forEach(a -> System.out.println("dept "+ a.getKey() + " age "+ a.getValue().get().getAge()));

        // Find first non-repeating character

        String str = "bbanana";

        LinkedHashMap<Character, Long> frequencyMap = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c ,LinkedHashMap::new, Collectors.counting()));

        Character ch = frequencyMap
                .entrySet()
                .stream()
                .filter( c -> c.getValue() == 1)
                .findFirst()
                        .map(Map.Entry::getKey).orElse(' ');
        System.out.println("char "+ ch);
    }

}
