package util;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 14/09/21.
 */
public class BinaryTreeNode<T> {

    public T data;

    public BinaryTreeNode<T> left, right;

    public BinaryTreeNode(){
        data = null;
        left = right = null;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        //level order traversal
        Deque<BinaryTreeNode<T>> traversal = new LinkedList<>();

        traversal.add(this);
        StringBuilder finalOutput  = new StringBuilder();

        while(!traversal.isEmpty()) {
            int size = traversal.size();

            StringBuilder res  = new StringBuilder();

            for(int i = 1; i <= size; i++) {
                BinaryTreeNode<T> rem = traversal.remove();

                res.append(rem.data +"   ");

                if(rem.left != null)
                    traversal.add(rem.left);

                if(rem.right != null)
                    traversal.add(rem.right);

            }
            finalOutput.append(res).append("\n");
        }
        return finalOutput.toString();
    }
}
