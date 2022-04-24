import java.util.*;

public class NodesDistanceKinBT {
    public Map<TreeNode, TreeNode> parent; // <node, parent>
    
    public void initializeParent(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        parent.put(root, null);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left != null) {
                q.add(node.left);
                parent.put(node.left, node);
            }
            if(node.right != null) {
                q.add(node.right);
                parent.put(node.right, node);
            }
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        initializeParent(root);
        Set<Integer> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.add(target.val);
        while(!q.isEmpty() && k-- > 0) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode node = q.poll();
                TreeNode left = node.left, right = node.right, p = parent.get(node);
                if(left != null && visited.add(left.val)) {
                    // System.out.println(k +" "+ node.val +" "+ left.val);
                    q.add(left);
                }
                if(right != null && visited.add(right.val)) {
                    // System.out.println(k +" "+ node.val +" "+ right.val);
                    q.add(right);
                }
                if(p != null && visited.add(p.val)) {
                    // System.out.println(k +" "+ node.val +" "+ p.val);
                    q.add(p);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            list.add(q.poll().val);
        }
        return list;
    }
}
