
public class UniqueBSTs {
    public int numTrees(int n) {
        long ans = 1;
        for(int i=2; i<=n; i++) {
            ans *= (2*i) * ((2*i)-1);
            ans /= (i+1) * i;
        }
        return (int)ans;
    }
}