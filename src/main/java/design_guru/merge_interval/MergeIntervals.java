package src.design_guru.merge_interval;

import src.design_guru.util.Interval;
import java.util.*;

//Validate the input
//Sort the input based on start time
//initialize first interval and iterate over rest of the interval
//check for start time is less than last end time. If so than update the endtime
//Anytime start time is greater than end time than add the interval into output and initialize the start/end time

public class MergeIntervals {
    public static List<Interval>  merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();

        if(intervals == null)
            return mergedIntervals;

        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));

        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval first = intervalIterator.next();
        int startTime =  first.start;
        int endTime = first.end;

        while(intervalIterator.hasNext()) {
            Interval next = intervalIterator.next();

            if(next.start <= endTime) {
               endTime = Integer.max(endTime, next.end);
            } else {
                mergedIntervals.add(new Interval(startTime,endTime));
                startTime = next.start;
                endTime = next.end;
            }
        }
        mergedIntervals.add(new Interval(startTime,endTime));


        return mergedIntervals;
    }
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
