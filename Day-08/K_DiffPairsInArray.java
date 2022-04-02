import java.util.*;

public class K_DiffPairsInArray {
        public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int n: nums) {
            mp.put(n, mp.getOrDefault(n,0) + 1);
        }
        int ans = 0;
        for(int n: mp.keySet()) {
            if(k == 0 && mp.get(n+k)>1) {
                ans++;
            }
            else if(k>0 && mp.containsKey(n+k)) {
                ans++;
            }
        }
        return ans;
    }
}
