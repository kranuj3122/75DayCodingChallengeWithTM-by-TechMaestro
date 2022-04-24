
public class PathSumiii {
    public int ans = 0;
    
    public void solve(TreeNode root, int target) {
        if(root == null) {
            return;
        }
        if(target == root.val) {
            ans++;
        }
        target -= root.val;
        solve(root.left, target);
        solve(root.right, target);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        solve(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return ans;
    }
}
