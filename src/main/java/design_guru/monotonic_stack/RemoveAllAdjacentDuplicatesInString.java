package monotonic_stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    //Check for input validation for string
    //Create String builder object and use as stack so that you can manipulate the string builder object from last character
    //Calculate the length of stack object so that deletion can happen from last.
    //if stack is not empty and last character same as current than delete the last character and add the current one.
    //return the Sting Builder as stack
    public String removeDuplicates(String s) {

        Stack<Character> charStack = new Stack<>();

        for(int i=0;i<s.length();i++) {

            if(!charStack.empty() && charStack.peek().charValue() == s.charAt(i)) {
                 while(!charStack.empty() && charStack.peek().charValue() == s.charAt(i))
                     charStack.pop();
                 continue;
            }
            charStack.push(s.charAt(i));
        }
        StringBuffer sb = new StringBuffer("");

        while(!charStack.empty())
            sb.append(charStack.pop());

            return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString solution = new RemoveAllAdjacentDuplicatesInString();
        System.out.println(solution.removeDuplicates("abccba")); // Output: ""
        System.out.println(solution.removeDuplicates("foobar")); // Output: "fbar"
        System.out.println(solution.removeDuplicates("abcd")); // Output: "abcd"
    }
}
