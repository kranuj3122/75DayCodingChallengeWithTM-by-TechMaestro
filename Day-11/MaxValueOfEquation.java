
public class MaxValueOfEquation {
    static class DiffAndX {
        int diff, x;
        DiffAndX(int diff, int x) {
            this.diff = diff;
            this.x = x;
        }
    }
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<DiffAndX> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(DiffAndX a, DiffAndX b) {
                if(a.diff != b.diff) {
                    return b.diff - a.diff;
                }
                return a.x - b.x;
            }
        });
        int n = points.length;
        int res = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            while(!pq.isEmpty() && x-pq.peek().x > k) {
                pq.poll();
            }
            if(!pq.isEmpty()) {
                res = Math.max(res, x+y+pq.peek().diff);
            }
            pq.add(new DiffAndX(y-x, x));
        }
        return res;
    }
}
