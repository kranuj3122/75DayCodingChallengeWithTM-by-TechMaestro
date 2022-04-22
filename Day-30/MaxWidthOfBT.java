
public class MaxWidthOfBT {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qIndex = new LinkedList<>();
        q.add(root);
        qIndex.add(1);
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int start = 0, end = 0;
            while(size-- > 0) {
                TreeNode node = q.poll();
                int currIndex = qIndex.poll();
                if(start == 0) {
                    start = currIndex;
                }
                end = currIndex;
                if(node.left != null) {
                    q.add(node.left);
                    qIndex.add(2*currIndex);
                }
                if(node.right != null) {
                    q.add(node.right);
                    qIndex.add(2*currIndex + 1);
                }
            }
            ans = Math.max(ans, end-start+1);
        }
        return ans;
    }
}
