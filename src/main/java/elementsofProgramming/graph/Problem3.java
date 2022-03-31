package elementsofProgramming.graph;

import java.util.*;

/**
 * Created by avinashkumarmishra on 30/09/21.
 * COMPUTE ENCLOSED REGIONS in a graph(2D array)
 * Hint: It is easier to compute the complement of the desired result.
 * 2022
 */
public class Problem3 {

    public static void main(String[] args) {

    }

    public static List<Coordinate> fillSurroundingRegions(List<List<Character>> board) {

        List<Coordinate> result = new ArrayList<>();

        if (board.isEmpty())
            return result;

        List<List<Boolean>> visited = new ArrayList<>(board.size());
        for ( int i = 0; i < board.size(); i++) {
            visited.add(new ArrayList<>(Collections.nCopies(visited.get(i).size(), false)));
        }

        //identifying region that are reachable via white path starting from the first and last column.
        for ( int i=0 ; i< board.size(); i++) {
            if ( board.get(i).get(0) == 'W' && !visited.get(i).get(0)) {
                markBoundaryRegion(i, 0, board, visited);
            }

            int col = board.get(i).size() - 1;

            if ( board.get(i).get(col) == 'W' && !visited.get(i).get(col)) {
                markBoundaryRegion(i, col, board, visited);
            }
        }

        //identifying region that are reachable via white path starting from the first and last row.
        for ( int j=0 ; j < board.get(j).size(); j++) {
            if ( board.get(0).get(j) == 'W' && !visited.get(0).get(j)) {
                markBoundaryRegion(0, j, board, visited);
            }

            int row = board.size() - 1;

            if ( board.get(row).get(j) == 'W' && !visited.get(row).get(j)) {
                markBoundaryRegion(row, j, board, visited);
            }
        }

        //this is the required region
        for ( int i=1 ; i < board.size() - 1; i++) {
            for ( int j= 1 ; i < board.get(i).size() - 1; i++) {
                if (board.get(i).get(j) == 'W' && !visited.get(i).get(j)) {
                    result.add(new Coordinate(i, j));
                }
            }
        }

        return result;
    }

    private static class Coordinate {

        public Integer x;
        public Integer y;

        public Coordinate(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void markBoundaryRegion(int i, int j, List<List<Character>> board, List<List<Boolean>> visited) {

        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(i, j));
        visited.get(i).set(j, true);

        while(!q.isEmpty()) {
            Coordinate curr = q.poll();
            final int[][] shifts = {{0,1}, {0,-1}, {1,0}, {-1,0} };
            for(int[] s : shifts ) {
                Coordinate next = new Coordinate(curr.x + s[0], curr.y + s[1]);
                if ( next.x >= 0 && next.x < board.size() &&
                     next.y >= 0 && next.y < board.get(next.x).size() &&
                     board.get(next.x).get(next.y) == 'W' && !visited.get(next.x).get(next.y)) {
                    visited.get(next.x).set(next.y, true);
                    q.add(next);
                }
            }

        }

    }
}


