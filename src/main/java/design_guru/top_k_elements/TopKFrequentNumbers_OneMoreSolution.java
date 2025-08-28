package top_k_elements;

import java.util.*;

public class TopKFrequentNumbers_OneMoreSolution {


    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);

        if(nums == null || nums.length < k)
            return null;

        Map<Integer,Integer> frequencyMap = new HashMap<>();

        PriorityQueue<Map.Entry<Integer,Integer>> frequencyHeap = new PriorityQueue<Map.Entry<Integer,Integer>>((a,b) -> a.getValue() - b.getValue());

        for(int i=0;i<nums.length;i++)
            frequencyMap.put(nums[i],frequencyMap.getOrDefault(nums[i],0)+1);

        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {

            frequencyHeap.add(entry);

            if(frequencyHeap.size() > k) {
                frequencyHeap.poll();
            }
        }

       while(!frequencyHeap.isEmpty()) {
           topNumbers.add(frequencyHeap.poll().getKey());
       }
        return topNumbers;
    }
    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers_OneMoreSolution.findTopKFrequentNumbers(
                new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result =
                TopKFrequentNumbers_OneMoreSolution.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
