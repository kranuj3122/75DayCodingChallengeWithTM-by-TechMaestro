
public class RightSideViewOfBT {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            int rightMostVal = 0;
            while(size-- > 0) {
                TreeNode node = q.poll();
                rightMostVal = node.val;
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(rightMostVal);
        }
        
        return ans;
    }
}
