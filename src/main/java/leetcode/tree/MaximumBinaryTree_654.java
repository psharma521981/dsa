package leetcode.tree;

public class MaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if(nums == null)
            return null;

        return buildTree(nums,0,nums.length-1);
    }

    public TreeNode buildTree(int[] nums,int start,int end) {

        if(start > end) {
            return null;
        }

        int largest = nums[start];
        int idx = start;
        for(int i  = start + 1;i<=end;i++) {
            if(nums[i] > largest) {
                largest = nums[i];
                idx = i;
            }
        }
        TreeNode root = new  TreeNode(nums[idx],null,null);
        root.left = buildTree(nums,start,idx-1);
        root.right = buildTree(nums,idx+1,end);

        return root;
    }
}
