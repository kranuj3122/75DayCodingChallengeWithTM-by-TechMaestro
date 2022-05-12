import java.util.*;

public class RatInAMaze {
    static ArrayList<String> ans;
    
    static void solve(int[][] maze, int i, int j, String path) {
        int n = maze.length;
        if(i<0 || j<0 || i==n || j==n || maze[i][j]==0) {
            return;
        }
        
        if(i==n-1 && j==n-1) {
            ans.add(path);
            return;
        }
        
        maze[i][j] = 0;
        
        solve(maze, i+1, j, path+"D");
        solve(maze, i-1, j, path+"U");
        solve(maze, i, j+1, path+"R");
        solve(maze, i, j-1, path+"L");
        
        maze[i][j] = 1;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        ans = new ArrayList<>();
        solve(m,0,0,"");
        return ans;
    }
}
