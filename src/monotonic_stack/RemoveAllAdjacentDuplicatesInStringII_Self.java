package monotonic_stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII_Self {
    //validate the input for null and length check.
    //Initialize the stack with int array type to store charcter at first index and count in second index
    //iterate over the string and check empty stack if not then check character count is equal to k
    //if yes then remove charcter or else increament the counter and move to next iteration
    //Create a String builder class and pop the elements of stack and on based of it's count replicate the characters in string builder
    //reverse the string builder to generate the output
    public String removeDuplicates(String s, int k) {

        if(s==null || s.length() < k)
            return null;

        Stack<int[]> characterAndFrequency = new Stack<>();

        for(char ch:s.toCharArray()) {
            if(!characterAndFrequency.empty() && characterAndFrequency.peek()[0] == ch) {
                characterAndFrequency.peek()[1]++;
                if(characterAndFrequency.peek()[1]==k)
                    characterAndFrequency.pop();
            } else {
                characterAndFrequency.push(new int[]{ch,1});
            }
        }
        StringBuilder sb= new StringBuilder();
        while(!characterAndFrequency.empty()) {
            int[] element = characterAndFrequency.pop();
            for(int i=1;i<=element[1];i++)
             sb.append((char)element[0]);
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII_Self solution = new RemoveAllAdjacentDuplicatesInStringII_Self();
        System.out.println(solution.removeDuplicates("abbbaaca", 3)); // Output: "ca"
        System.out.println(solution.removeDuplicates("abbaccaa", 3)); // Output: "abbaccaa"
        System.out.println(solution.removeDuplicates("abbacccaa", 3)); // Output: "abb"
    }
}
