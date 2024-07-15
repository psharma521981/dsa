package top_k_elements;

import java.util.PriorityQueue;

public class SumOfElements {
    public static int findSumOfElements(int[] nums, int k1, int k2) {
        int elementSum = 0;

        if(nums == null || nums.length < k1 || nums.length < k2)
            return elementSum;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a -b);

        for(int i=0;i<nums.length;i++) {
            minHeap.add(nums[i]);
        }

        int i = 1;
        while(i<=k1) {
            minHeap.poll();
            i++;
        }

        while(i<k2 && !minHeap.isEmpty()) {
            elementSum += minHeap.poll();
            i++;
        }
        return elementSum;
    }
    public static void main(String[] args) {
        int result =
                SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println(
                "Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println(
                "Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}
