
import java.util.*;

public class WordBreak {
    static int[] memo;
    
    static boolean solve(String s, List<String> words, int start) {
        int n = s.length();
        if(start == n) {
            return true;
        }
        if(memo[start] != -1) {
            return memo[start] == 1;
        }
        
        for(int i=start; i<n; i++) {
            if(words.contains(s.substring(start, i+1)) && solve(s, words, i+1)) {
                memo[start] = 1;
                return true;
            }
        }
        
        memo[start] = 0;
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return solve(s, wordDict, 0);
    }
}
