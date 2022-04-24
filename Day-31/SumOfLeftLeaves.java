
public class SumOfLeftLeaves {
    public int sum;

    public void solve(TreeNode root, boolean isLeft) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null && isLeft) {
            sum += root.val;
            return;
        }
        solve(root.left, true);
        solve(root.right, false);
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        solve(root, false);
        return sum;
    }
}
