package cracking.coding.interview.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarMishra on 03/11/21.
 * 2022

 src  nbr
 0 1
 1 2
 2 3
 0 3
 3 4
 4 5
 4 6
 5 6

 */
public class BFS {
    
    private static class Edge {
        int src;
        int nbr;
        
        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    
    private static class Pair {
        int v;
        String psf;
        
        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }
    
    public static void main(String[] args) {
        
        ArrayList<Edge>[] graph = new ArrayList[7];
        
        for(int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        graph[0].add(new Edge(0, 3));
        graph[3].add(new Edge(3, 0));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));

        graph[4].add(new Edge(4, 6));
        graph[6].add(new Edge(6, 4));

        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));

        Deque<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[7];

        int src = 2;
        queue.add(new Pair(src, ""+src));


        while (!queue.isEmpty()) {
            Pair p = queue.remove();

            if(visited[p.v]) continue;

            System.out.println(p.psf);

            visited[p.v] = true;

            for(Edge e : graph[p.v]) {
                queue.add(new Pair(e.nbr, p.psf+""+e.nbr));
            }
        }

    }


}
