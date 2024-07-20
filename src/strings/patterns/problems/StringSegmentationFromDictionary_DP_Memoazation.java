package src.strings.patterns.problems;

import java.util.*;

public class StringSegmentationFromDictionary_DP_Memoazation {

    public static boolean canSegment(String target, List<String> dictionary, Map<String,Boolean> chache) {

        if(chache.get(target) !=null)
            return chache.get(target);
        if(Objects.equals(target, ""))
            return true;

        for(String word:dictionary) {
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if(canSegment(suffix,dictionary,chache)) {
                    chache.put(target,true);
                    return true;
                }
            }
        }
        chache.put(target,false);
        return false;
    }
    public static void main(String[] s) {
        List<String> disctionary = new ArrayList<>();
        disctionary.add("a");
        disctionary.add("ab");
        disctionary.add("abc");
        disctionary.add("x");
        disctionary.add("xy");
        disctionary.add("xyz");
        disctionary.add("tv");
        Map<String,Boolean> memoazation = new HashMap<>();
        System.out.println(canSegment("abctvxy",disctionary,memoazation));
    }
}
