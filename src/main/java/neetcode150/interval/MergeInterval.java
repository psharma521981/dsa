package neetcode150.interval;

import java.util.*;
import design_guru.util.Interval;

;
/*
Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
 */
public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();

        if(intervals==null || intervals.size() <= 1)
            return intervals;

        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));

        Iterator<Interval> intervalIterator = intervals.iterator();

        Interval interval = intervalIterator.next();
        int startTime = interval.start;
        int endTime = interval.end;

        while(intervalIterator.hasNext()) {
            Interval nextInterval = intervalIterator.next();

            if(nextInterval.start <= endTime) {
                endTime = Math.max(nextInterval.end,endTime);
            } else {
                mergedIntervals.add(new Interval(startTime,endTime));
                startTime = nextInterval.start;
                endTime = nextInterval.end;
            }
        }
        mergedIntervals.add(new Interval(startTime,endTime));

        return mergedIntervals;
    }
    public static void main(String[] args) {
        MergeInterval sol = new MergeInterval();
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : sol.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : sol.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : sol.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
