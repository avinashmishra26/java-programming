package cracking.coding.interview.graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 01/11/21.
 *
 *      0 ---- 2 ----- 4 -- 6
 *      |      |       |   /
 *      |      |       |  /
 *      1----- 3 ----- 5
 *
 */
public class HamiltonianPath {

    public static void main(String[] args)throws IOException {

        ArrayList<Edge>[] graph = new ArrayList[7];

        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,0));
        graph[0].add(new Edge(0,2,0));

        graph[1].add(new Edge(1,0,0));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0,0));
        graph[2].add(new Edge(2,3,0));
        graph[2].add(new Edge(2,4,0));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,0));
        graph[3].add(new Edge(3,5,0));

        graph[4].add(new Edge(4,2,0));
        graph[4].add(new Edge(4,5,0));
        graph[4].add(new Edge(4,6,0));

        graph[5].add(new Edge(5,3,0));
        graph[5].add(new Edge(5,4,0));
        graph[5].add(new Edge(5,6,0));

        graph[6].add(new Edge(6,4,0));
        graph[6].add(new Edge(6,5,0));


        boolean[] visited = new boolean[7];

        List<String> path = new ArrayList<>();

        int src = 0;
        int numberOfNodesVisited = 1;
        hamiltonianCalculation(graph, src, src, src+"", path, visited, numberOfNodesVisited);

        path.forEach(e -> System.out.println(e));


    }

    private static void hamiltonianCalculation(ArrayList<Edge>[] graph,int start, int currentNode, String psf,  List<String> path, boolean[] visited, int numberOfNodesVisited) {

        if(numberOfNodesVisited == graph.length) {
            if(isHamiltonianCycle(start,graph[currentNode])) {
                path.add(psf+"*");
            } else {
                path.add(psf+".");
            }
        }

        visited[currentNode] = true;

        for(Edge edge : graph[currentNode]) {

            if(visited[edge.dest] == false) {
                hamiltonianCalculation(graph ,start, edge.dest, psf+edge.dest, path, visited, numberOfNodesVisited+1);
            }
        }

        visited[currentNode] = false;
    }

    private static boolean isHamiltonianCycle(int start, ArrayList<Edge> nbr) {

        for(Edge e : nbr) {
            if(e.dest == start){
                return true;
            }
        }
        return false;
    }
}
