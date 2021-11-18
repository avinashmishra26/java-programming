package elementsofProgramming.dynamicProgramming;

import java.util.Arrays;

/**
 * Created by avinashkumarmishra on 07/11/21.
 * Compute the Levenshtein distance
 */
public class problem2 {


    public static void main(String[] args) {

        System.out.println(getLevenshteinDistanceDP("carthorse", 0, "orchestra", 0));

        System.out.println(getLevenshteinDistance("carthorse", 0, "orchestra", 0));
    }

    //DP
    private static int getLevenshteinDistanceDP(String source, int oIdx, String destination, int tIdx ) {

        int[][] dp = new int[source.length()+1][destination.length()+1];

        for(int i = 0; i <= source.length(); i++) {
            for(int j = 0; j <= destination.length(); j++) {
                    if ( i == 0 ){
                        dp[i][j] = j;
                    } else if (j == 0){
                        dp[i][j] = i;
                    } else {
                        if( source.charAt(i-1) == destination.charAt(j-1) ) {
                            dp[i][j]=  Math.min(dp[i-1][j-1], Math.min(dp[i-1][j]+1, dp[i][j-1]+1 ));
                        } else {
                            dp[i][j]=  Math.min(dp[i-1][j-1]+1, Math.min(dp[i-1][j]+1, dp[i][j-1]+1 ));
                        }

                    }
            }
        }
        return dp[source.length()][destination.length()];

    }
    //Recurrsion
    private static int getLevenshteinDistance(String source, int oIdx, String destination, int tIdx ) {

        if(tIdx == destination.length() && oIdx == source.length()){
            return 0;
        } else if(tIdx == destination.length()){
            return source.length() - oIdx;
        } else if(oIdx == source.length()){
            return destination.length() - tIdx;
        }


        if(source.charAt(oIdx) == destination.charAt(tIdx)) {
            return getLevenshteinDistance(source, oIdx+1, destination, tIdx+1);
        } else {
            //Delete
            return (1 + Math.min(Math.min(getLevenshteinDistance(source, oIdx + 1, destination, tIdx),
            //insert
            getLevenshteinDistance(source, oIdx, destination, tIdx + 1)),
            //substitute
            getLevenshteinDistance(source, oIdx + 1, destination, tIdx + 1)));

        }

    }
}
