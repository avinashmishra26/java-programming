package cracking.coding.interview.binarySearchtree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 13/11/21.
 */
public class KthSmallest {

    public static void main(String[] args) {
        System.out.print(kthSmallest(PopulateTreeData.populateBST(), 3));
    }

    public static int kthSmallest( BinaryTreeNode<Integer> root, int k) {

        int[] idx = new int[2];
        findKElement(root, k, idx);
        return idx[1];
    }

    private  static void findKElement(BinaryTreeNode<Integer> root, int k, int[] idx) {

        if(root == null) return;

        findKElement(root.left, k , idx);
        if(idx[0] == k) return;
        idx[0] = idx[0] + 1;
        if(idx[0] == k)  {
            idx[1] = root.data;
            return;
        }
        findKElement(root.right, k , idx);
    }
}
