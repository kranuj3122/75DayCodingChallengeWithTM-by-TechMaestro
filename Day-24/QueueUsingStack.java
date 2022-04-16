import java.util.*;

public class QueueUsingStack {
    Stack<Integer> s1, s2;
    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!s1.empty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.empty()) {
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.empty();
    }
}
