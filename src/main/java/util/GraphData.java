package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avinashkumarmishra on 02/10/21.
 */
public class GraphData {

    public static List<GraphVertex> populateDeadLock() {

        GraphVertex a = new GraphVertex();

        GraphVertex b = new GraphVertex();

        GraphVertex c = new GraphVertex();

        GraphVertex d = new GraphVertex();

        GraphVertex x = new GraphVertex();

        GraphVertex y = new GraphVertex();

        GraphVertex e = new GraphVertex();

        GraphVertex f = new GraphVertex();

        GraphVertex k = new GraphVertex();

        GraphVertex l = new GraphVertex();

        a.edges.add(b);
        a.edges.add(k);
        a.edges.add(x);

        b.edges.add(c);
        b.edges.add(x);

        c.edges.add(d);

        x.edges.add(y);

        e.edges.add(f);

        k.edges.add(l);

        l.edges.add(a);

        return Arrays.asList(a,b,c,d,e,f,k,l,x,y);
    }
}


