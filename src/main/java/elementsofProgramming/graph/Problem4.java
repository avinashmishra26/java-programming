package elementsofProgramming.graph;

import util.GraphVertex.Color;
import util.GraphData;
import util.GraphVertex;

import java.util.List;

/**
 * Created by avinashkumarmishra on 01/10/21.
 * DEADLOCK DETECTION
 *
 */
public class Problem4 {

    public static void main(String[] args) {
        System.out.print(isDeadLocked(GraphData.populateDeadLock()));
    }


    public static boolean isDeadLocked(List<GraphVertex> G) {
        for ( GraphVertex g : G) {
            if ( g.color == Color.WHITE && hasCycle(g)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(GraphVertex g) {

        g.color = Color.GREY;

        for (GraphVertex child :  g.edges) {
            if ( child.color == Color.WHITE) {
                if (hasCycle(child))
                    return true;
            } else if (child.color == Color.GREY) {
                return true;
            } else {
                continue;
            }
        }

        g.color = Color.BLACk;
        return false;
    }
}

