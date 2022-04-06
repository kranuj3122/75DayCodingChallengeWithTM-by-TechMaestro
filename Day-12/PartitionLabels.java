import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] ind = new int[26];
        for(int i=0; i<n; i++) {
            ind[s.charAt(i)-'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int lastIndex = 0;
        int prevIndex = 0;
        for(int i=0; i<n; i++) {
            lastIndex = Math.max(lastIndex, ind[s.charAt(i)-'a']);
            if(lastIndex == i) {
                ans.add(i-prevIndex+1);
                prevIndex = i+1;
            }
        }
        return ans;
    }
}
