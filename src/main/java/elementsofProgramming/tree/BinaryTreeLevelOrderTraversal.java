package elementsofProgramming.tree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

import java.util.*;

/**
 * Created by avinashkumarmishra on 17/10/21.
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeNode root = PopulateTreeData.populateForLevelOrder();

        long c = System.currentTimeMillis();
        System.out.println(c);
        //one way with more space complexity
        System.out.println(levelOrder(root));

        System.out.println(System.currentTimeMillis() - c);

        c = System.currentTimeMillis();
        System.out.println(c);
        //Queue approach no extra space
        System.out.println(levelOrderBest(root));
        System.out.println(System.currentTimeMillis() - c);
    }

    public static List<List<Integer>> levelOrderBest(BinaryTreeNode<Integer> root) {

        Queue<BinaryTreeNode> parents = new LinkedList<>();

        Queue<BinaryTreeNode> childs = new LinkedList<>();

        parents.add(root);

        List<List<Integer>> res = new ArrayList<>();

        if(parents.isEmpty()) return res;

        while(!parents.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!parents.isEmpty()) {
                BinaryTreeNode<Integer> bt = parents.remove();
                temp.add(bt.data);
                if ( bt.left != null)
                    childs.add(bt.left);
                if ( bt.right != null)
                    childs.add(bt.right);
            }

            parents = childs;
            childs = new LinkedList<>();
            res.add(temp);
        }
        return res;
    }

    public static List<List<Integer>> levelOrder(BinaryTreeNode<Integer> root) {
        Map<Integer, List<Integer>> mp = new TreeMap();
        int level = 1;

        List<Integer> l = new ArrayList();
        l.add(root.data);

        mp.put(level, l);
        levelOrderRec(level+1, root.left, root.right, mp);

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for( Map.Entry<Integer, List<Integer>> r : mp.entrySet()) {
            res.add(r.getValue());
        }

        return res;
    }

    private static void levelOrderRec(int level, BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right, Map<Integer, List<Integer>> mp) {

        if(!mp.containsKey(level) &&  (left != null || right != null)){
            mp.put(level, new ArrayList());
        }
        if ( left != null) {
            mp.get(level).add(left.data);
            levelOrderRec(level+1, left.left, left.right, mp);
        }

        if ( right != null) {
            mp.get(level).add(right.data);
            levelOrderRec(level+1, right.left, right.right, mp);
        }


    }
}
