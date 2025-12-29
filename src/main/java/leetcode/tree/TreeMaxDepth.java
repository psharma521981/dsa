package leetcode.tree;

public class TreeMaxDepth {
    public int maxDepth(TreeNode root) {

        if(root==null)
            return 0;

        return calculateDepth(root);
    }

    int calculateDepth(TreeNode root) {

        if(root==null)
            return 0;

        int l = calculateDepth(root.left);
        int r = calculateDepth(root.right);

        return 1 + Math.max(l,r);
    }
}
