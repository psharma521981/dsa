package leetcode.dynamic_programming;

import java.util.Arrays;

public class MinCostClimbingStairs_746 {
    //top down approach

    int[] costMemoization;
    public int minCostClimbingStairs(int[] cost) {

        if(cost == null || cost.length == 0) {
            return 0;
        }
        costMemoization = new int[cost.length];
        Arrays.fill(costMemoization,-1);
        calculateMinCost(cost,0);

        return Math.min(costMemoization[0],costMemoization[1]);

    }

    public int calculateMinCost(int[] cost,int index) {

        if(index >= cost.length) {
            return 0;
        }
        if(costMemoization[index] == -1) {
            int first = cost[index] + calculateMinCost(cost,index + 1);
            int second = cost[index] + calculateMinCost(cost,index + 2);

            costMemoization[index] =  Math.min(first,second);
        }

        return costMemoization[index];

    }
    //bottom up

    public int minCostClimbingStairs2(int[] cost) {

        if(cost == null || cost.length == 0) {
            return 0;
        }

        if(cost.length == 1) {
            return cost[0];
        }

        if(cost.length == 2) {
            return Math.min(cost[0],cost[1]);
        }

        int i;
        for(i = 2; i < cost.length;i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1],cost[i - 2]);
        }

        return Math.min(cost[i -2], cost[i-1]);
    }

}
