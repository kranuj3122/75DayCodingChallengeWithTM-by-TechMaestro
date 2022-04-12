import java.util.*;

public class TopKfreqElement {
    static class Pair {
        int n, f;
        Pair(int n, int f) {
            this.n = n;
            this.f = f;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p, Pair q) {
                return p.f - q.f;
            }
        });
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num: nums) {
            mp.put(num, mp.getOrDefault(num,0)+1);
        }
        for(int num: mp.keySet()) {
            pq.add(new Pair(num, mp.get(num)));
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[k];
        int i = k-1;
        while(!pq.isEmpty()) {
            ans[i--] = pq.poll().n;
        }
        return ans; 
    }
}
