package neetcode150.array_and_hashing.prectice;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length == 0)
            return null;

        List<List<String>> output = new ArrayList<>();
        Map<String,List<String>> samStringMap = new HashMap<>();

        for(String str:strs) {

            char[] strToChar = str.toCharArray();
            Arrays.sort(strToChar);
            String charToStr = String.valueOf(strToChar);
            if(samStringMap.get(charToStr) == null) {
                samStringMap.put(charToStr,new ArrayList<>());
            }
            samStringMap.get(charToStr).add(str);

        }

        for(Map.Entry<String,List<String>> entry:samStringMap.entrySet()) {
            output.add(entry.getValue());
        }
        return output;
    }
}
