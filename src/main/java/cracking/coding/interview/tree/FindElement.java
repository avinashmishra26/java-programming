package cracking.coding.interview.tree;

/**
 * Created by avinashkumarmishra on 09/02/22.
 *
 *  FindElement in a tree
 *
 **/

public class FindElement {

    private static boolean  search(GenericTree node, int ele) {

        if(node.data == ele) return true;

        for(int i = 0 ; i < node.children.size(); i++) {
            boolean test = search(node.children.get(i), ele);
            if(test) return true;
        }
        return false;
    }
}