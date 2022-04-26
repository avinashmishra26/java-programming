package cracking.coding.interview.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by avinash on 15/04/2022.
 */
public class IterativeTraversal {

    public static void main(String[] args) {

        TreeNode t = ConstructBinaryTree.constructBT(new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null});

        ArrayList<Integer> pre = new ArrayList<>(), in = new ArrayList<>(),  post = new ArrayList<>();

        iterativeTravel(t, pre, in, post);

        System.out.println("pre " +pre);
        System.out.println("in " +in);
        System.out.println("post " +post);

    }
    private static void iterativeTravel(TreeNode node, ArrayList<Integer> pre,  ArrayList<Integer> in,  ArrayList<Integer> post) {

        ArrayDeque<State> stk = new ArrayDeque<>();
        stk.push(new State(node, 0));

        while(stk.size() > 0) {
            State stateValue = stk.peek();

            if(stateValue.state == 0) {
                pre.add(stateValue.node.data);
                stateValue.state++;
                if(stateValue.node.left != null) {
                    stk.push(new State(stateValue.node.left, 0));
                }
            } else if ( stateValue.state == 1) {
                in.add(stateValue.node.data);
                stateValue.state++;
                if(stateValue.node.right != null) {
                    stk.push(new State(stateValue.node.right, 0));
                }
            } else {
                post.add(stateValue.node.data);
                stk.pop();
            }
        }

    }

    private static class State {
        TreeNode node;
        int state;


        public State( TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
}
