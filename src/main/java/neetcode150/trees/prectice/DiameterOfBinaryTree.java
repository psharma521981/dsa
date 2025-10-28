package neetcode150.trees.prectice;

public class DiameterOfBinaryTree {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        diameter(root);
        return maxDiameter;

    }
    int diameter(TreeNode root) {
        //Height of ny node if max of left vs right
        //diameter is height of left + height of right

        if (root == null) {
            return 0;
        }

        int leftTreeHeight =  diameter(root.left);
        int rightTreeHeight =  diameter(root.right);

        maxDiameter = Math.max (maxDiameter,leftTreeHeight+rightTreeHeight);
        return 1 + Math.max(leftTreeHeight,rightTreeHeight);
    }
}
