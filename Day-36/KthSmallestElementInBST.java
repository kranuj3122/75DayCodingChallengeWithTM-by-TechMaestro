
public class KthSmallestElementInBST {
    static int kthSmallest, counter;
    
    static void solve(TreeNode root) {
        if(root == null || counter == 0) {
            return;
        }
        solve(root.left);
        counter--;
        if(counter == 0) {
            kthSmallest = root.val;
            return;
        }
        solve(root.right);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        kthSmallest = 0;
        counter = k;
        solve(root);
        return kthSmallest;
    }
}
