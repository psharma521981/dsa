package src.blind75.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationTargetSum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
         getCombinationSum(nums,target,0,new ArrayList<Integer>(),output);
        return output;
    }

    private void getCombinationSum(int[] nums, int target, int index, List<Integer> currentCombination, List<List<Integer>> output) {

        if(target==0) {
            output.add(new ArrayList<>(currentCombination));
            return;
        }

        for(int i=index;i<nums.length;i++) {
            if(target < nums[i])
                continue;

            currentCombination.add(nums[i]);
            getCombinationSum(nums,target-nums[i],i,currentCombination,output);
            currentCombination.remove(currentCombination.size()-1);
        }

    }
}
