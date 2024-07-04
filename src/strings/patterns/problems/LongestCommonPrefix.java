package src.strings.patterns.problems;

public class LongestCommonPrefix {
    public static void main(String args[]) {
        // Your code goes here
        LongestCommonPrefix ob = new LongestCommonPrefix();
        String s[] = {"flower", "flow", "flight"};
        System.out.println("flower".indexOf("flight"));
        System.out.println(ob.longestCommonPrefix(s));
    }
    public String longestCommonPrefix(String[] S) {
        if (S.length == 0) return "";
        String prefix = S[0];
        for (int i = 1; i < S.length; i++) {
            while (S[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
