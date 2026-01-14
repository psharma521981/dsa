package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given an array of integers candidates, which may contain duplicates, and a target integer target. Your task is to return a list of all unique combinations of candidates where the chosen numbers sum to target.

Each element from candidates may be chosen at most once within a combination. The solution set must not contain duplicate combinations.

You may return the combinations in any order and the order of the numbers in each combination can be in any order.

Example 1:

Input: candidates = [9,2,2,4,6,1,5], target = 8

Output: [
  [1,2,5],
  [2,2,4],
  [2,6]
]
 */
public class CombinationSumII {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if(candidates == null)
            return null;
        Arrays.sort(candidates);
        generateCombination(candidates,0,target,new ArrayList<>());
        return output;
    }

    public void generateCombination(int[] candidates,int index,int target,List<Integer> tmp) {


        if(target == 0) {
            output.add(new ArrayList<>(tmp));
            return;
        }

        if(target < 0 || index == candidates.length) {
            return;
        }

        tmp.add(candidates[index]);
        generateCombination(candidates,index + 1,target - candidates[index],tmp);
        tmp.remove(tmp.size() -1);
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        generateCombination(candidates,index +1,target,tmp);

    }
}
