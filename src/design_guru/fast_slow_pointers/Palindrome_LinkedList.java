package fast_slow_pointers;

public class Palindrome_LinkedList {
    public static boolean isPalindrome(ListNode head) {
       if(head==null)
        return false;

        ListNode start;
        ListNode mid;
        int count = 0;
        int midPoint;

        start = head;

        while(start!=null) {
            count++;
            start = start.next;
        }
        midPoint = (count%2==0 || count==1) ? count/2 : ((count/2) + 2) ;
        count = 0;
        start=head;

        while(count!=midPoint) {
            count++;
            start = start.next;
        }
        mid = start;
        start = head;

        while(mid!=null) {
            if(start.value==mid.value) {
                start = start.next;
                mid = mid.next;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = null;
       /* head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);*/
        System.out.println("Is palindrome: " + Palindrome_LinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + Palindrome_LinkedList.isPalindrome(head));
    }
}
