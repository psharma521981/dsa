package blind75.array_and_hashing;

import java.util.*;

public class TopKFrequentElements {
    public List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);

        //Validate the input
        //Calculate the frequncy of the numbers
        //Create max heap and store the top frequency numbers on top with entries in decreasing order
        if(nums == null || nums.length < k)
            return null;

        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            frequencyMap.put(nums[i],frequencyMap.getOrDefault(nums[i],0) + 1);
        }

        Queue<Map.Entry<Integer,Integer>> topElement = new PriorityQueue<>((element1,element2) -> element1.getValue() - element2.getValue());

        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {
            topElement.add(entry);
                    if(topElement.size() > k)
                        topElement.poll();
        }

        while(!topElement.isEmpty())
            topNumbers.add(topElement.poll().getKey());

        return topNumbers;
    }
    public static void main(String[] args) {
        TopKFrequentElements sol = new TopKFrequentElements();
        List<Integer> result = sol.findTopKFrequentNumbers(
                new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result =
                sol.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
