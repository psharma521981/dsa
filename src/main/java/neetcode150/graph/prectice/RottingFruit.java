package neetcode150.graph.prectice;

import java.util.LinkedList;
import java.util.Queue;

public class RottingFruit {
    int rows;
    int cols;
    int minutes = 0;
    int[][] allDirections = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int fresh = 0;
    Queue<int[]> rottenOrangeQueue = new LinkedList<>();


    public int orangesRotting(int[][] grid) {

        if(grid == null)
            return minutes;

        rows= grid.length;
        cols= grid[0].length;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 2) {
                    rottenOrangeQueue.add(new int[]{i,j,});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while(fresh > 0 && !rottenOrangeQueue.isEmpty()) {
            int rottenOrangeCount = rottenOrangeQueue.size();

            for(int i=1;i<=rottenOrangeCount;i++) {
                int[] rottenOrange = rottenOrangeQueue.poll();

                for(int[] direction:allDirections) {
                    int r = rottenOrange[0] + direction[0];
                    int c = rottenOrange[1] + direction[1];

                    if(r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        rottenOrangeQueue.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            minutes++;

        }

        return (fresh > 0) ? -1 : minutes;
    }
}
