
public class MinmAbsDiffOfBST {
    public int ans;
    public int prev;
    
    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(prev != -1 && root.val - prev < ans) {
            ans = root.val - prev;
        }
        prev = root.val;
        inorder(root.right);
    }
    
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        prev = -1;
        inorder(root);
        return ans;
    }
}
