
public class DiameterOfBinaryTree {
    int ans;
    public int solve(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);
        int tempAns = left + right + 1;
        if(tempAns > ans) {
            ans = tempAns;
        }
        return Math.max(left, right) + 1;
    } 
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        solve(root);
        return ans-1;
    }
}
