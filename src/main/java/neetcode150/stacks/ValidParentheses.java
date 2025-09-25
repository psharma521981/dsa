package neetcode150.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {

        if(s == null || s.length() <=0)
            return false;

        Map<Character,Character> closingChar = new HashMap<>();
        closingChar.put(')','(');
        closingChar.put('}','{');
        closingChar.put(']','[');

        Stack<Character> charStack = new Stack<>();

        char[] strToChar = s.toCharArray();
        for(char ch:strToChar) {

            if(closingChar.get(ch)!=null) {

                if(!charStack.empty() && charStack.peek() == closingChar.get(ch)) {
                    charStack.pop();
                } else {
                    return false;
                }
            } else {
                charStack.push(ch);
            }
        }

        return charStack.empty();

    }
}
