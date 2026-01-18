package leetcode.tree;

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

public class SortLinkedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            TreeNode root = new TreeNode(head.val);
            root.left = null;
            root.right = null;
            return root;
        }

        ListNode slow  = head;
        ListNode fast = head;
        ListNode slow_prev = slow;
        while(fast!=null && fast.next !=null) {
            slow_prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow_prev.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;

    }
}
