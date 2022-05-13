import java.util.*;

public class CombinationSum {
    public List<List<Integer>> ans;
    
    public void solve(int[] arr, int target, List<Integer> list, int start) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if(start == arr.length) {
            return;
        }
        
        if(arr[start] <= target) {
            list.add(arr[start]);
            solve(arr, target-arr[start], list, start);
            list.remove(list.size()-1);
        }
        
        solve(arr, target, list, start+1);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        solve(candidates, target, new ArrayList<>(), 0);
        return ans;
    }
}
