
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high) {
            int mid = (low + high)/2;
            long prev = Long.MIN_VALUE;
            if(mid > 0) {
                prev = nums[mid-1];
            }
            long next = Long.MIN_VALUE;
            if(mid < n-1) {
                next = nums[mid+1];
            }
            if(nums[mid]>prev && nums[mid]>next) {
                return mid;
            }
            else if(nums[mid]>prev && nums[mid]<next) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
