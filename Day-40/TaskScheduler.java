import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c: tasks) {
            freq[c-'A']++;
        }
        Arrays.sort(freq);
        int idleCases = n * (freq[25]-1);
        for(int i=24; i>=0 && idleCases > 0; i--) {
            idleCases -= Math.min(freq[25]-1, freq[i]);
        }
        idleCases = Math.max(0, idleCases);
        return idleCases + tasks.length;
    }
}
