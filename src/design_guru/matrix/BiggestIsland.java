package matrix;

public class BiggestIsland {
    //validate the input
    //iterate over matrix and check for ireland and if found call dfs to all connected irlands and calculate the area and return it
    //Check max area for each DFS return
    //return max area
    public static int maxAreaOfIsland(int[][] matrix) {
        int biggestIslandArea = 0;

        int rows = matrix.length -1 ;
        int cols = matrix[0].length - 1;

        for(int i=0;i<=rows;i++) {
            for(int j=0;j<=cols;j++) {
                if(matrix[i][j] == 1)
                    biggestIslandArea = Math.max(biggestIslandArea,getMaxArea(matrix,i,j,0));
            }
        }
        return biggestIslandArea;
    }

    private static int getMaxArea(int[][] matrix, int i, int j, int area) {

        int maxRows = matrix.length -1 ;
        int maxCols = matrix[0].length -  1;

        if(i < 0 || i > maxRows || j < 0 || j > maxCols || matrix[i][j] == 0)
            return 0;

        matrix[i][j] = 0;

        return 1 + getMaxArea(matrix,i+1,j,area) +
                getMaxArea(matrix,i,j+1,area) +
                getMaxArea(matrix,i-1,j,area) +
                getMaxArea(matrix,i,j-1,area);

    }
    public static void main(String[] args) {
        System.out.println(BiggestIsland.maxAreaOfIsland(
                new int[][] {
                        { 1, 1, 1, 0, 0 },
                        { 0, 1, 0, 0, 1 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }));
    }
}
