package cracking.coding.interview.binaryTree;

import util.PopulateTreeData;

import java.util.Stack;

/**
 * Created by avinash on 15/04/2022.
 */
public class ConstructBinaryTree {

    public static void main(String[] args) {

        TreeNode t = constructBT(new Integer[]{50,25,12, null,null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null});

        displayPreOrder(t);


        System.out.println(getMax(t));;

        System.out.println(getSum(t));

        System.out.println(getSize(t));

        System.out.println(getHeight(t));
    }

    public static TreeNode constructBT(Integer[] arr) {
        Stack<State> stk = new Stack<>();
        TreeNode head = null;

        for(Integer num : arr) {

            while(stk.size() > 0 && stk.peek().state == 2) {
                stk.pop();
            }

            TreeNode t = num != null ? new TreeNode(num) : null;
            if(stk.empty()) {
                head = t;
            } else {
                State parent = stk.peek();
                if(parent.state == 0) {
                    parent.treeNode.left = t;
                } else if(parent.state == 1) {
                    parent.treeNode.right = t;
                }
                parent.state++;
            }
            if(num != null) {
                stk.push(new State(t, 0));
            }
        }
        return head;
    }

    //size , sum, max, height
    private static int getSize(TreeNode node) {
        if(node == null) return 0;
        return getSize(node.left) + getSize(node.right) + 1;
    }

    private static int getSum(TreeNode node) {
        if(node == null) return 0;
        return getSum(node.left) + getSum(node.right) + node.data;
    }

    private static int getMax(TreeNode node) {
        if(node == null) return Integer.MIN_VALUE;

        int tempMax = Math.max(getMax(node.left), getMax(node.right));

        return Math.max(tempMax, node.data);
    }

    private static int getHeight(TreeNode node) {
        if(node == null) return 0;

        int tempH = Math.max(getHeight(node.left), getHeight(node.right));

        return tempH+1;
    }

    public static void displayPreOrder(TreeNode node) {
        if(node == null) return;

        String res = "";
        res += node.left == null ? "." : node.left.data + " ";
        res += "<- " +node.data+ "->";
        res += node.right == null ? "." : node.right.data + " ";
        System.out.println(res);


        displayPreOrder(node.left);
        displayPreOrder(node.right);
    }

    private static class State {
        TreeNode treeNode;
        int state;

        State(TreeNode treeNode, int state){
            this.treeNode = treeNode;
            this.state = state;
        }
    }


}
