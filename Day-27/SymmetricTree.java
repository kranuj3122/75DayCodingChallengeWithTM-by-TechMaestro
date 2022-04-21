
public class SymmetricTree {
    public boolean isIdentical(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return isIdentical(root1.left, root2.right) && isIdentical(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isIdentical(root.left, root.right);
    }
}
