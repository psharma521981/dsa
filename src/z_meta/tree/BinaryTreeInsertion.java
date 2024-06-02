package src.z_meta.tree;

class Node {
    int data;
    Node left;
    Node right;
}
public class BinaryTreeInsertion {
    public static Node insert(Node root,int data) {

        if(root==null) {
            Node newNode = new Node();
            newNode.left = null;
            newNode.right = null;
            newNode.data = data;
            return newNode;
        }

        if(root.data < data) {
            root.right = insert(root.right,data);
        }
        if(root.data > data) {
            root.left = insert(root.left,data);
        }
        return root;
    }
}
