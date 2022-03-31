
public class NextPermutation {
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static void reverse(int[] a, int s, int e) {
        while(s < e) {
            swap(a, s++, e--);
        }
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i>=0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if(i >= 0) {
            int j = nums.length-1;
            while(nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, nums.length-1);
    }
}
