package leetcode.linked_list;

import java.util.Stack;

// https://leetcode.com/problems/next-greater-node-in-linked-list/description/
public class NextGreaterNodeInLinkedList {
    class Tupel {
        int index;
        int val;

        Tupel(int a,int b) {
            index= a;
            val= b;
        }
    }
     class ListNode {
     int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public int[] nextLargerNodes(ListNode head) {

        if(head == null) {
            return new int[0];
        }
        int index = 0;
        Stack<Tupel> nextGreaterStack = new Stack<>();

        ListNode start = head;
        while(start !=null) {
            index++;
            start= start.next;
        }


        int[] output = new int[index];

        index = 0;
        while(head !=null) {

            while(!nextGreaterStack.empty() && nextGreaterStack.peek().val < head.val) {
                Tupel t = nextGreaterStack.pop();
                output[t.index] = head.val;
            }
            nextGreaterStack.push(new Tupel(index++,head.val));
            head = head.next;
        }

        while(!nextGreaterStack.empty()) {
            Tupel t = nextGreaterStack.pop();
            output[t.index] = 0;
        }

        return output;
    }
}
