package design_guru.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalDFS {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root==null)
            return null;
        else
            levelOrderTraverse(root,result,0);
        return result;
    }

    private static void levelOrderTraverse(TreeNode root, List<List<Integer>> result,int level) {

        if(root!=null) {
                if (result.size() == level) {
                    List<Integer> levelEelements = new ArrayList<>();
                    levelEelements.add(root.val);
                    result.add(levelEelements);
                } else {
                    result.get(level).add(root.val);
                }
            levelOrderTraverse(root.left,result,level+1);
            levelOrderTraverse(root.right,result,level+1);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = BinaryTreeLevelOrderTraversalDFS.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
