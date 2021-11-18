package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 02/10/21.
 */
public class GraphVertex {
    public Color color = Color.WHITE;
    public Character process;

    public List<GraphVertex> edges = new ArrayList<>();


    public enum Color { WHITE , BLACk , GREY}
}
