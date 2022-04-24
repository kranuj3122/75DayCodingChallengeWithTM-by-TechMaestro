
public class SerializeAndDeserializeBT {
    public String serialize(TreeNode root) {
        String ans = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr != null) {
                if(ans.length() != 0) {
                    ans += " ";
                }
                ans += curr.val;
                q.add(curr.left);
                q.add(curr.right);
            }
            else {
                if(ans.length() != 0) {
                    ans += " ";
                }
                ans += "#";
            }
        }
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(" ");
        int n = str.length;
        if(n == 1) {
            return null;
        }
        System.out.println(Arrays.toString(str));
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        q.add(root);
        for(int i=1; i<n; i++) {
            TreeNode node = q.poll();
            if(str[i].equals("#")) {
                node.left = null;
            }
            else {
                node.left = new TreeNode(Integer.parseInt(str[i]));
                q.add(node.left);
            }
            i++;
            if(str[i].equals("#")) {
                node.right = null;
            }
            else {
                node.right = new TreeNode(Integer.parseInt(str[i]));
                q.add(node.right);
            }
        }
        return root;
    }
}
