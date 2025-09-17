package neetcode150.sliding_window.prectice.more_prectice;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {

        int left  =0;
        int right = 0;
        int len = s.length();
        int output = 0;
        int maxFrequency = 0;

        Map<Character,Integer> frequencyMap = new HashMap<>();
        //Calculate substring window size
        //count frequency
        char ch;
        while (right < len) {
            ch = s.charAt(right);
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0) + 1);
            //check window valid
            maxFrequency = Math.max(maxFrequency,frequencyMap.get(ch));
            while(((right - left + 1 ) - maxFrequency) > k) {
                frequencyMap.put(s.charAt(left),frequencyMap.get(s.charAt(left)) - 1);
                left++;
            }
            output = Math.max(output,(right - left + 1 ));
            right++;
        }
        return output;
    }
}
