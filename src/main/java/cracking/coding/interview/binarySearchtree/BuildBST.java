package cracking.coding.interview.binarySearchtree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

import java.util.*;

/**
 * Created by avinashkumarmishra on 12/11/21.
 *
 * Build a BST using a sorted array
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class BuildBST {

    public static void main(String[] args) {

        int[] arr = {12, 25, 37, 50, 62, 75, 87};
        BinaryTreeNode<Integer> root = constructBST(arr, 0, arr.length-1);

        System.out.print(root);

        List l = new ArrayList<>();
        l.toArray();
    }

    private static BinaryTreeNode<Integer> constructBST(int[] arr, int low, int end) {

        if(low > end)  return null;

        int mid = (low+end) / 2;

        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        node.data = arr[mid];

        node.left = constructBST(arr, low, mid-1);
        node.right = constructBST(arr, mid+1, end);

        return node;
    }
}
