import java.util.*;

public class ActivitySelection {
    public static int activitySelection(int start[], int end[], int n) {
        int[][] activity = new int[n][2];
        for(int i=0; i<n; i++) {
            activity[i][0] = start[i];
            activity[i][1] = end[i];
        }
        Arrays.sort(activity, (a, b) -> {
            if(a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int e = activity[0][1];
        int ans = 1;
        for(int i=1; i<n; i++) {
            if(activity[i][0] > e) {
                ans++;
                e = activity[i][1];
            }
        }
        
        return ans;
    }
}
