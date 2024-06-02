package meta.lists;

import fast_slow_pointers.LinkedList_Cycle;
import fast_slow_pointers.ListNode;

/*
A linked list is said to contain a cycle if any node is visited more than once while traversing the list.
Given a pointer to the head of a linked list, determine if it contains a cycle. If it does, return . Otherwise, return .
 */
public class CycleDetection {

    static boolean hasCycle(ListNode head) {

        if(head==null || head.next == null)
            return false;

        ListNode slow,fast;

        slow=head;
        fast=head.next.next;
        boolean isCycle = false;
        while(fast!=null && fast.next!=null) {
           if(slow.value==fast.value) {
               isCycle=true;
               break;
           }
            slow = slow.next;
            fast = fast.next.next;
        }

        return isCycle;
    }
    static class ListNode {
        int value = 0;
      ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + CycleDetection.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + CycleDetection.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + CycleDetection.hasCycle(head));
    }
}
