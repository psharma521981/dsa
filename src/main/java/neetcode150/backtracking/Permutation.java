package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        if(nums == null)
            return output;

        permutation(nums,new ArrayList<>());
        return output;
    }

    public void permutation(int[] nums,List<Integer> tmpList) {

        if(tmpList.size() == nums.length) {
            output.add(new ArrayList<>(tmpList));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(!tmpList.contains(nums[i])) {
                tmpList.add(nums[i]);
                permutation(nums,tmpList);
                tmpList.remove(tmpList.size() -1);
            }
        }
    }
}
