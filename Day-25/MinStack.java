import java.util.*;

public class MinStack {
    Stack<Integer> stk, miniStack;
    public MinStack() {
        stk = new Stack<>();
        miniStack = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(miniStack.empty() || miniStack.peek() >= val) {
            miniStack.push(val);
        }
    }
    
    public void pop() {
        int val = stk.pop();
        if(miniStack.peek() == val) {
            miniStack.pop();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return miniStack.peek();
    }
}
