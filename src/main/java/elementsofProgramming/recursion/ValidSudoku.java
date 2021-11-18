package elementsofProgramming.recursion;

/**
 * Created by avinashkumarmishra on 29/10/21.
 */
public class ValidSudoku {


    public boolean isValidSudoku(char[][] board) {

        return true;
    }

    public static boolean checkSudoku(char[][] board) {

        for(int i = 0; i < board.length ; i++) {
            for(int j = 0; j < board.length ; j++) {

                if(board[i][j] != '.' && (!isHorizontallyValid(board, i ,j ) || !isVerticallyValid(board, i ,j ) || !isBoxValid(board, i ,j )) ) {
                    return false;
                }

            }
        }
        return true;
    }

    static boolean isHorizontallyValid(char[][] board, int i, int j) {

        for ( int col = 0; col < board[0].length ; col++) {
            if( j == col)
                continue;
            if(board[i][j] == board[i][col]) {
                return false;
            }
        }
        return true;
    }

    static boolean isVerticallyValid(char[][] board, int i, int j) {
        for ( int row = 0; row < board.length ; row++) {
            if( i == row)
                continue;
            if(board[i][j] == board[row][j]) {
                return false;
            }
        }
        return true;
    }

    static boolean isBoxValid(char[][] board, int i, int j) {

        int rowStart = i - (i % 3) ;

        int colStart = j - (j % 3) ;

        for ( int s = rowStart; s <  rowStart+3; s++) {
            for ( int c = colStart; c <  colStart+3; c++) {
                if( i == s && c == j)
                    continue;
                if(board[s][c] == board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
