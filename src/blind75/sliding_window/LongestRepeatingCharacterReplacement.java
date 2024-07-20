package src.blind75.sliding_window;

public class LongestRepeatingCharacterReplacement {
    //check validation
    //check the maxcount of character
    //check condition sliding window - maxcount is less than equal to replacement count
    //if condition fails increase the left pointer and decrease the maxcount
    public int findLength(String str, int k) {
        int maxLength = 0;

        if(str==null || str.length() < k)
            return -1;

        int maxCount = 0;
        int[] maxCharacterCount = new int[26];
        int left = 0;
        int index = 0;
        int maxReplacement = 0;
        for(int i=0;i<str.length();i++) {

            index = str.charAt(i) - 'a';
            maxCharacterCount[index]++;

            maxCount = Math.max(maxCount,maxCharacterCount[index]);

            while(!(i-left-maxCount+1<=k)) {
                index = str.charAt(left) - 'a';
                maxCharacterCount[index]--;
               // for(int j=0;j<maxCharacterCount.length;j++)
                 //   maxCount = Math.max(maxCount,maxCharacterCount[index]);
                left++;
            }

            maxReplacement = Math.max(maxReplacement,i-left+1);
        }

        return maxReplacement;
    }
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();
        System.out.println(sol.findLength("aabccbb", 2));
        System.out.println(sol.findLength("abbcb", 1));
        System.out.println(sol.findLength("abccde", 1));
    }
}
