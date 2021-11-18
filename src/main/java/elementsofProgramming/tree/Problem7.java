package elementsofProgramming.tree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 26/09/21.
 */
public class Problem7 {


    public static void main(String[] args) {

        inorderWithOutRecurrsion(PopulateTreeData.populateBST()).forEach(e -> System.out.print(e +" "));

    }

    static List<Integer> inorderWithOutRecurrsion(BinaryTreeNode<Integer> node) {

        Deque<BinaryTreeNode<Integer>> stackNodes = new LinkedList<>();

        List<Integer> res = new ArrayList<>();

        while(node != null || !stackNodes.isEmpty()) {

            if (node != null){
                stackNodes.addFirst(node);
                node = node.left;
            } else {
                BinaryTreeNode<Integer> p = stackNodes.removeFirst();
                res.add(p.data);
                node = p.right;
            }
        }
        return res;
    }
}
