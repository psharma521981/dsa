package neetcode150.heap_or_priority_queue;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an unsorted array of integers nums and an integer k, return the kth largest element in the array.

By kth largest element, we mean the kth largest element in the sorted order, not the kth distinct element.

Follow-up: Can you solve it without sorting?

Example 1:

Input: nums = [2,3,1,5,4], k = 2

Output: 4
Example 2:

Input: nums = [2,3,1,1,5,5,4], k = 3

Output: 4
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length < k)
            return 0;

        Queue<Integer> kthLargestElement = new PriorityQueue<>(k,(a, b) -> b - a);

        for(int i=0;i<nums.length;i++) {
            kthLargestElement.add(nums[i]);
        }
        int i  = 1;

        while(k >= 2) {
            kthLargestElement.poll();
            k--;
        }
        return kthLargestElement.poll();
    }
}
