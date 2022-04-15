
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node curr1 = head;
        Node curr2 = dummy;
        while(curr1 != null) {
            curr2.next = new Node(curr1.val);
            curr2 = curr2.next;
            map.put(curr1, curr2);
            curr1 = curr1.next;
        }
        
        curr1 = head;
        curr2 = dummy.next; 
        while(curr1 != null) {
            curr2.random = map.get(curr1.random);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        return dummy.next;
    }
}
