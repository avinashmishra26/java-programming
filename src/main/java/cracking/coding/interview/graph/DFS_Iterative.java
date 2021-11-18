package cracking.coding.interview.graph;

import java.io.IOException;
import java.util.*;

/**
 * Created by avinashkumarmishra on 05/11/21.
 */
public class DFS_Iterative {
    public static void main(String[] args)throws IOException {

        ArrayList<Edge>[] graph = new ArrayList[7];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }


        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 0, 10));

        graph[0].add(new Edge(0, 3, 40));
        graph[3].add(new Edge(3, 0, 40));

        graph[1].add(new Edge(1, 2, 10));
        graph[2].add(new Edge(2, 1, 10));

        graph[2].add(new Edge(2, 3, 10));
        graph[3].add(new Edge(3, 2, 10));

        graph[3].add(new Edge(3, 4, 2));
        graph[4].add(new Edge(4, 3, 2));

        graph[4].add(new Edge(4, 6, 8));
        graph[6].add(new Edge(6, 4, 8));

        graph[4].add(new Edge(4, 5, 3));
        graph[5].add(new Edge(5, 4, 3));

        graph[5].add(new Edge(5, 6, 3));
        graph[6].add(new Edge(6, 5, 3));

        boolean[] visited = new boolean[graph.length];

        iterativeDFS(graph, 0, visited);


    }

    private static void iterativeDFS(ArrayList<Edge>[] graph ,int src, boolean[] visited ) {

        Deque<Pair> d = new LinkedList<>();
        d.addFirst(new Pair(src,src+""));

        while(!d.isEmpty()) {

            Pair r = d.removeFirst();

            if (visited[r.vertex]) continue;

            visited[r.vertex] = true;

            System.out.println(r);

            for(Edge e : graph[r.vertex]) {
                if(!visited[e.dest]) {
                    d.addFirst(new Pair(e.dest, r.psf+e.dest));
                }
            }
        }


    }

    private static class Pair {
        int vertex;
        String psf;

        Pair(int v, String p) {
            this.vertex = v;
            this.psf = p;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "vertex=" + vertex +
                    ", psf='" + psf + '\'' +
                    '}';
        }
    }
}
