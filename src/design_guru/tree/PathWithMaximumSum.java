package tree;

public class PathWithMaximumSum {
    private static int globalMaximumSum;

    //Validate the input
    //DFS and for each node calculate path from left + right + self node
    //If current path is greater thand max then stored the path

    public int findMaximumPathSum(TreeNode root) {
        globalMaximumSum = Integer.MIN_VALUE;
        calculatePathSum(root);
        return globalMaximumSum;
    }

    private int calculatePathSum(TreeNode root) {
        if(root == null)
            return 0;

        int leftPathSum = calculatePathSum(root.left);
        int rightPathSum = calculatePathSum(root.right);
        // ignore paths with negative sums, since we need to find the maximum sum we should
        // ignore any path which has an overall negative sum.
        leftPathSum = Math.max(leftPathSum,0);
        rightPathSum = Math.max(rightPathSum,0);

        // maximum path sum at the current node will be equal to the sum from the left
        // subtree + the sum from right subtree + val of current node
        // update the global maximum sum

        globalMaximumSum = Math.max(globalMaximumSum,root.val + leftPathSum + rightPathSum);
        // maximum sum of any path from the current node will be equal to the maximum of
        // the sums from left or right subtrees plus the value of the current node
        return root.val + Math.max(leftPathSum,rightPathSum);
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
