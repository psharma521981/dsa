package merge_interval;

import java.util.Arrays;
import java.util.Comparator;

public class TwoDArraySort {

    public static void main(String s[]) {
        double[][] array= {
                {1, 5},
                {13, 1.55},
                {12, 100.6},
                {12.1, .85} };

      /*  java.util.Arrays.sort(array, new java.util.Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(a[1], b[1]);
            }
        }); */
        Arrays.sort(array, Comparator.comparingDouble(o -> o[1]));

        for(int i=0;i<array.length;i++) {

            for(int j=0;j<array[0].length;j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
