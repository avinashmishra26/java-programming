package elementsofProgramming.recursion;

import util.BinaryTreeNode;
import util.PopulateTreeData;

import java.util.Map;

/**
 * Created by avinashkumarmishra on 22/10/21.
 * COMPUTE THE DIAMETER OF A TREE
 * The longest path may or may not pass through the root.
 */
public class Problem11 {

    public static void main(String[] args) {

        Diameter diameter = new Diameter();
        getDiameter(PopulateTreeData.populateNodeToRoot(), diameter);
        System.out.print(diameter.diameter);
    }

    private static class Diameter {
        int diameter = Integer.MIN_VALUE;
    }


    public static int getDiameter(BinaryTreeNode<Integer> node, Diameter diameter) {

        if(node == null) {
            return -1;
        }

        int left = getDiameter(node.left, diameter) ;
        int right = getDiameter(node.right, diameter);

        if( (left + right +2) > diameter.diameter) {
            diameter.diameter = left + right + 2;
        }

        return Math.max(left, right) + 1;
    }
}
