package design_guru.tree;

import java.util.*;
//Validate the input
//Create a queue
//Insert root node and loop until queue is empty
//Create placeholder for each level by getiing the size of queue and add pop the lements of the queue. Add them to each level
//Check left and right child if not null then add them
public class BinaryTreeLevelOrderTraversalBFS {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root==null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> level = new ArrayList<>(queueSize);

            for(int i=0;i<queueSize;i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left !=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            result.add(level);
        }

        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = BinaryTreeLevelOrderTraversalBFS.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
