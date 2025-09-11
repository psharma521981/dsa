package neetcode150.array_and_hashing.prectice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElements {
    public int[] topKFrequent(int[] nums, int k) {

        int[] output = new int[k];

        if(nums == null || nums.length < k)
            return output;

        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int num:nums) {

            if(frequencyMap.get(num) == null) {
                frequencyMap.put(num,0);
            }
            int val = frequencyMap.get(num);
            frequencyMap.put(num,++val);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> frequenyQueue = new PriorityQueue<>(k,(a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer,Integer> entry:frequencyMap.entrySet()) {
            frequenyQueue.add(entry);

            if(frequenyQueue.size() > k)
                frequenyQueue.poll();
        }
        int index = 0;
        while(!frequenyQueue.isEmpty()) {
            output[index++] = frequenyQueue.poll().getKey();
        }
        return output;
    }
}
