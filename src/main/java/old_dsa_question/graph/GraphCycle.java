package src.miscellaneously.old.dsa.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphCycle {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Populate the data for graph

        Node root = null;

        new GraphCycle().checkGraphCycle(root);
        //

    }

    private boolean checkGraphCycle(Node root) {

        if (root == null)
            return false;

        Set<Integer> visted = new HashSet<>();
        visted.add(root.val);

        for (Node n : root.children) {

            if (n != null && n.children != null) {

                if (visted.contains(n.val)) {
                    return true;
                } else {
                    visted.add(n.val);
                }
            }
        }
        return false;
    }

}

class Node {

    int val;
    List<Node> children;

}

/*
 * 
 * 
 * Map<Integer,List<Node>> nodeList = new HashMap<>();
 * 
 * 1 -> 0 2 -> 0 3 -> 0 4 -> 1 5 -> 1 8 -> 4 9 -> 4 6 -> 3 7 -> 3 10 -> 6 11 ->
 * 6 9 -> 5
 * 
 * Vertex(0, 1), Vertex(0, 2), Vertex(0, 3), Vertex(1, 4), Vertex(1, 5),
 * Vertex(4, 8), Vertex(4, 9), Vertex(3, 6), Vertex(3, 7), Vertex(6, 10),
 * Vertex(6, 11), Vertex(5, 9)
 * 
 * 
 */