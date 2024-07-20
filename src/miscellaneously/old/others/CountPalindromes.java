package src.miscellaneously.old.others;

import java.util.HashMap;
import java.util.Map;

public class CountPalindromes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    // Count the palindrom word and it's count
    Map<String, Integer> getPalindromCount(String input) {
        Map<String, Integer> output = new HashMap<>();
        // Validate the input
        if (input == null || input.isEmpty())
            return output;
        
        String[] inputWords = input.split(" ");
        Map<String, Integer> inputWordsMap = new HashMap<>();
        for(String str:inputWords) {
            
            if (inputWordsMap.containsKey(str)) {
                inputWordsMap.put(str, inputWordsMap.get(str) + 1);
            } else {
                if (checkPalindrom(str)) {
                    inputWordsMap.put(str, 1);
                }
            }
        }
    return inputWordsMap;

    }

    // Check Palindrom String
    boolean checkPalindrom(String str) {

        // Validate the input

        if (str == null)
            return false;

        int end = str.length() - 1;
        int start = 0;

        while (start <= end) {
            // TODO Check for punctuation or find digit or alphabets
            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;

    }

}
