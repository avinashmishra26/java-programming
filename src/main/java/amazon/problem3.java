package amazon;

import java.util.*;

/**
 * Created by avinashkumarmishra on 18/11/21.
 */
public class problem3 {

    public static void main(String[] args) {
        isTaskPossible(2, new int[][]{{1,0}});
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
}
