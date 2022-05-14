import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> bst = new TreeSet<>();
        
        for(int num: nums) {
            Integer ceil = bst.ceiling(num);
            if(ceil != null) {
                bst.remove(ceil);
            }
            bst.add(num);
        }
        
        return bst.size();
    }
}
