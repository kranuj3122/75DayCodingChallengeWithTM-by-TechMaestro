import java.util.*;

public class PopulatingNextPointer {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int sz = q.size();
            Node prev = null;
            while(sz-- > 0) {
                Node n = q.poll();
                if(prev != null) {
                    prev.next = n;
                }
                prev = n;
                if(n.left != null) {
                    q.add(n.left);
                }
                if(n.right != null) {
                    q.add(n.right);
                }
            }
        }
        return root;
    }
}
