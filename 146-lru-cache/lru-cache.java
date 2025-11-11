class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    private int size;
    private int len;

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
        if (node != tail) {
            remove(node);
            insert(node);
        }

        return node.val;
    }

    public void put(int key, int value) {
        // If key already exists, update value and move to tail
        if (map.containsKey(key)) {
            Node existing = map.get(key);
            existing.val = value;
            if (existing != tail) {
                remove(existing);
                insert(existing);
            }
            return;
        }

        // If cache is full, remove least recently used (head)
        if (len == size) {
            map.remove(head.key);
            remove(head);
            len--;
        }

        // Create new node and insert at tail
        Node nn = new Node(key, value);
        insert(nn);
        map.put(key, nn);
        len++;
    }

    private void insert(Node nn) {
        if (head == null) {
            head = tail = nn;
            return;
        }

        tail.next = nn;
        nn.prev = tail;
        tail = nn;
    }

    private void remove(Node nn) {
        if (nn == null) return;

        if (nn.prev != null) nn.prev.next = nn.next;
        else head = nn.next; // removing head

        if (nn.next != null) nn.next.prev = nn.prev;
        else tail = nn.prev; // removing tail

        nn.next = null;
        nn.prev = null;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */