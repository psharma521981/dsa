package interview.question;

import java.util.LinkedHashMap;
import java.util.Map;
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
        System.out.println(firstNonRepeatingChar("swiss"));   // w
        System.out.println(firstNonRepeatingChar("aabbcc"));  // None
        System.out.println(firstNonRepeatingChar("aAbBc"));   // b
    }


    public static String firstNonRepeatingChar(String input) {


        Map<Character,Integer> frequencyCount = new LinkedHashMap<>();

        input.chars()
                .mapToObj((c -> (char) c))
                .forEach(c -> frequencyCount.put(c, frequencyCount.getOrDefault(c, 0) +1));


        return frequencyCount.entrySet().stream().filter(c -> c.getValue() == 1)
                .findFirst().map(c -> String.valueOf(c.getKey())).orElse("none");
    }





























}
