import java.util.*;

public class N_MeetingsInARoom {
    public static int maxMeetings(int start[], int end[], int n) {
        int[][] meetings = new int[n][2];
        for(int i=0; i<n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, (a, b) -> {
            if(a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int e = meetings[0][1];
        int ans = 1;
        for(int i=1; i<n; i++) {
            if(meetings[i][0] > e) {
                ans++;
                e = meetings[i][1];
            }
        }
        
        return ans;
    }
}
