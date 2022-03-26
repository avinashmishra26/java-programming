package cracking.coding.interview.backtracking;

import java.util.ArrayList;

/**
 * Created by avinashkumarmishra on 24/03/22.
 *
 * Print all paths from a co-ordinate to another co-ordinate
 *
 * Constraint : Either right or down is allowed.
 *
 * Variant : Maze Path with variable Jumps.
 * either 1 jump, 2 jump or 3 jump
 * on horizantally right, vertically down and diagonally down
 * */

public class MazePath {


    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();

        getMazePaths("", new Coordinate(0,0), new Coordinate(2,2), result);

        result.forEach(System.out :: println);

        System.out.println("\ngetMazePathsVariableJump");
        result = new ArrayList<>();
        getMazePathsVariableJump("", new Coordinate(0,0), new Coordinate(2,2), result);

        result.forEach(System.out :: println);
    }

    private static void getMazePaths(String ssf, Coordinate start, Coordinate end, ArrayList<String> result ) {

        if(start.equals(end)) {
            result.add(ssf);
            return;
        } else if(start.x > end.x || start.y > end.y) {
            return;
        }

        getMazePaths(ssf+"h", new Coordinate(start.x, start.y+1), end, result);
        getMazePaths(ssf+"d", new Coordinate(start.x+1, start.y), end, result);
    }

    private static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object other) {
            Coordinate o = (Coordinate)other;
            if(this.x == o.x && this.y == o.y) {
                return true;
            }
            return false;
        }
    }

    private static void getMazePathsVariableJump(String ssf, Coordinate start, Coordinate end, ArrayList<String> result ) {

        if(end.equals(start)) {
            result.add(ssf);
            return;
        } else if( start.y > end.y || start.x > end.x) {
            return;
        }

        getMazePathsVariableJump(ssf+"h ", new Coordinate(start.x, start.y+1), end, result);
        getMazePathsVariableJump(ssf+"v ", new Coordinate(start.x+1, start.y), end, result);
        getMazePathsVariableJump(ssf+"d ", new Coordinate(start.x+1, start.y+1), end, result);

        getMazePathsVariableJump(ssf+"hh ", new Coordinate(start.x, start.y+2), end, result);
        getMazePathsVariableJump(ssf+"vv ", new Coordinate(start.x+2, start.y), end, result);
        getMazePathsVariableJump(ssf+"dd ", new Coordinate(start.x+2, start.y+2), end, result);

        getMazePathsVariableJump(ssf+"hhh ", new Coordinate(start.x, start.y+3), end, result);
        getMazePathsVariableJump(ssf+"vvv ", new Coordinate(start.x+3, start.y), end, result);
        getMazePathsVariableJump(ssf+"ddd ", new Coordinate(start.x+3, start.y+3), end, result);
    }

}