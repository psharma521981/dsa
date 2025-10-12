package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_Iterative_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        //Adding empty Set
        powerSet.add(new ArrayList<>());

        for(int i=0;i<nums.length;i++) {
            int n = powerSet.size();

            for(int j=0;j<n;j++) {
                List<Integer> currentList = new ArrayList<>(powerSet.get(j));
                currentList.add(nums[i]);
                powerSet.add(currentList);
            }
        }
        return powerSet;
    }
    public static void main(String s[]) {
        int a[] = {1,2,3};
        List<List<Integer>> output = subsets(a);

        for(List<Integer> rows:output) {
            System.out.println();
            System.out.print("{");
            for(Integer row:rows) {
                System.out.print(+row+",");
            }
            System.out.print("}");
        }
    }
}
