package elementsofProgramming.binarySearchTree;


import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 27/10/21.
 */
public class Problem4 {

    public static void main(String[] args) {

        BinaryTreeNode<Integer> node = lowestCommonAncestor(PopulateTreeData.populateBST(), new BinaryTreeNode<>(100, null, null), new BinaryTreeNode<>(75, null, null));
        System.out.print(node.data);
    }


    public static BinaryTreeNode<Integer> lowestCommonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
        BinaryTreeNode<Integer> low = p.data < q.data ? p : q;
        BinaryTreeNode<Integer> high = q.data > p.data ? q : p;
        return getlowestCommonAncestor(root, low, high);
    }


    private static BinaryTreeNode<Integer> getlowestCommonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {

        if(root == null) {
            return null;
        }

        if ((p.data < root.data && q.data > root.data) || (p.data == root.data) || (q.data == root.data)){
            return root;
        }else if (p.data < root.data && q.data < root.data) {
            return getlowestCommonAncestor(root.left, p, q);
        } else {
            return getlowestCommonAncestor(root.right, p, q);
        }

    }
}
