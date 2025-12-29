package leetcode.tree;

public class DiameterOfBinaryTree {
    int _max_diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {


        if(root == null)
            return 0;

        calculateDiameter(root);
        return _max_diameter;
    }
    private int calculateDiameter(TreeNode root) {

        if(root==null)
            return 0;

        int l = calculateDiameter(root.left);
        int r = calculateDiameter(root.right);

        _max_diameter = Math.max(_max_diameter, l + r);

        return 1 + Math.max(l,r);

    }
}
