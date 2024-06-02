package meta.arrays;

import java.util.List;
/*
In this challenge, you are required to calculate and print the sum of the elements in an array,
keeping in mind that some of those integers may be quite large.
 */
public class AVeryBigSum {
    public static long aVeryBigSum(List<Long> ar) {
        long sum=0;

        for(Long num:ar)
            sum+=num;

        return sum;
    }
    public static void main(String s[]) {

    }
}
