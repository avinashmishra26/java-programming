package cracking.coding.interview.backtracking;

/**
 * Created by avinashkumarmishra on 29/03/22.
 *
 *   NQueensSolution
*/


public class NQueensSolution {


    public static void main(String[] args) {
        printNQueen(new int[4][4], 0, " ");
    }

    private static void printNQueen(int[][] chess, int row, String psf) {
        if(row == chess.length) {
            System.out.println(psf);
            return;
        }


        for(int col = 0; col < chess[0].length; col++) {

            if(chess[row][col] == 0 && isFeasible(chess, row, col)) {
                chess[row][col] = 1;
                printNQueen(chess, row+1, psf + row +"-"+col+" --");
                chess[row][col] = 0;
            }
        }
    }

    private static boolean isFeasible(int[][] chess, int row, int col) {

        for(int r = 0; r < row; r++) {
            if(chess[r][col] == 1) {
                return false;
            }
        }

        for(int c = col-1, r = row-1; c >=0 && r>= 0 ; c--, r--) {
            if(chess[r][c] == 1) {
                return false;
            }
        }

        for(int c = col+1, r = row-1; c < chess.length && r>= 0 ; c++, r--) {
            if(chess[r][c] == 1) {
                return false;
            }
        }

        return true;
    }
}