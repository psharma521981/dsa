package neetcode150.array_and_hashing.prectice;

import java.util.HashSet;
import java.util.Set;

//TODO Optimize it in one pass
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //Check rows
        //Check colomns
        //Check 3 x 3


        Set<Character> uniqueValue;

        int rows = board.length;
        int cols = board[0].length;

        boolean isSudokuValid = true;
        for(int i=0;i<rows;i++) {
            uniqueValue = new HashSet<>();
            for(int j=0;j<cols;j++) {
                if(board[i][j] == '.')
                    continue;
                if(uniqueValue.contains(board[i][j]))
                    return false;
                else
                    uniqueValue.add(board[i][j]);
            }
        }
        for(int i=0;i<rows;i++) {
            uniqueValue = new HashSet<>();
            for(int j=0;j<cols;j++) {
                if(board[j][i] == '.')
                    continue;
                if(uniqueValue.contains(board[j][i]))
                    return false;
                else
                    uniqueValue.add(board[j][i]);
            }
        }
        for(int k =0; k< 9; k++) {
            for (int i = 0; i < rows; i++) {
                uniqueValue = new HashSet<>();
                for (int j = 0; j < cols; j++) {
                    int row = (k / 3 ) * 3 + i;
                    int col = (k % 3 ) * 3 + j;

                    if(board[row][col] == '.')
                        continue;

                    if (uniqueValue.contains(board[row][col]))
                        return false;
                    else
                        uniqueValue.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
