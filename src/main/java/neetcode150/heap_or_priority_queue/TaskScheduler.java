package neetcode150.heap_or_priority_queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*

You are given an array of CPU tasks tasks, where tasks[i] is an uppercase english character from A to Z. You are also given an integer n.

Each CPU cycle allows the completion of a single task, and tasks may be completed in any order.

The only constraint is that identical tasks must be separated by at least n CPU cycles, to cooldown the CPU.

Return the minimum number of CPU cycles required to complete all tasks.

Example 1:

Input: tasks = ["X","X","Y","Y"], n = 2

Output: 5

 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        if(tasks == null || n < 0)
            return 0;

        int[] frequencyCount = new int[26];
        Queue<Integer> jobQueueProcessing = new PriorityQueue<>((a, b) -> b - a);
        Queue<int[]> jobQueueBacklog = new LinkedList<>();
        for(int i=0;i<tasks.length;i++) {
            frequencyCount[tasks[i] - 'A']++;
        }
        for(int i=0;i<26;i++) {
            if(frequencyCount[i] != 0) {
                jobQueueProcessing.add(frequencyCount[i]);
            }
        }
        int time = 0;
        while(!jobQueueProcessing.isEmpty() || !jobQueueBacklog.isEmpty()) {
            ++time;
            if(!jobQueueProcessing.isEmpty()) {
                int job = jobQueueProcessing.poll();


                int[] jobDetails = new int[2];
                jobDetails[0] = job - 1;
                jobDetails[1] = n + time;
                if(jobDetails[0] > 0)
                    jobQueueBacklog.add(jobDetails);
            }


            if(!jobQueueBacklog.isEmpty() && jobQueueBacklog.peek()[1] == time) {
                int[] backLogJob = jobQueueBacklog.poll();
                jobQueueProcessing.add(backLogJob[0]);
            }
        }

        return time;
    }
}
