package leetcode.dynamic_programming;

import java.util.Arrays;

public class JumpGame {int[] memoization;
    public boolean canJump(int[] nums) {

        memoization = new int[nums.length];
        Arrays.fill(memoization,-1);
        return valiadteJumps(nums,nums.length-1,0);

    }

    public boolean valiadteJumps(int[] nums, int lastIndex, int currentIndex) {

        if(currentIndex == lastIndex) {
            return true;
        }
        if(currentIndex > lastIndex) {
            return false;
        }

        if(memoization[currentIndex] != -1) {
            return memoization[currentIndex] == -2;
        }

        for(int i=1;i<=nums[currentIndex];i++) {
            if(valiadteJumps(nums,lastIndex,currentIndex + i)) {
                return true;
            }
        }
        memoization[currentIndex] = -3;

        return false;

    }

}
