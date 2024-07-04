package merge_interval;

import java.util.*;

public class MaximumCPULoad {
    static class Job {
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    };

    public static int findMaxCPULoad(List<Job> jobs) {
        int maxCPULoad = 0;

        //Validate the input
        //Sort the input
        //Create max heap on the basis finish time of job
        //If new job comes then compare if it can accomodate in same time window, if yes then add the load
        //If not then compare max load with load of current job. If current job load is more than empty the queue and add the job

        if(jobs == null || jobs.isEmpty())
            return maxCPULoad;

        Collections.sort(jobs,(a,b) -> a.start - b.start);

        PriorityQueue<Job> queue = new PriorityQueue<>(jobs.size(),(a,b) -> Integer.compare(a.end,b.end));
        int currentCPULoad = 0;
        for(Job j:jobs) {
            while(!queue.isEmpty() && queue.peek().end <= j.start) {
                currentCPULoad-=queue.poll().cpuLoad;
            }
            queue.add(j);
            currentCPULoad+=j.cpuLoad;

            maxCPULoad=Math.max(maxCPULoad,currentCPULoad);
        }

        return maxCPULoad;
    }
    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3),
                new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " +
                MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11),
                new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " +
                MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1),
                new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " +
                MaximumCPULoad.findMaxCPULoad(input));
    }
}
