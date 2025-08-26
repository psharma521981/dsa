package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> tempCobnation = new ArrayList<>();
        generateCombination(tempCobnation,output,nums,0,target, 0);
        return output;
    }

    private void generateCombination(List<Integer> tempCobnation, List<List<Integer>> output,
                                     int[] nums, int i, int target, int tmpSum) {

        if (tmpSum==target) {
            output.add(new ArrayList<>(tempCobnation));
            return;
        }
        if (tmpSum > target) {
            return;
        }

        tempCobnation.add(nums[i]);
        tmpSum+=nums[i];
        generateCombination(tempCobnation,output,nums,i,target, tmpSum);
        generateCombination(tempCobnation,output,nums,i+1,target, tmpSum);

    }

    public static void main(String s[]) {
        CombinationSum t = new CombinationSum();
        int[] input = {2,5,6,9};
        List<List<Integer>> output = t.combinationSum(input,8);
        System.out.println(output);
    }
}
