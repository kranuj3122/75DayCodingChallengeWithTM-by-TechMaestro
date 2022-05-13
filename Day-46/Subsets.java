import java.util.*;

public class Subsets {
    public List<List<Integer>> ans;
    
    public void solve(int[] nums, int start, List<Integer> list) {
        ans.add(new ArrayList<>(list));
        
        for(int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            solve(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        solve(nums, 0, new ArrayList<>());
        return ans;
    }
}
