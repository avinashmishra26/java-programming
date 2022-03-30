package cracking.coding.interview.tree;

import java.util.ArrayList;

/**
 * Created by avinashkumarmishra on 26/03/22.
 *
 *  DistanceBetweenNodes in a tree
 *
 **/

public class DistanceBetweenNodes {

    public static void main(String[] args) {

        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        ArrayList<Integer> a1 = new ArrayList<>();

       NodeToRootPath.nodeToRootPath(root, 70, a1);


        ArrayList<Integer> a2 = new ArrayList<>();

        NodeToRootPath.nodeToRootPath(root, 110, a2);


        int i  = a1.size() - 1;
        int j  = a2.size() - 1;

        while(i >= 0 && j >=0 && a1.get(i) == a2.get(j)){
            i--;
            j--;
        }
        i++; j++;

        System.out.print(i+j);
    }

}