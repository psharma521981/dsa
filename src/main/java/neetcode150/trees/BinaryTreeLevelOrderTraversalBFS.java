package src.neetcode150.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalBFS {
    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // TODO: Write your code here
        //Check root and add it to level. Add root to Queue
        //while Queue is not empty, check the size of queue. Each queue iteration for each level and add the left and right child
        //in to queue.
        if(root==null)
            return result;

        Queue<TreeNode> levelOrder = new LinkedList<>();

        levelOrder.add(root);

        while(!levelOrder.isEmpty()) {
            int size = levelOrder.size();
            List<Integer> levelElement = new ArrayList<>();
            for(int i=1;i<=size;i++) {
                TreeNode node = levelOrder.poll();
                levelElement.add(node.val);
                if(node.left!=null)
                    levelOrder.add(node.left);
                if(node.right!=null)
                    levelOrder.add(node.right);
            }
            result.add(levelElement);
        }
        return result;
    }
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalDFS sol = new BinaryTreeLevelOrderTraversalDFS();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = sol.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
