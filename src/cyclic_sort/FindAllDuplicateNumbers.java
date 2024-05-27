package cyclic_sort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumbers {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        if(nums == null || nums.length < 1)
            return duplicateNumbers;

        int index =0 ;

        while(index < nums.length) {

            if(nums[index] != nums[nums[index]-1]) {
                swap(nums,index,nums[index]-1);
            } else {
                index++;

            }

        }

         index =0 ;
        while(index < nums.length) {
            if(nums[index] != index + 1)
                duplicateNumbers.add(nums[index]);

            index++;
        }

        return duplicateNumbers;
    }
    private static void swap(int[] nums, int index, int num) {
        int temp = nums[index];
        nums[index] = nums[num];
        nums[num] = temp;

    }
    public static void main(String[] args) {
        List<Integer> duplicates = FindAllDuplicateNumbers.findNumbers(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates);

        duplicates = FindAllDuplicateNumbers.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
        System.out.println("Duplicates are: " + duplicates);
    }
}
