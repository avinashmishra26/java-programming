package elementsofProgramming.tree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 14/09/21.
 */
public class Problem2 {

    public static void main(String[] args) {


        BinaryTreeNode root = PopulateTreeData.populateForSymmetric();
        System.out.print(isSymmetric(root.left, root.right));
    }


    static boolean isSymmetric(BinaryTreeNode<Integer> leftNode, BinaryTreeNode<Integer> rightNode) {

        if ( (leftNode == null && rightNode !=null) || (rightNode == null && leftNode !=null))
            return false;
        else if (leftNode == null && rightNode == null)
            return true;

        if (leftNode.data != rightNode.data) {
            return false;
        }

        if (!isSymmetric(leftNode.left, rightNode.right))
            return false;

        if (!isSymmetric(leftNode.right, rightNode.left))
            return false;

        return true;
    }

}
