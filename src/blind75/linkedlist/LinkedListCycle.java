package src.blind75.linkedlist;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        if(head==null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next != null) {
             fast=fast.next.next;
             slow= slow.next;

            if(slow==fast)
                return true;
        }

        return false;
    }
    public static void main(String[] args) {
        LinkedListCycle sol = new LinkedListCycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + sol.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next; // Creating a cycle by connecting the last node to the third node.
        System.out.println("LinkedList has cycle: " + sol.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next; // Creating a cycle by connecting the last node to the fourth node.
        System.out.println("LinkedList has cycle: " + sol.hasCycle(head));
    }
}
