
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] width = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            if(stk.empty()) {
                width[i] = i+1;
            }
            else {
                width[i] = i - stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for(int i=n-1; i>=0; i--) {
            while(!stk.empty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            if(stk.empty()) {
                width[i] += (n - 1 - i);
            }
            else {
                width[i] += (stk.peek() - i - 1);
            }
            stk.push(i);
        }
        System.out.println(Arrays.toString(width));
        int mxArea = 0;
        for(int i=0; i<n; i++) {
            mxArea = Math.max(mxArea, heights[i]*width[i]);
        }
        return mxArea;
    }
}
