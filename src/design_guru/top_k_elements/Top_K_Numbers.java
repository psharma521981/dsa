package top_k_elements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Top_K_Numbers {
   //Validate the input;
    //initialize the max heap of size K and add first K element into heap
    //add numberes to heap if heap top is less then the number by roming the top
    //return the heap
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {

        if(nums == null || nums.length < k)
            return null;

        PriorityQueue<Integer> topElement = new PriorityQueue<>((a,b) -> a - b);

        for(int i = 0;i<k;i++)
            topElement.add(nums[i]);

        for(int i=k; i< nums.length;i++) {
            if(topElement.peek() < nums[i]) {
                topElement.poll();
                topElement.add(nums[i]);
            }
        }
        return new ArrayList<>(topElement);
    }
    public static void main(String[] args) {
        List<Integer> result =
                Top_K_Numbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = Top_K_Numbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
