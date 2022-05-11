import java.util.*;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n: stones) {
            pq.add(n);
        }
        while(pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if(x != y) {
                pq.add(y-x);
            }
        }
        if(pq.isEmpty()) {
            return 0;
        }
        return pq.poll();
    }
}
