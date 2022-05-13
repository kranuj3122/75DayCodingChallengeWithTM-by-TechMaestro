import java.util.*;

public class Permutations {
    public List<List<Integer>> ans;
    public boolean[] visited;
    
    public void solve(int[] nums, List<Integer> temp) {
        int n = nums.length;
        if(temp.size() == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                
                solve(nums, temp);
                
                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        visited = new boolean[nums.length];
        
        Arrays.sort(nums);
        solve(nums, new ArrayList<>());
        return ans;
    }
}
