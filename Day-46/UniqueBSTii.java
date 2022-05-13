import java.util.*;

public class UniqueBSTii {
    public List<TreeNode> solve(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if(start > end) {
            ans.add(null);
            return ans;
        }
        
        for(int i=start; i<=end; i++) {
            List<TreeNode> leftSubtree = solve(start, i-1);
            List<TreeNode> rightSubtree = solve(i+1, end);
            
            for(TreeNode left: leftSubtree) {
                for(TreeNode right: rightSubtree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        
        return ans;
    }
    
    public List<TreeNode> generateTrees(int n) {
        return solve(1,n);
    }
}
