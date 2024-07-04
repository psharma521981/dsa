package tree;

public class TreeDiameter {
    private int treeDiameter = 0;

    public int findDiameter(TreeNode root) {
        calculateHeight(root);
        return treeDiameter;
    }
    private int calculateHeight(TreeNode root) {
        if(root==null)
            return 0;
        //Calculate height of current node
        int heightLeft = calculateHeight(root.left);
        int heightRight = calculateHeight(root.right);

        // height of the current node will be equal to the maximum of the heights of
        // left or right subtrees plus '1' for the current node
        int currentNodeHeight = Math.max(heightLeft,heightRight) + 1;

        //Calculate diameter of current node
        // if the current node doesn't have a left or right subtree, we can't have
        // a path passing through it, since we need a leaf node on each side
        if(heightLeft!=0 && heightRight!=0) {
            // diameter at the current node will be equal to the height of left subtree +
            // the height of right sub-trees + '1' for the current node
            // update the global tree diameter
            treeDiameter = Math.max(treeDiameter,1 + heightLeft + heightRight);
        }

        return currentNodeHeight;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        TreeDiameter sol = new TreeDiameter();
        System.out.println("Tree Diameter: " + sol.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + sol.findDiameter(root));
    }
}
