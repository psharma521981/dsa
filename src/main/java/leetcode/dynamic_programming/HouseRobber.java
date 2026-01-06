package leetcode.dynamic_programming;

import java.util.Arrays;

public class HouseRobber {
    int[] memoization;
    public int rob(int[] nums) {
        memoization = new int[nums.length];
        Arrays.fill(memoization,-1);
        return calculateMaxAmount(nums,0);
    }
    //Bottom up approach

    public int calculateMaxAmount(int[] nums,int index) {

        if(index >= nums.length) {
            return 0;
        }
        if(memoization[index] == -1) {
            int selectHouse = nums[index] + calculateMaxAmount(nums,index +2);
            int skipHouse = calculateMaxAmount(nums,index + 1);
            memoization[index] = Math.max(selectHouse,skipHouse);
        }

        return  memoization[index];
    }
}
