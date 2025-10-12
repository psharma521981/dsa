package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] s) {
        int len = 4 * 2;
        List<String> output = new ArrayList<>();

        generateParenthisis(0,0, len, output, "");
        for(String st:output) {
            System.out.println(st);
        }
    }

    private static void generateParenthisis(int leftCount, int rightCount, int len, List<String> output, String s) {

    if(s.length() == len) {
        if( (leftCount - rightCount) ==0) {
            int left = leftCount;
            int right = rightCount;
            for(char c:s.toCharArray()) {
                if(c =='{')
                    left--;
                else
                    right--;
                if(right < left)
                    return;
            }
            output.add(s);
        }
        return;
    }
        s=s+"{";
        generateParenthisis(leftCount+1 ,rightCount, len, output,s);
        s=s.substring(0,s.length()-1);
        s=s+"}";
        generateParenthisis(leftCount ,rightCount+1, len, output,s);
    }
}
