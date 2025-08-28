package src.neetcode150.linkedlist;

public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        ListNode result = null;

        if (head == null || head.next==null)
            return result;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
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
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
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
