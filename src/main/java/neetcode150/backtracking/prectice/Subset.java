package neetcode150.backtracking.prectice;

import java.util.ArrayList;
import java.util.List;

/*

Given an array nums of unique integers, return all possible subsets of nums.

The solution set must not contain duplicate subsets. You may return the solution in any order.

Example 1:

Input: nums = [1,2,3]

Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [7]

Output: [[],[7]]

 */
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        if (nums == null) {
           return  output;
        }
        generateSubset(nums,0,new ArrayList<>(), output);
        return  output;
    }

    private void generateSubset(int[] nums, int i, ArrayList<Integer> objects, List<List<Integer>> output) {

        if(i == nums.length) {
            output.add(new ArrayList<>(objects));
            return;
        }

        objects.add(nums[i]);
        generateSubset(nums,i+1,objects, output);
        objects.remove(objects.size() -1);
        generateSubset(nums,i+1,objects, output);
    }
    public static void main(String s[]) {
        int[] nums = new int[]{1,2,3};
        Subset subset = new Subset();
        List<List<Integer>> output =  subset.subsets(nums);

        output.forEach(a -> {System.out.println();
            a.forEach(b -> System.out.print(b+","));
        });
    }
}
