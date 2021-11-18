package elementsofProgramming.binarySearchTree;

import util.BinaryTreeNode;

/**
 * Created by avinashkumarmishra on 12/11/21.
 *
 * Reconstruct a BST from traversal data (Preorder travsersal)
 *
 */
public class problem5 {

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>();

        int[] nums = { 108, 96, 70, 65, 75, 100, 285, 243, 301, 401 };

        constructBSTUsingPreOrder(root, nums, 0, nums.length-1);

        //debug and see the structure
        System.out.print(root);
    }

    private static void constructBSTUsingPreOrder(BinaryTreeNode<Integer> node, int[] nums, int start, int end) {

        node.data = nums[start];

        if(start == end) {
            return;
        }

        int leftStart = start+1;
        int leftEnd = start;

        while(nums[leftEnd+1] < node.data) {
            leftEnd += 1;
        }

        if(leftEnd != start) {
            node.left = new BinaryTreeNode<>();
            constructBSTUsingPreOrder(node.left, nums, leftStart, leftEnd);
        }

        int rightStart = leftEnd+1;
        int rightEnd = end;

        if(rightStart <= rightEnd) {
            node.right = new BinaryTreeNode<>();
            constructBSTUsingPreOrder(node.right, nums, rightStart, rightEnd);
        }
    }
}
