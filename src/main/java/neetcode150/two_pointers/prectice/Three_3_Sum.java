package neetcode150.two_pointers.prectice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*

sort the array
 start the nested loop for first 2 elements
 skp duplicate & search for 2 sum
 */
public class Three_3_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output= new ArrayList<>();

        if(nums == null || nums.length < 3) {
            return output;
        }
        Arrays.sort(nums);



        for(int i=0; i< nums.length - 2;i++) {
                if(i ==0 || nums[i] != nums[i-1])
                    generatePair(i,output,nums);
        }
        return output;
    }

    private void generatePair(int i, List<List<Integer>> output, int[] nums) {

        int start = i + 1;
        int end = nums.length - 1;

        while(start < end) {
            int sum =  nums[i] + nums[start] + nums[end];
         if(sum == 0) {
             List<Integer> triplet= new ArrayList<>();
             triplet.add(nums[i]);
             triplet.add(nums[start]);
             triplet.add(nums[end]);
             output.add(triplet);
             start++;
             end--;
             while(start < end && nums[start] == nums[start - 1])
                 start++;
             while(start < end && nums[end] == nums[end + 1])
                 end--;
         } else if(sum < 0) {
             start++;
         } else {
             end--;
         }
        }
    }
}
