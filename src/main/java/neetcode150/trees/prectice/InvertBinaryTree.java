package neetcode150.trees.prectice;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {

        if(root == null)
            return root;

        invertTree(root.left);
        invertTree(root.right);

        if(root.left !=null || root.right !=null) {
            TreeNode swap;
            swap = root.left;
            root.left = root.right;
            root.right = swap;
        }
        return root;

    }
}
