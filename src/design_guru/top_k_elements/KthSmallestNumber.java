package top_k_elements;

import java.util.PriorityQueue;

public class KthSmallestNumber {
    //Validate the input and check the array size with k
    //create max heap and then initialize with first k elements in array
    //check if every  rest of the elements of array is smaller with top or not
    //if smaller than peak than pop peak and add element
    //return peak.

    public static int findKthSmallestNumber(int[] nums, int k) {

        if(nums == null || nums.length < k)
            return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> b - a);

        for (int i = 0;i<k;i++) {
            minHeap.add(nums[i]);
        }

        for(int i = k;i<nums.length;i++) {

            if(minHeap.peek() > nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }
    public static void main(String[] args) {
        int result =
                KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers
        // should be a '5'
        result =
                KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result =
                KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);  }
}
