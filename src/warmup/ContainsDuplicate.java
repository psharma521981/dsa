package warmup;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        //Validate your input
        //Create one hashmap or Set and interate over array
        //First check if element already stored in hashmap or not
        //If it's there return the output

        if(nums==null || nums.length<1)
            return false;

        Set<Integer> findDuplicate = new HashSet<>();
        for(int i=0;i<nums.length;i++) {

            if(findDuplicate.contains(nums[i]))
                return true;
            else
                findDuplicate.add(nums[i]);
        }

        return false;
    }
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
}
