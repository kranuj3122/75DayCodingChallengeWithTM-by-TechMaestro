
public class RecoverBST {
    public TreeNode first;
    public TreeNode second;
    public TreeNode prev;
    
    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        
        if(prev != null && prev.val > root.val) {
            if(first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        
        inorder(root.right);
        
    }
    
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = null;
        
        inorder(root);
        
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }
}
