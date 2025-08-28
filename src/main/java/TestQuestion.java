package src;

import java.util.ArrayList;
import java.util.List;

public class TestQuestion {
    //write a function to take input array and reverse the element

    public static void main(String s[]) {
        List<String> input = new ArrayList<>();
        input.add("a");
        input.add("b");
        input.add("c");
        input.add("d");

        if(input!=null) {
            stringReverse(input);
            for (String str : input) {
                System.out.print(str +"\t");
            }
        }

        List<Integer> oddNumber = new ArrayList<>();
        oddNumber.add(1);
        oddNumber.add(3);
        oddNumber.add(5);
        oddNumber.add(7);

        List<Integer> evenNumber = new ArrayList<>();
        evenNumber.add(2);
        evenNumber.add(2);
        evenNumber.add(4);
        evenNumber.add(6);
        System.out.println();
       List<Integer> output = mergeLists(oddNumber,evenNumber);
       for(Integer e:output) {
           System.out.print(e +"\t");
       }
    }
//input a b c
// c b a
//a b c d
//d c b a
    public static void stringReverse(List<String> stringList) {

        //calculate the size of the list
        //run the loop over from start by pointing start and end location
        //Swap the position
        int end = stringList.size() - 1;
        int start = 0;
        String startStr;
        String endStr;
        List<String> output = new ArrayList<>(stringList.size());
        while(start < end) {

            startStr = stringList.get(start);
            endStr = stringList.get(end);
            stringList.set(start,endStr);
            stringList.set(end,startStr);
            start++;
            end--;
        }
    }

    public static List<Integer> mergeLists(List<Integer> first,List<Integer> second) {

        int endOfFisrtList = first.size() - 1;
        int endOfSecondList = second.size() - 1;

        int indexFirst = 0;
        int indexSecond = 0;
        List<Integer> outputList = new ArrayList<>(endOfFisrtList+endOfSecondList + 2);
        int outputIndex = 0;

        //Compare the both of the list element and add to the optput
        while(indexFirst <= endOfFisrtList && indexSecond <= endOfSecondList) {

            if(first.get(indexFirst) <= second.get(indexSecond)) {
                outputList.add(outputIndex++,first.get(indexFirst++));
            } else {
                outputList.add(outputIndex++,second.get(indexSecond++));
            }

        }
        //Add remianing elements of the list
        if(indexFirst <= endOfFisrtList) {
            outputList.add(outputIndex++,first.get(indexFirst++));
        }

        if(indexSecond <= endOfSecondList) {
            outputList.add(outputIndex++,second.get(indexSecond++));
        }
        return outputList;
    }

}
