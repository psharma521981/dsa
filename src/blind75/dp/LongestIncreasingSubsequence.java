package src.blind75.dp;

import java.util.HashSet;
import java.util.Set;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for(Integer i:nums) {
            numSet.add(i);
        }

        int maxSubSequence = -1;
        for(int i=0;i<nums.length;i++) {

            int localSubsequenceCount = 0;
            if(!numSet.contains(nums[i] - 1)) {
                int numToCheck = nums[i];
                while(numSet.contains(numToCheck)) {
                    localSubsequenceCount++;
                    numToCheck++;
                }
                maxSubSequence = Math.max(maxSubSequence,localSubsequenceCount);
            }
        }
        return maxSubSequence;

    }
    public static void main(String[] s) {

    }
}
