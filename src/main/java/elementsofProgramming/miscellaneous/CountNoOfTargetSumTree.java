package elementsofProgramming.miscellaneous;

import util.BinaryTreeNode;
import util.PopulateTreeData;

import java.util.Deque;
import java.util.LinkedList;
import java.util.*;

/**
 * Created by avinashkumarmishra on 17/10/21.
 */
public class CountNoOfTargetSumTree {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = PopulateTreeData.populatePathSum();

        System.out.print(pathSum(root, 22));
    }

    public static int pathSum(BinaryTreeNode<Integer> root, int targetSum) {
        if(root == null)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, targetSum, map);
    }

    public static int helper(BinaryTreeNode<Integer> root, int current, int target, Map<Integer, Integer> map) {
        if(root == null)
            return 0;

        current += root.data;
        int count = 0;

        count += map.getOrDefault(current - target, 0);
        map.put(current, map.getOrDefault(current, 0) + 1);

        count += helper(root.left, current, target, map);
        count += helper(root.right, current, target, map);

        map.put(current, map.get(current) - 1);
        return count;
    }

}
