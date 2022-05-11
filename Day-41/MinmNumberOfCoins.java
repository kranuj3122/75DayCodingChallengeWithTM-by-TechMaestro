import java.util.*;

public class MinmNumberOfCoins {
    static List<Integer> minPartition(int N) {
        int[] coins = {1,2,5,10,20,50,100,200,500,2000};
        int n = coins.length;
        int[] required = new int[n];
        
        for(int i=n-1; i>=0; i--) {
            if(N >= coins[i]) {
                required[i] = N/coins[i];
                N %= coins[i];
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i=n-1; i>=0; i--) {
            while(required[i]-- > 0) {
                ans.add(coins[i]);
            }
        }
        
        return ans;
    }
}
