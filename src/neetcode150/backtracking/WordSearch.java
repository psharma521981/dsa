package src.neetcode150.backtracking;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {

        int row  = board.length;
        int cols = board[0].length;

        boolean foundString = false;
        for(int i=0;i<row;i++) {
            for(int j=0;j<cols;j++) {
                if(checkWord(board,word,i,j,0))
                    return true;
            }
        }

        return foundString;
    }

    private static boolean checkWord(char[][] board, String word, int i, int j,int k) {

        int row  = board.length;
        int cols = board[0].length;

        if(i < 0 || i >= row || j < 0 || j >= cols || board[i][j] != word.charAt(k))
            return false;

        if (k == word.length() - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '#';

        boolean response = checkWord(board,word,i+1,j,k+1)
                || checkWord(board,word,i,j+1,k+1)
                || checkWord(board,word,i-1,j,k+1)
                || checkWord(board,word,i,j-1,k+1);

        board[i][j] = tmp;

        return response;


    }
    public static void main(String[] args) {
        WordSearch sol = new WordSearch();
        // Test Case 1
        char[][] board1 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word1 = "ABCCED";
        System.out.println(sol.exist(board1, word1)); // expected output: true

        // Test Case 2
        char[][] board2 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word2 = "SEE";
        System.out.println(sol.exist(board2, word2)); // expected output: true

        // Test Case 3
        char[][] board3 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word3 = "ABCB";
        System.out.println(sol.exist(board3, word3)); // expected output: false

        char[][] board4 = { { 'a', 'a' } };
        String word4 = "aaa";
        System.out.println(sol.exist(board4, word4)); // expected output: false

        char[][] board5 = { { 'a' } };
        String word5 = "a";
        System.out.println(sol.exist(board5, word5)); // expected output: true

        char[][] board6 = {
                { 'a', 'b', 'c', 'd', 'e' },
                { 'f', 'g', 'h', 'i', 'j' },
                { 'k', 'l', 'm', 'n', 'o' },
                { 'p', 'q', 'r', 's', 't' },
                { 'u', 'v', 'w', 'x', 'y' },
                { 'z', 'a', 'b', 'c', 'd' }
        };
        String word6 = "abcde";
        System.out.println(sol.exist(board6, word6)); // expected output: true

        char[][] board7 = {
                { 'a', 'b', 'c', 'd', 'e' },
                { 'f', 'g', 'h', 'i', 'j' },
                { 'k', 'l', 'm', 'n', 'o' },
                { 'p', 'q', 'r', 's', 't' },
                { 'u', 'v', 'w', 'x', 'y' },
                { 'z', 'a', 'b', 'c', 'd' }
        };
        String word7 = "zabcd";
        System.out.println(sol.exist(board7, word7)); // expected output: true
    }
}
