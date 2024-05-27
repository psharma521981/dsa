package top_k_elements;

import java.util.PriorityQueue;
//Logic for add method.
//Add the element into heap and if size of heap is greater than K then poll
//return peek of heap
public class KthLargestNumberinAStream {
    PriorityQueue<Integer> maxHeap;
    int KthLargest;

    public KthLargestNumberinAStream(int[] nums, int k) {
        maxHeap = new PriorityQueue<>((a,b) -> a - b);
        this.KthLargest = k;

        for(int i=0;i<nums.length;i++) {
            add(nums[i]);
        }

    }

    public int add(int num) {
        maxHeap.add(num);
        if(maxHeap.size() > KthLargest) {
                maxHeap.poll();
        }

        int output = maxHeap.peek();

        return output;
    }
    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberinAStream kthLargestNumber = new KthLargestNumberinAStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
