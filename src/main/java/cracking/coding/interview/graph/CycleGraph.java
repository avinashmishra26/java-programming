package cracking.coding.interview.graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 *  Created by avinashkumarmishra on 04/11/21.
 *  2022
 *
 */
public class CycleGraph {

    public static void main(String[] args)throws IOException {

        ArrayList<Edge>[] graph = new ArrayList[7];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }


        graph[0].add(new Edge(0, 1, 0));
        graph[1].add(new Edge(1, 0, 0));

        graph[2].add(new Edge(2, 3, 0));
        graph[3].add(new Edge(3, 2, 0));

        graph[4].add(new Edge(4, 5, 0));
        graph[4].add(new Edge(4, 6, 0));
        graph[5].add(new Edge(5, 4, 0));
        graph[5].add(new Edge(5, 6, 0));
        graph[6].add(new Edge(6, 4, 0));
        graph[6].add(new Edge(6, 5, 0));

        boolean[] visited = new boolean[graph.length];

        for(int i = 0; i < 7 ; i++) {

            if(visited[i]) continue;

            if(isCyclic(graph, i, visited)){
                System.out.print("Has Cycle");
                return;
            }

        }
        System.out.print("No Cycle");
    }

    private static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited) {

        Deque<Pair> deque = new LinkedList<>();
        deque.add(new Pair(src, src+""));

        while (!deque.isEmpty()) {
            Pair p = deque.remove();

            if (visited[p.v]) return true;

            visited[p.v] = true;

            for(Edge e: graph[p.v]) {
                if (!visited[e.dest]) {
                    deque.add(new Pair(e.dest, p.psf+e.dest));
                }
            }
        }
        return false;
    }

    private static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }
}
