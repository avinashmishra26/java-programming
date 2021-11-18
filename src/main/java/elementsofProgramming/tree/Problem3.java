package elementsofProgramming.tree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 25/09/21.
 */
public class Problem3 {

    public static void main(String[] args) {
        AncestorDetail a = lca(PopulateTreeData.populateDataHeightBalanced(), new BinaryTreeNode<>('E', null, null), new BinaryTreeNode<>('D', null, null));

        System.out.print(a.ancestor.data);
    }

    private static class AncestorDetail {
        BinaryTreeNode<Character> ancestor = null;
        int noOfNodes = 0;

        AncestorDetail(BinaryTreeNode<Character> ancestor , int noOfNodes) {
            this.ancestor = ancestor;
            this.noOfNodes = noOfNodes;
        }

    }

    static AncestorDetail lca(BinaryTreeNode<Character> node , BinaryTreeNode<Character> node1, BinaryTreeNode<Character> node2) {

        if ( node == null) {
            return new AncestorDetail(null, 0);
        }

        AncestorDetail leftDetail = lca(node.left, node1, node2);

        if (leftDetail.noOfNodes == 2) {
                return leftDetail;
        }

        AncestorDetail rightDetail = lca(node.right, node1, node2);

        if (rightDetail.noOfNodes == 2) {
                return rightDetail;
        }

        int cnt = 0;

        cnt = (node1.data == node.data || node2.data == node.data) ? 1 : 0;

        return new AncestorDetail(node, cnt + leftDetail.noOfNodes + rightDetail.noOfNodes);

    }
}
