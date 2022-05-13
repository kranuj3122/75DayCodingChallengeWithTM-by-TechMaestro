import java.util.*;

public class NQueenProblem {
    static ArrayList<ArrayList<Integer>> ans;
    static boolean[][] board;
    
    static boolean isSafe(int r, int c) {
        //NW
        int i=r-1, j=c-1;
        while(i>=0 && j>=0) {
            if(board[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        //NE
        i=r-1; j=c+1;
        while(i>=0 && j<board.length) {
            if(board[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        //same row
        j=c-1;
        while(j>=0) {
            if(board[r][j]) {
                return false;
            }
            j--;
        }
        //same col
        i=r-1;
        while(i>=0) {
            if(board[i][c]) {
                return false;
            }
            i--;
        }
        return true;
    }
    
    static void solve(int currRow, int n, ArrayList<Integer> list) {
        if(currRow == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int col=0; col<n; col++) {
            if(isSafe(currRow, col)) {
                board[currRow][col] = true;
                list.add(col+1);
                
                solve(currRow+1, n, list);
                
                board[currRow][col] = false;
                list.remove(list.size()-1);
            }
        }
    }
    
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ans = new ArrayList<>();
        board = new boolean[n][n];
        
        solve(0, n, new ArrayList<>());
        
        return ans;
    }
}
