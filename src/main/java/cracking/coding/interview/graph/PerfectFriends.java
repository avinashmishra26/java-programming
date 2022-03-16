package cracking.coding.interview.graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 01/11/21.
 * 2022
 */
public class PerfectFriends {

    public static void main(String[] args)throws IOException {
        ArrayList<Edge>[] graph = new ArrayList[7];

        for(int i = 0; i < graph.length; i++) {
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
        List<List<Integer>> connectedComponent = new ArrayList<>();

        for(int i = 0; i < graph.length; i++) {
            if(visited[i] == false) {
                List<Integer> component = new ArrayList<>();
                GraphConnected.addConnectedComponent(graph, i, visited, component);
                connectedComponent.add(component);
            }
        }

        int totalCnt = connectedComponent.size();

        int totalCombination = 0;
        for(int i = 0; i < totalCnt; i++) {
            for(int j = i+1; j < totalCnt; j++) {
                totalCombination += connectedComponent.get(i).size() * connectedComponent.get(j).size();
            }
        }

       System.out.print(totalCombination);
    }
}
