package cracking.coding.interview.binaryTree;

import java.util.ArrayList;

/**
 * Created by avinash on 16/04/2022.
 */
public class NodesKLevel {


    public static void main(String[] args) {

        TreeNode t = ConstructBinaryTree.constructBT(new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null});

        ArrayList<TreeNode> res = new ArrayList<>();
        nodeToRoot(t, 25, res);

        int kVal = 2;

        for(int i  = 0; i < res.size() && kVal >= 0; i++) {
            if(i == 0 || kVal == 0) {
                printKlevelDown(res.get(i), kVal);
            } else {
                TreeNode curr = res.get(i);
                if(curr.left == res.get(i-1)) {
                    printKlevelDown(curr.right, kVal-1);
                } else {
                    printKlevelDown(curr.left, kVal-1);
                }
            }
            kVal--;
        }

    }

    private static void printKlevelDown(TreeNode node, int k) {
        if(node == null || k < 0) return;

        if(k == 0) {
            System.out.print(node.data + " ");
            return;
        }

        printKlevelDown(node.left, k-1);
        printKlevelDown(node.right, k-1);
    }

    private static boolean nodeToRoot(TreeNode node, int k, ArrayList<TreeNode> result) {

        if(node == null)  return false;

        if(node.data == k) {
            result.add(node);
            return true;
        }

        boolean lPresent = nodeToRoot(node.left, k, result);
        if(lPresent) {
            result.add(node);
            return true;
        }

        boolean rPresent = nodeToRoot(node.right, k, result);
        if(rPresent) {
            result.add(node);
            return true;
        }

        return false;
    }
}
