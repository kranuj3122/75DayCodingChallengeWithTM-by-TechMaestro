
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int k = n - 1;
        int[] ans = new int[n];
        while(i <= j) {
            if(nums[i]*nums[i] <= nums[j]*nums[j]) {
                ans[k] = nums[j]*nums[j];
                j--;
            }
            else {
                ans[k] = nums[i]*nums[i];
                i++;
            }
            k--;
        }
        return ans;
    }
}
