package leetcode.tree;

import java.util.*;

public class VerticalOrderTraversalOfaBinaryTree {
    static class Tupal {
        TreeNode node;
        int row;
        int col;

        public Tupal(TreeNode node, int r, int c) {
            this.node = node;
            this.row = r;
            this.col = c;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if(root == null)
            return null;

        Queue<Tupal> bfsQueue = new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> verticalOrderMap = new TreeMap<>();

        bfsQueue.add(new Tupal(root, 0, 0));

        while(!bfsQueue.isEmpty()) {

            Tupal tupal = bfsQueue.poll();
            TreeNode node = tupal.node;

            TreeMap<Integer,PriorityQueue<Integer>> level = new TreeMap<>();

            if(verticalOrderMap.containsKey(tupal.col)) {
                level = verticalOrderMap.get(tupal.col);
                if(level.containsKey(tupal.row)) {
                    level.get(tupal.row).add(tupal.node.val);
                } else {
                    PriorityQueue<Integer> pQueue = new PriorityQueue<>();
                    pQueue.add(tupal.node.val);
                    level.put(tupal.row,pQueue);
                    verticalOrderMap.put(tupal.col,level);
                }
            } else {
                PriorityQueue<Integer> pQueue = new PriorityQueue<>();
                pQueue.add(tupal.node.val);
                level.put(tupal.row,pQueue);
                verticalOrderMap.put(tupal.col,level);
            }
            if(node.left !=null) {
                bfsQueue.add(new Tupal(node.left, tupal.row + 1, tupal.col - 1));
            }
            if(node.right !=null) {
                bfsQueue.add(new Tupal(node.right, tupal.row + 1, tupal.col + 1));
            }
        }
        List<List<Integer>> output = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> mapValues: verticalOrderMap.values()) {
            output.add(new ArrayList<>());
            for(PriorityQueue<Integer> queue: mapValues.values()) {

                while(!queue.isEmpty()) {
                    output.get(output.size() - 1).add(queue.poll());
                }
            }
        }

        return output;
    }
}
