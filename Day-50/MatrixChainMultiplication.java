public class MatrixChainMultiplication {
    static int[][] t;
    
    static int solve(int[] a, int i, int j) {
        if(i>=j) {
            return 0;
        }
        
        if(t[i][j] != -1) {
            return t[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int tempAns = solve(a, i, k) + solve(a, k+1, j) + a[i-1]*a[k]*a[j];
            ans = Math.min(ans, tempAns);
        }
        t[i][j] = ans;
        return ans;
    }
    
    static int matrixMultiplication(int N, int arr[]) {
        t = new int[N][N];
        for(int[] a: t) {
            Arrays.fill(a, -1);
        }
        
        return solve(arr, 1, N-1);
    }
}
