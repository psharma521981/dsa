package sliding_windows.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s==null)
            return -1;

        int maxLength = 0;
        Set<Character> uniqueCharSet = new HashSet<>();
        int left=0;
        for(int i =0;i<s.length();i++) {

            while(uniqueCharSet.contains(s.charAt(i))) {
                uniqueCharSet.remove(s.charAt(left));
                ++left;
            }
            uniqueCharSet.add(s.charAt(i));

            maxLength = Math.max(maxLength,(i-left)+1);
        }
        return maxLength;
    }
}
