package cracking.coding.interview.tree;

/**
 * Created by avinashkumarmishra on 26/03/22.
 *
 *  LowestCommonAncestor in a tree
 *
 **/

public class LowestCommonAncestor {

    private static class LCA {
        int numberOfNodes = 0;
        GenericTree parent = null;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        LCA l = getLowestCommonAncestor(root, 50 , 120);
        if(l.numberOfNodes == 2) {
            System.out.print(l.parent.data);
        }


    }

    private static LCA getLowestCommonAncestor(GenericTree node, int ele1, int ele2) {

        if(node == null) return new LCA();

        LCA l = new LCA();
        for(GenericTree child : node.children) {
            LCA temp = getLowestCommonAncestor(child, ele1, ele2);
            l.numberOfNodes += temp.numberOfNodes;
            if(l.numberOfNodes == 2) {
                if(temp.parent == null) {
                    l.parent = node;
                    return l;
                }else {
                    return temp;
                }

            }
        }

        if(ele1 == node.data || ele2 == node.data) {
            l.numberOfNodes += 1;
            if(l.numberOfNodes == 2) {
                l.parent = node;
            }
        }
        return l;
    }
}