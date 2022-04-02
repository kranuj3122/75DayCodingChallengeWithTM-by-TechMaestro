import java.util.*;

public class SubArraySumDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        int sum = 0;
        for(int n: nums) {
            sum += n;
            int r = sum % k;
            if(r < 0) {
                r += k;
            }
            if(mp.containsKey(r)) {
                ans += mp.get(r);
                mp.put(r, mp.get(r)+1);
            }
            else {
                mp.put(r, 1);
            }
        }
        return ans;
    }
}
