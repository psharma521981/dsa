package src.miscellaneously.old.others;

import java.util.ArrayList;
import java.util.List;

/*

After catching your classroom students cheating before, you realize your students are getting craftier and hiding words in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.

Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.

grid1 = [
    ['c', 'c', 't', 'n', 'a', 'x'],  
    ['c', 'c', 'a', 't', 'n', 't'],  
    ['a', 'c', 'n', 'n', 't', 't'],  
    ['t', 'n', 'i', 'i', 'p', 'p'],  
    ['a', 'o', 'o', 'o', 'a', 'a'],
    ['s', 'a', 'a', 'a', 'o', 'o'],
    ['k', 'a', 'i', 'o', 'k', 'i'],
]
word1 = "catnip"
word2 = "cccc"
word3 = "s"
word4 = "ant"
word5 = "aoi"
word6 = "ki"
word7 = "aaoo"
word8 = "ooo"

grid2 = [['a']]
word9 = "a"

find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
find_word_location(grid1, word2) =>
       [(0, 0), (1, 0), (1, 1), (2, 1)]
    OR [(0, 0), (0, 1), (1, 1), (2, 1)]
find_word_location(grid1, word3) => [(5, 0)]
find_word_location(grid1, word4) => [(0, 4), (1, 4), (2, 4)] OR [(0, 4), (1, 4), (1, 5)]
find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
find_word_location(grid1, word6) => [(6, 4), (6, 5)]
find_word_location(grid1, word7) => [(5, 2), (5, 3), (5, 4), (5, 5)]
find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
find_word_location(grid2, word9) => [(0, 0)]

Complexity analysis variables:

r = number of rows
c = number of columns
w = length of the word
*/

public class FindEmbeddedWordMatrix {

    public static void main(String[] args) {
        char[][] grid1 = { 
                { 'c', 'c', 't', 'n', 'a', 'x' },
                { 'c', 'c', 'a', 't', 'n', 't' },
                { 'a', 'c', 'n', 'n', 't', 't' }, 
                { 't', 'n', 'i', 'i', 'p', 'p' }, 
                { 'a', 'o', 'o', 'o', 'a', 'a' },
                { 's', 'a', 'a', 'a', 'o', 'o' }, 
                { 'k', 'a', 'i', 'o', 'k', 'i' } };
        String word1 = "catnip";
        String word2 = "zzzz";
        String word3 = "s";
        String word4 = "ant";
        String word5 = "aoi";
        String word6 = "ki";
        String word7 = "aaoo";
        String word8 = "ooo";

        List<int[]> output = find_embedded_word(grid1, word1);
        for (int i = 0; i < output.size(); i++) {

            System.out.println(output.get(i)[0] + "," + output.get(i)[1]);
        }

    }

    public static List<int[]> find_embedded_word(char[][] board, String word) {
        List<int[]> output;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    output = new ArrayList<int[]>();
                    if (compare(board, word, 0, i, j, output))
                        return output;
                }
            }
        }
        return null;
    }

    private static boolean compare(char[][] board, String word, int index, int row, int col, List<int[]> output) {
        if (index >= word.length())
            return true;

        int maxRow = board.length - 1;
        int maxCol = board[0].length - 1;

        if (row < 0 || col < 0 || row > maxRow || col > maxCol || board[row][col] != word.charAt(index))
            return false;

        int[] rowDirection = new int[] { 0, 1, 0, -1 };
        int[] colDirection = new int[] { 1, 0, -1, 0 };

        board[row][col] = '#';
        output.add(new int[] { row, col });
        for (int d = 0; d < 4; d++) {
            if (compare(board, word, index + 1, row + rowDirection[d], col + colDirection[d], output)) {

                return true;
            }
        }

        board[row][col] = word.charAt(index);

        return false;
    }

}
