import java.util.*;

public class KnightTourProblem {
    static int[] xMove, yMove;
	static List<List<Integer>> board;
	
	static boolean isSafe(int i, int j) {
		return i>=0 && j>=0 && i<board.size() && j<board.get(0).size() && board.get(i).get(j)==-1;
	}

    static void print(List<List<Integer>> board) {
        for(List<Integer> l: board) {
            System.out.println(l);
        }
    }

	static void solve(int i, int j, int move) {
		if(move == board.size() * board.get(0).size()) {
			print(board);
			return;
		}
		
		if(!isSafe(i,j)) {
			return;
		}
		
		board.get(i).set(j, move);
		move++;

		for(int k=0; k<8; k++) {
			solve(i+xMove[k], j+yMove[k], move);
		}
		
		move--;
		board.get(i).set(j, -1);
	}

    public static void knightTour(int n, int m) {
		xMove = new int[] {-2, -2, -1, -1, 1, 1, 2, 2};
		yMove = new int[] {-1, 1, -2, 2, -2, 2, -1, 1};
		board = new ArrayList<>();
		for(int i=0; i<n; i++) {
			List<Integer> arr = new ArrayList<>();
			for(int j=0; j<m; j++) {
				arr.add(-1);
			}
			board.add(arr);
		}

		solve(0,0,0);
    }
}
