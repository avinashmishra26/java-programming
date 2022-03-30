package cracking.coding.interview.tree;


/**
 * Created by avinashkumarmishra on 26/03/22.
 *
 *  2 Tree with Mirror Shape of 2 different tree
 *  (data check is not required just the tree structure)
 *
 **/

public class TreesMirrorShape {


    public static boolean isMirrorShape(GenericTree node1, GenericTree node2) {


        if(node1.children.size() != node2.children.size()) return false;


        int i = 0;
        int j = node2.children.size()-1;

        while( i < node1.children.size() && j >= 0){

            boolean test = isMirrorShape(node1.children.get(i) , node2.children.get(j));
            if(test == false){
                return false;
            }
            i--; j++;
        }
        return true;

    }
}