package tree;

public class SumOfPathNumbers {

    public int findSumOfPathNumbers(TreeNode root) {

        if(root == null)
            return 0;

        return findSumOfAllPath(root,0);
    }

    private int findSumOfAllPath(TreeNode root, int sum) {
        if(root == null)
            return 0;

        sum = sum * 10 + root.val;

        if(root.left == null && root.right == null) {
            return sum;
        }
        return findSumOfAllPath(root.left,sum) + findSumOfAllPath(root.right,sum);



    }
    public static void main(String[] args) {
        SumOfPathNumbers sol = new SumOfPathNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " +
                sol.findSumOfPathNumbers(root));
    }
}
