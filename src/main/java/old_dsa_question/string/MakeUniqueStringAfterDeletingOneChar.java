package src.miscellaneously.old.dsa.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times. 
 * It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. 
 * Given a string , determine if it is valid. If so, return YES, otherwise return NO.

Example

This is a valid string because frequencies are .
This is a valid string because we can remove one  and have  of each character in the remaining string.
This string is not valid as we can only remove  occurrence of . That leaves character frequencies of .

Function Description

Complete the isValid function in the editor below.

isValid has the following parameter(s):

string s: a string
Returns

string: either YES or NO
Input Format

A single string .

Constraints

Each character 
Sample Input 0
 */
public class MakeUniqueStringAfterDeletingOneChar {

    public static void main(String[] args) {
        System.out.println(isValid("abcda"));
    }

    public static String isValid(String str) {

        int length = str.length();
        int i = 0;

        Map<Character, Integer> frequencyMap = new HashMap<>();

        while (i < length) {
            char ch = str.charAt(i);

            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            i++;

        }
        System.out.println(frequencyMap.values());
        List<Integer> frequency = new ArrayList<Integer>(frequencyMap.values());
        
        Collections.sort(frequency);
        
        int first = frequency.get(0);
        int second = frequency.get(1);
        int secondLast = frequency.get(frequency.size() - 2);
        int last = frequency.get(frequency.size() - 1);

        // frequency same for all characters

        if (first == last)
            return "YES";

        // Only one frequency is different is difference is 1

        if (secondLast != last && last - secondLast == 1)
            return "YES";

        // One frequency is different and that is 1

        if (second != first && first == 1)
            return "YES";

        return "NO";
       

    }

}
