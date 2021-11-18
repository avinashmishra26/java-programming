package cracking.coding.interview.graph;

/**
 * Created by avinashkumarmishra on 03/11/21.
 */
public class KnightMoves {

    private void knightMoves(int[][] board, int r, int c, int moves){

        if( r < 0 || c < 0 || r >= board.length || c >= board.length || board[r][c] > 0) {
            return;
        } else if(moves == board.length*board.length) {
            System.out.print(board);
            return;
        }

        board[r][c] = moves;

        knightMoves(board, r-2, c+1, moves+1);
        knightMoves(board, r-2, c-1, moves+1);

        knightMoves(board, r+2, c+1, moves+1);
        knightMoves(board, r+2, c-1, moves+1);

        knightMoves(board, r-1, c+2, moves+1);
        knightMoves(board, r+1, c+2, moves+1);

        knightMoves(board, r-1, c-2, moves+1);
        knightMoves(board, r+1, c-2, moves+1);

    }

}
