
public class RodCutting {
    public int cutRod(int price[], int n) {
        int[][] t = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i <= j) {
                    t[i][j] = Math.max(price[i-1] + t[i][j-i], t[i-1][j]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][n];
    }
}
