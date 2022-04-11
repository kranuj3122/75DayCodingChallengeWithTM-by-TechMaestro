
public class SplitArrLargestSum {
    static int countSubarray(int[] nums, int mid) {
        int sum = 0;
        int count = 0;
        for(int n: nums) {
            sum += n;
            if(sum > mid) {
                sum = n;
                count++;
            }
        }
        return count+1;
    }
    public int splitArray(int[] nums, int m) {
        int l = 0;
        int r = 0;
        for(int n: nums) {
            l = Math.max(l, n);
            r += n;
        }
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(countSubarray(nums, mid) <= m) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return r+1;
    }
}
