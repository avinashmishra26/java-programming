package cracking.coding.interview.backtracking;

import java.util.List;

/**
 * Created by avinashkumarmishra on 13/10/21.
 * Queens Combination treating 2D board as 1D and queens are not attacking ( simple use all possible combination nCr)
 *  1. You are given a number n, representing the size of a n * n chess board.
 *  2. You are required to calculate and print the combinations in which n queens can be placed on the n * n chess-board.
 *
 */
public class CombinationQueen {

    public static void main(String[] args) {
        queenCombination(0, 2, new boolean[2][2], -1);
    }

    // queen so far, total queen, chess will contain the combination, last queen index
    public static void queenCombination(int qsfr, int tq, boolean[][] chess, int lcno) {

        if(qsfr == tq) {
            for(int i =0; i< chess.length; i++) {
                for (int j = 0; j<chess[i].length ; j++){
                    if(chess[i][j]){
                        System.out.print("Q");
                    } else {
                        System.out.print("_");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int cell = lcno+1; cell < chess.length*chess.length ; cell++) {
            int row = cell / chess.length;
            int col = cell % chess.length;

            chess[row][col] = true;

            queenCombination(qsfr+1, tq, chess, cell);
            chess[row][col] = false;
        }
    }
}
