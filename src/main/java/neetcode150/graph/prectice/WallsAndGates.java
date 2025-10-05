package neetcode150.graph.prectice;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    int MAX = Integer.MAX_VALUE;
    Queue<int[]> value = new LinkedList<>();
    int[][] direction = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    public void islandsAndTreasure(int[][] grid) {

        if(grid == null)
            return;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 0) {
                    value.add(new int[] {i,j});
                }
            }
        }

        if (value.size() == 0)
            return;

        while(!value.isEmpty()) {
            int[] val = value.poll();
            int row = val[0];
            int col = val[1];

            for(int[] dir:direction) {

                int r =   row + dir[0];
                int c =   col + dir[1];

                if(r < 0 || c < 0 || r >=grid.length || c >= grid[0].length || grid[r][c] != MAX)
                    continue;

                grid[r][c] = grid[row][col] + 1;
                value.add(new int[] {r,c});
            }

        }
    }
}
