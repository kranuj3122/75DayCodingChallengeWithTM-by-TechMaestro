
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] ans = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int liveCount = 0;
                // top neighbour
                if(i-1 >= 0) {
                    if(j-1 >= 0 && board[i-1][j-1] == 1) {
                        liveCount++;
                    }
                    if(board[i-1][j] == 1) {
                        liveCount++;
                    }
                    if(j+1 < n && board[i-1][j+1] == 1) {
                        liveCount++;
                    }
                }
                // down neighbour
                if(i+1 < m) {
                    if(j-1 >= 0 && board[i+1][j-1] == 1) {
                        liveCount++;
                    }
                    if(board[i+1][j] == 1) {
                        liveCount++;
                    }
                    if(j+1 < n && board[i+1][j+1] == 1) {
                        liveCount++;
                    }
                }
                // left
                if(j-1 >= 0 && board[i][j-1] == 1) {
                    liveCount++;
                }
                // right
                if(j+1 < n && board[i][j+1] == 1) {
                    liveCount++;
                }
                
                if(board[i][j] == 1 && (liveCount==2 || liveCount==3)) {
                     ans[i][j] = 1;
                }
                else if(board[i][j] == 0 && liveCount == 3) {
                    ans[i][j] = 1;
                }
            }
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }
}
