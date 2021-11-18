package elementsofProgramming.recursion;

/**
 * Created by avinashkumarmishra on 18/10/21.
 * Here Queens are different for 4X4 board (Q1, Q2, Q3, Q4) but each can attack each other with the same rule
 */
public class Problem2_NQueenPermutation {

    static int cnt =  0;

    public static void main(String[] args) {
        attackingQueenPermute(0, 4, new int[4][4]);
        //System.out.println(cnt);
    }

    static void attackingQueenPermute(int queenSofar, int totalQueen, int[][] board) {

        if(queenSofar == totalQueen){
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j< board[0].length; j++) {
                    if(board[i][j] != 0)
                        System.out.print(board[i][j] +" ");
                    else
                        System.out.print("_ ");
                }
                System.out.println();
            }
            System.out.println();
            cnt++;
        }

        for(int i = 0; i< board.length*board.length; i++) {
            int row = i / (board.length);
            int col = i % (board.length);

            if(board[row][col] == 0 && isQueenSafe(board, row, col)) {
                board[row][col] = (queenSofar+1);
                attackingQueenPermute(queenSofar+1, totalQueen, board);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isQueenSafe(int[][] board, int row, int col) {
        //Row down
        for(int i=row-1, j = col; i>=0 && j>=0; i--){
            if(board[i][j] != 0){
                return false;
            }
        }
        //Row up
        for(int i=row+1, j = col; i<board.length && j < board.length; i++){
            if(board[i][j] != 0){
                return false;
            }
        }
        // column back
        for(int i=row, j = col-1; i>=0 && j>=0; j--){
            if(board[i][j] != 0){
                return false;
            }
        }
        // column front
        for(int i=row, j = col+1; i<board.length && j < board.length; j++){
            if(board[i][j] != 0){
                return false;
            }
        }

        // diagonal
        for(int i=row-1, j = col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] != 0){
                return false;
            }
        }
        // diagonal
        for(int i=row+1, j = col+1; i<board.length && j < board.length; i++, j++){
            if(board[i][j] != 0){
                return false;
            }
        }

        // diagonal
        for(int i=row-1, j = col+1; i >=0 && j < board.length; i--, j++){
            if(board[i][j] != 0){
                return false;
            }
        }
        // diagonal
        for(int i=row+1, j = col-1; i<board.length && j >= 0; i++, j--){
            if(board[i][j] != 0){
                return false;
            }
        }

        return true;
    }
}
