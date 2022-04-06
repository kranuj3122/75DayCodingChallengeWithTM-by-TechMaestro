
public class LongestRepeatingCharacterReplacement {
    static int maxFreq(int[] freq) {
        int mx = 0;
        for(int n: freq) {
            mx = Math.max(mx, n);
        }
        return mx;
    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int i=0, j=0;
        int ans = 0;
        while(j < n) {
            freq[s.charAt(j) - 'A']++;
            while((j-i+1)-maxFreq(freq) > k) {
                freq[s.charAt(i)-'A']--;
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}
