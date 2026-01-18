package leetcode.tree;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

public class ConvertArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums == null) {
            return null;
        }

        int start = 0;
        int end = nums.length-1;

        TreeNode root = createBST(nums,start,end);
        return root;

    }

    TreeNode createBST(int[] nums,int start,int end) {

        if(start > end) {
            return null;
        }

        int mid = ((start + end) + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left =  createBST(nums,start,mid-1);
        root.right = createBST(nums,mid+1,end);

        return root;

    }
}
