package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval_56 {
    public int[][] merge(int[][] intervals) {

        if(intervals.length == 0)
            return new int[][]{};

        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0],b[0]));
        List<int[]> output = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++) {

            if(intervals[i][0] <= end) {
                end = Math.max(end,intervals[i][1]);
            } else {
                output.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        output.add(new int[]{start,end});

        return output.toArray(new int[output.size()][]);
    }
}
