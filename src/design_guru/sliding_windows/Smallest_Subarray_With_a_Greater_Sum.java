package src.design_guru.sliding_windows;

public class Smallest_Subarray_With_a_Greater_Sum {
    public static int findMinSubArray(int S, int[] arr) {

        if(arr==null || arr.length < 1)
            throw new IllegalArgumentException();

        int arrayLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for(int i=0;i<arr.length;i++) {
            sum+=arr[i];

            while(sum>=S) {
                arrayLength = Math.min(arrayLength,i-left+1);
                sum-=arr[left];
                left++;
            }
        }
        return left==0 ? left : arrayLength;
    }
    public static void main(String[] args) {
        int result = Smallest_Subarray_With_a_Greater_Sum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = Smallest_Subarray_With_a_Greater_Sum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = Smallest_Subarray_With_a_Greater_Sum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
