package elementsofProgramming.graph;

import cracking.coding.interview.graph.Edge;
import util.GraphVertex;

import java.util.*;

/**
 * Created by avinashkumarmishra on 16/11/21.
 *
 * MAKING WIRED CONNECTIONS : Bipartite Graph
 */
public class Problem6 {

    public static void main(String[] args) {

    }

    public static class GraphVertex {
        public int label = -1;
        public List<GraphVertex> edges = new ArrayList<>();
    }

    //Bipartite Graph
    public static boolean isAnyPlacementFeasible(List<GraphVertex> graph) {

        Map<Integer, Integer> visited = new HashMap<>();

        for(GraphVertex g : graph) {
            if(!visited.containsKey(g.label)) {
                boolean check = isBipartite(g, visited);
                if(check == false) return false;
            }
        }
        return true;
    }

    private static boolean isBipartite(GraphVertex graph , Map<Integer, Integer> visited) {
        Queue<GraphVertex> q = new LinkedList<>();
        q.add(graph);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for( int i = 1; i <= size; i++) {

                GraphVertex r = q.remove();

                if (visited.containsKey(r.label) && visited.get(r.label) != level) {
                    return false;
                }
                visited.put(r.label, level);

                for (GraphVertex e : r.edges) {
                    if (!visited.containsKey(e.label)) {
                        q.add(e);
                    }
                }
            }
            level++;
        }
        return true;
    }
}
