package src.miscellaneously.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(4, 5, 6, 2, 3, 5);
        int sum = 0;
        // numberList.stream().filter(a -> a % 2 == 0).forEach(a ->
        // System.out.print(a));
        List<List<Node>> levelOrderTrverse = new ArrayList<>();
        Node root = new Node(1);
        Node rootLeft = new Node(2);
        Node rightChild = new Node(3);
        root.left = rootLeft;
        root.right = rightChild;

        levelOrder(root, 0, levelOrderTrverse);
        
        levelOrderTrverse.forEach(a -> {
            
            a.forEach(b -> System.out.print(b.val));
        });
    }

    public static void levelOrder(Node root, int level, List<List<Node>> levelOrderTrverse) {

        if (root == null)
            return;

        if (levelOrderTrverse.size() == level) {
            List<Node> levelList = new ArrayList<>();
            levelOrderTrverse.add(levelList);
        }
        levelOrderTrverse.get(level).add(root);

        levelOrder(root.left, level + 1, levelOrderTrverse);
        levelOrder(root.right, level + 1, levelOrderTrverse);

    }


}

class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}
