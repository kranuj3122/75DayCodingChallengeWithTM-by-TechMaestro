import java.util.*;

public class GenerateParentheses {
    public List<String> ans;
    
    public void solve(int open, int close, String s) {
        if(open == close && open == 0) {
            ans.add(s);
            return;
        }
        
        if(open > 0) {
            solve(open-1, close, s+'(');
        }
        
        if(close > open) {
            solve(open, close-1, s+')');
        }
    }
    
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        solve(n, n, "");
        return ans;
    }
}
