class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val){
            this.val = val;
            this.key = key;
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
        if(!map.containsKey(key)) return -1;
        Node nn = map.get(key);
        remove(nn);
        insert(nn);
        return nn.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node nn = map.get(key);
            remove(nn);
            nn.val = value;
            insert(nn);
            return;
        }
        Node nn = new Node(key, value);
        if(len < size){
            insert(nn);
            len++;
        }else{
            remove(head);
            insert(nn);
        }
    }

    private void insert(Node nn){
        map.put(nn.key, nn);
        if(head == null){
            head = tail = nn;
            return;
        }
        tail.next = nn;
        nn.prev = tail;
        tail = nn;
    }

    private void remove(Node nn){
        if (nn == null) return;
        map.remove(nn.key);
        if(nn.prev != null){
            nn.prev.next = nn.next;
        }else{
            head = nn.next; // bcoz if list is 2-> <- 3 -> <- 4 and we remove 2 so the head will be 3 this time 
        }


        if(nn.next != null){
            nn.next.prev = nn.prev;
        }else{
            tail = nn.prev; // bcoz if list is 2-> <- 3 -> <- 4 and we remove 4 so the tail will be 3 this time 
        }
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