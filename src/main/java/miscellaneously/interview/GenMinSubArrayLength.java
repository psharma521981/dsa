package src.miscellaneously.interview;

public class GenMinSubArrayLength {
    public static void main(String s[]) {
        int[] a = {2,3,1,2,4};
        System.out.println(getMinSubArrayLength(a,7));
    }

    private static int getMinSubArrayLength(int[] a, int target) {

        int minCount = Integer.MAX_VALUE;
        int tmpSum = 0;
        int startIndex = 0;
        for(int i=0;i<a.length;i++) {
            tmpSum += a[i];

            while(tmpSum>=target) {
                minCount = Math.min(minCount,i - startIndex + 1);
                tmpSum = tmpSum - a[startIndex];
                startIndex++;
            }
        }
    return (startIndex==0) ? startIndex : minCount;
    }
}
