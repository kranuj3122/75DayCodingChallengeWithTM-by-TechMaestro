
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        
        // 1st row
        for(int i=1; i<=amount; i++) {
            dp[0][i] = Integer.MAX_VALUE - 1;
        }
        // 2nd row
        for(int i=1; i<=amount; i++) {
            dp[1][i] = i % coins[0] == 0 ? i / coins[0] : dp[0][i];
        }
        
        for(int i=2; i<=n; i++) {
            for(int j=1; j<=amount; j++) {
                if(j >= coins[i-1]) {
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][amount]==Integer.MAX_VALUE-1 ? -1 : dp[n][amount];
    }
}
