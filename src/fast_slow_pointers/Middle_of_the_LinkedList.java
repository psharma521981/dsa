package fast_slow_pointers;

public class Middle_of_the_LinkedList {

    public static ListNode findMiddle(ListNode head) {
        // TODO: Write your code here

        if(head==null || head.next==null)
            return head;

        ListNode slow =head;
        ListNode fast =head;

        while(fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        if(fast.next==null)
            return slow;

            return slow.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle Node: " + Middle_of_the_LinkedList.findMiddle(head).value);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + Middle_of_the_LinkedList.findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + Middle_of_the_LinkedList.findMiddle(head).value);
    }
}
