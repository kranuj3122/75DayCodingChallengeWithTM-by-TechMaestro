
public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = -1;
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<n-2; i++) {
            int t = target - nums[i];
            int j = i+1, k = n-1;
            while(j < k) {
                int currDiff = Math.abs(target - nums[i] - nums[j] - nums[k]);
                if(currDiff < diff) {
                    // System.out.println(diff + " " + currDiff);
                    ans = nums[i] + nums[j] + nums[k];
                    diff = currDiff;
                }
                if(nums[j]+nums[k] == t) {
                    return target;
                }
                else if(nums[j]+nums[k] > t) {
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
