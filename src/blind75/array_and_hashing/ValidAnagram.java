package blind75.array_and_hashing;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        //Validate the input
        if(s == null || t == null || s.length() != t.length())
            return false;

        //Create frequency map and count the character in source and if target also contains then reduced it
        Map<Character,Integer> frequencyMap = new HashMap<>();

        for(int i=0;i < s.length();i++){
            char sChar = s.charAt(i);
            frequencyMap.put(sChar,frequencyMap.getOrDefault(sChar,0) + 1);

            char tChar = t.charAt(i);
            frequencyMap.put(tChar,frequencyMap.getOrDefault(tChar,0) - 1);
        }

        for(Map.Entry<Character,Integer> ch:frequencyMap.entrySet()) {
            if(frequencyMap.get(ch.getKey()) !=0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();

        // Test case 1
        String s1 = "listen";
        String t1 = "silent";
        System.out.println(sol.isAnagram(s1, t1)); // Expected output: true

        // Test case 2
        String s2 = "hello";
        String t2 = "world";
        System.out.println(sol.isAnagram(s2, t2)); // Expected output: false

        // Test case 3
        String s3 = "anagram";
        String t3 = "nagaram";
        System.out.println(sol.isAnagram(s3, t3)); // Expected output: true

        // Test case 4
        String s4 = "rat";
        String t4 = "car";
        System.out.println(sol.isAnagram(s4, t4)); // Expected output: false

        // Test case 5
        String s5 = "";
        String t5 = "";
        System.out.println(sol.isAnagram(s5, t5)); // Expected output: true
    }
}
