package meta.stack_and_queues;

import java.util.Stack;

public class BalanaceBracket {
    public static String isBalanced(String s) {

        if (s == null || s.length() == 0)
            return null;

        Stack<Character> bracketStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(' || bracket == '{' || bracket == '[')
                bracketStack.push(bracket);
            else if (!bracketStack.empty() && ((bracket == ')' && bracketStack.peek() == '(')
                    || (bracket == '}' && bracketStack.peek() == '{')
                    || (bracket == ']' && bracketStack.peek() == '['))) {
                bracketStack.pop();
            } else {
                return "NO";
            }
        }
        return (!bracketStack.empty()) ? "NO" :"YES";
    }
    public static void main(String[] args)   {
        System.out.println(isBalanced("{}{()}{{}}"));
    }
}
