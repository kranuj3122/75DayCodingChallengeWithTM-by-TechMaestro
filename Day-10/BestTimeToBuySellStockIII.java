
public class BestTimeToBuySellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int leftMin = prices[0];
        int rightMax = prices[n-1];
        for(int i=1; i<n; i++) {
            left[i] = Math.max(left[i-1], prices[i]-leftMin);
            leftMin = Math.min(leftMin, prices[i]);
        }
        for(int i=n-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], rightMax-prices[i]);
            rightMax = Math.max(rightMax, prices[i]);
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int profit = left[0] + right[0];
        for(int i=1; i<n; i++) {
            profit = Math.max(profit, left[i-1]+right[i]);
        }
        return profit;
    }
}
