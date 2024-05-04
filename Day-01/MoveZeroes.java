
public class MoveZeroes {
    // function to moveZeros
    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] != 0) {
                nums[nonZero++] = nums[i];
            }
        }
        while(nonZero < n) {
            nums[nonZero++] = 0;
        }
    }
}
