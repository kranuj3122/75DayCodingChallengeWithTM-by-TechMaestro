
public class MaxPointsFromCards {
    /* Recursion
    static int recursion(int[] c, int l, int r, int k) {
        if(k == 0) {
            return 0;
        }
        int ans1 = c[l] + recursion(c, l+1, r, k-1);
        int ans2 = c[r] + recursion(c, l, r-1, k-1);
        return Math.max(ans1, ans2); 
    } */
    public int maxScore(int[] cardPoints, int k) {
        // return recursion(cardPoints, 0, cardPoints.length-1, k);
        int[] left = new int[k+1];
        for(int i=1; i<=k; i++) {
            left[i] += left[i-1] + cardPoints[i-1];
        }
        int[] right = new int[k+1];
        for(int i=1; i<=k; i++) {
            right[i] += right[i-1] + cardPoints[cardPoints.length-i];
        }
        int ans = 0;
        for(int i=0; i<=k; i++) {
            ans = Math.max(ans, left[i]+right[k-i]);
        }
        return ans;
    }
}
