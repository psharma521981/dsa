package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null)
            return root;

        swapOddLevel(root);

        return root;
    }
    public void swapOddLevel(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int level = 0;
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> levelNodes = new LinkedList<>();
            for(int i=1;i<=size;i++) {
                TreeNode node =  queue.poll();
                levelNodes.add(node);
                if(node.left !=null )
                    queue.add(node.left);
                if(node.right !=null)
                    queue.add(node.right);
            }
            if(level % 2 ==1) {
                int left = 0;
                int right = levelNodes.size() - 1;
                while (left < right) {
                    int tmp = levelNodes.get(left).val;
                    levelNodes.get(left).val = levelNodes.get(right).val;
                    levelNodes.get(right).val = tmp;
                    left++;
                    right--;
                }
            }
            level++;
        }
    }
    public static void main(String s[]) {

    }
}
