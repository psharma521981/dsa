package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAveragesInaBinaryTree {
    public List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if(root==null)
            return result;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while(!treeNodeQueue.isEmpty())
        {
            int size = treeNodeQueue.size();
            int sum = 0;
            TreeNode node = null;
            for(int i=0;i<size;i++) {
                node = treeNodeQueue.poll();
                if(node!=null) {
                    sum += node.val;
                    if(node.left!=null)
                    treeNodeQueue.add(node.left);
                    if(node.right!=null)
                    treeNodeQueue.add(node.right);
                }
            }
            result.add((double)sum/size);
        }
        return result;
    }
    public static void main(String[] args) {
        LevelAveragesInaBinaryTree sol = new LevelAveragesInaBinaryTree();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = sol.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
