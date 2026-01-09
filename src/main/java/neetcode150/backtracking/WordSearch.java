package neetcode150.backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {

        if(board == null || word == null) {
            return false;
        }
        boolean found =false;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(checkWordExist(board,i,j,word,0))
                    return true;
            }
        }

        return found;
    }

    public boolean checkWordExist(char[][] board,int i,int j,String word,int index) {

        if (index == word.length()) {
            return true;
        }

        int r = board.length;
        int c = board[0].length;

        if(i >= r || i < 0 || j >= c || j < 0 || index >= word.length() || board[i][j] != word.charAt(index)
                || board[i][j] == '#') {
            return false;
        }

        board[i][j] = '#';
        boolean found = checkWordExist(board,i+1,j,word,index+1) ||
                checkWordExist(board,i,j+1,word,index+1) ||
                checkWordExist(board,i-1,j,word,index+1) ||
                checkWordExist(board,i,j-1,word,index+1);

        board[i][j] = word.charAt(index);

        return found;
    }
}
