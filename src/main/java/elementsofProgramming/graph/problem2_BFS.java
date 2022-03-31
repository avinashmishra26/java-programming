package elementsofProgramming.graph;

import java.util.*;

/**
 * Created by avinashkumarmishra on 31/03/22.
 */
public class problem2_BFS {

    private enum Color { WHITE, BLACK };

    public static void main(String[] args) {
        List<List<Color>> maze = Arrays.asList(Arrays.asList(Color.WHITE,Color.BLACK, Color.WHITE),
                Arrays.asList(Color.WHITE,Color.BLACK, Color.WHITE),
                Arrays.asList(Color.WHITE,Color.BLACK, Color.WHITE));

        paintMaze(maze, new Coordinate(2,0));
        maze.forEach(e -> System.out.println(e));
    }


    private static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void paintMaze(List<List<Color>> maze, Coordinate start) {

        Color col = maze.get(start.x).get(start.y);
        Color oppositeColor = flipColor(col);



        ArrayDeque<Coordinate> q = new ArrayDeque<>();
        q.add(start);
        maze.get(start.x).set(start.y,oppositeColor);


        while(!q.isEmpty()) {
            Coordinate c = q.remove();

            int[][] shifts = { {0,1}, {0,-1}, {1,0}, {-1,0} };

            for(int[] s: shifts) {
                int x = s[0] + c.x;
                int y = s[1] + c.y;

                if( x >= 0 && y >= 0 && x < maze.size() && y < maze.get(x).size() &&
                        maze.get(x).get(y) == col) {
                    q.add(new Coordinate(x,y));
                    maze.get(x).set(y,oppositeColor);
                }
            }
        }

    }

    private static Color flipColor(Color curColor) {
        return curColor == Color.WHITE ? Color.BLACK : Color.WHITE;
    }
}
