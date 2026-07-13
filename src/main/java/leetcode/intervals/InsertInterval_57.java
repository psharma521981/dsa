package leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals == null || intervals.length == 0) {
            return new int[][]{{newInterval[0],newInterval[1]}};
        }

        List<int[]> output = new ArrayList<>();

        int maxIndex = intervals.length;
        int index = 0;

        while(index < maxIndex && intervals[index][1] < newInterval[0]) {
            output.add(intervals[index]);
            index++;
        }
        int start = newInterval[0];
        int end = newInterval[1];
        while(index < maxIndex && newInterval[1] >= intervals[index][0]) {
            start = Math.min(start,intervals[index][0]);
            end = Math.max(newInterval[1],intervals[index][1]);
            index++;
        }
        output.add(new int[]{start,end});

        while(index < maxIndex) {
            output.add(intervals[index]);
            index++;
        }
        return output.toArray(new int[output.size()][]);
    }
}
