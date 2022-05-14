
public class Knapsack01 {
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] t=new int[n+1][W+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=W;j++) {
                if(wt[i-1]<=j) {
                    t[i][j] = Math.max(t[i-1][j], val[i-1]+t[i-1][j-wt[i-1]]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][W];
    }
}
