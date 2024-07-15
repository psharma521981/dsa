package matrix;

import java.util.Arrays;
//Validate the input
//serach for the cell and call dfs function to fill the color and cell no.
//search all the connected cell and change the color of those cells and return
//make sure to check old color and replace with new color
public class FloodFill {
    public static int[][] floodFill(int[][] matrix, int x, int y, int newColor) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int oldColor = 0;

        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {

                if (i == x && j == y) {
                    oldColor = matrix[i][j];
                    floodFillHelper(matrix, i, j, oldColor,newColor);
                }
            }
        }
        return matrix;
}

    private static void floodFillHelper(int[][] matrix, int i, int j, int oldColor,int newColor) {

        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return;

        if(matrix[i][j] != oldColor || matrix[i][j] == newColor)
            return;

         matrix[i][j] = newColor;
        floodFillHelper(matrix,i+1,j,oldColor,newColor);
        floodFillHelper(matrix,i,j+1,oldColor,newColor);
        floodFillHelper(matrix,i-1,j,oldColor,newColor);
        floodFillHelper(matrix,i,j-1,oldColor,newColor);

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(FloodFill.floodFill(
                new int[][] {
                        { 0, 1, 1, 1, 0 },
                        { 0, 0, 0, 1, 1 },
                        { 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }, 1, 3, 2)));

        System.out.println(Arrays.deepToString(FloodFill.floodFill(
                new int[][] {
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }, 3, 2, 5)));
    }
}
