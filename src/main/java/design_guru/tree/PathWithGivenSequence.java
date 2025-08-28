package tree;

public class PathWithGivenSequence {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };
    public boolean findPath(TreeNode root, int[] sequence) {

        if(root==null || sequence.length < 1)
            return false;

        return checkPathExist(root,0,sequence);
    }

    private boolean  checkPathExist(TreeNode root, int index, int[] sequence) {

        if(root==null)
            return false;

        if(root.val == sequence[index] && ((index + 1) == sequence.length) && root.left == null && root.right==null)
            return true;

        return checkPathExist(root.left,index+1,sequence) ||  checkPathExist(root.right,index+1,sequence);
    }
    public static void main(String[] args) {
        PathWithGivenSequence sol = new PathWithGivenSequence();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " +
                sol.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " +
                sol.findPath(root, new int[] { 1, 1, 6 }));
    }
}
