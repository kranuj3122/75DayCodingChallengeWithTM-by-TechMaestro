import java.util.*;

public class LRUCache {
    static class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    
    int cap;
    Node head, tail;
    Map<Integer, Node> mp;
    
    public LRUCache(int capacity) {
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = tail;
        this.tail.prev = head;
        this.cap = capacity;
        this.mp = new HashMap<>();
    }
    
    public int get(int key) {
        int ans = -1;
        if(mp.containsKey(key)) {
            Node node = mp.get(key);
            ans = node.val;
            mp.remove(key);
            deleteNode(node);
            addNode(node);
            mp.put(key, head.next);
        }
        return ans;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)) {
            deleteNode(mp.get(key));
            mp.remove(key);
            cap++;
        }
        if(cap == 0) {
            mp.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key, value));
        if(cap > 0) {
            cap--;
        }
        mp.put(key, head.next);
    }
    
    void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
