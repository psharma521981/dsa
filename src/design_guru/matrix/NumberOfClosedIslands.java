package matrix;

public class NumberOfClosedIslands {
    public static int countClosedIslands(int[][] matrix) {
        int countClosedIslands = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {

                if(matrix[i][j] == 1)
                    if(checkClosedIslands(matrix,i,j))
                        countClosedIslands++;
            }
        }
        return countClosedIslands;
    }

    private static boolean checkClosedIslands(int[][] matrix, int i, int j) {

        int maxRows = matrix.length;
        int maxCols = matrix[0].length;

        if(i < 0 || i > maxRows || j < 0 || j > maxCols)
            return true;

        if(matrix[i][j] == 0)
            return true;

        if( matrix[i][j] == 1 && (i==maxRows-1 || i==0 || j==maxCols-1 || j==0))
            return false;

        matrix[i][j] = 0;


        return (checkClosedIslands(matrix,i+1,j) && checkClosedIslands(matrix,i,j+1)
               && checkClosedIslands(matrix,i-1,j) && checkClosedIslands(matrix,i,j-1));

    }
    public static void main(String[] args) {
        System.out.println(NumberOfClosedIslands.countClosedIslands(
                new int[][] {
                        { 1, 1, 0, 0, 0 },
                        { 0, 1, 0, 0, 0 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));

        System.out.println(NumberOfClosedIslands.countClosedIslands(
                new int[][] {
                        { 0, 0, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 0, 1, 0 },
                        { 0, 0, 0, 0 }
                }));
    }
}
