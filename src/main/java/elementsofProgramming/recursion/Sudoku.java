package elementsofProgramming.recursion;

/**
 * Created by avinashkumarmishra on 18/10/21.
 */
public class Sudoku {

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};



        //char[][] board = {{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};

        solveSudokuProblem(board, -1);


    }

    private static void solveSudokuProblem(char[][] board, int lPos) {

        if(lPos == (board.length*board.length-1) ) {
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board.length; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }

        int cell = lPos + 1;
        int row = cell / board.length;
        int col = cell % board.length;

        if (board[row][col] == '.') {
            for (int val = 1; val <= 9 ; val++) {
                char c = (char)('0'+val);
                if(isValuePossible(board, row, col, c)) {
                    board[row][col] = c;
                    solveSudokuProblem(board, cell);
                    board[row][col] = '.';
                }
            }
        } else {
           solveSudokuProblem(board, cell);
        }

    }

    private static boolean isValuePossible(char[][] board, int row, int col, char value) {

        for(int i= row, j=0; j< board.length; j++){
            if(col != j && board[i][j] == value) {
                return false;
            }
        }

        for(int i= 0, j = col; i< board.length; i++){
            if(row != i && board[i][j] == value) {
                return false;
            }
        }

        int startRow = row - (row % 3);
        int endRow =  startRow + 2;

        int startCol = col - (col % 3);
        int endCol =  startCol + 2;

        for(int i= startRow; i <= endRow; i++){
            for(int j = startCol;  j <= endCol; j++) {
                if(board[i][j] == value)
                    return false;
            }
        }
        return true;
    }
}
