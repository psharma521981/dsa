package linked_list;

//One approach to use stack data structire to put all the nodes into starck
//After that start poping out all elelemnt and create the link in between then. Peek element is start element
//Other approach is to traverse the linked list and reverse the link
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val)
      { this.val = val; }
      ListNode(int val, ListNode next)
      { this.val = val; this.next = next; }}

public class ReverseALinkedList {
    public ListNode reverseList(ListNode head) {

        return reverseList(head,null);
    }
    public ListNode reverseList(ListNode head,ListNode newHead) {
        if(head==null)
            return newHead;

        ListNode next  = head.next;
        head.next = newHead;
        return reverseList(next,head);
    }
    public static void main(String s[]) {

    }
}
