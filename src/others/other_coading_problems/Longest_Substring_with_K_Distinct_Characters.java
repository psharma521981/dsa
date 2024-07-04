package src.others.other_coading_problems;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_with_K_Distinct_Characters {
    public static int findLength(String str, int k) {
        int maxLength = 0;

        if(str==null || str.length()==0 || str.length() < k)
             throw new IllegalArgumentException();

        int left = 0;
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);

            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);

            while(frequencyMap.size() > k) {
                char chToRemove = str.charAt(left);
                frequencyMap.put(chToRemove,frequencyMap.get(chToRemove)-1);
                if(frequencyMap.get(chToRemove)==0)
                    frequencyMap.remove(chToRemove);

                left++;
            }
            maxLength = Math.max(maxLength,i-left+1);
        }
        return maxLength;


    }
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: "
                + Longest_Substring_with_K_Distinct_Characters.findLength("aabbccdd", 2));
        System.out.println("Length of the longest substring: "
                + Longest_Substring_with_K_Distinct_Characters.findLength("araaci", 1));
        System.out.println("Length of the longest substring: "
                + Longest_Substring_with_K_Distinct_Characters.findLength("cbbebi", 3));
    }
}
