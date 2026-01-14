package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Duplicate values in input
/*
You are given an array nums of integers, which may contain duplicates. Return all possible subsets.

The solution must not contain duplicate subsets. You may return the solution in any order.

Example 1:

Input: nums = [1,2,1]

Output: [[],[1],[1,2],[1,1],[1,2,1],[2]]
Example 2:

Input: nums = [7,7]

Output: [[],[7], [7,7]]
 */
public class SubsetII {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        if(nums == null) {
            return null;
        }
        Arrays.sort(nums);
        generateSubset(nums,0,new ArrayList<>());
        return output;
    }

    public void generateSubset(int[] nums,int i,List<Integer> tmpList) {

        if(i == nums.length) {
            output.add(new ArrayList<>(tmpList));
            return;
        }

        tmpList.add(nums[i]);
        generateSubset(nums,i + 1,tmpList);
        tmpList.remove(tmpList.size() - 1);
        while(i + 1 < nums.length && nums[i] == nums[i +1]) {
            i++;
        }
        generateSubset(nums,i + 1,tmpList);
    }
}
