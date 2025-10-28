package neetcode150.trees.prectice;

public class MaxDepthOfBinaryTree {
    int maxPath = 0;
    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        int leftMaxPath = maxDepth(root.left);
        int rightMaxPath = maxDepth(root.right);
        int nodeMaxPath = Math.max(leftMaxPath,rightMaxPath);
        maxPath = Math.max(maxPath,nodeMaxPath);

        return 1 + nodeMaxPath;
    }
}
