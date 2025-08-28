package k_way_merge;

import java.util.PriorityQueue;

class ListNode {
    int val; ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
public class MergeKSortedLists {
    //Validate the input
    //Assume that all the list are sorted
    //Craete Heap and add root of each list
    private ListNode merge(ListNode[] listNodes) {
        if(listNodes==null)
            return null;

        ListNode root = null;
        ListNode tail = null;
        PriorityQueue<ListNode> mergeQueue = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);

        for(int i=0;i<listNodes.length;i++) {
            if(listNodes[i]!=null)
            mergeQueue.add(listNodes[i]);
        }
        ListNode tmp;
        while(!mergeQueue.isEmpty()) {
            tmp = mergeQueue.poll();
            if(root==null) {
                root=tail=tmp;
            } else {
                if(tmp !=null) {
                    tail.next = tmp;
                    tail = tail.next;
                }
            }
            if(tmp.next!=null)
                mergeQueue.add(tmp.next);
        }

        return root;
    }
    public static void main(String[] args) {
        MergeKSortedLists sol = new MergeKSortedLists();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = sol.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
