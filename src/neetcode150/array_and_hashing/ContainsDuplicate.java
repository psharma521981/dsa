package blind75.array_and_hashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(solution.containsDuplicate(nums1)); // Expected output: false

        int[] nums2 = {1, 2, 3, 1};
        System.out.println(solution.containsDuplicate(nums2)); // Expected output: true

        int[] nums3 = {};
        System.out.println(solution.containsDuplicate(nums3)); // Expected output: false

        int[] nums4 = {1, 1, 1, 1};
        System.out.println(solution.containsDuplicate(nums4)); // Expected output: true
    }

    private boolean containsDuplicate(int[] nums) {

        //Validate the input
        if(nums==null || nums.length < 2)
            return false;

        //Create set to maintain the existing elements
        Set<Integer> uniqueSet = new HashSet<>();

        for(int num:nums) {
            if(uniqueSet.contains(num))
                return true;
            else
                uniqueSet.add(num);
        }
        return false;
    }
}
