package design_guru.recussion;

import design_guru.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BST_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {

        if(node==null)
            return;

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);

    }
    public static void main(String[] args) {
        // Example inputs
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BST_Inorder_Traversal inorderTraversal = new BST_Inorder_Traversal();
        List<Integer> result = inorderTraversal.inorderTraversal(root);

        System.out.println("Inorder Traversal: " + result);
    }
}
