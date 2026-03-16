package src.miscellaneously.old.dsa.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BNode {
    int data;
    BNode left = null, right = null;

    public BNode(int data) {
        this.data = data;
    }
}

public class BinaryTreeToBST_AWS {
    static int index = 0;

    public static void main(String[] args) {
        BNode root = new BNode(8);
        root.left = new BNode(3);
        root.right = new BNode(5);
        root.left.left = new BNode(10);
        root.left.right = new BNode(2);
        root.right.left = new BNode(4);
        root.right.right = new BNode(6);

        convertBinaryTree(root);
        inorder(root);

    }

    public static void inorder(BNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    // Tree traversal and get fill the array
    // Sort the Array
    // Make the Inorder Traversal to form BST

    public static BNode convertBinaryTree(BNode root) {

        if (root == null)
            return root;
        List<Integer> list = new ArrayList<>();
        convertBinaryTreeToArray(root, list);

        Collections.sort(list);
        System.out.println(list);
        int[] inputArr = list.stream().mapToInt(Integer::intValue).toArray();

        convertArrayToBST(root, inputArr);

        return root;
    }

    private static void convertArrayToBST(BNode root, int[] list) {
        if (root == null)
            return;

        convertArrayToBST(root.left, list);
        root.data = list[index];
        index++;
        convertArrayToBST(root.right, list);

    }

    private static void convertBinaryTreeToArray(BNode root, List<Integer> list) {

        if (root == null)
            return;

        list.add(root.data);
        convertBinaryTreeToArray(root.left, list);
        convertBinaryTreeToArray(root.right, list);

    }

}
