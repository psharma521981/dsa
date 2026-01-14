package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a string digits made up of digits from 2 through 9 inclusive.

Each digit (not including 1) is mapped to a set of characters as shown below:

A digit could represent any one of the characters it maps to.

Return all possible letter combinations that digits could represent. You may return the answer in any order.

Input: digits = "34"

Output: ["dg","dh","di","eg","eh","ei","fg","fh","fi"]

 */
public class MobileLetterCombination {
    List<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.length() == 0) {
            return output;
        }

        Map<Integer,String> combination = new HashMap<>();
        combination.put(2,"abc");
        combination.put(3,"def");
        combination.put(4,"ghi");
        combination.put(5,"jkl");
        combination.put(6,"mno");
        combination.put(7,"pqrs");
        combination.put(8,"tuv");
        combination.put(9,"wxyz");

        generateCombination(digits,combination,0,new StringBuilder(""));

        return output;

    }

    public void generateCombination(String digits, Map<Integer,String> combination,int index,StringBuilder comb) {

        if(comb.length() == digits.length()) {
            output.add(comb.toString());
            return;
        }

        int digit = Integer.valueOf(digits.charAt(index) - '0');
        String digitComb = combination.get(digit);

        for(char ch:digitComb.toCharArray()) {
            comb.append(ch);
            generateCombination(digits,combination,index+1,comb);
            comb.deleteCharAt(comb.length()-1);
        }

    }
}
