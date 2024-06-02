package src.blind75.trees;

//Match the both tree for every node in parent tree
//

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if(s==null)
            return false;

        return isMatch(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    private boolean isMatch(TreeNode s, TreeNode t) {

        if(s==null && t==null)
            return true;

        if(s==null || t==null)
            return false;

        if(s.val!=t.val)
            return false;

        return isMatch(s.left,t.left) || isMatch(s.right,t.right);
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree sol = new SubtreeOfAnotherTree();

        TreeNode s1 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode t1 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(sol.isSubtree(s1, t1));  // true

        TreeNode s2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2 = new TreeNode(2, new TreeNode(3), null);
        System.out.println(sol.isSubtree(s2, t2));  // false

        TreeNode s3 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)), new TreeNode(5));
        TreeNode t3 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(sol.isSubtree(s3, t3));  // false
    }

}
