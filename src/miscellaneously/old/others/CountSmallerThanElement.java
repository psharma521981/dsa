package src.miscellaneously.old.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//Extreme Network
public class CountSmallerThanElement {

    public static void main(String[] args) {
       
        int[] input = new int[] { 9, 2, 3, 3, 4, 5, 6 };
        input = countSmaller(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print("\t "+input[i]);
            
        }

    }

    public static int[] countSmaller(int[] input) {

        // validate the input
        if (input == null)
            return null;

        int[] output = new int[input.length];
        Stack<Integer> countSmallerElements = new Stack<>();
        
        for (int i = 0; i <= input.length; i++) {
            int count = 0;
            while (!countSmallerElements.isEmpty() && countSmallerElements.peek() < input[i]) {
                countSmallerElements.pop();
                count++;
            }
            output[i] = count;
            countSmallerElements.push(input[i]);
            
        }

        return output;

    }

}
