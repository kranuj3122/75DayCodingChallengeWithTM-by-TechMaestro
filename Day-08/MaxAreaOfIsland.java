
public class MaxAreaOfIsland {
    static int backtrack(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]==0) {
            return 0;
        }
        int ans = 1;
        grid[i][j] = 0;
        ans += backtrack(grid, i+1, j);
        ans += backtrack(grid, i-1, j);
        ans += backtrack(grid, i, j+1);
        ans += backtrack(grid, i, j-1);
        return ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    ans = Math.max(ans, backtrack(grid, i, j));
                }
            }
        }
        return ans;
    }
}
