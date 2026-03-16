package src.miscellaneously.old.dsa.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//Remove deplicate and get maxmum string - walmart
//iterate over the string and count the occurences of each character

//Count the maximum characters in the string 
//Multiple unique strings 
//Lexicographically string 

public class StringRemoveDuplicateAndGetMaxSubstring {

    public static void main(String[] args) {
        String input_str = "cdeaabfghi";
        System.out.println("Input_string " + input_str);
        System.out.println("Output_string " + getString(input_str));

    }

    public static String getString(String input_str) {

        int left = 0, right = 0;
        int maxLength = Integer.MIN_VALUE;
        int length = input_str.length();
        Set<Character> duplicateChar = new HashSet<>();
        String output = "";

        while (left < length) {
            char ch = input_str.charAt(left);

            if (duplicateChar.contains(ch)) {
                    duplicateChar.remove(ch);
                    right = left;
                }

            duplicateChar.add(ch);

            if (maxLength <= (left - right + 1)) {
                maxLength = left - right + 1;
                String currentMaxSubString =  input_str.substring(right, left + 1);
                System.out.println("currentMaxSubString " + currentMaxSubString);

                if (currentMaxSubString.compareToIgnoreCase(output) >= 1)
                    output = currentMaxSubString;
            }
            left++;
        }

        return output;
    }
}
