package neetcode150.trees.prectice;
/*
Given a binary search tree (BST) where all node values are unique, and two nodes from the tree p and q, return the lowest common ancestor (LCA) of the two nodes.

The lowest common ancestor between two nodes p and q is the lowest node in a tree T such that both p and q as descendants. The ancestor is allowed to be a descendant of itself.
 */
public class LowestCommonAncestorinBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root ==null || root.val==p.val || root.val==q.val)
            return root;

        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);

        if(l!=null && r!=null)
            return root;

        if(l==null && r!=null)
            return r;

        return l;
    }

}
