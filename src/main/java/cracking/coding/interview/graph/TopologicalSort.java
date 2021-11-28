package cracking.coding.interview.graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by avinashkumarmishra on 05/11/21.
 * Topological Sort
 */
public class TopologicalSort {


    public static void main(String[] args) {

        int vertex = 7;

        ArrayList<Edge>[] graph = new ArrayList[vertex];
        boolean[] visited = new boolean[vertex];

        for (int i = 0; i < vertex; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));

        graph[0].add(new Edge(0, 3, 40));

        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 3, 10));

        graph[4].add(new Edge(4, 3, 2));

        graph[4].add(new Edge(4, 6, 8));

        graph[4].add(new Edge(4, 5, 3));

        graph[5].add(new Edge(5, 6, 3));


        Stack<Integer> ele = new Stack<>();

        for(int i = 0; i < vertex; i++) {
            if (!visited[i])
                getTopological(graph, i, visited, ele);
        }


        ele.forEach(e -> System.out.print(e+ " "));

    }

    private static void getTopological(ArrayList<Edge>[] graph, int src, boolean[] visited,  Stack<Integer> ele) {

        visited[src] = true;
        for(Edge e: graph[src]) {
            if (!visited[e.dest]) {
                getTopological(graph, e.dest, visited, ele);
            }
        }
        ele.push(src);
    }
}
