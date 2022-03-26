package cracking.coding.interview.graph;

import java.io.IOException;
import java.util.*;

/**
 *  Created by avinashkumarmishra on 04/11/21.
 *  2022
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
                System.out.println("It is Not bipartite");
                //return;
            }
        }
        //System.out.println("u are safe");

        System.out.println("Method 2:");


        int[] visitArr = new int[graph.length];
        Arrays.fill(visitArr, -1);

        for(int i = 0; i < graph.length; i++){
            if(visitArr[i] == -1){
                boolean res = isBipartiteMethod(graph, i, visitArr);
                if(res == false) {
                    System.out.print("It is Not bipartite");
                    return;
                }
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

    // Second method
    private static boolean isBipartiteMethod(ArrayList<Edge>[] graph, int curr, int[] visited) {

        ArrayDeque<PairLevel> d = new ArrayDeque<>();
        d.add(new PairLevel(curr, curr+"", 0));

        while(!d.isEmpty()) {

            PairLevel rem = d.remove();

            if(visited[rem.v] != -1){
                if(rem.level != visited[rem.v]) {
                    return false;
                }
            }

            visited[rem.v] = rem.level;

            for(Edge e : graph[rem.v]){
                if(visited[e.dest] == -1){
                    d.add(new PairLevel(e.dest, rem.psf + e.dest, rem.level+1));
                }
            }

        }
        return true;
    }

    private static class PairLevel {
        int v;
        String psf;
        int level;

        PairLevel(int v, String psf, int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }
}
