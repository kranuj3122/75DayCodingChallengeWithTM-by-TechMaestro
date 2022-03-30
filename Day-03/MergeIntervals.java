import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) {
                    return a[0]-b[0];
                }
                return a[1] - b[1];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            if(end >= s) {
                end = Math.max(e, end);
            }
            else {
                ans.add(new int[] {start, end});
                start = s;
                end = e;
            }
        }
        ans.add(new int[] {start, end});
        return ans.toArray(new int[ans.size()][2]);
    }
}
