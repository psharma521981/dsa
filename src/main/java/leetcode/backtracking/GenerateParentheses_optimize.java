package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_optimize {
    public static void main(String[] s) {
        int len = 3;
        List<String> output = new ArrayList<>();

        generateParenthisis(0,0, len, output, "");
        for(String st:output) {
            System.out.println(st);
        }
    }

    private static void generateParenthisis(int leftCount, int rightCount, int len, List<String> output, String s) {

    if(rightCount > leftCount || rightCount > len || leftCount > len)
        return;

    if(leftCount == len && rightCount ==len) {
        output.add(s);
        return;
    }

        generateParenthisis(leftCount+1,rightCount, len, output, s+"{");
        generateParenthisis(leftCount,rightCount+1, len, output, s+"}");
    }
}
