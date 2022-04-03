
public class MaxValueOfEquation {
    static class Pair {
        int diff, x;
        Pair(int diff, int x) {
            this.diff = diff;
            this.x = x;
        }
    }
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(Pair a, Pair b) {
                if(a.diff != b.diff) {
                    return b.diff - a.diff;
                }
                return a.x - b.x;
            }
        });
        int n = points.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            while(!pq.isEmpty() && x-pq.peek().x > k) {
                pq.poll();
            }
            if(!pq.isEmpty()) {
                ans = Math.max(ans, x+y+pq.peek().diff);
            }
            pq.add(new Pair(y-x, x));
        }
        return ans;
    }
}
