package miscellaneously.interview;

import java.util.PriorityQueue;

public class TaskScheduler {
    public int overlappingInterval(int[][] intervals) {

        if (intervals == null || intervals[0].length == 0) {
            return 0;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));
        int maxCPU = 0;
        for(int[] interval:intervals) {

            while (!minHeap.isEmpty() && minHeap.peek()[1] <= interval[0]) {
                minHeap.poll();
            }
            minHeap.add(interval);
            maxCPU = Math.max(maxCPU,minHeap.size());
        }
        return maxCPU;
    }
    public static void main(String s[]) {
        TaskScheduler taskScheduler = new TaskScheduler();
        int[][] tasks = new int[][]{{1,3},{3,5},{4,7},{4,5},{8,9},{9,10}};
       System.out.println(taskScheduler.overlappingInterval(tasks));
    }
}
