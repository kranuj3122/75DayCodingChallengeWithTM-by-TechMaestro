
public class FlattenMultilevelDoublyLinkedList {
    static Node flattenRec(Node head) {
        Node curr = head, tail = head;
        while(curr != null) {
            Node next = curr.next;
            if(curr.child != null) {
                Node nextLevelTail = flattenRec(curr.child);
                
                nextLevelTail.next = next;
                if(next != null) {
                    next.prev = nextLevelTail;
                }
                
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                
                if(next != null) {
                    curr = next;
                }
            }
            else {
                curr = curr.next;
            }
            
            if(curr != null) {
                tail = curr;
            }
        }
        return tail;
    }
    public Node flatten(Node head) {
        if(head != null) {
            flattenRec(head);
        }
        return head;
    }
}
