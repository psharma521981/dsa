package neetcode150.sliding_window.prectice;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseTraversers;

import java.util.HashSet;
import java.util.Set;

//abcbacbb
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        if(s==null)
            return 0;

        int l =0;
        int r = 0;
        Set<Character> duplicateSet = new HashSet<>();
        int maxLength= 0;

        while(r < s.length()) {
            char  ch = s.charAt(r);
                while(duplicateSet.contains(ch)) {
                    duplicateSet.remove(s.charAt(l));
                    l++;
                }

            duplicateSet.add(ch);
            maxLength = Math.max(maxLength,r - l + 1);
            r++;
        }
        return maxLength;
    }
}
