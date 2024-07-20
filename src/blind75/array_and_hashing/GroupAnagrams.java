package blind75.array_and_hashing;

import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
/*
Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: strs = ["act","pots","tops","cat","stop","hat"]

Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // ToDo: Write Your Code Here.

        //Validate the inout
        if(strs == null || strs.length < 1)
            return new ArrayList<>();

        //Map the simillar strings
        Map<String,List<String>> mapSimillarStrings= new HashMap<>();

        //Fir each string need to be sorted to compare easily and check the simillar
        for(String str:strs) {

            char[] strToChar = str.toCharArray();
            Arrays.sort(strToChar);
            String stringKey = String.valueOf(strToChar);
            if(!mapSimillarStrings.containsKey(stringKey)) {
                mapSimillarStrings.put(stringKey,new ArrayList<>());
            }
            mapSimillarStrings.get(stringKey).add(str);
        }
        List<List<String>> output = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:mapSimillarStrings.entrySet()) {
            output.add(entry.getValue());
        }
        return output;
    }
    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        System.out.println(sol.groupAnagrams(new String[]{"dog", "god", "hello"}));
        System.out.println(sol.groupAnagrams(new String[]{"listen", "silent", "enlist"}));
        System.out.println(sol.groupAnagrams(new String[]{"abc", "cab", "bca", "xyz", "zxy"}));
    }
}
