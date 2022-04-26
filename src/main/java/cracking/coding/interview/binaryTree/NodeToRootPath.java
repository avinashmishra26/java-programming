package cracking.coding.interview.binaryTree;

import java.util.ArrayList;

/**
 * Created by avinash on 16/04/2022.
 */
public class NodeToRootPath {

    public static void main(String[] args) {

        TreeNode t = ConstructBinaryTree.constructBT(new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null});

        ArrayList<Integer> res = new ArrayList<>();

        nodeToRootPath(t, 62, res);

        res.forEach(System.out :: println);

    }

    private static void nodeToRootPath(TreeNode node, int val, ArrayList<Integer> res) {


        if(node == null) return;

        if(node.data == val) {
            res.add(node.data);
            return;
        }

        nodeToRootPath(node.left, val, res);
        if(res.size() > 0) {
            res.add(node.data);
            return;
        }


        nodeToRootPath(node.right, val, res);
        if(res.size() > 0) {
            res.add(node.data);
            return;
        }

    }
}
