package monotonic_stack;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveNodesFromLinkedList {
    //Check for input validation
    //Initialize ans stack of node type
    //if stack is empty then store the element and initialize the head
    //else check if stack peek is less than the node value then pop the element. At last attche peek next to current element
    //this way stack having nodes in decreasing order of value. Now return first element.

    public ListNode removeNodes(ListNode head) {

        Stack<ListNode> nodeStack = new Stack<>();
        ListNode cursor = head;

        while(cursor!=null) {

            while(!nodeStack.empty() && cursor.val > nodeStack.peek().val) {
                nodeStack.pop();
            }

            if(!nodeStack.empty()) {
                nodeStack.peek().next = cursor;
            }
            nodeStack.push(cursor);
            cursor = cursor.next;

        }
        if(!nodeStack.empty()) {
            return nodeStack.firstElement();
        }
        return null;
    }
    public static void main(String[] args) {
        RemoveNodesFromLinkedList solution = new RemoveNodesFromLinkedList();

        // Creating the linked list 5 -> 3 -> 7 -> 4 -> 2 -> 1
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(7);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(2);
        head1.next.next.next.next.next = new ListNode(1);
        head1 = solution.removeNodes(head1);

        // Printing the modified list: 7 -> 4 -> 2 -> 1
        ListNode node = head1;
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
    }
}
