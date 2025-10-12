package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46_No_Loop {
    public static void main(String s[]) {
        int[] nums = {1,2,3};
        List<List<Integer>> output =  new Permutations_46_No_Loop().permute(nums);
        for(List<Integer> row:output) {
            System.out.println();
            for(Integer i:row) {
                System.out.print(i+"\t");
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutation = new ArrayList<>();

        permutations(nums,new ArrayList<>(),permutation);

        return permutation;

    }

    public void permutations(int[] nums, ArrayList<Integer> temp, List<List<Integer>> permutation) {

        if (temp.size() >= nums.length) {
            permutation.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (temp.contains(nums[i]))
                continue;
            temp.add(nums[i]);
            permutations(nums, temp, permutation);
            temp.remove(temp.size() - 1);
        }
    }
}
