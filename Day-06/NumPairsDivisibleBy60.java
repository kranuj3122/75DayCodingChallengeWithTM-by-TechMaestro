
public class NumPairsDivisibleBy60 {
    static int nc2(int n) {
        long ans = (long)n*(n-1);
        return (int)(ans/2);
    }
    public int numPairsDivisibleBy60(int[] time) {
        int[] freq = new int[60];
        for(int n: time) {
            freq[n%60]++;
        }
        int ans = nc2(freq[0]);
        for(int i=1; i<30; i++) {
            ans += freq[i] * freq[60-i];
        }
        ans += nc2(freq[30]);
        return ans;
    }
}
