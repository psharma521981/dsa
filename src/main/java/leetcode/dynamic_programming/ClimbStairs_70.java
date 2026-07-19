package leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs_70 {
    //Top down
   /* int[] steps;
    public int climbStairs(int n) {

        steps =  new int[n+1];
        Arrays.fill(steps,-1);
        return countWay(n);

    }
    public int countWay(int n) {
            if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(steps[n] == -1) {

            steps[n] = countWay(n-1) + countWay(n-2);
        }

        return steps[n];
    }*/

    //Bottom Up
    int[] steps;
    public int climbStairs(int n) {

        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        steps =  new int[n+1];

        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;

        for(int i=3;i<=n;i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }

        return steps[n];
    }

}
