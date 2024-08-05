package src.miscellaneously.interview;

public class CalculateArea {

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0 }, { 1, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 } };
        System.out.println("result is: ");
        System.out.println(getBiggestRegion(matrix));

    }

    public static int getBiggestRegion(int[][] matrix) {
        if (matrix == null)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;
        int currentArea = 0;
        // Iterating over the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == 1) {
                    currentArea = calculateArea(matrix, i, j);
                    maxArea = Math.max(maxArea, currentArea);

                }

            }
        }
        return maxArea;
    }

    // Calculate the area for every cell in the matrix
    public static int calculateArea(int[][] matrix, int row, int col) {
        int maxRows = matrix.length;
        int maxCols = matrix[0].length;

        // Check the boundary conditions for cell
        if (row < 0 || row >= maxRows || col < 0 || col >= maxCols || matrix[row][col] == 0)
            return 0;

        matrix[row][col] = 0;
        // Calculate the area by calling the cell’s neighbor

        int area = 1 + calculateArea(matrix, row, col - 1) + calculateArea(matrix, row, col + 1)
                + calculateArea(matrix, row + 1, col) + calculateArea(matrix, row - 1, col)
                + calculateArea(matrix, row - 1, col - 1) + calculateArea(matrix, row + 1, col - 1)
                + calculateArea(matrix, row - 1, col + 1) + calculateArea(matrix, row + 1, col + 1);

        return area;
    }

}

