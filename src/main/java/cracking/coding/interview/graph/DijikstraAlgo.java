package cracking.coding.interview.graph;

import java.util.*;

/**
 * Created by avinashkumarmishra on 04/11/21.
 * 2022
 */
public class DijikstraAlgo {

    public static void main(String[] args){

        int vertex = 7;

        ArrayList<Edge>[] graph = new ArrayList[vertex];

        for(int i = 0; i < vertex; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[1].add(new Edge(1,0,10));

        graph[0].add(new Edge(0,3,40));
        graph[3].add(new Edge(3,0,40));

        graph[1].add(new Edge(1,2,10));
        graph[2].add(new Edge(2,1,10));

        graph[2].add(new Edge(2,3,10));
        graph[3].add(new Edge(3,2,10));

        graph[3].add(new Edge(3,4,2));
        graph[4].add(new Edge(4,3,2));

        graph[4].add(new Edge(4,6,8));
        graph[6].add(new Edge(6,4,8));

        graph[4].add(new Edge(4,5,3));
        graph[5].add(new Edge(5,4,3));

        graph[5].add(new Edge(5,6,3));
        graph[6].add(new Edge(6,5,3));

        boolean[] visited = new boolean[vertex];

        int src = 0;

        Pair[] route = getShortestPath(graph, src, visited);

        for(Pair p : route) {
            System.out.println("To Reach Vertex :" +p.vertex +" Route is "+ p.psf+" with weight :"+ p.totalWeight);
        }
    }

    private static Pair[] getShortestPath(ArrayList<Edge>[] graph, int src, boolean[] visited) {

        Pair[] route = new Pair[graph.length];

        PriorityQueue<Pair> deque = new PriorityQueue<>();

        deque.add(new Pair(src, src+"", 0));

        while (!deque.isEmpty()) {

            Pair p = deque.remove();

            if (visited[p.vertex]) continue;

            //capture all the shortest path to each vertex
            route[p.vertex] = p;
            //capture all the shortest path to each vertex

            visited[p.vertex] = true;

            for(Edge e : graph[p.vertex]) {
                if(!visited[e.dest]) {
                    deque.add(new Pair(e.dest, p.psf + e.dest, p.totalWeight + e.weight));
                }
            }
        }
        return route;

    }


    private static class Pair implements Comparable<Pair>{
        int vertex;
        String psf;
        int totalWeight;

        Pair( int vertex, String psf, int totalWeight) {
            this.vertex = vertex;
            this.psf = psf;
            this.totalWeight = totalWeight;
        }

        public int compareTo(Pair p) {
            return this.totalWeight - p.totalWeight;
        }
    }
}
