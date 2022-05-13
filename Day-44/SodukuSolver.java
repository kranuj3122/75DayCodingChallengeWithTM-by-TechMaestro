
public class SodukuSolver {
    public char[][] ans;
    
    public boolean isSafe(int r, int c, char[][] b, char ch) {
        int n = b.length;
        //same row
        for(int i=0; i<n; i++) {
            if(b[r][i] == ch) {
                return false;
            }
        }
        //same col
        for(int i=0; i<n; i++) {
            if(b[i][c] == ch) {
                return false;
            }
        }
        //same box
        int sq = (int)Math.sqrt(n);
        int startRow = r - r % sq;
        int startCol = c - c % sq;
        for(int i = startRow; i < startRow+sq; i++) {
            for(int j = startCol; j < startCol+sq; j++) {
                if(b[i][j] == ch) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void solve(char[][] board) {
        int n = board.length;
        // Find first empty cell
        int r=-1, c=-1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == '.') {
                    r=i;
                    c=j;
                    break;
                }
            }
            if(r != -1) {
                break;
            }
        }
        // Not found empty cell -> means we have a solution
        if(r == -1) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    ans[i][j] = board[i][j];
                }
            }
            return;
        }
        // Found empty cell -> fill it with 1-9
        for(char ch='1'; ch<='9'; ch++) {
            if(isSafe(r, c, board, ch)) {
                board[r][c] = ch;
                solve(board);
                board[r][c] = '.';
            }
        }
    }
    
    public void solveSudoku(char[][] board) {
        int n = board.length;
        ans = new char[n][n];
        
        solve(board);
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }
}
