import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n-2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int j = i+1, k = n-1;
            while(j < k) {
                if(nums[j]+nums[k] == target) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j<n-1 && nums[j]==nums[j+1]) {
                        j++;
                    }
                    while(k>0 && nums[k]==nums[k-1]) {
                        k--;
                    }
                    j++;
                    k--;  
                }
                else if(nums[j]+nums[k] > target) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return ans;
    }
}
