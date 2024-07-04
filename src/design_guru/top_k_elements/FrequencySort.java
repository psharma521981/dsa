package top_k_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Input: "Programming"
//        Output: "rrggmmPiano"
public class FrequencySort {
    public static String sortCharacterByFrequency(String str) {

        Map<Character,Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> frequencyHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for(int i=0;i<str.length();i++)
            frequencyMap.put(str.charAt(i),frequencyMap.getOrDefault(str.charAt(i),0)+1);

        for(Map.Entry<Character,Integer> entry:frequencyMap.entrySet())
            frequencyHeap.add(entry);

        StringBuffer outputStr = new StringBuffer();
        while(!frequencyHeap.isEmpty()) {
            Map.Entry<Character,Integer> entry = frequencyHeap.poll();
            int frequency = entry.getValue();

            while(frequency >=1) {
                outputStr.append(entry.getKey());
                frequency--;
            }
        }
        return outputStr.toString();
    }
    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: "
                + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: "
                + result);
    }
}
