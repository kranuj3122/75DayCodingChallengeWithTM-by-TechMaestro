import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<k; i++) {
            while(dq.size() != 0 && dq.peekLast() < nums[i]) {
                dq.pollLast();
            }
            dq.addLast(nums[i]);
        }
        int j=0;
        int[] ans = new int[n-k+1];
        for(int i=k; i<n; i++) {
            ans[j] = dq.peekFirst();
            if(nums[j] == dq.peekFirst()) {
                dq.pollFirst();
            }
            while(dq.size() != 0 && dq.peekLast() < nums[i]) {
                dq.pollLast();
            }
            dq.addLast(nums[i]);
            j++;
        }
        ans[j] = dq.peekFirst();
        
        return ans;
    }
}
