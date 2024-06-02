package src.blind75.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumber {

    //For array
    public int findKthSmallestNumber(int[] nums, int k) {

        if(nums==null || nums.length < k)
            return -1;

        PriorityQueue<Integer> smallestNumberHeap = new PriorityQueue<>(k,(a,b) -> a - b);
        for(int num:nums) {
            smallestNumberHeap.add(num);
        }
        for(int i=1;i<k;i++)
            smallestNumberHeap.poll();

        return smallestNumberHeap.poll();
    }

    //For BST
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
