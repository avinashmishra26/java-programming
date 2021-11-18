package cracking.coding.interview.dynamicProgram;

/**
 * Created by avinashkumarmishra on 04/11/21.
 *
 * Two approach a) LIS
 *              b) Similar to LIS ( Did not solving this here)
 */
public class HighWayBillboard {

    public static void main(String[] args) {

        Board[] boards = new Board[5];
        boards[0] = new Board(6,5);
        boards[1] = new Board(8,8);
        boards[2] = new Board(12,5);
        boards[3] = new Board(14,3);
        boards[4] = new Board(16,1);

        System.out.print(getMaxValue(new int[]{}, boards));

    }

    private static class Board implements Comparable<Board> {
        int atMiles;
        int value;

        Board(int atMiles, int value) {
            this.atMiles = atMiles;
            this.value = value;
        }

        @Override
        public int compareTo(Board o) {
            return this.atMiles - o.atMiles;
        }
    }

    //Using LIS approach t(n) = baords^2
    private static int getMaxValue(int[] miles, Board[] boards ) {
        int[] dp = new int[boards.length];

        int oMax = 0;

        for(int i = 0; i < boards.length; i++) {

            int max = 0;

            for(int j = 0; j < i; j++) {
                if ( (boards[i].atMiles - boards[j].atMiles ) >= 3){
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max + boards[i].value;

            if(oMax < dp[i])  oMax = dp[i];
        }

        return oMax;
    }
}
