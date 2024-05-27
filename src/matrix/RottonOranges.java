package matrix;

/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */

import java.util.LinkedList;
import java.util.Queue;

/*
Approach:
 Validate the input
 Count the fresh oranges
 Count the rotton oranges
 If rotton oranges is 0 then return -1
 insert all rotton oranges into queue and for every quue cycle check the boundry of rotton oranges and mark the fresh oranges as rotton
 and add them into queue. Run loop until queue is empty. Every loop from queue is count as 1 minute.

 */
public class RottonOranges {

    public int orangesRotting(int[][] grid) {

        int numberOfMinutes = 0;
        if(grid == null || grid.length < 1)
            return numberOfMinutes;

        int freshOranges = 0;
        int rottonOranges = 0;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2)
                    rottonOranges++;
                if(grid[i][j] == 1)
                    freshOranges++;
            }
        }

        if(rottonOranges ==0)
            return numberOfMinutes;

        Queue<int[]>  rottonOrangesLocation = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    rottonOrangesLocation.add(new int[]{i,j});
                }
            }
        }

        while(!rottonOrangesLocation.isEmpty()) {
            numberOfMinutes++;

            int[] cell = rottonOrangesLocation.poll();
            int row = cell[0];
            int col = cell[1];

        }

        return 0;
    }

}
