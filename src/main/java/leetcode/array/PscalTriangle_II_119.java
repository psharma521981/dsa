package leetcode.array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle-ii/description/
public class PscalTriangle_II_119 {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();
        row.add(1);
        List<Integer> tmp = row;
        for(int i=1;i<=rowIndex;i++) {
            row = new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++) {
                row.add(tmp.get(j-1)+tmp.get(j));
            }
            row.add(1);
            tmp = row;
        }
        return row;
    }
}
