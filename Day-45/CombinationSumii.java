import java.util.*;

public class CombinationSumii {
    public List<List<Integer>> ans;
    
    public void solve(int[] arr, int target, int start, List<Integer> list) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=start; i<arr.length; i++) {
            if((i>start && arr[i]==arr[i-1]) || (arr[i] > target)) {
                continue;
            }
            list.add(arr[i]);
            solve(arr, target-arr[i], i+1, list);
            list.remove(list.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, new ArrayList<>());
        return ans;
    }
}
