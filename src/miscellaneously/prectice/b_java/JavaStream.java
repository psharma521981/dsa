package src.miscellaneously.prectice.b_java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStream {

    public static void main(String[] str) {
        List<String> friendsList = new ArrayList<>();
        friendsList.add("test");
        friendsList.add("zxy");
        friendsList.add("pankaj");
        friendsList.add("patric");

        Boolean output = friendsList.stream().anyMatch((e) -> e.startsWith("p"));
        System.out.println(output);

        List<String> outputList = friendsList.stream().filter((a) -> a.startsWith("p")).collect(Collectors.toList());
        outputList.forEach((e) -> System.out.println("Hi-"+e));

        //Map and reduce example
        //flatMap example
    }
}
