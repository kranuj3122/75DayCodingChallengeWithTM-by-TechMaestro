
public class MinCapacityToShipPackage {
    static int countDays(int[] weights, int capacity) {
        int sum = 0;
        int days = 0;
        for(int n: weights) {
            sum += n;
            if(sum > capacity) {
                days++;
                sum = n;
            }
        }
        if(sum > 0) {
            days++;
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for(int n: weights) {
            min = Math.max(min, n);
            max += n;
        }
        while(min <= max) {
            int mid = min + (max - min)/2;
            if(countDays(weights, mid) <= days) {
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }
        return max + 1;
    }
}
