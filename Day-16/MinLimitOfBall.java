
public class MinLimitOfBall {
    static int operationRequired(int[] nums, int mid) {
        int count = 0;
        for(int n: nums) {
            count += (n/mid);
            if(n%mid == 0) {
                count--;
            }
        }
        return count;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = 0;
        for(int n: nums) {
            r = Math.max(n, r);
        }
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(operationRequired(nums, mid) <= maxOperations) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return r+1;
    }
}
