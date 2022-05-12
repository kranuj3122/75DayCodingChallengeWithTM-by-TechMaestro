import java.util.*;

public class FractionalKnapsack {
    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, (a,b) -> {
            if((long)(b.value)*(a.weight) - (long)(a.value)*(b.weight) > 0) {
                return 1;
            }
            else if((long)(b.value)*(a.weight) - (long)(a.value)*(b.weight) < 0) {
                return -1;
            }
            return 0;
        });
        // for(Item i: arr) {
        //     System.out.println(i.value+" "+i.weight);
        // }
        double ans = 0.0;
        for(int i=0; i<n; i++) {
            Item it = arr[i];
            if(W > 0) {
                if(it.weight <= W) {
                    ans += it.value;
                    W -= it.weight;
                }
                else {
                    ans += ((double)it.value * W) / (double)it.weight;
                    break;
                }
            }
        }
        
        return ans;
    }
}
