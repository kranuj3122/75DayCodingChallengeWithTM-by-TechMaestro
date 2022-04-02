import java.util.*;

public class MaxAreaOfPieceOfCake {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        int n1 = horizontalCuts.length;
        int maxHeight = Math.max(horizontalCuts[0] - 0, h - horizontalCuts[n1-1]);
        for(int i=1; i<n1; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i]-horizontalCuts[i-1]);
        }
        Arrays.sort(verticalCuts);
        int n2 = verticalCuts.length;
        int maxWidth = Math.max(verticalCuts[0] - 0, w - verticalCuts[n2-1]);
        for(int i=1; i<n2; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i]-verticalCuts[i-1]);
        }
        
        long ans = 1L*maxWidth*maxHeight;
        return (int)(ans % 1000000007);
    }
}
