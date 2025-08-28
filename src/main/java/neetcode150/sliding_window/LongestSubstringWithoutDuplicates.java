package src.neetcode150.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutDuplicates {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueSet = new HashSet<>();

        int left = 0;
        int right =0;
        int lengthOfMaxSubstring = 0;
        while(right < s.length()) {

            char ch = s.charAt(right);
            //found duplicate
            while(uniqueSet.contains(ch)) {
                uniqueSet.remove(s.charAt(left));
                left++;
            }
            uniqueSet.add(ch);
            lengthOfMaxSubstring = Math.max(lengthOfMaxSubstring,(right - left) + 1);
            right++;
        }
        return lengthOfMaxSubstring;
    }
    public static void main(String[] s) {
        LongestSubstringWithoutDuplicates ls =new LongestSubstringWithoutDuplicates();
        System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(ls.lengthOfLongestSubstring("pwwkew"));
    }
}
