package cracking.coding.interview.tree;

/**
 * Created by avinashkumarmishra on 26/03/22.
 *
 *  PredessorAndSuccessor
 *
 **/


public class PredessorAndSuccessor {

    static GenericTree predessor = null;
    static GenericTree successor = null;
    static int state = 0;

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        find(root, 110);

        System.out.println("predessor "+predessor.data);

        System.out.println("successor "+successor.data);
    }


    private static void find(GenericTree node, int ele) {
        if(state == 0) {
            if(node.data == ele) {
                state = 1;
            } else {
                predessor = node;
            }
        } else if(state == 1) {
            state = 2;
            successor = node;
            return;
        }

        for(GenericTree child : node.children) {
            find(child, ele);
        }

    }

}