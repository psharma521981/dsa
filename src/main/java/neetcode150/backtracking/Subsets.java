package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        List<Integer> tmp =new ArrayList<>();
        generateSubset(nums,output,tmp,0);

        return output;
    }

    private void generateSubset(int[] nums, List<List<Integer>> output,List<Integer> tmp, int i) {

            if(i == nums.length) {
                output.add(new ArrayList<>(tmp));
               return;
            }

        tmp.add(nums[i]);
        generateSubset(nums,output,tmp,i+1);
        tmp.remove(tmp.size()-1);
        generateSubset(nums,output,tmp,i+1);
    }
}
