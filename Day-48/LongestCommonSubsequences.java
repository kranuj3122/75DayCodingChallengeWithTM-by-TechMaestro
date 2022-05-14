
public class LongestCommonSubsequences {
    // TopDown
    /* static int[][] t;
    static int topDown(String s1, String s2, int m, int n) {
        if(m==0 || n==0) {
            return 0;
        }
        if(t[m][n] != -1) {
            return t[m][n];
        }
        if(s1.charAt(m-1) == s2.charAt(n-1)) {
            t[m][n] = 1 + topDown(s1, s2, m-1, n-1);
            return t[m][n];
        }
        t[m][n] = Math.max(topDown(s1, s2, m, n-1), topDown(s1, s2, m-1, n));
        return t[m][n];
    } */
    
    // Recursion
    /* static int recursion(String s1, String s2, int m, int n) {
        if(m==0 || n==0) {
            return 0;
        }
        if(s1.charAt(m-1) == s2.charAt(n-1)) {
            return 1 + recursion(s1, s2, m-1, n-1);
        }
        return Math.max(recursion(s1, s2, m, n-1), recursion(s1, s2, m-1, n));
    } */
    
    // Bottom Up
    static int bottomUp(String s1, String s2, int m, int n) {
        int[][] t = new int[m+1][n+1];
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        // 1st Method Using Recursion
        // return recursion(text1, text2, text1.length(), text2.length());
        
        // 2nd Method Top Down
        /* 
        t = new int[text1.length()+1][text2.length()+1];
        for(int[] arr: t) {
            Arrays.fill(arr, -1);
        }
        return topDown(text1, text2, text1.length(), text2.length()); */
        
        // 3rd Method Bottom Up
        return bottomUp(text1, text2, text1.length(), text2.length());
    }
}
