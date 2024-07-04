package fast_slow_pointers;

public class Start_of_LinkedList_Cycle {
    public static ListNode findCycleStart(ListNode head) {
        if(head==null)
        return head;

        ListNode slow;
        ListNode fast;
        ListNode entry;

        slow = fast = entry = head;

        while(fast!=null && fast.next!=null) {

            fast = fast.next.next;
            slow = slow.next;

            if(slow==fast) {
                while(slow!=entry) {
                    entry=entry.next;
                    slow=slow.next;
                }
                return entry;
            }
        }

        return null;




    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " +
                Start_of_LinkedList_Cycle.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " +
                Start_of_LinkedList_Cycle.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " +
                Start_of_LinkedList_Cycle.findCycleStart(head).value);
    }
}
