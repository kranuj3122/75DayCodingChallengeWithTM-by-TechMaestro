
public class CountGoodNodeInBT {
    public int ans;
    public void solve(TreeNode root, int prev) {
        if(root == null) {
            return;
        }
        if(root.val >= prev) {
            ans++;
            prev = root.val;
        }
        solve(root.left, prev);
        solve(root.right, prev);
    }
    public int goodNodes(TreeNode root) {
        int prev = -10005;
        ans = 0;
        solve(root, prev);
        return ans;
    }
}
