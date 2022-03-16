package cracking.coding.interview.graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by avinashkumarmishra on 16/02/22.
 *
 */

public class MultiSolverDFS {
    public static void main(String[] args) throws IOException {

        ArrayList<Edge>[] graphs = new ArrayList[7];

        for(int i = 0; i < 7; i++){
            graphs[i] = new ArrayList<Edge>();
        }

        graphs[0].add(new Edge(0, 1, 10));
        graphs[0].add(new Edge(0, 3, 40));

        graphs[1].add(new Edge(1, 2, 10));
        graphs[1].add(new Edge(1, 0, 10));

        graphs[2].add(new Edge(2, 1, 10));
        graphs[2].add(new Edge(2, 3, 10));

        graphs[3].add(new Edge(3, 0, 40));
        graphs[3].add(new Edge(3, 2, 10));
        graphs[3].add(new Edge(3, 4, 2));

        graphs[4].add(new Edge(4, 3, 2));
        graphs[4].add(new Edge(4, 5, 3));
        graphs[4].add(new Edge(4, 6, 8));

        graphs[5].add(new Edge(5, 4, 3));
        graphs[5].add(new Edge(5, 6, 3));

        graphs[6].add(new Edge(6, 4, 8));
        graphs[6].add(new Edge(6, 5, 3));

        boolean[] visited = new boolean[7];

        PriorityQueue<Pair> pr = new PriorityQueue(3);

        multiSolver(graphs, 0, 6, "", 0, visited, pr);

        System.out.println("sPath "+ sPath + " with weigth " + sPathWt);

        System.out.println("lPath "+ lPath + " with weigth " + lPathWt);

        System.out.println("cPath "+ cPath + " with ceiling weigth " + ceilWt);

        System.out.println("fPath "+ fPath + " with floor weigth " + floorWt);

        System.out.println("3rd Largest"+ pr.peek());
    }

    static String sPath;
    static Integer sPathWt = Integer.MAX_VALUE;

    static String lPath;
    static Integer lPathWt = Integer.MIN_VALUE;

    static Integer ceilWt = Integer.MAX_VALUE;
    static Integer criteriaCeilWt = 42;
    static String cPath;

    static Integer floorWt = Integer.MIN_VALUE;
    static Integer criteriaFloorWt = 42;
    static String fPath;

    //3rd Largest
    static int k = 3;

    private static void multiSolver(ArrayList<Edge>[] graphs, int curr, int dest, String psf, int wsf, boolean[] visited, PriorityQueue<Pair> pr) {

        if ( curr == dest ){

            if(wsf < sPathWt){
                sPath = psf;
                sPathWt = wsf;
            }

            if(wsf > lPathWt) {
                lPathWt = wsf;
                lPath = psf;
            }

            if(wsf > criteriaCeilWt && wsf < ceilWt){
                ceilWt = wsf;
                cPath = psf;
            }

            if(wsf < criteriaFloorWt && wsf > floorWt){
                floorWt = wsf;
                fPath = psf;
            }

            if(pr.size() < k) {
                pr.add(new Pair(wsf, psf));
            } else {
                if(pr.peek().wsf < wsf) {
                    pr.poll();
                    pr.add(new Pair(wsf, psf));
                }
            }

            return;
        }

        if(visited[curr] == true) return;

        visited[curr] = true;

        for(Edge edge : graphs[curr]) {
            if(visited[edge.dest] == false)
                multiSolver(graphs, edge.dest, dest, psf+edge.dest, wsf+edge.weight, visited, pr);
        }

        visited[curr] = false;
    }
}