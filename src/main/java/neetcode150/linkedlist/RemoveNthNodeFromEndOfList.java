package neetcode150.linkedlist;

public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNth(ListNode head, int n) {

        if(head == null)
            return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        int count = 0;
        while(head !=null ) {
            count++;
            head =head.next;
        }
        head = dummy;
        int index = 0;
        while(head.next !=null) {
            if(index == count-n) {
                head.next = head.next.next;
                break;
            }
            index++;
            head = head.next;
        }


        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = RemoveNthNodeFromEndOfList.removeNth(head, 2);
        System.out.print("Nodes after removing the Nth node from the end: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
