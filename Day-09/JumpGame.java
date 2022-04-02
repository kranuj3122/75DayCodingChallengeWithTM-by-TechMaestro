
public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastPos = n- 1;
        int i = n-2;
        while(i>=0) {
            if(i + nums[i] >= lastPos) {
                lastPos = i;
            }
            i--;
        }
        return lastPos == 0;
    }
}
