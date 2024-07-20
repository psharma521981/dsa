package src.miscellaneously.old.others;

import java.util.Arrays;

public class MaxNumberReplace5 {

    public static void main(String[] args) {
        int num = -5000;

        String s = String.valueOf(num);
        int[] indexCount = new int[s.length()];
        int j = 0;
        Arrays.fill(indexCount, -1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '5')
                indexCount[j++] = i;
        }
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < indexCount.length; i++) {

            if (indexCount[i] != -1) {
                String tmp = s.substring(0, indexCount[i]);
                tmp = tmp + s.substring(indexCount[i] + 1, s.length());
                maxVal = Math.max(maxVal, Integer.parseInt(tmp));
            }
        }
        System.out.println(maxVal);
    }

}
