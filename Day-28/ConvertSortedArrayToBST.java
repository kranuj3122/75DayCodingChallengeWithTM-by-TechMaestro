
public class ConvertSortedArrayToBST {
    public TreeNode solve(int[] nums, int l, int r) {
        if(l > r) {
            return null;
        }
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = solve(nums, l, mid-1);
        root.right = solve(nums, mid+1, r);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums, 0, nums.length-1);
    }
}
