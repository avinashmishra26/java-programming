package elementsofProgramming.recursion;

/**
 * Created by avinashkumarmishra on 13/10/21.
 * Here all queens are same for 4X4 board (Q, Q, Q, Q)
 * 2022
 */
public class Problem2_NQueenSafe {
    public static void main(String[] args) {
        attackingQueenCombination(0, 4, new boolean[4][4], -1);
    }

    // queen so far, total queen, chess will contain the combination, last queen index
    private static void attackingQueenCombination(int qsfr, int tq, boolean[][] chess, int lcno) {

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

            if (isQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                attackingQueenCombination(qsfr + 1, tq, chess, (row+1)*chess.length-1);  //Next Row so no need to check row thing
                chess[row][col] = false;
            }
        }
    }

    private static boolean isQueenSafe(boolean[][] chess, int row, int col) {

        //column upwards {-1, 0}
        for(int i= row-1, j = col; i>=0; i--){
            if(chess[i][j]){
                return false;
            }
        }

        //diagonal left upwards {-1, -1}
        for(int i= row-1, j = col-1; i>=0 && j >=0; i--, j--){
            if(chess[i][j]){
                return false;
            }
        }

        //diagonal right upwards {-1, +1}
        for(int i= row-1, j = col+1; i>=0 && j < chess.length; i--, j++){
            if(chess[i][j]){
                return false;
            }
        }

        return true;
    }
}
