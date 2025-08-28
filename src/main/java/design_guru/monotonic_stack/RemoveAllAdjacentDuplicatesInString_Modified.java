package monotonic_stack;

public class RemoveAllAdjacentDuplicatesInString_Modified {
    //Check for input validation for string
    //Create String builder object and use as stack so that you can manipulate the string builder object from last character
    //Calculate the length of stack object so that deletion can happen from last.
    //if stack is not empty and last character same as current than delete the last character and add the current one.
    //return the Sting Builder as stack
    public String removeDuplicates(String s) {

       StringBuilder sb = new StringBuilder("");

       for(char ch : s.toCharArray()) {
           int length =  sb.length();
           if(length > 0 && sb.charAt(length-1) == ch)
               sb.deleteCharAt(length-1);
           else
               sb.append(ch);

       }

            return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString_Modified solution = new RemoveAllAdjacentDuplicatesInString_Modified();
        System.out.println(solution.removeDuplicates("abccba")); // Output: ""
        System.out.println(solution.removeDuplicates("foobar")); // Output: "fbar"
        System.out.println(solution.removeDuplicates("abcd")); // Output: "abcd"
    }
}
