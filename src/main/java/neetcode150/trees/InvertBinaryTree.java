package neetcode150.trees;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;

        TreeNode tmp;
        tmp=root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private static void invert(TreeNode root) {


        if(root.left!=null && root.right!=null) {

        } else if(root.left==null) {
            root.left = root.right;
        } else {
            root.right = root.left;
        }
    }
}
