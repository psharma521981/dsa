package meta.lists;
/*
Given the pointer to the head node of a linked list and an integer to insert at a certain position,
create a new node with the given integer as its  attribute, insert this node at the desired position and return the head node.
A position of 0 indicates head, a position of 1 indicates one node away from the head and so on.
The head pointer given may be null meaning that the initial list is empty.
 */
public class InsertNodeInLinkedList {
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {

        if(llist == null)
            return null;

        SinglyLinkedListNode head = llist;
        int count  = 1;

        while(count<position) {
            head = head.next;
        }
        SinglyLinkedListNode newNode = new SinglyLinkedListNode();
        newNode.data = data;
        newNode.next = head.next;

        head.next = newNode;

        return llist;

    }
}
class SinglyLinkedListNode {
          int data;
          SinglyLinkedListNode next;
      }
