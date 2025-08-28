package matrix;

public class NumberOfIslands {

    //Validate the input for null and m by x
    //loop through row and columns
    //if found island and then call dfs to reach it's all connected points and marke them as 0
    //return to main
    public static int countIslands(int[][] matrix) {
        int totalIslands = 0;

        int right = matrix[0].length;
        int bottom = matrix.length;

        for(int i=0;i<bottom;i++) {
            for(int j=0;j<right;j++) {

                if(matrix[i][j] == 1) {
                    totalIslands++;
                    isLandArea(matrix,i,j);
                }
            }
        }

        return totalIslands;
    }

    private static void isLandArea(int[][] matrix, int top, int left) {


        if(top > matrix.length-1 || left > matrix[0].length-1 || top < 0 || left < 0)
            return;

        if(matrix[top][left] == 0)
            return;

            matrix[top][left] = 0;
            isLandArea(matrix,top+1,left);
            isLandArea(matrix,top,left+1);
            isLandArea(matrix,top-1,left);
            isLandArea(matrix,top,left-1);
    }
    public static void main(String[] args) {
        System.out.println(NumberOfIslands.countIslands(
                new int[][] {
                        { 0, 1, 1, 1, 0 },
                        { 0, 0, 0, 1, 1 },
                        { 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));

        System.out.println(NumberOfIslands.countIslands(
                new int[][] {
                        { 1, 1, 1, 0, 0 },
                        { 0, 1, 0, 0, 1 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }));
    }
}
