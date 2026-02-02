package strings;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateCharsWithCounts {

    public static void main(String s[]) {

        for(Map.Entry<Character,Integer> entry:checkDuplicateCount("pankajpa").entrySet()) {
            System.out.println(entry.getKey()+" ->"+entry.getValue());
        }

    }

   public static Map<Character,Integer> checkDuplicateCount(String s) {

        int[] duplicateCount = new int[26];
        Map<Character,Integer> duplicate = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            int index = s.charAt(i) - 'a';
          duplicateCount[index] = duplicateCount[index] + 1;
            if(duplicateCount[index] > 1) {
                duplicate.put(s.charAt(i),duplicateCount[index]);
            }
        }

       return duplicate;

   }
}
