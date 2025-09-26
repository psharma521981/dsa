package neetcode150.binary_search;

public class BinarySearch {
    public int search(int[] nums, int target) {

        if(nums == null || nums.length < 1)
            return -1;

        int low = 0;
        int high = nums.length-1;

        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if(target > nums[mid]) {
                low  = mid + 1;
            } else if(target < nums[mid]) {
                high = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
