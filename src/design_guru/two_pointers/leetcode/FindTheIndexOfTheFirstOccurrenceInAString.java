package two_pointers.leetcode;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {

        if(haystack==null || needle==null || needle.length() > haystack.length())
            return -1;

        for(int i=0;i<haystack.length()-needle.length();i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int j;
                for(j=1;j<needle.length();j++) {
                    if(haystack.charAt(i+j) != needle.charAt(j))
                        break;
                }
                if(j==needle.length())
                    return i;
            }
        }

        return -1;

    }
}
