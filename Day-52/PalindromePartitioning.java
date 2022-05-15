
import java.util.*;

public class PalindromePartitioning {
    static int[][] t;
    
    static boolean isPalindrome(String str, int i, int j) {
        while(i<j) {
            if(str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    
    static int solve(String str, int i, int j) {
        if(i >= j) {
            return 0;
        }
        if(t[i][j] != -1) {
            return t[i][j];
        }
        if(isPalindrome(str, i, j)) {
            t[i][j] = 0;
            return 0;
        }
        
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int left = 0;
            if(t[i][k] != -1) {
                left = t[i][k];
            }
            else {
                left = solve(str, i, k);
                t[i][k] = left;
            }
            
            int right = 0;
            if(t[k+1][j] != -1) {
                right = t[k+1][j];
            }
            else {
                right = solve(str, k+1, j);
                t[k+1][j] = right;
            }
            
            int tempAns = left + right + 1;
            if(tempAns < ans) {
                ans = tempAns;
            }
        }
        
        t[i][j] = ans;
        return ans;
    }
    
    public int minCut(String s) {
        int n = s.length();
        t = new int[n][n];
        for(int[] a: t) {
            Arrays.fill(a, -1);
        }
        
        return solve(s, 0, n-1);
    }
}
