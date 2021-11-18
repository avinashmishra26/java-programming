package cracking.coding.interview.binarySearchtree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 13/11/21.
 *
 *
 * Find BST size , sum
 */
public class BSTLogic {

    public static void main(String[] args) {


        // size for BT and BST is same
        System.out.println(sizeBS(PopulateTreeData.populateBST()));

        // sum for BT and BST is same
        System.out.println(sumBS(PopulateTreeData.populateBST()));


        // max for BST
        System.out.println(maxBST(PopulateTreeData.populateBST()));

        // Min for BST
        System.out.println(minBST(PopulateTreeData.populateBST()));

        // find for BST
        System.out.println(findBST(PopulateTreeData.populateBST(), 75));
    }

    private static boolean findBST(BinaryTreeNode<Integer> node, int val) {

        if(node == null) return false;

        if(node.data == val) return true;
        else if(node.data > val) {
            return findBST(node.left, val);
        }else if(node.data < val) {
            return findBST(node.right, val);
        }

     return false;
    }


    private static int maxBST(BinaryTreeNode<Integer> node) {

        while(node.right != null) {
            node = node.right;
        }
       return node.data;
    }

    private static int minBST(BinaryTreeNode<Integer> node) {

        while(node.left != null) {
            node = node.left;
        }
        return node.data;
    }


    private static int sizeBS(BinaryTreeNode<Integer> node) {

        if(node.left == null  && node.right == null) {
            return 1;
        }

        int ls =0, rs = 0;
        if(node.left != null) {
            ls = sizeBS(node.left);
        }

        if(node.right != null) {
            rs = sizeBS(node.right);
        }

        return ls+rs+1;
    }

    private static int sumBS(BinaryTreeNode<Integer> node) {

        if(node.left == null  && node.right == null) {
            return node.data;
        }

        int ls =0, rs = 0;
        if(node.left != null) {
            ls = sumBS(node.left);
        }

        if(node.right != null) {
            rs = sumBS(node.right);
        }

        return ls+rs+node.data;
    }
}
