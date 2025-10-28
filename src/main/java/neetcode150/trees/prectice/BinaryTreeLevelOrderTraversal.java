package neetcode150.trees.prectice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null)
            return output;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> level = new ArrayList();
            for(int i=1;i<=size;i++) {
                TreeNode tmp = nodeQueue.poll();
                level.add(tmp.val);
                if(tmp.left !=null)
                    nodeQueue.add(tmp.left);
                if(tmp.right !=null)
                    nodeQueue.add(tmp.right);
            }
            output.add(level);
        }

        return output;
    }
}
