package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_Recussive_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        //Adding empty Set
        getAllSubsets(0,nums,powerSet,new ArrayList<>());
        return powerSet;
    }

    private void getAllSubsets(int index, int[] nums, List<List<Integer>> powerSet, List<Integer> current) {
        powerSet.add(new ArrayList<>(current));
         for(int i=index;i<nums.length;i++) {
             current.add(nums[i]);
           getAllSubsets(i+1,nums,powerSet,current);
             current.remove(current.size()-1);
       }
    }

    public static void main(String s[]) {
        int[] nums = {1,2,3};
        Subsets_Recussive_78 subsets= new Subsets_Recussive_78();
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
