package design_guru.tree;

import java.util.ArrayList;
import java.util.List;

public class AllPathsforASum {
    public List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        dfs(root,allPaths,sum,currentPath);

        return allPaths;
    }

    private void dfs(TreeNode root, List<List<Integer>> allPaths, int sum, List<Integer> currentPath) {

        if(root==null)
            return;

        currentPath.add(root.val);
        if(root.val == sum && root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            dfs(root.left,allPaths,sum-root.val,currentPath);
            dfs(root.right,allPaths,sum-root.val,currentPath);
        }
        currentPath.remove(currentPath.size()-1);
    }
    public static void main(String[] args) {
        AllPathsforASum sol = new AllPathsforASum();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = sol.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
