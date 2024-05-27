package tree;

import java.util.*;

public class ReverseLevelOrderTraversal {
   /* public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        // TODO: Write your code here
        if(root==null)
            return result;
        dfs(root,result,0);
        return result;
    }*/

    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        // TODO: Write your code here
        if(root==null)
            return result;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while(!treeNodeQueue.isEmpty()) {
            int queueSize = treeNodeQueue.size();
            List<Integer> level = new ArrayList<>(queueSize);

            for(int i=0;i<queueSize;i++) {
                TreeNode node = treeNodeQueue.poll();
                if (node != null) {
                    level.add(node.val);
                    treeNodeQueue.add(node.left);
                    treeNodeQueue.add(node.right);
                 }
            }
            if(!level.isEmpty())
                result.add(0,level);
        }

        return result;
    }

    private void dfs(TreeNode root,List<List<Integer>> result,int level) {
        if(root==null)
            return;

        if(result.size() == level) {
            List<Integer> treeLevel = new ArrayList<>();
            result.add(0,treeLevel);
        }

        result.get(0).add(root.val);

        if(root.left!=null)
            dfs(root.left,result,level+1);

        if(root.right!=null)
            dfs(root.right,result,level+1);

    }
    public static void main(String[] args) {
        ReverseLevelOrderTraversal sol = new ReverseLevelOrderTraversal();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = sol.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
