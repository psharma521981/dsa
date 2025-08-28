package sliding_windows;

public class Maximum_Sum_Subarray_of_Size_K {

    public int findMaxSumSubArray(int k, int[] arr) {
        // TODO: Write your code here

        if(k<1 || arr==null)
         return -1;

        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        int windowSize = 0;
        for(int i=0;i<arr.length;i++) {
            windowSum+=arr[i];
            windowSize++;

            if(windowSize==k) {
                maxSum = Integer.max(windowSum,maxSum);
                windowSize--;
                windowSum -= arr[i-k+1];
            }
        }
         return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + new Maximum_Sum_Subarray_of_Size_K().findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + new Maximum_Sum_Subarray_of_Size_K().findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
