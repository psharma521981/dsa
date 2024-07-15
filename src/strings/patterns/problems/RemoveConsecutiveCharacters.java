package src.strings.patterns.problems;

import java.util.Stack;

/*
Given a string A and integer B, remove all consecutive same characters that have length exactly B.

Input 1:

A = "aabcd"
B = 2

Input 2:
A = "aabbccd"
B = 2

Output 1:
 "bcd"
Output 2:
 "d"

 Explanation 1:

 "aa" had length 2.
Explanation 2:

 "aa", "bb" and "cc" had length of 2.

 */
public class RemoveConsecutiveCharacters {
    public static String solve(String A, int B) {
        if(A==null || A.isEmpty() || A.length() < B)
            return A;

        Stack<Character> characters = new Stack<>();
        Stack<Integer> charactersFrequency = new Stack<>();

        for(Character ch:A.toCharArray()) {
            if (!characters.empty() && !charactersFrequency.empty()
                    && characters.peek() == ch
                    && charactersFrequency.peek() >= B) {
                characters.pop();
                charactersFrequency.pop();
            } else {
                characters.push(ch);
                if(charactersFrequency.isEmpty())
                    charactersFrequency.push(1);
                else
                    charactersFrequency.push(charactersFrequency.pop() + 1);
            }
        }

        StringBuffer output= new StringBuffer();
        while(!characters.empty() && !charactersFrequency.empty()) {
           char ch =  characters.pop();
           int frequency = charactersFrequency.pop();
           for(int i=1;i<=frequency;i++) {
               output.append(ch);
           }
        }
        return output.reverse().toString();
    }
    public static void main(String[] s) {
        System.out.println(solve("aabcd",2));
        System.out.println(solve("aabbccd",2));
    }
}
