package top_k_elements;

import java.util.PriorityQueue;

public class SumOfElements_II_Solution {
    public static int findSumOfElements(int[] nums, int k1, int k2) {
        int elementSum = 0;

        if(nums == null || nums.length < k1 || nums.length < k2)
            return elementSum;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int i=0;i<nums.length;i++) {
            if(i < k2-1)
                minHeap.add(nums[i]);
            else {
                if(minHeap.peek() > nums[i]) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }

        int i = 1;
        while(i<k2-k1) {
            elementSum += minHeap.poll();
            i++;
        }
        return elementSum;
    }
    public static void main(String[] args) {
        int result =
                SumOfElements_II_Solution.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println(
                "Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements_II_Solution.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println(
                "Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}
