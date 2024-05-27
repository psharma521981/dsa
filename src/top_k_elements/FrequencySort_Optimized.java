package top_k_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Input: "Programming"
//        Output: "rrggmmPiano"
//Validate the input
//Create each charcater frequency map of it's occurences
//Initialize heap with size of map and Map.Entry decreasing order of frequency
//pool every map entry from heap and loop over total frequency of each charceter and form string out of it.
public class FrequencySort_Optimized {
    public static String sortCharacterByFrequency(String str) {

        Map<Character,Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> frequencyHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for(Character ch : str.toCharArray())
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);

        frequencyHeap.addAll(frequencyMap.entrySet());

        StringBuilder outputStr = new StringBuilder();
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
        String result = FrequencySort_Optimized.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: "
                + result);

        result = FrequencySort_Optimized.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: "
                + result);
    }
}
