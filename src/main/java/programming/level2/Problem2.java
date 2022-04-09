package programming.level2;


/**
 *  Created by avinashkumarmishra on 05/04/22.
 *
 *  N Queens Problem using Backtracking using Branch and Bound Algorithm
 *  Best Time Complexity using Backtracking
 *
 **/

public class Problem2 {


    public static void main(String[] args) {

        boolean[][] board = new boolean[4][4];

        boolean[] cols = new boolean[board.length];

        boolean[] ndiag = new boolean[2*board.length-1];

        boolean[] rdiag = new boolean[2*board.length-1];

        solve(board, 0,cols,  ndiag, rdiag, "");

    }

    private static void solve(boolean[][] board, int row, boolean[] cols,
                              boolean[] ndiag, boolean[] rdiag, String asf) {

        if(row == board.length) {
            System.out.println(asf);
            return;
        }

        for(int i = 0; i < cols.length; i++) {
            if(cols[i] == false && ndiag[row+i] == false &&
                    rdiag[row-i + board.length-1] == false) {
                cols[i] = true;
                int diad = row+i;

                ndiag[row+i] = true;
                rdiag[row-i + board.length-1] = true;

                solve(board, row+1, cols, ndiag, rdiag, asf+"("+row+" "+i+")");
                cols[i] = false;
                ndiag[row+i] = false;
                rdiag[row-i + board.length-1] = false;
            }
        }

    }
}