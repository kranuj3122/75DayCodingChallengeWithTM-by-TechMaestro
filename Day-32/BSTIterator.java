import java.util.*;

public class BSTIterator {
    public Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode temp = stk.pop();
        pushAllLeft(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stk.empty();
    }
    
    public void pushAllLeft(TreeNode root) {
        while(root != null) {
            stk.push(root);
            root = root.left;
        }
    }
}
