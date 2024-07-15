package monotonic_stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures {

    //Validate the input and check the empty and length
    //intialize and empty stack and map
    //iterate over the input and check if stack is not empty and peek is less than next element (store the index instead of value)
    //If yes then add entry into Map by adding index as key and index also as value
    //iterate over the input again and check the index as key and calculate the differnce with value and store into original array.
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> temperaturesStack = new Stack<>();
        int[] output = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++) {
            while (!temperaturesStack.isEmpty() && temperatures[i] > temperatures[temperaturesStack.peek()]) {
                int index = temperaturesStack.pop();
                output[index] = i - index;
            }
            temperaturesStack.push(i);
        }

        return output;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();  // 70 - 1, 73 - 1, 69 -1 , 71 - 2, 72 - 1, 75 - 2, 73
        int[] temperatures1 = {70, 73, 75, 71, 69, 72, 76, 73};
        int[] temperatures2 = {73, 72, 71, 70};
        int[] temperatures3 = {70, 71, 72, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures1))); // Output: [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures2))); // Output: [0, 0, 0, 0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures3))); // Output: [1, 1, 1, 0]
    }
}
