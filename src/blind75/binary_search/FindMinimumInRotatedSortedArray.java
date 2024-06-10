package src.blind75.binary_search;

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
