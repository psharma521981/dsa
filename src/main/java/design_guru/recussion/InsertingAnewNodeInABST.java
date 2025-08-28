package recussion;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class InsertingAnewNodeInABST {
    public TreeNode insert(TreeNode root, int value) {
        insertNode(root,value);
        return root;
    }

    private TreeNode insertNode(TreeNode root, int value) {

        if(root==null) {
            TreeNode newNode = new TreeNode(value);
            newNode.right = null;
            newNode.left = null;
            return newNode;
        }

        if(root.val < value) {
            root.right = insertNode(root.right, value);
        }

        if(root.val > value) {
            root.left = insertNode(root.left, value);
        }

        return root;
    }

    public static void main(String[] args) {
        // Example inputs
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int[] values = { 5, 4, 2 };

        InsertingAnewNodeInABST bstInsertion = new InsertingAnewNodeInABST();

        // Insert nodes into the BST
        for (int value : values) {
            root = bstInsertion.insert(root, value);
        }

        // Print the updated BST
        System.out.println("BST After Insertion:");
        printBST(root);
    }

    private static void printBST(TreeNode node) {
        if (node == null) {
            return;
        }
        printBST(node.left);
        System.out.print(node.val + " ");
        printBST(node.right);
    }
}
