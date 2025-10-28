package neetcode150.trees.prectice;
/*
Given a binary tree, return true if it is height-balanced and false otherwise.

A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class BalancedBinaryTree {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {

        calculateHeight(root);
        return isBalanced;
    }
    int calculateHeight(TreeNode root) {
        if(root == null)
            return 0;

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }


        return 1 + Math.max(leftHeight,rightHeight);
    }
}
