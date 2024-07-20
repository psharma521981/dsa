package src.miscellaneously.prectice.b_java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamPrectice {
   public static void main(String s[]) {

        List<Integer>  listOfInteger = Arrays.asList(1,3,5,6,7,8,9);

       List<Integer> filterList = listOfInteger.stream().filter((a) -> a >= 5).collect(Collectors.toList());
       //filterList.forEach(System.out::println);

       List<List<Integer>>  listOflistOfInteger = Arrays.asList(Arrays.asList(1,3,5,7,9),Arrays.asList(2,4,6,8,10,20,30));

       listOfInteger = listOflistOfInteger.stream().flatMap(a -> a.stream()).collect(Collectors.toList());
       listOfInteger.forEach(System.out::println);

    }
}
