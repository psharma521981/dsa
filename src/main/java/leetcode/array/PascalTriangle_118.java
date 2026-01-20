package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> row = new ArrayList<>(Arrays.asList(1));
        output.add(row);

        for(int i=1;i<numRows;i++) {
            row = new ArrayList<>(Arrays.asList(1));
            List<Integer> tmp = output.get(i-1);
            for(int j=1;j<i;j++) {
                row.add(tmp.get(j-1) + tmp.get(j));

            }
            row.add(1);
            output.add(row);

        }
        return output;
    }
}
