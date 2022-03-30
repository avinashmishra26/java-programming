package cracking.coding.interview.tree;

/**
 * Created by avinashkumarmishra on 26/03/22.
 *
 *  GenericTreeSymmetric without comparing data
 *
 **/

public class GenericTreeSymmetric {

    private static boolean isSymmetric(GenericTree node) {
        return TreesMirrorShape.isMirrorShape(node, node);
    }
}