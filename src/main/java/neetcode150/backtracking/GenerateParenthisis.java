package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.

Example 1:

Input: n = 1

Output: ["()"]
Example 2:

Input: n = 3

Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParenthisis {
    List<String> output = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        if(n <= 0) {
            return output;
        }
        generateCombination(new StringBuilder(""),n,0,0);

        return output;
    }

    public void generateCombination(StringBuilder sb,int n,int open,int close) {

        if(open == close && open == n) {
            output.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append('(');
            generateCombination(sb,n,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open) {
            sb.append(')');
            generateCombination(sb,n,open,close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    /*public boolean validParenthesis(String sb) {

        int open =0;
        for(char ch : sb.toCharArray()) {
            if(ch=='(') {
                open++;
            } else {
                open--;
            }
            if(open < 0) {
                return false;
            }
        }
        return open == 0;
    }*/

}
