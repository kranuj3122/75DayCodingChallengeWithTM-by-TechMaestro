import java.util.*;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for(int[] b: buildings) {
            heights.add(new int[] {b[0], -b[2]});
            heights.add(new int[] {b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int prevHeight = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] h: heights) {
            if(h[1] < 0) {
                pq.add(-h[1]);
            }
            else {
                pq.remove(h[1]);
            }
            
            if(pq.peek() != prevHeight) {
                ans.add(Arrays.asList(h[0], pq.peek()));
                prevHeight = pq.peek();
            }
        }
        
        return ans;
    }
}
