
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null;
        ListNode curr = head;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
