package elementsofProgramming.binarySearchTree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 26/09/21.
 * Find the first key greater than a given value in a BST
 */
public class Problem2 {

    public static void main(String[] args) {
        //System.out.print(findKeyBinaryTree(PopulateTreeData.populateBST(), 60));

        System.out.print(findFirstGreaterThanK(PopulateTreeData.populateBST(), 60).data);
    }

    static BinaryTreeNode<Integer> findFirstGreaterThanK(BinaryTreeNode<Integer> node, int key) {

        BinaryTreeNode<Integer> greaterThanSoFar = null;

        while (node != null) {

            if (node.data > key) {
                greaterThanSoFar = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return greaterThanSoFar;
    }

    //There is some flaw in findKeyBinaryTree() : Can you find it ?
    static int findKeyBinaryTree(BinaryTreeNode<Integer> node, int key) {

        if (node == null)
            return -1;

        if ( node.data == key)
            return nexInorderEle(node.right);

        int l = findKeyBinaryTree(node.left, key);

        if (l != -1 )
            return l;

        int r = findKeyBinaryTree(node.right, key);
        if (r != -1 )
            return r;

        return -1;
    }

    static int nexInorderEle(BinaryTreeNode<Integer> node) {

        while(node.left != null)
            node = node.left;

        return node.data;
    }
}
