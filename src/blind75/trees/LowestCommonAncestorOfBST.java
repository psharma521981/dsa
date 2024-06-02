package src.blind75.trees;

public class LowestCommonAncestorOfBST {
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root==null)
            return -1;

       if(root.val > p && root.val > q) {
           //p and q must be left side of the tree
           root = root.left;
       } else if(root.val < p && root.val < q) {
           //p and q must be right side of the tree
            root = root.right;
        } else{
            //this mean one is right side of root and other is left side of root (p or q)
            return root.val;
        }
        return lowestCommonAncestor(root,p,q);
    }
}
