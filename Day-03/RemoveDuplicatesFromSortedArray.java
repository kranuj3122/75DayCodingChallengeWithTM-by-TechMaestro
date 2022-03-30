
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int prevNum = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(prevNum != nums[i]) {
                nums[k++] = nums[i];
                prevNum = nums[i];
            }
        }
        return k;
    }
}
