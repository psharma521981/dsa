package others.a_design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public Map<Integer,Node> cache = new HashMap<>();
    int size;
    int capacity;
    Node head;
    Node tail;

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
    public void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

    }

    public void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public void addToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
    public Node popTail() {

        Node last = tail.prev;
        removeNode(last);
        return last;
    }


    LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    void put(int key,int val) {
        Node  node = cache.get(key);

        if(node==null) {
            Node newNode = new Node();
            newNode.val = val;
            newNode.key = key;
            cache.put(key,newNode);
            addNode(newNode);
            size++;

            if(size > capacity) {
                Node removeNode = popTail();
                cache.remove(removeNode.key);
                size--;
            }
        } else {
            node.val = val;
            addToHead(node);
        }
    }
    int get(int key) {
        Node  node = cache.get(key);
        if(node==null) {
            return -1;
        } else {
            addToHead(node);
            return node.val;
        }
    }
    public static void main(String s[]) {

    }
}
