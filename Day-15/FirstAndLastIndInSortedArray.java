
public class FirstAndLastIndInSortedArray {
    static int firstIndex(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                index = mid;
                high = mid - 1;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return index;
    }
    static int lastIndex(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                index = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return index;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = firstIndex(nums, target);
        if(first == -1) {
            return new int[] {-1, -1};
        }
        return new int[] {first, lastIndex(nums, target)};
    }
}
