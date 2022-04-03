package cracking.coding.interview.stackQueue;

import java.util.Stack;

/**
 * Created by avinashkumarmishra on 02/04/22.
 *
 * Celebrity Problem
 *
 */

public class Celebrityproblem {

    public static void main(String[] args) {

        int[][] celebsMapping = {{0, 1,1,1,0},   // 0 celeb
                                 {1, 0,1,0,1},   // 1 celeb
                                 {0, 0,0,0,0},   // 2 celeb -> 2 does not know anyone but everyone knows him
                                 {0, 1,1,0,0},   // 3 celeb
                                 {1, 1,1,1,0}};  // 4 celeb

        System.out.print(getCelebrity(celebsMapping));

    }

    private static int getCelebrity(int[][] celebsMapping) {

        Stack<Integer> celeb = new Stack<>();

        for(int i = 0; i < celebsMapping.length; i++) {
            celeb.push(i);
        }

        while(celeb.size() > 1) {

            int f = celeb.pop();

            int s = celeb.pop();

            if(celebsMapping[f][s] == 0) {
                celeb.push(f);
            }

            if(celebsMapping[s][f] == 0) {
                celeb.push(s);
            }

        }

        // now check all the cells of the potential celeb
        if(celeb.size() == 0) return -1;

        int cidx = celeb.peek();

        for(int i = 0; i < celebsMapping.length; i++) {

            if(cidx == i)  continue;

            if(celebsMapping[cidx][i] != 0) return -1;

            if(celebsMapping[i][cidx] != 1) return -1;
        }

        return cidx;

    }
}