package src.neetcode150.array_and_hashing;

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int longestSequence = 0;

        if(nums==null || nums.length < 1)
            return longestSequence;

        Set<Integer> numbers = new HashSet<>();

        for(int num:nums)
            numbers.add(num);

        for(int num:nums) {
            if(!numbers.contains(num - 1)) {
                int currentNum = num;
                int currentSeqCount = 0;

                while(numbers.contains(currentNum)) {
                    currentNum++;
                    currentSeqCount++;
                }
                longestSequence = Math.max(longestSequence,currentSeqCount);
            }
        }

        return longestSequence;
    }
    public static void main(String[] args) {
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();
        System.out.println(sol.longestConsecutive(new int[]{10, 11, 14, 12, 13})); // 5
        System.out.println(sol.longestConsecutive(new int[]{3, 6, 4, 100, 101, 102})); // 3
        System.out.println(sol.longestConsecutive(new int[]{7, 8, 10, 11, 15})); // 2
    }
}
