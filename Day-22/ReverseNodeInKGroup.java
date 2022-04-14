
public class ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;
        int n = -1;
        while(head != null) {
            n++;
            head = head.next;
        }
        ListNode prev = dummy;
        while(n >= k) {
            ListNode curr = prev.next;
            for(int i=1; i<k; i++) {
                ListNode next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
            n -= k;
        }
        return dummy.next;
    }
}
