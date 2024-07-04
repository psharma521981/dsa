package recussion;

public class RemovingNodesFromLinkedList {
    public static ListNode removeNodes(ListNode head, int target) {

        if(head==null)
            return null;

        if(head.val == target)
            return head.next;

        ListNode tmpHead = head;
        removeNodesHelper(tmpHead,target);
        return head;

    }

    private static void removeNodesHelper(ListNode tmpHead, int target) {
        if(tmpHead == null || tmpHead.next == null) {
            return;
        }

        if(tmpHead.next.val == target) {
            tmpHead.next = tmpHead.next.next;
        }
        removeNodesHelper(tmpHead.next,target);
    }

    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(2);

        System.out.print("Original Linked List 1: ");
        printLinkedList(head1);

        // Remove nodes with value 2 from linked list
        ListNode modifiedHead1 = removeNodes(head1, 2);
        System.out.print("Modified Linked List 1: ");
        printLinkedList(modifiedHead1);

        // Example 2
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(2);

        System.out.print("Original Linked List 2: ");
        printLinkedList(head2);

        // Remove nodes with value 2 from linked list
        ListNode modifiedHead2 = removeNodes(head2, 2);
        System.out.print("Modified Linked List 2: ");
        printLinkedList(modifiedHead2);

        // Example 3
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(3);
        head3.next.next = new ListNode(5);
        head3.next.next.next = new ListNode(7);

        System.out.print("Original Linked List 3: ");
        printLinkedList(head3);

        // Remove nodes with value 2 from linked list
        ListNode modifiedHead3 = removeNodes(head3, 2);
        System.out.print("Modified Linked List 3: ");
        printLinkedList(modifiedHead3);
    }
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
