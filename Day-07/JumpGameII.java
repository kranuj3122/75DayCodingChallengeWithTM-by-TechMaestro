public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int l=0, r=0;
        int newR = 0;
        int jump = 0;
        while(r < n-1) {
            for(int i=l; i<=r; i++) {
                newR = Math.max(newR, i+nums[i]);
            }
            l = r+1;
            r = newR;
            jump++;
        }
        return jump;
    }
}
