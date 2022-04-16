import java.util.*;

public class NextGreaterElement_II {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        for(int i=n-1; i>=0; i--) {
            stk.push(nums[i]);
        }
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!stk.empty() && stk.peek() <= nums[i]) {
                stk.pop();
            }
            if(stk.empty()) {
                ans[i] = -1;
            }
            else {
                ans[i] = stk.peek();
            }
            stk.push(nums[i]);
        }
        return ans;
    }
}
