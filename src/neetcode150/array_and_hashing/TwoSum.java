package blind75.array_and_hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // TODO: Write your code here
        int[] output = new int[] {-1,-1};
        //Validate the inout
        if(nums==null || nums.length < 2)
            return output;
        //Create map to store number with their index
        Map<Integer,Integer> numberWithTheirIndex = new HashMap<>();

        //Iterate over the input and check if target - currrent number difference exist in map or not
        //If exist then found and return
        for(int i=0;i<nums.length;i++) {
            if(numberWithTheirIndex.containsKey(target-nums[i])) {
                output[0] = i;
                output[1] = numberWithTheirIndex.get(target - nums[i]);
                return output;
            }
                numberWithTheirIndex.put(nums[i],i);
        }
        // Throw an exception if no solution is found
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        // Test the algorithm with example inputs
        int[] result1 = solution.twoSum(new int[]{2, 15, 11, 7}, 9);
        // Output the results
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]"); // Output: [0, 3]

        int[] result2 = solution.twoSum(new int[]{3, 1, 4, 8, 5}, 9);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]"); // Output: [2, 4]

        int[] result3 = solution.twoSum(new int[]{10, 20, 30, 40, 50}, 90);
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]"); // Output: [3, 4]
    }
}
