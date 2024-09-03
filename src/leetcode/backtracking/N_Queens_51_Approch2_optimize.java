package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
Input: n = 4

 */
/*
Approach 1
Plot the board
Check for valid column for current row
Check valid function will check following:
    1) check same column in all previous rows
    2) check diagonally left-side in previous rows
    3) check diagonally right-side in previous rows
 If valid colum then place queen and check next subsequent rows until end of the board
 remove the queen and explore the option
 */

/*
Approach 2

To check the valid column need to be refactor and every column need to be recorded for placement
column check - column no. need to be recorded
for right side diagonal check, sum the row + col will be same for previous rows
for left side diagonal check, sum the row - col will be same for previous rows
 */
public class N_Queens_51_Approch2_optimize {
    Set<Integer> columnIndex = new HashSet<>();
    Set<Integer> leftDisgonalIndex = new HashSet<>();
    Set<Integer> rightDisgonalIndex = new HashSet<>();

    public static void main(String s[]) {
        List<int[][]> output = new N_Queens_51_Approch2_optimize().solveNQueens(4);
        System.out.println("done");
    }

    private List<int[][]> solveNQueens(int n) {
        List<int[][]> output = new ArrayList<>();
        int[][] board = new int[n][n];

        for(int i=0;i<n;i++) {
            Arrays.fill(board[i],0);
        }

        fillQueen(board,0,n,output);
        return output;
    }

    private void fillQueen(int[][] board, int i,int n,List<int[][]> output) {

        if(i == n) {
            output.add(copyArray(board));
            return;
        }
        for(int col=0;col<n;col++){
            if (validPlace(board, i, n,col)) {
                board[i][col] = 1;
                columnIndex.add(col);
                leftDisgonalIndex.add(i-col);
                rightDisgonalIndex.add(i+col);
                fillQueen(board,i+1,n,output);
                board[i][col] = 0;
                columnIndex.remove(col);
                leftDisgonalIndex.remove(i-col);
                rightDisgonalIndex.remove(i+col);
            }
        }
    }
    private int[][] copyArray(int[][] source) {

        int[][] target = new int[source.length][source[0].length];

        for(int i=0;i<source.length;i++) {
            for(int j=0;j<source[0].length;j++) {
                target[i][j] = source[i][j];
            }
        }
        return target;
    }

    private boolean validPlace(int[][] board, int i, int n,int col) {


       if(columnIndex.contains(col) || leftDisgonalIndex.contains(i-col)
       || rightDisgonalIndex.contains(i+col))
           return false;

        return true;
    }

}
