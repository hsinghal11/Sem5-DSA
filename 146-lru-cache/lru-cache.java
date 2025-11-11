import java.util.HashMap;

class LRUCache {

    class Node {
        int val;
        Node next;
        Node prev;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    private int size; // capacity
    private int len;  // current number of elements

    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        len = 0;
        head = null;
        tail = null;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);

        // Move node to tail (most recently used)
        remove(node);
        insert(key, node);

        return node.val;
    }

    public void put(int key, int value) {
        // If key already exists, update and move it to tail
        if (map.containsKey(key)) {
            Node existing = map.get(key);
            existing.val = value;
            remove(existing);
            insert(key, existing);
            return;
        }

        // If cache is full, remove least recently used (head)
        if (len == size) {
            // We need to find which key had that head node
            int toRemoveKey = -1;
            for (var entry : map.entrySet()) {
                if (entry.getValue() == head) {
                    toRemoveKey = entry.getKey();
                    break;
                }
            }
            if (toRemoveKey != -1) {
                map.remove(toRemoveKey);
            }
            remove(head);
        }

        // Create new node and insert at tail
        Node nn = new Node(value);
        insert(key, nn);
    }

    private void insert(int key, Node nn) {
        map.put(key, nn);
        if (head == null) {
            head = tail = nn;
        } else {
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }
        len = map.size();
    }

    private void remove(Node nn) {
        if (nn == null) return;

        if (nn.prev != null) nn.prev.next = nn.next;
        else head = nn.next; // removing head

        if (nn.next != null) nn.next.prev = nn.prev;
        else tail = nn.prev; // removing tail

        nn.next = null;
        nn.prev = null;

        len = map.size();
    }
}
