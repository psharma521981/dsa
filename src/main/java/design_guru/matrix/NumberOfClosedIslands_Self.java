package matrix;

//Validate the input
//run the loop for each cell and check for island
//if found then run dfs and check valid island. If it is island then return true or else false
//Count the valid island

public class NumberOfClosedIslands_Self {
    public static int countClosedIslands(int[][] matrix) {
        int countClosedIslands = 0;

        if(matrix==null || matrix.length > 0)

            for(int i=0;i<matrix.length;i++) {
                for(int j=0;j<matrix[0].length;j++) {
                    if(matrix[i][j] == 1) {
                        if(checkValudIsLand(matrix,i,j))
                            countClosedIslands++;
                    }
                }
            }
        return countClosedIslands;
    }

    private static boolean checkValudIsLand(int[][] matrix, int i, int j) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;

        if(i < 0 || i > rows || j < 0 || j > cols || matrix[i][j] == 0)
            return true;

        if(matrix[i][j] == 1 && (i == 0 || i > rows-1 || j == 0 || j > cols-1))
            return false;

        matrix[i][j] = 0;

        return checkValudIsLand(matrix,i+1,j) && checkValudIsLand(matrix,i-1,j)
             && checkValudIsLand(matrix,i,j+1) && checkValudIsLand(matrix,i,j-1);
    }

    public static void main(String[] args) {
        System.out.println(NumberOfClosedIslands_Self.countClosedIslands(
                new int[][] {
                        { 1, 1, 0, 0, 0 },
                        { 0, 1, 0, 0, 0 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));

        System.out.println(NumberOfClosedIslands_Self.countClosedIslands(
                new int[][] {
                        { 0, 0, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 0, 1, 0 },
                        { 0, 0, 0, 0 }
                }));
    }
}
