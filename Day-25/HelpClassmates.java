import java.util.*;

public class HelpClassmates {
    public static int[] help_classmate(int arr[], int n) {
	    Stack<Integer> stk = new Stack<>();
	    int[] ans = new int[n];
	    for(int i=n-1; i>=0; i--) {
	        while(!stk.empty() && stk.peek() >= arr[i]) {
	            stk.pop();
	        }
	        if(stk.empty()) {
	            ans[i] = -1;
	        }
	        else {
	            ans[i] = stk.peek();
	        }
	        stk.push(arr[i]);
	    }
	    return ans;
	}
}
