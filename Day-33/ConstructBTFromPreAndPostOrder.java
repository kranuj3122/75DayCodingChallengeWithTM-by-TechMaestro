
public class ConstructBTFromPreAndPostOrder {
    public TreeNode solve(int[] pre, int prStart, int prEnd, int[] post, int psStart, int psEnd) {
        if(prStart > prEnd || psStart > psEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(pre[prStart]);
        if(prStart == prEnd) {
            return root;
        }
        
        int v = pre[prStart+1];
        int ind = psStart;
        while(ind <= psEnd && post[ind] != v) {
            ind++;
        }
        int count = ind - psStart + 1;
        
        root.left = solve(pre, prStart+1, prStart+count, post, psStart, ind);
        root.right = solve(pre, prStart+count+1, prEnd, post, ind+1, psEnd-1);
        
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return solve(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
    }
}