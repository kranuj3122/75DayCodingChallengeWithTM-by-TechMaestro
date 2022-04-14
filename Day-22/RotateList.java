
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        int n = 0;
        ListNode curr = head;
        while(curr != null) {
            n++;
            curr = curr.next;
        }
        k %= n;
        if(k==0) {
            return head;
        }
        curr = head;
        k = n - k;
        while(--k > 0) {
            curr = curr.next;
        }
        
        ListNode ans = curr.next;
        curr.next  = null;
        
        curr = ans;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        
        return ans;
    }
}
