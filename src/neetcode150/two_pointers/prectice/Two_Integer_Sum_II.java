package src.neetcode150.two_pointers.prectice;

public class Two_Integer_Sum_II {
    public int[] twoSum(int[] numbers, int target) {

        if(numbers == null || numbers.length < 2)
            return null;

        int[] output =new int[2];

       int start = 0;
       int end = numbers.length - 1;

       while(start < end) {
           int sum = numbers[start] + numbers[end];

           if(sum == target && start < end) {
               output[0] = start + 1 ;
               output[1] = end + 1;
               return output;
           } else if(sum < target) {
               start++;
           } else {
               end--;
           }
       }
       return output;
    }
}
