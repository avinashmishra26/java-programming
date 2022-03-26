package cracking.coding.interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *  Created by avinashkumarmishra on 20/03/22.
 *
 *  BFS : count number of people infected
 *
 */

public class SpreadInfection {
    public static void main(String[] args){

        ArrayList<Edge>[] graph = new ArrayList[7];



        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,0));graph[0].add(new Edge(0,3,0));

        graph[1].add(new Edge(1,0,0));graph[1].add(new Edge(1,2,0));

        graph[2].add(new Edge(2,1,0));graph[2].add(new Edge(2,3,0));

        graph[3].add(new Edge(3,0,0));graph[3].add(new Edge(3,2,0));graph[3].add(new Edge(3,4,0));

        graph[4].add(new Edge(4,3,0));graph[4].add(new Edge(4,5,0));graph[4].add(new Edge(4,6,0));

        graph[5].add(new Edge(5,4,0));graph[5].add(new Edge(5,6,0));

        graph[6].add(new Edge(6,4,0));graph[6].add(new Edge(6,5,0));


        int[] visited = new int[graph.length];

        int count = infectionSpread(graph, 6, 4, visited);

        System.out.print(count);
    }

    private static class PairInfection {
        int v;
        int time;

        PairInfection(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }

    private static int infectionSpread(ArrayList<Edge>[] graph, int src, int timeThreshold, int[] visited) {

        ArrayDeque<PairInfection> pf = new ArrayDeque<>();
        pf.add(new PairInfection(src, 1));
        int count = 0;

        while(pf.size() > 0) {

            PairInfection rem = pf.remove();

            if (visited[rem.v] > 0) {
                continue;
            }

            if(rem.time > timeThreshold)  break;

            visited[rem.v] = rem.time;
            count++;

            for(Edge e: graph[rem.v]){
                if(visited[e.dest] == 0) {
                    pf.add(new PairInfection(e.dest, rem.time+1));
                }
            }
        }
        return count;
    }
}