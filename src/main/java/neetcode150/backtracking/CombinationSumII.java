package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
