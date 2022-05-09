import java.util.*;

public class  NearlySortedArray {
    ArrayList <Integer> nearlySorted(int arr[], int num, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<num; i++) {
            if(i <= k) {
                pq.add(arr[i]);
            }
            else {
                ans.add(pq.poll());
                pq.add(arr[i]);
            }
        }
        
        while(pq.size() > 0) {
            ans.add(pq.poll());
        }
        
        return ans;
    }
}
