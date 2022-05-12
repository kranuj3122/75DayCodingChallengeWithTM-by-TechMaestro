import java.util.*;
public class MinimumPlatform {
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platformNeeded = 1, ans = 1;
        int i=1, j=0;
        
        while(i<n && j<n) {
            if(arr[i] <= dep[j]) {
                platformNeeded++;
                i++;
            }
            else {
                platformNeeded--;
                j++;
            }
            
            if(platformNeeded > ans) {
                ans = platformNeeded;
            }
        }
        
        return ans;
        
    }
}
