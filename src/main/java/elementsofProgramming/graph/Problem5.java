package elementsofProgramming.graph;

import java.util.*;

/**
 * Created by avinashkumarmishra on 06/10/21.
 * CLONE A GRAPH
 */
public class Problem5 {

    public static void main(String[] args) {

        Node node1 = new Node(1);

        Node node2 = new Node(2);

        Node node3 = new Node(3);

        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);


       Node newNode = cloneGraph(node1);

    }

    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Set<Integer> visited = new HashSet<>();

        Map<Integer, Node> map = new  HashMap<>();

        while (!queue.isEmpty()) {
            Node old =  queue.remove();
            if (!visited.contains(old.val)) {
                visited.add(old.val);
                if (!map.containsKey(old.val))
                    map.put(old.val, new Node(old.val));
                for (Node n : old.neighbors) {
                    if (!map.containsKey(n.val)) {
                        map.put(n.val, new Node(n.val));
                    }
                    Node t_neighbour = map.get(n.val);
                    List<Node> nei = map.get(old.val).neighbors;
                    nei.add(t_neighbour);
                    queue.add(n);
                }
            }
        }
        return map.get(node.val);
    }


}
