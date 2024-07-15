package top_k_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySortBySelf_April_27 {
    public static String sortCharacterByFrequency(String str) {

        if(str == null || str.length() < 1)
            return null;

        Map<Character,Integer> frequencyMap = new HashMap<>();

        for(Character ch : str.toCharArray()) {
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> frequencyHeap = new PriorityQueue<>(frequencyMap.size(),(a,b) -> b.getValue() - a.getValue());
        frequencyHeap.addAll(frequencyHeap);

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Character,Integer> entry:frequencyHeap) {
            for(int i=1;i<=entry.getValue();i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String result = FrequencySort_Optimized.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: "
                + result);

        result = FrequencySort_Optimized.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: "
                + result);
    }
}
