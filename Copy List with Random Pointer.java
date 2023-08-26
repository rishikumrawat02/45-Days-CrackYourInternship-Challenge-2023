class Solution {
    public Node copyRandomList(Node head) {
        Node orgHead = head;
        if(head==null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        map.put(head,new Node(head.val));
        while(head!=null){
            Node cur = map.get(head);
            Node nxt = null;
            if(head.next!=null && map.containsKey(head.next)){
                nxt=map.get(head.next);
            }else if(head.next!=null){
                nxt=new Node(head.next.val);
                map.put(head.next,nxt);
            }
            cur.next=nxt;
            
            Node random=null;
            if(head.random!=null && map.containsKey(head.random)){
                random=map.get(head.random);
            }else if(head.random!=null){
                random=new Node(head.random.val);
                map.put(head.random,random);
            }
            cur.random=random;
            
            head=head.next;
        }
        return map.get(orgHead);        
    }
}
