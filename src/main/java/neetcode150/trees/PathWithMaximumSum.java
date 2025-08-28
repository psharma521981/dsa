package src.neetcode150.trees;

public class PathWithMaximumSum {
    private static int globalMaximumSum;

    public int findMaximumPathSum(TreeNode root) {
        globalMaximumSum = Integer.MIN_VALUE;

        maximumPathSum(root);
        return globalMaximumSum;
    }

    private int maximumPathSum(TreeNode root) {

        if(root==null)
            return 0;

        //Calculate left path sum
        //Calculate right path sum
        //Get the max between left and right path sum
        //Add node value and return to it's paraent

        int leftPathSum = maximumPathSum(root.left);
        int rightPathSum = maximumPathSum(root.right);

        leftPathSum = Math.max(leftPathSum,0);
        rightPathSum = Math.max(rightPathSum,0);

        int localPathSum = leftPathSum + rightPathSum + root.val;

        globalMaximumSum = Math.max(globalMaximumSum,localPathSum);

        return Math.max(leftPathSum,rightPathSum) + root.val;

    }

    public static void main(String[] args) {
        PathWithMaximumSum sol = new PathWithMaximumSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + sol.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + sol.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + sol.findMaximumPathSum(root));
    }
}
