package cracking.coding.interview.binarySearchtree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 13/11/21.
 */
public class BSTLCA {

    public static void main(String[] args) {
        System.out.print(findLST(PopulateTreeData.populateBST(), 75, 62));
    }


    private static int findLST(BinaryTreeNode<Integer> node, int d1, int d2) {

       if(node == null) return -1;

        if (node.data > d1 && node.data > d2) {
            return findLST(node.left, d1, d2);
        } else if (node.data < d1 && node.data < d2) {
            return findLST(node.right, d1, d2);
        } else {
           return node.data;
        }

    }
}
