package leetcode.array;

public class TransposeMatrix_867 {
    public int[][] transpose(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] output  = new int[col][row];

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                output[j][i] = matrix[i][j];
            }
        }
        return output;
    }
}
