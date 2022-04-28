import java.util.*;

public class UniqueBSTii {

    public List<TreeNode> solve(int start, int end) {

        List<TreeNode> list = new ArrayList<>();
        
        if(start > end) {
            list.add(null);
            return list;
        }
        
        for(int i=start; i<=end; i++) {
            
            List<TreeNode> leftSubtrees = solve(start, i-1);
            List<TreeNode> rightSubtrees = solve(i+1, end);
            
            for(TreeNode left: leftSubtrees) {
                for(TreeNode right: rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    
                    list.add(root);
                }
            }
        }
        
        return list;
    }
    
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }
}
