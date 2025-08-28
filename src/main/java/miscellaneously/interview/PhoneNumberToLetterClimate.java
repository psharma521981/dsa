package src.miscellaneously.interview;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberToLetterClimate {

    public static void main(String[] args) {

        List<String> result = new ArrayList<>();

        String[] combinations = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        String digit = "3456";
        getListOfcombination(result, combinations, digit, 0, "");
        System.out.println(result);

    }

    private static void getListOfcombination(List<String> result, String[] combinations, String digit, int i,
            String string) {

        if (digit.length() == i) {
            result.add(string);
            return;
        }
        String combination = combinations[digit.charAt(i) - '0'];
        for (int j = 0; j < combination.length(); j++) {
            string = string + combination.charAt(j);
            getListOfcombination(result, combinations, digit, i + 1, string);
        }

    }

}
