package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
Given an array nums of unique integers, return all possible subsets of nums.

The solution set must not contain duplicate subsets. You may return the solution in any order.

Example 1:

Input: nums = [1,2,3]

Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();

        if(nums ==null)
            return output;


        subsets(output,0,new ArrayList<>(),nums);
        return output;
    }

    private void subsets(List<List<Integer>> output, int i, List<Integer> list,int[] nums) {

        if(i == nums.length) {
            output.add(new ArrayList<>(list));
        }

        list.add(i);
        subsets(output,i + 1,list,nums);
        list.remove(list.size() -1);
        subsets(output,i + 1,list,nums);
    }
}
