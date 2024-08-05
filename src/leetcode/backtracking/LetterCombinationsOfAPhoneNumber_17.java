package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber_17 {
    public List<String> letterCombinations(String digits) {

        List<String> output = new ArrayList<>();
        Map<Character,String> digitToCharMap= new HashMap<>();
        digitToCharMap.put('2',"abc");
        digitToCharMap.put('3',"def");
        digitToCharMap.put('4',"ghi");
        digitToCharMap.put('5',"jkl");
        digitToCharMap.put('6',"mno");
        digitToCharMap.put('7',"pqrs");
        digitToCharMap.put('8',"tuv");
        digitToCharMap.put('9',"wxyz");

        generateCombination(digits,digitToCharMap,output,0,"");

        return (output.size() > 1) ? output : new ArrayList<>();

    }

    private void generateCombination(String digits,Map<Character, String> digitToCharMap, List<String> output, int idx, String tmp) {

        if(tmp.length() == digits.length()) {
            output.add(tmp);
            return;
        }
        String comb = digitToCharMap.get(digits.charAt(idx));
        for(int i=0;i<comb.length();i++) {
            tmp+=comb.charAt(i);
            generateCombination(digits,digitToCharMap,output,idx+1,tmp);
            tmp=tmp.substring(0,tmp.length()-1);
        }
    }

    public static void main(String[] b) {
        List<String> output = new LetterCombinationsOfAPhoneNumber_17().letterCombinations("");
        for(String s:output) {
            System.out.println("{"+s+"}");
        }
    }
}
