package src.neetcode150.sliding_window;

public class LongestRepeatingCharacterReplacement_Revision {

    public int findLength(String str, int k) {

        if(str == null || str.length() < k)
            return -1;

        int maxLength = 0;
        int left =0;
        int right = 0;
        int maxLengthOfString = str.length();
        int maxFrequencyCount = 0;
        int[] frequency = new int[26];

        while(right < maxLengthOfString) {

            int index = str.charAt(right) - 'a';
            frequency[index]++;

            maxFrequencyCount = Math.max(maxFrequencyCount,frequency[index]);

            while(!((right-left-maxFrequencyCount+1) <= k)) {
                index = str.charAt(left) - 'a';
                frequency[index]--;
                left++;
            }

            maxLength = Math.max(maxLength,(right-left+1));
            right++;
        }
        return maxLength;

    }
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement_Revision sol = new LongestRepeatingCharacterReplacement_Revision();
        System.out.println(sol.findLength("aabccbb", 2));
        System.out.println(sol.findLength("abbcb", 1));
        System.out.println(sol.findLength("abccde", 1));
    }
}
