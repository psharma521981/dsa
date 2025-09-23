package neetcode150.sliding_window.prectice.more_prectice;

public class PermutationInString {
    //Brute Force
    public boolean checkInclusion(String s1, String s2) {

        if(s1 == null || s2 == null) {
            return false;
        }
        for(int i=0; i<s2.length();i++) {
            char ch = s2.charAt(i);
            if(s1.indexOf(ch) >= 0) {
                int[] s1FrequencyCount = new int[26];
                char[] s1ToChar = s1.toCharArray();
                for(char charcterOfS1:s1ToChar) {
                    s1FrequencyCount[charcterOfS1 - 'a']++;
                }
                for(int j=0;j<s1.length() && ((i+j) < s2.length()) ;j++) {
                    s1FrequencyCount[s2.charAt(i+j) - 'a']--;
                }
                int k=0;
                for(;k<26;k++) {
                    if(s1FrequencyCount[k] !=0)
                        break;
                }
                if(k==26)
                    return true;
            }
        }
        return false;
    }
}
