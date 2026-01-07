package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Duplicate values in input
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
