package src.neetcode150.array_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    final String delimiter = "##";
    final String separate = "_";
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        if(strs == null || strs.size() < 1)
            return sb.toString();


        for(String s:strs) {
            int len = s.length();
            sb.append(len+separate+s+delimiter);
        }

        return sb.toString();
    }

    // Function to decode the encoded string back to the list of strings
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();

        while(s.length() > 0) {
            int indexOfSeparator = s.indexOf(separate);
            int lengthofString = Integer.valueOf(s.substring(0,indexOfSeparator));

            String str = s.substring(indexOfSeparator+1,indexOfSeparator+lengthofString+1);
            s = s.substring(indexOfSeparator+lengthofString+delimiter.length()+1,s.length());
            res.add(str);
        }
        return res;
    }
    public static void main(String[] args) {
        EncodeAndDecodeStrings sol = new EncodeAndDecodeStrings();
        // Test the encode and decode functions with the example
        List<String> example = Arrays.asList("apple", "banana##cherry");
        System.out.println(sol.encode(example));  // Should print ["apple", "banana##cherry"]
        System.out.println(sol.decode(sol.encode(example)));  // Should print ["apple", "banana##cherry"]
    }
}
