import java.util.*;

public class Combinations {
    public List<List<Integer>> ans;
    
    public void solve(int start, int n, int k, List<Integer> list) {
        if(list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(start > n) {
            return;
        }
        
        for(int i=start; i<=n; i++) {
            list.add(i);
            solve(i+1, n, k, list);
            list.remove(list.size()-1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        solve(1, n, k, new ArrayList<>());
        return ans;
    }
}
