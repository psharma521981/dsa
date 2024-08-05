package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Input: n = 4

 */
public class N_Queens_51 {
    public List<List<String>> solveNQueens(int n) {
        List<String> input = new ArrayList<>();
        List<List<String>> output = new ArrayList<>();
        checkQueuePlacement(input,output,n,0);
        return output;
    }

    private void checkQueuePlacement(List<String> input, List<List<String>> output, int n, int row) {

        if(row >= n) {
            output.add(new ArrayList<>(input));
            return;
        }

        for(int i=0;i<n;i++) {
            if(isValidPlace(input,i,n,n)) {

            }
            char[] eachRow= new char[n];
            Arrays.fill(eachRow,'.');
            eachRow[i] = 'Q';

        }
    }

    private boolean isValidPlace(List<String> board,int row,int col,int n) {

        //Check diaogonally row >= 0 and cols >=0 (left side) and row>=0 and cols <= n
        //Check if no queens in same column
        for(int i=row-1; i>=0;i--) {
           if(board.get(i).charAt(col)=='Q')
               return false;
        }

        //check left diagonal
        for(int i=row; i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if (board.get(i).charAt(j) == 'Q')
                    return false;
            }
        }
        //check right diagonal
        for(int i=row; i>=0;i--) {
            for(int j=n-1;j<n;j++) {
                if (board.get(i).charAt(j) == 'Q')
                    return false;
            }
        }
        return true;
    }
    public static void main(String s[]) {
        new N_Queens_51().solveNQueens(4);
    }

}
