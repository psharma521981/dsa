package src.miscellaneously.old.dsa.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//simullar to the asked in - extreme netwrok
public class FindingLargestThenIndexOnRightSide {

    public static void main(String[] args) {

        int[] element = new int[] { 3, 5, 2, 7, 4, 1, 8 };

        printLargestThenIndexValueOnRight(element);
    }

    private static void printLargestThenIndexValueOnRight(int[] element) {

        Stack<Integer> largestValue = new Stack<>();
        int length = element.length;
        Map<Integer, Integer> rightLargest = new HashMap<>();

        for (int i = length - 1; i >= 0; i--) {

            while (!largestValue.isEmpty() && largestValue.peek() < element[i]) {
                largestValue.pop();
            }

            if (largestValue.isEmpty()) {
                largestValue.push(element[i]);
                rightLargest.put(element[i], -1);
            } else {
                rightLargest.put(element[i], largestValue.peek());
            }
        }

        for (Map.Entry<Integer, Integer> entry : rightLargest.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

}
