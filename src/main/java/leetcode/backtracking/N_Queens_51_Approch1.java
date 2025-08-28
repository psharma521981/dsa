package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class N_Queens_51_Approch1 {
    public static void main(String s[]) {
        List<int[][]> output = new N_Queens_51_Approch1().solveNQueens(4);
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
                fillQueen(board,i+1,n,output);
                board[i][col] = 0;
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

        //check for column

        for(int row=i;row>=0;row--) {
            if(board[row][col] == 1)
                return false;
        }
        //check left diagonal
        int cols =col;
        for(int row=i;row>=0 && cols >=0;row--,cols--) {
            if(board[row][cols] == 1)
                return false;
        }
        //check right diagonal
        cols =col;
        for(int row=i;row>=0 && cols < n;row--,cols++) {
            if(board[row][cols] == 1)
                return false;
        }
        return true;
    }

}
