package leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs_70 {
    //Bottom down approach
    Map<Integer,Integer> memoization;
    public int climbStairs(int n) {
        memoization = new HashMap<>();
        return calculateWays(n);
    }

    public int calculateWays(int n) {
        if(n == 0 || n == 1)
            return 1;

        if(n < 0)
            return 0;

        if(!memoization.containsKey(n)) {
            int left = calculateWays(n - 1);
            int right = calculateWays(n - 2);
            memoization.put(n, left + right);
        }

        return memoization.get(n);

    }
    //top down approach

}
