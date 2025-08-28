package matrix.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        int l = 0, r = matrix[0].length-1;
        int t = 0, b = matrix.length-1;
        int i,j,k,m;
        List<Integer> output = new ArrayList<>();

        while (l <= r && t <= b  ) {

            for(i=l;i<=r;i++)
                output.add(matrix[t][i]);
            t++;

            for(j=t;j<=b;j++)
                output.add(matrix[j][r]);
            r--;

            if(l>r || t>b)
                break;

            for(k=r;k>=l;k--)
                output.add(matrix[b][k]);
            b--;
            for(m=b;m>=t;m--)
                output.add(matrix[m][l]);
            l++;

        }
        return output;
    }
}
