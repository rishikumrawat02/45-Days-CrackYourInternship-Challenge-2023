class Solution {
    public Node flatten(Node head) {
        helper(head);
        return head;
    }

    Node helper(Node head){
        Node prev=null; Node cur=head;
        while(cur!=null){
            if(prev!=null){
                prev.next=cur;
                cur.prev=prev;
            }
            Node next=cur.next;
            if(cur.child!=null){
                cur.next=cur.child;
                cur.next.prev=cur;
                prev=helper(cur.child); 
                cur.child=null; cur=next;
            }else{
                prev=cur; cur=next;
            }
        }
        return prev;
    }
}
