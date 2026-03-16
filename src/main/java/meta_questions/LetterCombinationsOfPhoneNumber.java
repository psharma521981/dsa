package src.z_meta;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits==null || digits.length() == 0)
            return result;

        String[] combinations = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        getListOfcombination(result, combinations, digits, 0, "");
        return result;
    }

    private  void getListOfcombination(List<String> result, String[] combinations, String digit, int i,String string) {

        if (digit.length() == i) {
            result.add(string);
            return;
        }
        String combination = combinations[digit.charAt(i) - '0'];
        for (int j = 0; j < combination.length(); j++) {
            getListOfcombination(result, combinations, digit, i + 1, string + combination.charAt(j));
        }

    }
}
