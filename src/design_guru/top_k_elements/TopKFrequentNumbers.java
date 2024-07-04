package top_k_elements;

import java.util.*;

class Pair {
    int num;
    int frequency;

    Pair(int num,int freq) {
        this.num = num;
        this.frequency = freq;
    }
}
public class TopKFrequentNumbers {

    //Validate the input. check array size with k
    //Create frequency map for each array element
    //For each map entry create max heap and stored map entries for k elements
    //poll every element of heap and out of key of heap element

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        if(nums == null || nums.length < k)
            return null;

        PriorityQueue<Pair> frequencyHeap = new PriorityQueue<>((a,b) -> b.frequency - a.frequency);

        for(int i=0;i<nums.length;i++)
            frequencyMap.put(nums[i],frequencyMap.getOrDefault(nums[i],0)+1);

        for(Map.Entry<Integer,Integer> entry:frequencyMap.entrySet()) {
            frequencyHeap.add(new Pair(entry.getKey(),entry.getValue()));
        }

        for(int i=1;i<=k;i++) {
            topNumbers.add(frequencyHeap.poll().num);

        }
        return topNumbers;
    }
    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(
                new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result =
                TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
