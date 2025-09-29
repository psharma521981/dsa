package neetcode150.binary_search;

/*
You have an array of length n, which was initially sorted in ascending order. This array was then rotated x times. It is given that 1 <= x <= n. For example, if you rotate [1, 2, 3, 4] array 3 times, resultant array is [2, 3, 4, 1].

Your task is to find the minimum element from this array. Note that the array contains unique elements.

You must write an algorithm that runs in O(log n) time.

Example 1:

Input: [8, 1, 3, 4, 5]
Expected Output: 1
Justification: The smallest number in the array is 1.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length < 1)
            return -1;

        int start = 0;
        int end = nums.length - 1;

        while(start <  end) {

            int mid = (start + end)/2;

            if(nums[mid] > nums[end]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();
        System.out.println(sol.findMin(new int[]{8, 1, 3, 4, 5}));  // Expected output: 1
        System.out.println(sol.findMin(new int[]{4, 5, 7, 8, 0, 2, 3}));  // Expected output: 0
        System.out.println(sol.findMin(new int[]{7, 9, 12, 3, 4, 5}));  // Expected output: 3
    }
}
