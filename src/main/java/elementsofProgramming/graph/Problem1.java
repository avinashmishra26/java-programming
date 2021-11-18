package elementsofProgramming.graph;

/**
 * Created by avinashkumarmishra on 15/09/21.
 */
import java.util.*;

public class Problem1 {

    public static void main(String[] args) {
        List<List<Color>>  maze = Arrays.asList(Arrays.asList(Color.WHITE, Color.BLACK, Color.WHITE),
                                                Arrays.asList(Color.WHITE, Color.BLACK, Color.WHITE),
                                                Arrays.asList(Color.WHITE, Color.WHITE, Color.WHITE));


        maze.forEach(e -> System.out.println(e));
        searchMaze(maze, new Coordinate(2,0), new Coordinate(0,2)).forEach(e -> System.out.println(e));

    }

    private static class Coordinate {
        int x,y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Coordinate c = obj instanceof Coordinate ? ((Coordinate) obj) : null;
            if (c.x != this.x || c.y != this.y ) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "( "+this.x +" , "+this.y+" )";
        }
    }

    private static enum Color { WHITE, BLACK};

    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate s, Coordinate e) {

        List<Coordinate>  path = new ArrayList<>();
        maze.get(s.x).set(s.y, Color.BLACK);
        path.add(s);

        if (!searchMazeHelper(maze, s, e, path))
            path.remove(path.size() - 1);

        return path;
    }


    private static boolean searchMazeHelper(List<List<Color>> maze, Coordinate curr, Coordinate e, List<Coordinate> path) {

        if (curr.equals(e))
            return true;

        final int[][] SHIFT = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int[] s: SHIFT) {

            Coordinate next = new Coordinate(curr.x + s[0], curr.y + s[1]);
            if (isFeasible(next, maze) ) {
                maze.get(next.x).set(next.y, Color.BLACK);
                path.add(next);

                if (searchMazeHelper(maze, next, e, path))
                    return true;

                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    private static boolean isFeasible(Coordinate curr , List<List<Color>> maze) {
        return curr.x >= 0 && curr.x < maze.size() && curr.y >= 0
                && curr.y < maze.get(curr.x).size()
                && maze.get(curr.x).get(curr.y) == Color.WHITE;
    }
}
