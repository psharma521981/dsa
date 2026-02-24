package strings;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeating_java_functional {
    public static String firstNonRepeating(String input) {

        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,   // preserve order
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> String.valueOf(entry.getKey()))
                .findFirst()
                .orElse("None");
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeating("swiss"));   // w
        System.out.println(firstNonRepeating("aabbcc"));  // None
        System.out.println(firstNonRepeating("aAbBc"));   // b
    }
}
