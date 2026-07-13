package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning_131 {
    public static void main(String s[]) {

    // aab
    }

    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        doPartition(s,0,new ArrayList<>(),output);
        return output;
    }
    public void doPartition(String s, int idx,List<String> current,List<List<String>> output) {

        if(idx > s.length()-1) {
            output.add(new ArrayList<>(current));
        }
        for(int i=idx;i<s.length();i++) {

            String tmp = s.substring(idx,i+1);
            if(checkPalindron(tmp)) {
                current.add(tmp);
                doPartition(s,i+1,current,output);
                current.remove(current.size() -1);
            }
        }
    }

    public static boolean checkPalindron(String st) {

        if(!st.isEmpty()) {

            int start = 0;
            int end = st.length() -1;

            while(start <= end) {

                if(st.charAt(start) != st.charAt(end)) {
                    return false;
                } else {
                    start++;
                    end--;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
