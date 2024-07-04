package two_pointers.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three3Sum {
    public List<List<Integer>> threeSum(int[] nums) {

        if(nums==null || nums.length < 3)
            return null;

        Arrays.sort(nums);

        List<List<Integer>> output= new ArrayList<>();

        for(int i=0;i<nums.length-2;i++) {
            if(nums[i]==nums[i+1])
                continue;

            searchTriplet(i,nums,output);
        }

        return output;
    }

    private void searchTriplet(int i, int[] nums, List<List<Integer>> output) {

        int left = i + 1;
        int right = nums.length -1;

        while(left < right) {
            while(left < right && nums[left] == nums[left+1])
                left++;

            while(left < right && nums[right] == nums[right-1])
                right--;
            int sum = nums[i]+nums[left]+nums[right];
            if(sum==0) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.add(nums[left]);
                triplet.add(nums[right]);
                output.add(triplet);
            } else if(sum < 0)
                left++;
            else
                right--;

        }
    }
}
