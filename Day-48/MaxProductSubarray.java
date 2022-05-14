
public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int l = 1, r = 1;
        int ans = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++) {
            if(l == 0) {
                l = 1;
            }
            if(r == 0) {
                r = 1;
            }
            
            l *= nums[i];
            r *= nums[n-1-i];
            
            ans = Math.max(ans, Math.max(l, r));
        }
        
        return ans;
    }
}