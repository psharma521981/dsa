package neetcode150.heap_or_priority_queue;

import java.util.PriorityQueue;
import java.util.Queue;

/*

You are given an array of integers stones where stones[i] represents the weight of the ith stone.

We want to run a simulation on the stones as follows:

At each step we choose the two heaviest stones, with weight x and y and smash them togethers
If x == y, both stones are destroyed
If x < y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
Continue the simulation until there is no more than one stone remaining.

Return the weight of the last remaining stone or return 0 if none remain.

Example 1:

Input: stones = [2,3,6,2,4]

Output: 1

 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {

        if(stones == null)
            return 0;
        if(stones.length == 1)
            return stones[0];

        Queue<Integer> stonesWeightqueue = new PriorityQueue<>((a, b) -> b - a);

        for (int i=0;i<stones.length;i++) {
            stonesWeightqueue.add(stones[i]);
        }

        while(stonesWeightqueue.size()>1) {
            int topTwoDiffernce = stonesWeightqueue.poll() - stonesWeightqueue.poll();
            stonesWeightqueue.add(topTwoDiffernce);
        }

        return (stonesWeightqueue.size() > 0) ? stonesWeightqueue.poll() : 0;
    }
}
