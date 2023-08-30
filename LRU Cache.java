class LRUCache {
    class Node{
        Node prev; Node next; int key; int data;
        Node(Node prev, Node next, int key, int data){
            this.prev=prev; this.next=next; this.key=key; this.data=data;
        }
    }

    HashMap<Integer,Node> map;
    int size=0; int cap;
    Node head; Node tail;

    public LRUCache(int cap) {
        this.cap=cap;
        map=new HashMap<>();
        head=new Node(null,null,-1,-1);
        tail=new Node(null,null,-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node keyNode = map.get(key);
            delete(keyNode);
            add(keyNode.key,keyNode.data);
            return keyNode.data;
        }else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            delete(map.get(key));
            size--;
        }
        
        add(key,value);
        size++;
        if(size>cap){
            delete(tail.prev);
            size--;
        }

        return;
    }

    void delete(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        map.remove(node.key);
        return;
    }

    void add(int key, int value){
        Node node = new Node(null,null,key,value);
        node.next=head.next;
        node.next.prev=node;

        head.next=node;
        node.prev=head;

        map.put(key,node);
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
