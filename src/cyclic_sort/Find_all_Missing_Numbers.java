package cyclic_sort;

import java.util.ArrayList;
import java.util.List;

public class Find_all_Missing_Numbers {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        // TODO: Write your code here

        if(nums==null)
            return missingNumbers;

        int left = 0;

        while(left<nums.length) {

            if(nums[left] != nums[nums[left]-1]) {
                int index = nums[left]-1;
                int temp =  nums[index];
                nums[index] = nums[left];
                nums[left] =  temp;
            } else {
                left++;
            }
        }
        left =0;

        while(left<nums.length) {
            if(nums[left] != left +1) {
                missingNumbers.add(left +1);
            }
            left++;
        }
        return missingNumbers;
    }
    public static void main(String[] args) {
        List<Integer> missing = Find_all_Missing_Numbers.findNumbers(
                new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = Find_all_Missing_Numbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = Find_all_Missing_Numbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
