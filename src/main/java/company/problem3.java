package company;

import java.util.*;

/**
 * Created by avinashkumarmishra on 18/11/21.
 *
 * https://leetcode.com/problems/course-schedule/
 */
public class problem3 {

    public static void main(String[] args) {
        System.out.println(isTaskPossible(2, new int[][]{{1,0}}));


        //Best Method
        System.out.println(canFinish(2, new int[][]{{1,0},{0,1}}));
    }

    static boolean bfsTraversal(int[] deg, Map<Integer, ArrayList<Integer>> lt) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < deg.length; i++) {
            if(deg[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.remove();

            ArrayList<Integer> children = lt.get(cur);
            if(children != null) {
                for(int child: children) {
                    deg[child] -= 1;
                    if(deg[child] == 0)
                        q.add(child);
                }
            }
        }

        for(int i = 0; i < deg.length; i++) {
            if(deg[i] != 0) {
                return false;
            }
        }

        return true;
    }


    private static boolean isTaskPossible(int numCourses, int[][] prerequisites) {

        Map<Integer, ArrayList<Integer>> lt = new HashMap<>();
        int[] deg = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            int first = prerequisites[i][0];
            int second = prerequisites[i][1];

            if(!lt.containsKey(second)) {
                lt.put(second, new ArrayList<Integer>());
            }
            lt.get(second).add(first);
            deg[first]++;

        }
        return bfsTraversal(deg, lt);
    }


    //Best Method
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Edge>[] graph = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        for(int[] c : prerequisites) {
            graph[c[0]].add(new Edge(c[0],c[1]));
        }

        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stk = new Stack();

        for(int i = 0; i < numCourses; i++) {

            if(visited[i] == false) {
                boolean taskPossible = isTaskPossible(graph, i, visited, stk);
                if(taskPossible == false) return false;
            }
        }
        return true;

    }

    private  static boolean isTaskPossible(ArrayList<Edge>[] graph, int node, boolean[] visited, Stack<Integer> stk ) {

        visited[node] = true;

        for(Edge e : graph[node]) {
            if(visited[e.nbr] == false) {
                boolean t = isTaskPossible(graph, e.nbr, visited, stk);
                if(t == false) return false;
            } else if(visited[e.nbr] == true && !stk.contains(e.nbr)) {
                return false;
            }
        }

        stk.push(node);
        return true;

    }

    private static class Edge {
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
}
