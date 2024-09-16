package src.neetcode150.trees;

public class ValidateBinarySearchTree {
   /* public boolean isValidBST(TreeNode root) {

        if(root==null)
            return true;

        if(root.left !=null && root.val < root.left.val)
            return false;

        if(root.right !=null && root.val > root.right.val)
            return false;

        isValidBST(root.left);
        isValidBST(root.right);

        return true;
    }*/
   public boolean isValidBST(TreeNode root) {
       return validateBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
   }

    private boolean validateBST(TreeNode root, Integer min, Integer max) {

       if(root==null)
           return true;

       if(root.val < min || root.val > max)
           return false;

       return validateBST(root.left,min,root.val) && validateBST(root.right,root.val,max);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree sol = new ValidateBinarySearchTree();

        TreeNode example1 = new TreeNode(5);
        example1.left = new TreeNode(3);
        example1.right = new TreeNode(7);
        System.out.println(sol.isValidBST(example1));  // true

        TreeNode example2 = new TreeNode(5);
        example2.left = new TreeNode(7);
        example2.right = new TreeNode(3);
        System.out.println(sol.isValidBST(example2));  // false

        TreeNode example3 = new TreeNode(10);
        example3.left = new TreeNode(5);
        example3.right = new TreeNode(15);
        example3.right.left = new TreeNode(12);
        example3.right.right = new TreeNode(20);
        System.out.println(sol.isValidBST(example3));  // false
    }
}
