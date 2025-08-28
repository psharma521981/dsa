package linked_list;
class DoublyLinkedNode {
    int val;
    DoublyLinkedNode next;
    DoublyLinkedNode prev;

    DoublyLinkedNode() {}
    DoublyLinkedNode(int val)
    { this.val = val; }

    DoublyLinkedNode(int val, DoublyLinkedNode next)
    { this.val = val; this.next = next; }
}
    public class ReverseADoublyLinkedList {
        static DoublyLinkedNode head;
    public static void main(String s[]) {
        ReverseADoublyLinkedList list = new ReverseADoublyLinkedList();

        /* Let us create a sorted linked list to test the
         functions Created linked list will be 10->8->4->2
       */
        list.push(2);
        list.push(4);
        list.push(8);
        list.push(10);

        System.out.println("Original linked list ");
        list.printList(head);

        // Function call
        list.reverseDoublyList();

        System.out.println("");
        System.out.println("The reversed Linked List is ");
        list.printList(head);
    }
        void push(int new_data)
        {
            /* allocate node */
            DoublyLinkedNode new_node = new DoublyLinkedNode(new_data);

        /* since we are adding at the beginning,
         prev is always NULL */
            new_node.prev = null;

            /* link the old list of the new node */
            new_node.next = head;

            /* change prev of head node to new node */
            if (head != null) {
                head.prev = new_node;
            }

            /* move the head to point to the new node */
            head = new_node;
        }

        public void reverseDoublyList() {

        DoublyLinkedNode current = head;
        DoublyLinkedNode tmp = null;

        while(current !=null) {
           tmp = current.prev;
           current.prev = current.next;
           current.next = tmp;
           current = current.prev;
        }
        if(tmp !=null) {
            head = tmp.prev;
        }
    }
        void printList(DoublyLinkedNode node)
        {
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
        }
}
