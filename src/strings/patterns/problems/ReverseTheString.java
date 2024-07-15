package src.strings.patterns.problems;

/*
Input 1:
    A = "the sky is blue"
Input 2:
    A = "this is ib"

    Output 1:
    "blue is sky the"
Output 2:
    "ib is this"
 */
public class ReverseTheString {
    /*public static String solve(String A) {

        if(A==null || A.isEmpty())
            return A;

        String outputString = new String();
        String tempString = new String();

        String input = A.trim();

        for(int i=0;i<input.length();i++) {
            char ch = input.charAt(i);
            if(ch==' ') {
                outputString = tempString + input.charAt(i) + outputString;
                tempString ="";
            } else {
                tempString = tempString + input.charAt(i);
            }
        }
        outputString = tempString + ' ' + outputString;
        return outputString;
    }*/
    public static String solve(String A) {

        if(A==null || A.isEmpty())
            return A;

        String outputString = new String();

        String[] inputWords = A.split(" ");
        for(int i=inputWords.length-1;i>0;i--) {

            outputString = outputString + inputWords[i] + " ";
        }

        return outputString + inputWords[0];
    }
    public static void main(String[] s) {
        System.out.println(solve("the sky is blue"));
        System.out.println(solve("this is ib"));
    }
}
