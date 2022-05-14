
public class MaxSumIncreasingSequence {
    public int maxSumIS(int arr[], int n)  {
	    int[] dp = new int[n];
	    for(int i=0; i<n; i++) {
	        dp[i] = arr[i];
	        int mx = 0;
	        for(int j=i-1; j>=0; j--) {
	            if(arr[i] > arr[j]) {
	                mx = Math.max(mx, dp[j]);
	            }
	        }
	        dp[i] += mx;
	    }
	    
	    int ans = 0;
	    for(int num: dp) {
	        ans = Math.max(ans, num);
	    }
	    
	    return ans;
	}
}
