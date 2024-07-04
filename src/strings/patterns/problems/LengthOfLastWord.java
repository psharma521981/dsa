package src.strings.patterns.problems;
/*

input A = " hello world "
output = 5
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(final String A) {

        if(A==null || A.isEmpty())
            return 0;

        String input = A.trim();

        int output = 0;
        for(Character ch:input.toCharArray()) {
            if(ch==' ') {
                output=0;
            } else {
                output++;
            }
        }
        return output;
    }
    public static void main(String[] s) {
        System.out.println(lengthOfLastWord(" hello world "));
        System.out.println(lengthOfLastWord("InterviewBit"));
    }
}
