package neetcode150.linkedlist;

public class ReverseLinkedList {
    public neetcode150.linkedlist.ListNode reverse(neetcode150.linkedlist.ListNode head) {
        neetcode150.linkedlist.ListNode result = null;

        if (head == null || head.next==null)
            return result;

        neetcode150.linkedlist.ListNode prev = null;
        neetcode150.linkedlist.ListNode current = head;
        neetcode150.linkedlist.ListNode next = null;
        while(current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
    public static void main(String[] args) {
        ReverseLinkedList sol = new ReverseLinkedList();
        neetcode150.linkedlist.ListNode head = new neetcode150.linkedlist.ListNode(2);
        head.next = new neetcode150.linkedlist.ListNode(4);
        head.next.next = new neetcode150.linkedlist.ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = sol.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
