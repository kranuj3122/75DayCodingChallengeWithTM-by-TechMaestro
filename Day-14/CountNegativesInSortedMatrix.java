
public class CountNegativesInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = 0;
        int j = n-1;
        int ans = 0;
        while(i<m && j>=0) {
            if(grid[i][j] < 0) {
                ans += (m-i);
                j--;
            }
            else {
                i++;
            }
        }
        return ans;
    }
}
