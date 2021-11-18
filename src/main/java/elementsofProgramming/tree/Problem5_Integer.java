package elementsofProgramming.tree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 27/10/21.
 */
public class Problem5_Integer {

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = PopulateTreeData.populateBinarySum();
        int[] res = new int[1];

        getBinarySum(root, 0, res);
        System.out.print(res[0]);

    }

    private static void getBinarySum(BinaryTreeNode<Integer> node, int prev, int[] res) {


        int newprev = 10*prev + node.data;

        if(node.left == null && node.right == null) {
            res[0] += newprev;
            return;
        }

        if ( node.left != null)
            getBinarySum(node.left, newprev, res);

        if ( node.right != null)
            getBinarySum(node.right, newprev, res);


    }
}
