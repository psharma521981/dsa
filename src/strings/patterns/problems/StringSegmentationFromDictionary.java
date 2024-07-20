package src.strings.patterns.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringSegmentationFromDictionary {

    public static boolean canSegment(String target, List<String> dictionary) {

        if(Objects.equals(target, ""))
            return true;

        for(String word:dictionary) {
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if(canSegment(suffix,dictionary))
                    return true;
            }
        }
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
        System.out.println(canSegment("abctvxy",disctionary));

        disctionary = new ArrayList<>();
        disctionary.add("e");
        disctionary.add("ee");
        disctionary.add("eee");
        disctionary.add("eeee");
        disctionary.add("eeeeee");
        disctionary.add("eeeeeeeeeeee");
        disctionary.add("eeeeeeeeeeeeeeeeeeeeeeee");
        System.out.println(canSegment("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",disctionary));
    }
}
