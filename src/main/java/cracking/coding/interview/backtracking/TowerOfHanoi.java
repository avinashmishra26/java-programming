package cracking.coding.interview.backtracking;

import java.util.Scanner;

/**
 * Created by avinashkumarmishra on 22/03/22.
 * 2022
 */

public class TowerOfHanoi {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int t1d = scn.nextInt();
        int t2d = scn.nextInt();
        int t3d = scn.nextInt();

        toh(n, t1d, t2d, t3d);
    }

    private static void toh(int n, int t1d, int t2d, int t3d) {
        if(n == 0) {
            return;
        }

        toh(n-1, t1d, t3d, t2d);
        System.out.println(n + " [ " +t1d+ " -> " +t2d +"]");
        toh(n-1, t3d, t2d, t1d);
    }

}

