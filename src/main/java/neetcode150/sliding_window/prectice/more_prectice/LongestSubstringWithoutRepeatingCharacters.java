package neetcode150.sliding_window.prectice.more_prectice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        if(s==null || s.length() < 1)
            return 0;

        Set<Character> uniqueChar = new HashSet<>();

        int left = 0, right = 0;
        int lengthOfInput = s.length();
        int lengthOfSubString = 0;

        while(right < lengthOfInput) {
            char ch =  s.charAt(right);
            while(uniqueChar.contains(ch)) {
                uniqueChar.remove(s.charAt(left));
                left++;
            }
            uniqueChar.add(ch);
            lengthOfSubString = Math.max(lengthOfSubString, (right - left + 1));
            right++;
        }
        return lengthOfSubString;

    }
}
