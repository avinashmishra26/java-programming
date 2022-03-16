package cracking.coding.interview.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 31/10/21
 * 2022.
 *
 7
 8
 0 1 10
 1 2 10
 2 3 10
 0 3 30
 3 4 5
 4 5 3
 4 6 3
 5 6 3
 0
 5

 */
public class HasPath {

    public static void main(String[] args)throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input Required");

        int vtcs = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[vtcs];

        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());

        for(int i = 0; i <edges; i++) {
            String[] val = br.readLine().split(" ");
            int src = Integer.parseInt(val[0]);
            int dest = Integer.parseInt(val[1]);
            int weight = Integer.parseInt(val[2]);

            graph[src].add(new Edge(src, dest, weight));
            graph[dest].add(new Edge(dest, src, weight));
        }

        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtcs];

        System.out.println(hasPath(graph, visited, start, end));


        boolean[] visited1 = new boolean[vtcs];
        printAllPath(graph, visited1, start, end, start+"");

    }


    private static boolean hasPath(ArrayList<Edge>[] graph, boolean[] visited, int currentNode, int destinatipn) {

        if(visited[currentNode]) {
            return false;
        }

        if(currentNode == destinatipn) {
            return true;
        }

        visited[currentNode] = true;

        for(Edge e : graph[currentNode]) {

            if(hasPath( graph, visited, e.dest, destinatipn)) {
                return true;
            }
        }
        return false;
    }

    private static void printAllPath(ArrayList<Edge>[] graph, boolean[] visited, int currentNode, int destinatipn, String path) {

        if(visited[currentNode]) {
            return;
        }

        if(currentNode == destinatipn) {
           System.out.println(path+" -> "+destinatipn);
            return;
        }

        visited[currentNode] = true;

        for(Edge e : graph[currentNode]) {

            if(!visited[e.dest]) {
                printAllPath(graph, visited, e.dest, destinatipn , path+" -> "+ e.dest);
            }
        }

        visited[currentNode] = false;
    }
}
