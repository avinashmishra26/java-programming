package cracking.coding.interview.tree;


/**
 * Created by avinashkumarmishra on 26/03/22.
 *
 *  2 Tree with Similar Shape of 2 different tree
 *  (data check is not happening here)
 *
 **/


public class SimilarShape {


    private static boolean isSimilarShape(GenericTree node1, GenericTree node2) {

        if(node1.children.size() == node2.children.size()) {

            for(int i = 0; i < node1.children.size() ; i++) {
                boolean test = isSimilarShape(node1.children.get(i), node2.children.get(i));
                if(test == false) {
                    return test;
                }
            }
            return true;
        }

        return false;

    }
}