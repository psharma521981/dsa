package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_Recussive_No_loop {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        //Adding empty Set
        getAllSubsets(0,nums,powerSet,new ArrayList<>());
        return powerSet;
    }

    private void getAllSubsets(int index, int[] nums, List<List<Integer>> powerSet, List<Integer> current) {

        if(index >= nums.length) {
            powerSet.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        getAllSubsets(index+1,nums,powerSet,current);
        current.remove(current.size()-1);
        getAllSubsets(index+1,nums,powerSet,current);

    }

    public static void main(String s[]) {
        int[] nums = {1,2,3};
        Subsets_Recussive_No_loop subsets= new Subsets_Recussive_No_loop();
        List<List<Integer>> powerSet = subsets.subsets(nums);

        for(List<Integer> list:powerSet) {
            System.out.print("{");
            for(Integer i : list) {
                System.out.print(" "+i+" ");
            }
            System.out.print("}");
            System.out.println();
        }

    }
}
