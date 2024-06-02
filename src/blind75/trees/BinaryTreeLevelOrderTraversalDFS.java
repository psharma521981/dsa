package src.blind75.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalDFS {
    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // TODO: Write your code here
        levelOrderTraversal(result,root,0);
        return result;
    }

    private void levelOrderTraversal(List<List<Integer>> result, TreeNode root,int level) {

        if(root==null)
            return;

        if(level == result.size()) {
            List<Integer> levelElements = new ArrayList<>();
            result.add(levelElements);
        }
        result.get(level).add(root.val);
        levelOrderTraversal(result,root.left,level+1);
        levelOrderTraversal(result,root.right,level+1);
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
