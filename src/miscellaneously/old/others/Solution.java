package src.miscellaneously.old.others;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String S = "^^<<>>^";
        if (S == null || S.isEmpty())
            return;
        Map<Character, Integer> frequency = new HashMap<>();
        
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        int maxFrequency = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> f : frequency.entrySet()) {

            if (f.getValue() > maxFrequency)
                maxFrequency = f.getValue();

        }
    }

}
