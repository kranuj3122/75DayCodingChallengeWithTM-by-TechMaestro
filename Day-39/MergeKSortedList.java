
public class MergeKSortedList {
    public ListNode sort(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        curr.next = l1 != null ? l1 : l2;
        
        return dummy.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) {
            return null;
        }
        
        for(int i=n-2; i>=0; i--) {
            lists[i] = sort(lists[i], lists[i+1]);
        }
        
        return lists[0];
    }
}
