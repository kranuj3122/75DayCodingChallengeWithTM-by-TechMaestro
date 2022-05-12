import java.util.*;

public class JobSequencingProblem {
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a,b) -> b.profit - a.profit);
        
        int maxDeadline = 0;
        for(Job j: arr) {
            maxDeadline = Math.max(maxDeadline, j.deadline);
        }
        
        int[] temp = new int[maxDeadline+1];
        Arrays.fill(temp, -1);
        
        int jobCount = 0, profit = 0;
        
        for(Job j: arr) {
            for(int i=j.deadline; i>0;  i--) {
                if(temp[i] == -1) {
                    temp[i] = j.id;
                    profit += j.profit;
                    jobCount++;
                    break;
                }
            }
        }
        
        return new int[] {jobCount, profit};
    }
}
