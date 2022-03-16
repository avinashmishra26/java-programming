package elementsofProgramming.dynamicProgramming;

import java.util.*;

/**
 * Created by avinashkumarmishra on 27/09/21.
 * 2022
 * In an American football game, a play can lead to 2 points(safety), 3 points(field goal),
 * or 7 points (touchdown, assuming the extra point). Many different combinations of
 * 2, 3, and 7 point plays can make up a final score. For example, four combinations of
 * plays yield a score of
 *  12:
 *  • 6 safeties(2x6 = 12),
 *  • 3 safeties and 2 field goals(2x3 + 3x2 = 12),
 *  • 1 safety, 1 field goal and 1 touchdown (2xl + 3xl + 7xl = 12), and
 *  • 4 field goals(3x4 = 12).
 *
 * Write a program that takes a final score and scores for individual plays, and returns
 * the number of combinations of plays that result in the finalscore.
 *
 */
public class Problem1 {

    private static Map<Map<Integer, Integer>, String> paths = new HashMap<>();

    public static void main(String[] args) {

        scoreConsume(new int[]{2, 3, 7}, 12);
        //scoreConsume(new int[]{1,2}, 4);

        paths.entrySet().forEach(e -> System.out.println("key" + e.getValue()));

        System.out.println(paths.entrySet().stream().count());

        // more optimized and code efficient
        System.out.println("more optimized and code efficient :: "+getCount(new int[]{2, 3, 7}, 12));

        //optimized

        System.out.println(count(12));

        System.out.println("2022 goal GOOGLE "+getScoreCombinations(new int[]{7,3, 2}, 12));

    }

    static int getCount(int[] values, int total) {

        int[] dp = new int[total+1];
        dp[0] = 1;

        for(int v : values) {
            for ( int i = v; i <= total; i++) {
                dp[i] = dp[i] + dp[i-v];
            }
        }
        return dp[total];
    }

    static int getScoreCombinations(int[] n, int total) {

        int[][] dp = new int[n.length][total+1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                int cnt = 0;
                if( j == 0 ){
                    dp[i][j] = 1;
                } else if ( i == 0) {
                    if(j >= n[i]){
                        dp[i][j] += dp[i][j-n[i]];
                    }
                } else {
                    if(j >= n[i]){
                        cnt = dp[i][j-n[i]];
                    }
                    dp[i][j] = dp[i-1][j] + cnt;
                }
            }
        }
        return dp[n.length-1][total];
    }



    static int count(int n)
    {

        int table[] = new int[n + 1], i;


        Arrays.fill(table, 0);

        table[0] = 1;


        printTable(table);
        for (i = 2; i <= n; i++)
            table[i] += table[i - 2];
        printTable(table);
        for (i = 3; i <= n; i++)
            table[i] += table[i - 3];
        printTable(table);
        for (i = 7; i <= n; i++)
            table[i] += table[i - 7];
        printTable(table);

        return table[n];
    }

    static void printTable(int[] a) {
        for (int a1:a) {
            System.out.print(a1+" ");
        }
        System.out.println();
    }




    // Exponential time complexity
    public static void scoreConsume(int[] plays, int total) {

        if (total > 0)
            scoreConsumeHelper(plays, total, new String());
    }

    private static void scoreConsumeHelper(int[] plays, int total, String prev) {

        if (total == 0){
            dealPrev(prev);
            return;
        } else if (total < 0){
            return;
        }


        for ( int play : plays) {
            scoreConsumeHelper(plays, total-play, prev+"+"+play);
        }

    }

    static void dealPrev(String prev) {
        StringBuilder str = new StringBuilder(prev);
        int idx = str.indexOf("+");
        str.delete(idx, idx+1);


        Map<Integer,Integer> map = new HashMap<>();

        for (String s: str.toString().split("\\+")){
            int temp = Integer.parseInt(s);
            if(!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }

        paths.put(map, str.toString());
    }
}
