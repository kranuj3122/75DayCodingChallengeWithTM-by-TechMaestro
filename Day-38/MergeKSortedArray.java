import java.util.*;

public class MergeKSortedArray {
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int col=0; col<K; col++) {
            for(int row=0; row<K; row++) {
                pq.add(arr[row][col]);
            }
            ans.add(pq.poll());
        }
        
        while(pq.size() > 0) {
            ans.add(pq.poll());
        }
        
        return ans;
    }
}
