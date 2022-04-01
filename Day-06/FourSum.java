
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-3; i++) {
            if(i!=0 && nums[i-1] == nums[i]) {
                continue;
            }
            for(int j=i+1; j<n-2; j++) {
                if(j != i+1 && nums[j-1] == nums[j]) {
                    continue;
                }
                int k = j+1, l = n-1;
                int t = target - nums[i] - nums[j];
                while(k < l) {
                    if(nums[k]+nums[l] == t) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while(k+1 < n && nums[k]==nums[k+1]) {
                            k++;
                        }
                        k++;
                        while(l-1 >= 0 && nums[l]==nums[l-1]) {
                            l--;
                        }
                        l--;
                    }
                    else if(nums[k]+nums[l] > t) {
                        l--;
                    }
                    else {
                        k++;
                    }
                }
            }
        }
        return ans;
    }
}
