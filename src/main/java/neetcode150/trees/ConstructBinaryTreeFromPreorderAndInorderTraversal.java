package src.neetcode150.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int preIndex = 0; // To keep track of the current index in the preorder traversal
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>(); // Map to quickly get the index of an element in inorder

    // Main function that is used to construct the binary tree from preorder and inorder
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // ToDo: Write Your Code Here.

        //create and populate inorder traversal map
        for(int i=0;i<inorder.length;i++) {
            inorderIndexMap.put(inorder[i],i);
        }

        return constructTree(preorder,0,inorder.length-1);
    }

    private TreeNode constructTree(int[] preorder, int start, int end) {

        if(start > end)
            return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        if(start==end)
            return root;

        int index = inorderIndexMap.get(root.val);

        root.left = constructTree(preorder,start,index-1);
        root.right = constructTree(preorder,index+1,end);

        return root;
    }
    public static void printTree(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of elements at the current level
            boolean isLastLevel = true;

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                if (curr != null) {
                    // Print the value of the current node
                    System.out.print(curr.val + " ");
                    queue.add(curr.left);
                    queue.add(curr.right);
                    // If any of the children is not null, this is not the last level
                    if (curr.left != null || curr.right != null) {
                        isLastLevel = false;
                    }
                } else {
                    System.out.print("null ");
                }
            }
            // After finishing a level, if it's the last level, break out of the loop
            if (isLastLevel) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal sol = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode root = sol.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        printTree(root); // Expected output: 3 9 20 null null 15 7
    }
}
