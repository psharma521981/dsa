package blind75.array_and_hashing;

//check for empty validation
//1st loop through calculate multiplication from left
//2nd loop through calculate multiplication from right

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        if(nums == null || len < 1)
            return null;

       int[] left = new int[len];
       int[] right = new int[len];

       left[0] =1;
       right[len-1] = 1;

       for(int i=1;i<len;i++)
           left[i] = left[i-1] * nums[i-1];

        for(int i=len-2;i>=0;i--)
            right[i] = right[i+1] * nums[i+1];

        for(int i=0;i<len;i++)
            result[i] = right[i] * left[i];

        return result;
    }
    public static void main(String[] args) {
        ProductOfArrayExceptSelf sol = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{2, 3, 4, 5})));
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{1, 1, 1, 1})));
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{10, 20, 30, 40})));
    }
}
