import java.util.*;

public class NextGreaterElement_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        int m = nums1.length;
        int n = nums2.length;
        for(int i=n-1; i>=0; i--) {
            while(!stk.empty() && stk.peek() <= nums2[i]) {
                stk.pop();
            }
            if(stk.empty()) {
                mp.put(nums2[i], -1);
            }
            else {
                mp.put(nums2[i], stk.peek());
            }
            stk.push(nums2[i]);
        }
        for(int i=0; i<m; i++) {
            nums1[i] = mp.get(nums1[i]);
        }
        return nums1;
    }
}
