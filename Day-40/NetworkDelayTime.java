import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Integer>>[] adjList = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] t: times) {
            adjList[t[0]].add(Arrays.asList(t[1], t[2]));
        }
        
        int[] dist = new int[n+1];
        for(int i=0; i<=n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        
        PriorityQueue<List<Integer>> q = new PriorityQueue<>((a,b) -> a.get(1) - b.get(1));
        q.add(Arrays.asList(k, 0));
        boolean[] visited = new boolean[n+1];
        while(!q.isEmpty()) {
            List<Integer> p = q.poll();
            int node = p.get(0);
            int d = p.get(1);
            if(visited[node]) {
                continue;
            }
            visited[node] = true;
            for(List<Integer> l: adjList[node]) {
                int curr = l.get(0);
                int currDist = l.get(1);
                int newDist = d + currDist;
                if(newDist < dist[curr]) {
                    dist[curr] = newDist;
                }
                q.add(Arrays.asList(curr, newDist));
            }
        }
        
        int ans = -1;
        for(int i=1; i<=n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
