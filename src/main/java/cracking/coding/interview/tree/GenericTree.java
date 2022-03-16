package cracking.coding.interview.tree;

import java.util.ArrayList;

public class GenericTree {
    int data;
    ArrayList<GenericTree> children = new ArrayList<>();

    GenericTree(int data) {
        this.data = data;
    }
}