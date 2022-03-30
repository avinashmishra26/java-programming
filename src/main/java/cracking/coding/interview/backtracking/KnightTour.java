package cracking.coding.interview.backtracking;


/**
 * Created by avinashkumarmishra on 29/03/22.
 *
 *   KnightTour
 */


public class KnightTour {

    public static void main(String[] args) {
        printKnightTour(new int[8][8], 0, 0, 1);
    }

    private static void printKnightTour(int[][] chess, int row, int col, int count) {


        if(row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] == 1)
            return;


        if(count == chess.length*chess.length) {

            chess[row][col] = 1; //last move

            for(int i = 0; i < chess.length; i++) {
                for(int j = 0; j < chess.length; j++) {
                    System.out.print(i+" "+j);
                }
                System.out.println();
            }

            chess[row][col] = 0; //undo last move

            System.out.println("New");
            return;
        }

        chess[row][col] = 1;

        printKnightTour(chess, row-2, col+1, count+1);

        printKnightTour(chess, row-1, col+2, count+1);

        printKnightTour(chess, row+1, col+2, count+1);

        printKnightTour(chess, row+2, col+1, count+1);

        printKnightTour(chess, row+2, col-1, count+1);

        printKnightTour(chess, row+1, col-2, count+1);

        printKnightTour(chess, row-1, col-2, count+1);

        printKnightTour(chess, row-2, col-1, count+1);

        chess[row][col] = 0;

    }
}