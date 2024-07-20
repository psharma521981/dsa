package src.miscellaneously.old.others;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));

    }

    public String minWindow(String s, String t) {

        if (s == null || t == null || s.isEmpty() || t.isEmpty())
            return "";

        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, r = 0;
        int count = tMap.size();
        int left = 0, right = 0;
        int minLength = s.length();
        boolean found = false;

        while (r < s.length()) {

            if (tMap.containsKey(s.charAt(r))) {
                tMap.put(s.charAt(r), tMap.get(s.charAt(r)) - 1);
                if (tMap.get(s.charAt(r)) == 0)
                    count--;
            }
            r++;

            if (count > 0)
                continue;

            while (count == 0) {

                if (tMap.containsKey(s.charAt(l))) {
                    tMap.put(s.charAt(l), tMap.get(s.charAt(l)) + 1);
                    if (tMap.get(s.charAt(l)) > 0)
                        count++;
                }
                l++;

                if ((r - l + 1) < minLength) {

                    left = l;
                    right = r;
                    minLength = (r - l + 1);
                    found = true;
                }

            }
        }

        return (!found) ? " " : s.substring(left - 1, right);
    }

}
