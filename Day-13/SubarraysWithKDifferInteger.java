
public class SubarraysWithKDifferInteger {
    static int solve(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j < n) {
            if(mp.getOrDefault(nums[j], 0) == 0) {
                k--;
            }
            mp.put(nums[j], mp.getOrDefault(nums[j], 0)+1);
            while(k < 0) {
                mp.put(nums[i], mp.get(nums[i])-1);
                if(mp.get(nums[i]) == 0) {
                    k++;
                }
                i++;
            }
            ans += (j-i+1);
            j++;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        // exactly(k) == atMost(k) - atMost(k-1)
        return solve(nums, k) - solve(nums, k-1);
    }
}
