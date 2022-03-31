
public class WordSearch {
    static boolean backtrack(char[][] b, char[] w, int i, int j, int ind) {
        if(ind == w.length) {
            return true;
        }
        if(i<0 || j<0 || i==b.length || j==b[0].length || b[i][j]!=w[ind]) {
            return false;
        }
        char c = w[ind];
        b[i][j] = '*';
        boolean ans = backtrack(b,w,i+1,j,ind+1) || backtrack(b,w,i-1,j,ind+1) || backtrack(b,w,i,j-1,ind+1) || backtrack(b,w,i,j+1,ind+1);
        b[i][j] = c;
        return ans;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        char[] w = word.toCharArray();
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == w[0] && backtrack(board, w, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
