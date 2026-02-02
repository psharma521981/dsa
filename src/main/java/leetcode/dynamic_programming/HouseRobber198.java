package leetcode.dynamic_programming;

import java.util.Arrays;
// https://leetcode.com/problems/house-robber/
//Top down
/*public class HouseRobber198 {
    //top down up approach
    int[] memoization;
    public int rob(int[] nums) {
        memoization = new int[nums.length];
        Arrays.fill(memoization,-1);
        return calculateMaxAmount(nums,0);
    }


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
}*/
//Botoom up
public class HouseRobber198 {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] robbedMoney = new int[nums.length + 1];
        robbedMoney[0] = 0;
        robbedMoney[1] = nums[0];

        for(int i=2;i<robbedMoney.length;i++) {
            int steal = nums[i-1] + robbedMoney[i - 2];
            int notSteal = robbedMoney[i - 1];

            robbedMoney[i] = Math.max(steal,notSteal);
        }

        return robbedMoney[robbedMoney.length-1];
    }
}
