package others.b_java;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.*;

interface TestStringFunction {
    String run(String str);
}
public class JavaLambdaConsumer {

    public static void main(String s[]) {
        TestStringFunction testStr = (str) -> "Hi-"+str;
        printOutput("Pankaj",testStr);
        List<String> listOfName = new ArrayList<>();
        listOfName.add("Pankaj");
        listOfName.add("Test");
        Consumer<String> consumer = (st) -> System.out.println("Hello-"+st);
        listOfName.forEach(consumer);

        Consumer<String> consumer1 = (st) -> System.out.println("Hello-"+st);


    }

    private static void printOutput(String str, TestStringFunction testStringFunction) {
        System.out.println(testStringFunction.run(str));
    }
}
