package elementsofProgramming.graph;

import sun.plugin.dom.core.CoreConstants;

import java.util.Arrays;
import java.util.List;

/**
 * Created by avinashkumarmishra on 19/09/21.
 */
public class Problem2 {

    public static void main(String[] args) {
        List<List<Color>> maze = Arrays.asList(Arrays.asList(Color.WHITE,Color.BLACk, Color.WHITE),
                                               Arrays.asList(Color.WHITE,Color.BLACk, Color.WHITE),
                                               Arrays.asList(Color.WHITE,Color.BLACk, Color.WHITE));

        flipColor(maze, new Coordinate(2,0));
        maze.forEach(e -> System.out.println(e));
    }

    private enum Color { WHITE, BLACk};

    private static class Coordinate {

        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void flipColor(List<List<Color>> maze, Coordinate curr) {
        if (isColorable(maze, curr)) {
            Color currColor = getColor(maze, curr);
            int[][] shift = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
            Color oppositeColor = getOppositeColor(currColor);

            maze.get(curr.x).set(curr.y, oppositeColor);

            for (int[] s : shift) {
                Coordinate next = new Coordinate(curr.x + s[0], curr.y + s[1]);

                if ( isColorable(maze, next) && getColor(maze, next) == currColor ) {
                    flipColor(maze, next);
                }
            }


        }
    }

    private static boolean isColorable(List<List<Color>> maze, Coordinate curr) {
        return curr.x >= 0 && curr.x < maze.size() && curr.y >= 0 && curr.y < maze.get(curr.x).size();
    }

    private static Color getColor(List<List<Color>> maze, Coordinate curr) {
        return maze.get(curr.x).get(curr.y);
    }

    private static Color getOppositeColor(Color curColor) {
        return curColor == Color.WHITE ? Color.BLACk : Color.WHITE;
    }
}
