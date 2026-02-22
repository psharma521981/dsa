package leetcode.tree;

import java.util.*;

public class AverageOfEachLevel_637 {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> average = new ArrayList<>();

        if(root == null) {
            return average;
        }
        Queue<TreeNode> traverseTree = new LinkedList<>();

        traverseTree.add(root);

        while(!traverseTree.isEmpty()) {

            double sum = 0.0;

            int size = traverseTree.size();

            for(int i=1;i<=size;i++) {
                TreeNode element = traverseTree.poll();
                sum += element.val;

                if(element.left != null) {
                    traverseTree.add(element.left);
                }
                if(element.right != null) {
                    traverseTree.add(element.right);
                }
            }
            average.add(sum/size);
        }
        return average;
    }
}
