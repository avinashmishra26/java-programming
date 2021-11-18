package cracking.coding.interview.graph;

import java.io.IOException;
import java.util.*;

/**
 * Created by avinashkumarmishra on 03/11/21.
 *
 * The chess knight has a unique movement, it may move two squares vertically and one square horizontally,
 * or two squares horizontally and one square vertically (with both forming the shape of an L).
 * The possible movements of chess knight are shown in this diagaram:
 *
 * Given an integer n, return how many distinct phone numbers of length n we can dial.

 * You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial a number of length n.
 * All jumps should be valid knight jumps.

 * As the answer may be very large, return the answer modulo 109 + 7.


 * A chess knight can move as indicated in the chess diagram below:

 * https://leetcode.com/problems/knight-dialer/
 *
 * We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).
 *
 */
public class KnightDialer {


    static Map<Integer, List<Integer>>  mapping = new HashMap<>();


    public static void main(String[] args)throws IOException {

        mapping.put(0, Arrays.asList(4,6));
        mapping.put(1, Arrays.asList(6,8));
        mapping.put(2, Arrays.asList(7,9));
        mapping.put(3, Arrays.asList(4,8));

        mapping.put(4, Arrays.asList(0,3,9));
        mapping.put(5, Arrays.asList());
        mapping.put(6, Arrays.asList(0, 1, 7));
        mapping.put(7, Arrays.asList(2,6));

        mapping.put(8, Arrays.asList(1, 3));
        mapping.put(9, Arrays.asList(2,4));


        System.out.print(knightDialer(313));
    }

    public static int knightDialer(int n) {

        if ( n == 0) return 0;

        long[] totalMoves = new long[1];

        for(int i = 0; i <= 9; i++) {
                knightMoves(i, n-1, totalMoves);
            }

        return (int)(totalMoves[0] % ((int)(Math.pow(10,9) + 7)));
    }

    private static void knightMoves(int ele, int n, long[] totalMoves) {

        if ( n == 0) {
            totalMoves[0] += 1;
            return;
        }

        for(int e : mapping.get(ele)) {
            knightMoves(e, n-1, totalMoves);
        }

    }

    static int mod=1000000007;
    static Map<Integer,Set<Integer>> prevMove;
    static Map<String, Integer> mem;
    public static int knightDialer1(int n) {
        int ans=0;
        mem = new HashMap<>();
        prevMove = new HashMap<>();
        prevMove.put(0, new HashSet<>(Arrays.asList(4,6)));
        prevMove.put(1, new HashSet<>(Arrays.asList(8,6)));
        prevMove.put(2, new HashSet<>(Arrays.asList(7,9)));
        prevMove.put(3, new HashSet<>(Arrays.asList(4,8)));
        prevMove.put(4, new HashSet<>(Arrays.asList(0,9,3)));
        prevMove.put(5, new HashSet<>());
        prevMove.put(6, new HashSet<>(Arrays.asList(1,7,0)));
        prevMove.put(7, new HashSet<>(Arrays.asList(2,6)));
        prevMove.put(8, new HashSet<>(Arrays.asList(1,3)));
        prevMove.put(9, new HashSet<>(Arrays.asList(2,4)));

        for(int i=0; i<=9; i++) {
            ans =(ans+subCount(i, n))%mod;
        }
        return ans;
    }

    private static int subCount(int num, int rem) {
        if(rem==1) return 1; // Base case when n=1.
        int innCnt=0;
        for(Integer prevNum: prevMove.get(num)) {
            String key = String.valueOf(prevNum +"#"+(rem-1)); //creating a key with input of this method
            Integer cnt = mem.get(key);
            if(cnt==null) {
                cnt=subCount(prevNum, rem-1);
                mem.put(key, cnt);
            }
            innCnt = (innCnt + cnt)%mod;
        }
        return innCnt;
    }
}
