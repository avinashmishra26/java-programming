package elementsofProgramming.binarySearchTree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

import java.util.*;

/**
 * Created by avinashkumarmishra on 26/09/21.
 *
 * Find the k largest elements in a BST
 */
public class Problem3 {

    public static void main(String[] args) {

       findKLargestInBST(PopulateTreeData.populateBST(), 4).forEach(e -> System.out.print(e + " "));
    }

    public static List<Integer> findKLargestInBST(BinaryTreeNode<Integer> node, int k) {

        List<Integer> list = new ArrayList<>();
        findKLargestInBSTHelper(node, k, list);
        return list;
    }

    private static void findKLargestInBSTHelper(BinaryTreeNode<Integer> node, int k, List<Integer> KLargestElement) {

        if (node != null && KLargestElement.size() < k) {
            findKLargestInBSTHelper(node.right, k, KLargestElement);
            KLargestElement.add(node.data);
            findKLargestInBSTHelper(node.left, k, KLargestElement);
        }
    }
}
