package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
You are given an array of distinct integers nums and a target integer target. Your task is to return a list of all unique combinations of nums where the chosen numbers sum to target.

The same number may be chosen from nums an unlimited number of times. Two combinations are the same if the frequency of each of the chosen numbers is the same, otherwise they are different.

You may return the combinations in any order and the order of the numbers in each combination can be in any order.

Example 1:

Input:
nums = [2,5,6,9]
target = 9

Output: [[2,2,5],[9]]
 */
public class CombinationSum {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        if(nums == null)
            return output;

        generateCombination(nums,target,0,new ArrayList<>());

        return output;
    }

    public void generateCombination(int[] nums,int target,int index,List<Integer> combination) {

        if(target < 0 || index >= nums.length) {
            return;
        }
        if(0 == target) {
            output.add(new ArrayList<>(combination));
            return;
        }

        combination.add(nums[index]);
        generateCombination(nums,target - nums[index],index,combination);
        combination.remove(combination.size() - 1);
        generateCombination(nums,target,index + 1,combination);

    }

    public static void main(String s[]) {
        CombinationSum t = new CombinationSum();
        int[] input = {2,5,6,9};
        List<List<Integer>> output = t.combinationSum(input,8);
        System.out.println(output);
    }
}
