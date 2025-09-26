package neetcode150.binary_search;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null)
            return false;
        int rowIndex = -1;

        for(int i=0;i<matrix.length;i++) {
            if(target < matrix[i][0]) {
                rowIndex = i - 1;
                break;
            }
        }
        if(rowIndex == -1) {
            rowIndex = matrix.length - 1;
        }
        int l = 0;
        int r = matrix[rowIndex].length -1;

        while(l <= r) {
            int mid = l + ((r -l) / 2);

            if(target > matrix[rowIndex][mid]) {
                l = mid + 1;
            } else if(target < matrix[rowIndex][mid]) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
