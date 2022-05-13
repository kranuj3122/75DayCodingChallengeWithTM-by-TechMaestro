import java.util.*;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(1);
        
        if(n == 1) {
            return ans;
        }
        
        int curr = 2;
        for(int i=2; i<=n; i++) {
            for(int j=ans.size()-1; j>=0; j--) {
                ans.add(curr+ans.get(j));
            }
            curr <<= 1;
        }
        
        return ans;
    }
}
