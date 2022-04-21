
public class BinaryTreePath {
    public List<String> ans;
    
    public void solve(TreeNode root, List<Integer> list) {
        if(root.left == null && root.right == null) {
            String str = "";
            for(int n: list) {
                str += (n+"->");
            }
            str += root.val;
            ans.add(str);
            return;
        }
        
        list.add(root.val);
        if(root.left != null) {
            solve(root.left, list);
        }
        if(root.right != null) {
            solve(root.right, list);
        }
        
        list.remove(list.size() - 1);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        solve(root, new ArrayList());
        return ans;
    }
}
