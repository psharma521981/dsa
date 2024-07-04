package monotonic_stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {

        StringBuilder sb = new StringBuilder("");
        Stack<int[]> charCount = new Stack<>();

        for(char ch : s.toCharArray()) {

            if(!charCount.empty() && charCount.peek()[0] == ch)
                charCount.peek()[1]++;
            else
                charCount.push(new int[]{ch,1});

            if(charCount.peek()[1] == k)
                charCount.pop();
        }

        while(!charCount.empty()) {
            int[] element = charCount.pop();
            for(int i=1;i<=element[1];i++)
             sb.append(String.valueOf((char) element[0]));
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII solution = new RemoveAllAdjacentDuplicatesInStringII();
        System.out.println(solution.removeDuplicates("abbbaaca", 3)); // Output: "ca"
        System.out.println(solution.removeDuplicates("abbaccaa", 3)); // Output: "abbaccaa"
        System.out.println(solution.removeDuplicates("abbacccaa", 3)); // Output: "abb"
    }
}
