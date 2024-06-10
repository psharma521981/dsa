package src.blind75.interval;

import src.util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/*
Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
Output: [[1,3], [4,7], [8,12]]
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();
        if(intervals==null)
            return intervals;

        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));

        int i=0;
        while(i<intervals.size() && intervals.get(i).end <= newInterval.start) {
            mergedIntervals.add(intervals.get(i++));
        }

        while(i<intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Integer.min(newInterval.start,intervals.get(i).start);
            newInterval.end = Integer.max(newInterval.end,intervals.get(i).end);
            i++;
        }
        mergedIntervals.add(newInterval);

        while(i<intervals.size()) {
            mergedIntervals.add(intervals.get(i++));
        }

        // TODO: Write your code here
        return mergedIntervals;
    }
    public static void main(String[] args) {
        InsertInterval sol = new InsertInterval();
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : sol.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : sol.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : sol.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
