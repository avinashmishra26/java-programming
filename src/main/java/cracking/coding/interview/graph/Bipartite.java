package cracking.coding.interview.graph;

import java.io.IOException;
import java.util.*;

/**
 * Created by avinashkumarmishra on 04/11/21.
 */
public class Bipartite {
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

       Map<Integer, List<Integer>> test = new HashMap<>();

        List<Integer> list1 = new ArrayList<>();
        test.put(0, list1);

        List<Integer> list2 = new ArrayList<>();
        test.put(1, list2);

        for(int i = 0; i < 7; i++) {

            if(visited[i]) continue;

            if (!isBipartite(graph, i, test, visited)){
                System.out.print("It is Not bipartite");
                return;
            }
        }
        System.out.print("u are safe");
    }

    private static boolean isBipartite(ArrayList<Edge>[] graph, int idx, Map<Integer, List<Integer>> test, boolean[] visited) {
        Deque<Integer> que = new LinkedList<>();
        que.add(idx);
        int in = 0;

        while(!que.isEmpty()) {

            List<Integer> toBeInsertedIdx = test.get(in % 2);
            List<Integer> notToBeInsertedIdx = test.get((in+1) % 2);

            int qSize = que.size();

            for(int i = 0; i < qSize; i++) {
                int vertex = que.poll();
                visited[vertex]  = true;

                if(notToBeInsertedIdx.contains(vertex)) return false;

                toBeInsertedIdx.add(vertex);

                for(Edge e : graph[vertex]) {
                    if(!visited[e.dest]) {
                        que.add(e.dest);
                    }
                }
            }
            in++;
        }
        return true;
    }
}
