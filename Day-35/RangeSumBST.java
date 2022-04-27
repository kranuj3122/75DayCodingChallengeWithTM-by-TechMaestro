
public class RangeSumBST {
    /*  static void inorder(TreeNode root, int low, int high) {
        if(root == null) {
            return;
        }
        inorder(root.left, low, high);
        if(root.val>=low && root.val<=high) {
            ans += root.val;
        }
        inorder(root.right, low, high);;
    }
    static int ans; 
  */
    public int rangeSumBST(TreeNode root, int low, int high) {
     // 1st method
     /* ans = 0;
        inorder(root, low, high);
        return ans;
     */
        
     // 2nd Mehod
        if(root == null) {
            return 0;
        }
        if(root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if(root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
