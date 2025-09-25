package neetcode150.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> operand = new Stack<>();

        if(tokens == null)
            return 0;

        int index = 0;

        List<String> operator = Arrays.asList("+","-","*","/");

        while(index < tokens.length) {
            String s = tokens[index];

            if(operator.contains(s)) {
                int b = operand.pop();
                int a = operand.pop();
                if(s.equals("+"))
                    operand.push(a+b);
                if(s.equals("-"))
                    operand.push(a-b);
                if(s.equals("*"))
                    operand.push(a*b);
                if(s.equals("/"))
                    operand.push(a/b);
            } else {
                operand.push(Integer.valueOf(s));
            }
            index++;
        }

        return operand.peek();

    }
}
