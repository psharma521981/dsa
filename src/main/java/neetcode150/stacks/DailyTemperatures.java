package neetcode150.stacks;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] output = new int[temperatures.length];

        if(temperatures.length == 0)
            return output;

        Stack<Integer> maxTemprature = new Stack<>();

        for(int i=0;i<temperatures.length;i++) {

            while(!maxTemprature.empty() && temperatures[maxTemprature.peek()] < temperatures[i]) {
                int index = maxTemprature.pop();
                output[index] = i - index;
            }
            maxTemprature.push(i);
        }
        return output;
    }
}
