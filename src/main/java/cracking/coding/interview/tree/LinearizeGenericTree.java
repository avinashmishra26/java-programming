package cracking.coding.interview.tree;

/**
 * Created by avinashkumarmishra on 09/02/22.
 *
 *  LinearizeGenericTree
 *
 *  Each node will have only one child which is in post-order traversal.
 *  Tree is now skeewed
 *
 */

public class LinearizeGenericTree {

    public static void main(String[] args) {

        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        linearConvert(root);

        GenericTreeConstruction.display(root);
    }

    private static void  linearConvert(GenericTree node) {


        for(GenericTree g : node.children) {
            linearConvert(g);
        }
        if(node.children.size() > 1) {
            int childIdx = 1;
            GenericTree first = node.children.get(0);

            while (first != null) {
                if (first.children.size() == 0) {
                    if (childIdx >= node.children.size()) break;

                    GenericTree attach = node.children.get(childIdx);
                    first.children.add(attach);
                    childIdx++;
                }
                first = first.children.get(0);
            }

            for (int i = node.children.size() - 1; i >= 1; i--)
                node.children.remove(node.children.get(i));
        }

    }

    private static void  linearConvertMethod2(GenericTree node) {


    }
}