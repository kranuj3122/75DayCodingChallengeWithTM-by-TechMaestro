import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[') {
                stk.push(ch);
            }
            else if(ch==')') {
                if(stk.empty() || stk.peek()!='(') {
                    return false;
                }
                stk.pop();
            }
            else if(ch=='}') {
                if(stk.empty() || stk.peek()!='{') {
                    return false;
                }
                stk.pop();
            }
            else if(ch==']') {
                if(stk.empty() || stk.peek()!='[') {
                    return false;
                }
                stk.pop();
            }
        }
        return stk.empty();
    }
}
