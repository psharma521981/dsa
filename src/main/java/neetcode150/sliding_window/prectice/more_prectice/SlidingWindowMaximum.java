package neetcode150.sliding_window.prectice.more_prectice;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int low = 0;
        int high = nums.length - k;
        int[] output = new int[high + 1];
        int index = 0;
        while(low <= high) {
            output[index++] = maxNumber(nums,low,low+k-1);
            low++;
        }
        return output;
    }

    public int maxNumber(int[] source,int lower,int upper) {

        int max = Integer.MIN_VALUE;
        while(lower <= upper) {
            max = Math.max(max,source[lower++]);

        }
        return max;
    }
}
