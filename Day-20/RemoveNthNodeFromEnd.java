
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;
        while(n-- > 0) {
            head = head.next;
        }
        ListNode nthNode = dummy;
        while(head.next != null) {
            head = head.next;
            nthNode = nthNode.next;
        }
        nthNode.next = nthNode.next.next;
        return dummy.next;
    }
}
