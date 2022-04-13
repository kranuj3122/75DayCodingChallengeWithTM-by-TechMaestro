
public class AddTwoNumbersII {
    static ListNode reverse(ListNode head) {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            curr.next = new ListNode(val%10);
            curr = curr.next;
            carry = val/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int val = l1.val + carry;
            curr.next = new ListNode(val%10);
            curr = curr.next;
            carry = val/10;
            l1 = l1.next;
        }
        while(l2 != null) {
            int val = l2.val + carry;
            curr.next = new ListNode(val%10);
            curr = curr.next;
            carry = val/10;
            l2 = l2.next;
        }
        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return reverse(dummy.next);
    }
}
