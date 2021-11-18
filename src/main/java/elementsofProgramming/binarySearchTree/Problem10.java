package elementsofProgramming.binarySearchTree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 13/11/21.
 *
 * INSERTION AND DELETION IN A BST
 *
 * While remove consider
 * a) if it is leaf node => remove it
 * b) if it has one child => remove add join the one child
 * c) if it has 2 children => find the left subtree max of the remove node and replace it with it.
 *
 *
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 */
public class Problem10 {

    public static void main(String[] args) {


        // Insert
        BinaryTreeNode<Integer> node = PopulateTreeData.populateBST();
        addIntoBST(node, 56);
        System.out.println(node);


        // delete
        BinaryTreeNode<Integer> node1 = PopulateTreeData.populateBST();
        removeFromBST(node1, 75);
        System.out.println(node1);

    }

    private static BinaryTreeNode<Integer> removeFromBST(BinaryTreeNode<Integer> node, int data) {

        if(node == null) return null;

        if( node.data == data) {
            //leaf-node
            if(node.left == null && node.right == null) {
                return null;
            }
            // one node either on left or right
            else if ( (node.left == null && node.right != null)) {
                return  node.right;
            } else if ( (node.left != null && node.right == null)) {
                return  node.left;
            }
            // two children are available
            else {
                Pair p = removeMaximumLeftSubTree(node.left);
                node.left =  p.leftTree;
                node.data = p.requiredData;
                return node;
            }
        }

        if ( data > node.data) {
            node.right = removeFromBST(node.right, data);
        } else {
            node.left = removeFromBST(node.left, data);
        }

        return node;
    }

    private static class Pair {
        BinaryTreeNode<Integer> leftTree;
        int requiredData;

        Pair(BinaryTreeNode<Integer> leftTree, int requiredData) {
            this.leftTree = leftTree;
            this.requiredData = requiredData;
        }
    }

    private static Pair removeMaximumLeftSubTree( BinaryTreeNode<Integer> node) {

        BinaryTreeNode<Integer>  prev = null, next = node, dummyHead = node;

        while(next.right != null) {
            prev = next;
            next = next.right;
        }

        if( prev == null) {
            return new Pair(next.left, prev.data);
        } else {
            prev.right = next.left;
            return new Pair(dummyHead, next.data);
        }
    }

    private static void addIntoBST(BinaryTreeNode<Integer> node, int data) {

        if(node.data < data) {
            if(node.right == null) {
                node.right = new BinaryTreeNode<>(data, null, null);
                return;
            }
            addIntoBST(node.right, data);
        } else {
            if(node.left == null) {
                node.left = new BinaryTreeNode<>(data, null, null);
                return;
            }
            addIntoBST(node.left, data);
        }
    }
}
